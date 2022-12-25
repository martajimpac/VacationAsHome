/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import Modelo.Alojamiento;
import Modelo.Mensaje;
import Modelo.Reserva;
import Datos.AlojamientoDB;
import Datos.AnfitrionDB;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @authors oscar
 */
@WebServlet(name = "MensajeReservaServlet", urlPatterns = {"/MensajeReservaServlet"})
public class MensajeReservaServlet extends HttpServlet {

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
        
        //variables que vamos a usar
        String mensaje = "";
        String texto = "";
        String fechaEnt = "";
        String fechaSal = "";
        boolean fracciona =  false;
        Reserva reserva = new Reserva();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");       
       
        try (PrintWriter out = response.getWriter()) {
            
            fechaEnt = request.getParameter("inputDateOne");
            fechaSal = request.getParameter("inputDateTwo");
            //Pasar las fechas a tipo date
            Date fechaEntrada = dateFormat.parse(fechaEnt);
            Date fechaSalida = dateFormat.parse(fechaSal);
            mensaje = request.getParameter("inputMensaje");
            fracciona =  Boolean.parseBoolean(request.getParameter("inputFracciona"));

            //la reserva mejor crear una nueva, hay que poner los datos de fecha entrada y salida
            //Comprobar que los campos no estén vacíos
            if(!"".equals(mensaje)){
                texto = "El mensaje no puede estar vacío";
            }else{
                texto = "La reserva se ha realizado correctamente";
            }
            
            //Guardamos los datos de la reserva
            reserva.setEstado("realizada");
            reserva.setFechaEntrada(fechaEntrada);
            reserva.setFechaSalida(fechaSalida);
            //no se como conseguir ahora los datos de entrada y salida porque eran del anterior formulario
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try { //RECARGAR LA PÁGINA Y MANDAR LAS VARIABLES
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/reservarCliente.jsp");

            request.setAttribute("textoMensaje", texto); 
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
