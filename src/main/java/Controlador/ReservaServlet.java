/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import Modelo.Alojamiento;
import Modelo.Imagen;
import Datos.AlojamientoDB;
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
 * @author marta
 */
@WebServlet(name = "ReservaServlet", urlPatterns = {"/ReservaServlet"})
public class ReservaServlet extends HttpServlet {

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
        String texto = new String();
        ArrayList<Alojamiento> alojamientos = new ArrayList();
        String nombre = new String();
        int maxHuesp = 0;
        int valoracion = 0;
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String direccion1 = request.getParameter("inputAddress1");
            String direccion2 = request.getParameter("inputAddress2");
            String direccion = direccion1 + direccion2;
            int numHuespedes = Integer.parseInt(request.getParameter("inputPersonOne"));
            
            //Devolver la lista de alojamientos para la localidad y los huespedes introducidos
            alojamientos = AlojamientoDB.buscarLocalidadyHuespedes(direccion,numHuespedes);
            
            out.println(alojamientos);
            if(alojamientos==null){
                texto = "There is no accommodation that matches your search";
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try { //Para actualizar la vista
            
            /*//mostrar el texto
            request.setAttribute("showText", texto);
            //mostrar alojamientos solo si hay resultados para la búsqueda
            request.setAttribute("correcto", request.getParameter("inputAddress1")); 
            //mandar lista de alojamientos*/
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/reservarCliente.jsp");
            request.setAttribute("alojamientos", alojamientos);
      
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
