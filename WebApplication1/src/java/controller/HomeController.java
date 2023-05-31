/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductDao;
import java.util.*;
import models.Category;
import models.Product;

/**
 *
 * @author TT
 */
@WebServlet(name="ProductController", urlPatterns={"/home"})
public class HomeController extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDao productDao = new ProductDao();
        List<Product> listNew = productDao.getLastestProducts(0);
        List<Product> listNew1 = productDao.getLastestProducts(5);
        
        CategoryDao categoryDao = new CategoryDao();
        Category category1 = categoryDao.getCategoryById(1);
        Category category2 = categoryDao.getCategoryById(2);
        Category category3 = categoryDao.getCategoryById(3);
        Category category4 = categoryDao.getCategoryById(4);
        
        List<Category> listC = categoryDao.getAllCategory();
        
        List<Product> listC1 = productDao.getProductsByCategory(1, 0, 5);
        List<Product> listC2 = productDao.getProductsByCategory(2, 0, 5);
        List<Product> listC3 = productDao.getProductsByCategory(3, 0, 5);
        List<Product> listC4 = productDao.getProductsByCategory(4, 0, 5);
        
        request.setAttribute("listC", listC);
        
        request.setAttribute("listC1", listC1);
        request.setAttribute("listC2", listC2);
        request.setAttribute("listC3", listC3);
        request.setAttribute("listC4", listC4);
        
        request.setAttribute("category1", category1);
        request.setAttribute("category2", category2);
        request.setAttribute("category3", category3);
        request.setAttribute("category4", category4);
        
        request.setAttribute("listNew", listNew);
        request.setAttribute("listNew1", listNew1);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
