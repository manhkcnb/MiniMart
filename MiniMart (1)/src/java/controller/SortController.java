/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CategoryDao;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Product;

/**
 *
 * @author TT
 */
@WebServlet(name="SortController", urlPatterns={"/sort"})
public class SortController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDao productDao = new ProductDao();
        String min = request.getParameter("min");
        if("".equals(min)) min = null;
        String max = request.getParameter("max");
        if ("".equals(max)) max = null;
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Product> listP = productDao.sortProductByPrice(cid, 0, 8, min, max);
        CategoryDao categoryDao = new CategoryDao();
        Category C = categoryDao.getCategoryById(cid);
        List<Category> listC = categoryDao.getAllCategory();
        List<Product> listNew = productDao.getLastestProducts(0);
        
        request.setAttribute("category", C);
        request.setAttribute("listP", listP);
        request.setAttribute("listC", listC);
        request.setAttribute("listNew", listNew);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
