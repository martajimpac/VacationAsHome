/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Imagen;
import Modelo.Reserva;
import static Datos.ImagenDB.buscarImagenesReserva;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "DetallesReservaServlet", urlPatterns = {"/DetallesReservaServlet"})
public class DetallesReservaServlet extends HttpServlet {

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
        Reserva res = new Reserva();
        Imagen img= new Imagen();
        String nom="";
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = dateFormat.parse(request.getParameter("fechaEntrada"));
            System.out.println("*************************************************"+request.getParameter("fechaEntrada"));
            Date d2 = dateFormat.parse(request.getParameter("fechaSalida"));
            int numHuespedes = Integer.parseInt(request.getParameter("numHuespe"));
            System.out.println("*************************************************"+request.getParameter("numHuespe"));
            String est = request.getParameter("estado");
            nom= request.getParameter("nombre");
            System.out.println("*************************************************"+nom);
            String emailAnf = request.getParameter("Alojamiento_Anfitrion_email");
            String ubprecisa = request.getParameter("Alojamiento_ubicacionPrecisa");
            String cliente=request.getRemoteUser();
            res.setAlojamiento_anfitrion_email(emailAnf);
            res.setAlojamiento_ubicacion_precisa(ubprecisa);
            res.setEstado(est);
            res.setFechaEntrada(d1);
            res.setFechaSalida(d2);
            res.setNumHuespedes(numHuespedes);
            res.setUsuarioRegistrado_email(cliente);
            img=buscarImagenesReserva(ubprecisa);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        // una vez se pulse el boton, se captura su evento y se recraga la misma pagina
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/reserva.jsp");
            request.setAttribute("res", res);
            request.setAttribute("imgen", img);
            request.setAttribute("nom", nom);
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
