/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.Date;


import Modelo.Anfitrion;
import Modelo.Imagen;
import Modelo.Mensaje;
import Modelo.Cliente;
import Modelo.Reserva;
import Modelo.Precio;
import Modelo.Alojamiento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marta
 */
@WebServlet(name = "ControladorNuevosPrecios", urlPatterns = {"/ControladorNuevosPrecios"})
public class ServletReservar extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void procesarEventoIntroducir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //Declarar variables
            ArrayList <Alojamiento> listaAlojamientos = new ArrayList<>();
            String nombreLocalidad;
            String numHuespedes;
            
            nombreLocalidad = request.getParameter("nombreLoc");
            numHuespedes = request.getParameter("numH");
            
            // COMPROBAR QUE EL NUMERO SEA CORRECTO Y QUE EL NOMBRE NO ESTÉ VACÍO
            
            //Consultar la base de datos para obtener los datos
            listaAlojamientos = ConsultarDB.ConsultarAlojamientos(nombreLocalidad,numHuespedes);
            
            //De la lista de alojamientos que nos devuelve ver cuales son válidos para el número de huespedes que tenemos
            
            //Mostrar: nombre, número de huéspedes, valoración global y foto portada.
            
            //Creo que hay que devolver el código con los alojamientos a mostrar pero no estoy segura si esto se hace aquí
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("</html>");
        }
    }
    
    protected void procesarEventoSeleccionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Crear variables
            int k;
            Alojamiento alojamiento = new Alojamiento();
            Precio precio = new Precio();
            Imagen imagen = new Imagen();
            
            //recoge el valor de k de la petición http
            k = Integer.parseInt(request.getParameter("k"));
            
            alojamiento = ConsultarDB.ConsultarAlojamiento(k);
            //mostrar todos los detalles menos ubicación precisa
            
            imagen = ConsultarDB.ConsultarImagen(k);
            
            //Consultar solo el último precio del hístorico
            precio = ConsultarDB.ConsultarPrecio(k);
            
            //Mostrar detalles del alojamiento seleccionado
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("</html>");
        }
    }
    
    protected void procesarEventoReservar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Crear variables
            Reserva reserva = new Reserva();
            Date fechaEntrada = new Date();
            Date fechaSalida = new Date();
            
            //recoge los valores de las fechas la petición http
            fechaEntrada = request.getParameter("fechaEntrada");
            fechaSalida = request.getParameter("fechaSalida");
            //hay que convertir esto a tipo de datos Date
            
            //comprobar que fecha entrada sea anterior a fecha de salida
            
            //Hay que conseguir la reserva ligada a el alojamiento, no se como se hace eso sin tener el índice de alojamiento que es
           
            //comprobar que no haya una reserva en ejecución, ni en estado realizada, aceptada por anfitrión
            
            //mostrar mensaje confirmación
            
            //preguntar si desea fraccionar el pago y guardar la información en la tabla Reserva
            
            
            out.println("<!DOCTYPE html>");
        }
    }
    
    protected void procesarEventoMensaje(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("</html>");
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
        procesarEventoIntroducir(request, response);
        procesarEventoSeleccionar(request, response);
        procesarEventoReservar(request, response);
        procesarEventoMensaje(request, response);
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
        procesarEventoIntroducir(request, response);
        procesarEventoSeleccionar(request, response);
        procesarEventoReservar(request, response);
        procesarEventoMensaje(request, response);
        
             
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Este es el servlet para el caso de uso reservar alojamiento";
    }// </editor-fold>

}
