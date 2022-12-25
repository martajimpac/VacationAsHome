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
        ArrayList alojamientos = new ArrayList<> ();
        ArrayList imagenes = new ArrayList<> ();
        String provincia = "";
        String municipio = "";
        int numHuespedes = 0;
        String texto = "";
                
        try {
            provincia = request.getParameter("inputAddress1");
            municipio = request.getParameter("inputAddress2");
            numHuespedes = Integer.parseInt(request.getParameter("inputPersonOne"));
            
            //Comprobar que los campos no estén vacíos
            if("".equals(provincia) || "".equals(municipio)){  
                texto = "The address cannot be empty";
            }else{

                //Devolver la lista de alojamientos para la localidad y los huespedes introducidos
                alojamientos = AlojamientoDB.buscarLocalidadyHuespedes(provincia,numHuespedes);
                imagenes=Datos.ImagenDB.buscarImagenesAlojamientos(alojamientos);
                
            }
          
        }catch(Exception e){
            System.out.println(e);
        }
        
        try { //RECARGAR LA PÁGINA Y MANDAR LAS VARIABLES
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/reservarCliente.jsp");

            //mandar lista de alojamientos*/
            request.setAttribute("alojamientos", alojamientos);
            request.setAttribute("texto", texto);
            request.setAttribute("imagenes", imagenes);
            
         
            //enviar al servlet la informacion de la direccion y los huespedes de nuevo
            request.setAttribute("inputAddress1", provincia);
            request.setAttribute("inputAddress2", municipio);
            request.setAttribute("inputPersonOne", request.getParameter("inputPersonOne"));
            
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
