/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

/**
 *
 * @author TT
 */
@WebServlet("/api/product/*")
public class ProductApi extends HttpServlet {
    private ObjectMapper obj;
    private ProductDao productDao;
    
    @Override
    public void init(){
        productDao = new ProductDao();
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
            int currentPage = Integer.parseInt(request.getParameter("page"));
            int pageSize = 8;
            List<Product> list = productDao.getAllProduct(currentPage, pageSize);
            int totalProducts = productDao.getTotalProduct();
            int totalPage = (int) Math.ceil(totalProducts / pageSize);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("products", list);
            responseData.put("totalPage", totalPage);
            
            String json = obj.writeValueAsString(responseData);
            response.setContentType("application/json");
            response.getWriter().write(json);
        }else{
            int productId = Integer.parseInt(pathInfo.substring(1));
            Product product = productDao.getProductById(productId);
            if (product != null) {
                String json = obj.writeValueAsString(product);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Không tìm thấy sản phẩm !");
            }
        }
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Product product = obj.readValue(json, Product.class);
        productDao.addProduct(product);
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().write("Đã lưu sản phẩm !");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        String productId = request.getPathInfo().substring(1);
        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Product product = obj.readValue(json, Product.class);
        productDao.updateProduct(Integer.parseInt(productId), product);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Cập nhật thành công !");
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        String productId = request.getPathInfo().substring(1);
        productDao.deleteProduct(Integer.parseInt(productId));
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Đã xóa !");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
