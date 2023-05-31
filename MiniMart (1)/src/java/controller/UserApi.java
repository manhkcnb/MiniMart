/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author TT
 */
@WebServlet("/api/user/*")
public class UserApi extends HttpServlet {
    private ObjectMapper obj;
    private UserDao dao;
    
    @Override
    public void init(){
        dao = new UserDao();
        obj = new ObjectMapper();
        obj.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        String pathInfo = request.getPathInfo();
        if(pathInfo == null || pathInfo.equals("/")){
            List<User> list = dao.getAllUsers();
            String json = obj.writeValueAsString(list);
            response.setContentType("application/json");
            response.getWriter().write(json);
        }
    } 

    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        String userId = request.getPathInfo().substring(1);
        dao.deleteUser(Integer.parseInt(userId));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
