/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import Modelo.Alojamiento;
import Modelo.Imagen;
import Datos.AlojamientoDB;
import Datos.ImagenDB;
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
@WebServlet(name = "RealizarReservaServlet", urlPatterns = {"/RealizarReservaServlet"})
public class RealizarReservaServlet extends HttpServlet {

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
        ArrayList<Alojamiento> alojamientos = new ArrayList();
        ArrayList<Imagen> imagenes = new ArrayList();
        Alojamiento alojamiento = new Alojamiento();
        String provincia = "";
        String municipio = "";
        String fechaEnt = "";
        String fechaSal = "";
        String texto = "";
        int indiceAloj = 0;
        int numHuespedes = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {        
            provincia = request.getParameter("inputAddress1");
            municipio = request.getParameter("inputAddress2");
            numHuespedes = Integer.parseInt(request.getParameter("inputPersonOne"));
            fechaEnt = request.getParameter("inputDateOne");
            fechaSal = request.getParameter("inputDateTwo");
            indiceAloj = Integer.parseInt(request.getParameter("inputAlojamiento"));
            //Pasar las fechas a tipo date
            Date fechaEntrada = dateFormat.parse(fechaEnt);
            Date fechaSalida = dateFormat.parse(fechaSal);
            
            alojamientos = AlojamientoDB.buscarLocalidadyHuespedes(provincia,numHuespedes);
            alojamiento = alojamientos.get(indiceAloj);
           
            //Comprobar que el alojamiento este disponible en las fechas introducidas y que no tenga una reserva
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try { //RECARGAR LA PÁGINA Y MANDAR LAS VARIABLES
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/reservarCliente2.jsp");
            
            request.setAttribute("texto", texto);
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
