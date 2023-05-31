/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dao.OrderDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Order;

/**
 *
 * @author TT
 */
@WebServlet("/api/order/*")
public class OrderApi extends HttpServlet {
    private ObjectMapper obj;
    private OrderDao dao;
    
    @Override
    public void init(){
        dao = new OrderDao();
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
            List<Order> list = dao.getAllOrder();
            String json = obj.writeValueAsString(list);
            response.setContentType("application/json");
            response.getWriter().write(json);
        }else{
            int id = Integer.parseInt(pathInfo.substring(1));
            Order order = dao.getOrderById(id);
            if(order != null){
                String json = obj.writeValueAsString(order);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }else{
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Không tìm thấy đơn hàng !");
            }
        }
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        String orderId = request.getPathInfo().substring(1);
        dao.acceptOrder(Integer.parseInt(orderId));
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Xác nhận thành công !");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
