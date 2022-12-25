/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paula
 */
@WebServlet(name = "ConsultaClienteServlet", urlPatterns = {"/ConsultaClienteServlet"})
public class ConsultaClienteServlet extends HttpServlet {

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
        String provincia = "";
        String municipio= "";
        String date1 = "";
        String date2 = "";
        int numPersonas = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList Aloj1= new  ArrayList<> ();
        ArrayList img1 = new  ArrayList<> ();
        try{
            /* TODO output your page here. You may use following sample code. */
            provincia=request.getParameter("inputAddress1");
            municipio=request.getParameter("inputAddress2");
            date1 = request.getParameter("inputdateOne");
            Date d1 = dateFormat.parse(date1);
            date2 = request.getParameter("inputDateTwo");
            Date d2 = dateFormat.parse(date2);
            numPersonas = Integer.parseInt(request.getParameter("inputPersonOne"));
            Aloj1=Datos.AlojamientoDB.consulta(provincia,municipio,d1,d2,numPersonas);
            img1=Datos.ImagenDB.buscarImagenesAlojamientos(Aloj1);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        // una vez se pulse el boton, se captura su evento y se recraga la misma pagina
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistaCliente.jsp");
            request.setAttribute("Aloj1", Aloj1);
            request.setAttribute("img1", img1);
            request.setAttribute("fechaEntrada", date1);
            request.setAttribute("fechaSalida", date2);
            request.setAttribute("numpersonas", numPersonas);
            // save in the session the email of the user and 
            // is save in the request object
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
