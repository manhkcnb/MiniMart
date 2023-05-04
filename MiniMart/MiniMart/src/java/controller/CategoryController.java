/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CategoryDao;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import models.Category;
import models.Product;
/**
 *
 * @author TT
 */
@WebServlet(name="CategoryController", urlPatterns={"/category"})
public class CategoryController extends HttpServlet {
   
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
        CategoryDao categoryDao = new CategoryDao();
        List<Category> listC = categoryDao.getAllCategory();
        ProductDao productDao = new ProductDao();
        int id = Integer.parseInt(request.getParameter("cid"));
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int records = productDao.getTotalProductByCategory(id);
        int pageSize = 8;
        int start = currentPage * pageSize - pageSize;
        int totalPage = (int) Math.ceil(records * 1.0 / pageSize);
        List<Product> listP = productDao.getProductsByCategory(id, start, pageSize);
        Category C = categoryDao.getCategoryById(id);
        List<Product> listNew = productDao.getLastestProducts(0);
        
        request.setAttribute("category", C);
        request.setAttribute("listC", listC);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("listP", listP);
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
