/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.AnfitrionDB;
import Datos.ClienteDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author franc
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = "";
        String password = "";
        String texto = "";
        String nextStep = "/register.jsp";
        
        try{
            /* TODO output your page here. You may use following sample code. */
            email=request.getParameter("email");
            password=request.getParameter("password");
            if(ClienteDB.emailExists(email)){
                if(ClienteDB.userExists(email, password)){
                    nextStep = "/vistaCliente.jsp";
                }else{
                    texto = "Your password is wrong";
                }  
            }else if(AnfitrionDB.emailExists(email)){
                    if(AnfitrionDB.userExists(email, password)){
                        nextStep = "/vistaAnfitrion.jsp";
                    }else{
                        texto = "Your password is wrong";
                    }  
            }else{
                    texto = "You are not registered";
                    nextStep = "/register.jsp";
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextStep);
            request.setAttribute("showText", texto);
            // save in the session the email of the user and 
            // is save in the request object
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
