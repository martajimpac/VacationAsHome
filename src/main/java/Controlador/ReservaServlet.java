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
 * @authors marta oscar
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
        ArrayList<Alojamiento> alojamientos = new ArrayList();
        ArrayList<Imagen> imagenes = new ArrayList();
       
        try (PrintWriter out = response.getWriter()) {
            
            String provincia = request.getParameter("inputAddress1");
            String municipio = request.getParameter("inputAddress2");
            //he quitado la fecha porque se introduce despues en el caso de uso
           
            int numHuespedes = Integer.parseInt(request.getParameter("inputPersonOne"));
            
            //Comprobar que los campos no estén vacíos
            if(!"".equals(provincia) || !"".equals(municipio)){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "The address cannot be empty");
            }
            
             
            //Devolver la lista de alojamientos para la localidad y los huespedes introducidos
            alojamientos = AlojamientoDB.buscarLocalidadyHuespedes(provincia,municipio,numHuespedes);
            
          
            if(alojamientos==null){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "There is no accommodation that matches your search");
            }

            
            //Conseguir la lista de imagenes de los alojamientos
            imagenes = ImagenDB.buscarImagenesAlojamientos(alojamientos);
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try { //RECARGAR LA PÁGINA Y MANDAR LAS VARIABLES
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/reservarCliente.jsp");

            //mandar lista de alojamientos*/
            request.setAttribute("alojamientos", alojamientos);
            //mandar lista de imagenes*/
            request.setAttribute("imagenes", imagenes);
           
            
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
