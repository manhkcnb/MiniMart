/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CartDao;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cart;
import models.CartItem;
import models.User;
import java.util.*;
import models.Product;

/**
 *
 * @author TT
 */
@WebServlet(name="CartController", urlPatterns={"/cart"})
public class CartController extends HttpServlet {
   
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
        ProductDao productDao = new ProductDao();
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("account");
        CartDao cartDao = new CartDao();

        if (currentUser == null) {
            response.sendRedirect("login.jsp");
        } else {
            Cart currentCart = cartDao.getCartByUser(currentUser.getId());
            if (currentCart == null) {
                cartDao.createCart(currentUser.getId());
                currentCart = cartDao.getCartByUser(currentUser.getId());
            }

            int totalPrice = calculateTotalPrice(cartDao, productDao, currentCart);
            List<CartItem> listI = cartDao.getListCartItemByCart(currentCart.getId());

            request.setAttribute("total", totalPrice);
            request.setAttribute("listI", listI);

            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
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
        int id = Integer.parseInt(request.getParameter("productId"));
        ProductDao productDao = new ProductDao();
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("account");
        CartDao cartDao = new CartDao();
        if (currentUser == null) {
            response.sendRedirect("login.jsp");
        }else{
            Cart currentCart = cartDao.getCartByUser(currentUser.getId());
            if (currentCart == null) {
                cartDao.createCart(currentUser.getId());
                currentCart = cartDao.getCartByUser(currentUser.getId()); // Lấy lại thông tin giỏ hàng sau khi tạo
            }
            String action = request.getParameter("action");
            if (action != null && !action.isEmpty()) {
                if (action.equals("add")) {
                    CartItem item = cartDao.getCartItemByProductAndCart(id, currentCart.getId());
                    if (item == null) {
                        cartDao.addToCart(id, currentCart.getId());
                    } else {
                        cartDao.updateCartItem(id, currentCart.getId(), item.getCount() + 1);
                    }
                } else if (action.equals("delete")) {
                    String deleteItemId = request.getParameter("deleteItemId");
                    if (deleteItemId != null && !deleteItemId.isEmpty()) {
                        int itemToDeleteId = Integer.parseInt(deleteItemId);
                        cartDao.deleteCartItem(itemToDeleteId, currentCart.getId());
                    }
                }
            }

            int totalPrice = calculateTotalPrice(cartDao, productDao, currentCart);
            cartDao.saveCart(currentUser.getId(), totalPrice);

            response.sendRedirect("cart");
        }
    }
    
    private int calculateTotalPrice(CartDao cartDao, ProductDao productDao, Cart cart){
        int totalPrice = 0;
        List<CartItem> listI = cartDao.getListCartItemByCart(cart.getId());
        for (CartItem item : listI) {
            Product product = productDao.getProductById(item.getProduct_id());
            totalPrice += item.getCount() * product.getPrice();
        }
        return totalPrice;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
