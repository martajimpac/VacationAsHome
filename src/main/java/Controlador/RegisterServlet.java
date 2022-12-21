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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        String email = "";
        String password = "";
        String name = "";
        String idioma = "";
        String texto = "";
        String nextStep = "/newRegister.jsp";
        try{
            /* TODO output your page here. You may use following sample code. */
            if("".equals(name)){
                /*Comprobamos si el usuario ya existe*/
                if (!ClienteDB.emailExists(email)){
                   ClienteDB.singInClient(email, password);
                   nextStep = "/register.jsp";
                }
            }
            if(!"".equals(name)){
                /*Comprobamos si el usuario ya existe*/
                if (!AnfitrionDB.emailExists(email)){
                   AnfitrionDB.singInAnfitrion(email, name, idioma, password);
                   nextStep = "/register.jsp";
                }
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

}
