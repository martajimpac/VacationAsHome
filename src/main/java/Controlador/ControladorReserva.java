import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ESTE CONTROLADOR NO ES FUNCIONAL, ES LA PRIMERA VERSION
@WebServlet("/ControladorReserva")
public class ControladorReserva extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //Importamos los modelos que vamos a utilizar para la comprobación de datos

    //inicializamos variables con los valores extraidos de los modelos 

    //Datos que sacamos de los modelos para comprobaciones y operaciones
    //nombreApartamento 
    //maxHuespedesApartamento 
    //valoracionGlobal
    //imagen
    //TODA LA INFO DEL ALOJAMIENTO menos la ubicacion prevista y las reservas
    //estadoAlojamiento(ocupado o no)
    //estadoReserva
    //fechas de las reservas para hacer la comprobacion del alojamiento



    //Metodo que maneja GET request del cliente
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the parameters from the request
        //String email = request.getParameter("email");
        String localidad = request.getParameter("localidad");
        String numHuespedes = request.getParameter("numHuespedes");
        int numhuespedes = Integer.parseInt(numHuespedes);
        String alojamientoSeleccionado = request.getParameter("alojamientoSeleccionado");
        String fechaEntrada = request.getParameter("fechaEntrada");
        String fechaSalida = request.getParameter("fechaSalida");
        boolean fraccionPago = request.getParameter("fraccionPago") != null; //si se hace con strings hay que hacer comprobacion
        String mensajeAnfitrion = request.getParameter("mensajeAnfitrion");
        

        // Validar input
        if (localidad == null || localidad.trim().length() == 0) {
            // Devolvemos error por no introducir localidad
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere localidad");
            return;
        }
        if (numHuespedes == null || numHuespedes.trim().length() == 0) {
            // Devolvemos error por no introducir número de huespedes
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere número de huespedes");
            return;
        }
        if (alojamientoSeleccionado == null || alojamientoSeleccionado.trim().length() == 0) {
            // Devolvemos error por no seleccionar alojamiento
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere seleccionar alojamiento");
            return;
        }
        if (fechaEntrada == null || fechaEntrada.trim().length() == 0) {
            // Devolvemos error por no introducir fechaEntrada
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere fechaEntrada");
            return;
        }
        if (fechaSalida == null || fechaSalida.trim().length() == 0) {
            // Devolvemos error por no introducir fechaSalida
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere fechaSalida");
            return;
        }
        //if (fraccionPago == null || fraccionPago.trim().length() == 0) {
        //    // Devolvemos error por no seleccionar fraccionar o no el pago
        //    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere seleccionar si se quiere fraccionar el pago");
        //    return;
        //}
        if (mensajeAnfitrion == null || mensajeAnfitrion.trim().length() == 0) {
            // Devolvemos error por no dejar un mensaje al Anfitrion
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere introducir un mensaje para el anfitrion");
            return;
        }

        //AHORA SE HACEN COMPROBACIONES LOGICAS, TRAS LAS QUE SE LLAMA A LAS FUNCIONES QUE HAGAN FALTA
        // Funciones de resultado
        int numlocalidad = comprobarLocalidad(localidad, numhuespedes);
        int numalojamiento = comprobarAlojamiento(alojamientoSeleccionado, fechaEntrada, fechaSalida);

        // Set the content type of the response
        response.setContentType("text/html");


        // Write the response back to the client
        PrintWriter out = response.getWriter();

        //Resultado comprobacion localidad
        if(numlocalidad==0){
            //Devolvemos los datos de los alojamientos disponibles para mostrarselos al asuario
            //ModeloAlojamiento.localidad[localidad].nombre[];
            //ModeloImagen.alojamiento[nombre].imagen[];
            //ModeloAlojamiento.localodad[localidad].maxHuespedesAlojamiento[];
            //ModeloAlojamiento.localodad[localidad].valoracionGlobal[];
            
        }else if(numlocalidad==1){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No hay alojamientos en la localidad introducida, o esta no existe.");
            return;
        }else if(numlocalidad==2){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El número de huespedes debe ser un entero positivo.");
            return;
        }else if(numlocalidad==3){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No hay alojamientos disponibles en esa localidad para ese número de huespedes.");
            return;
        }

        //Resultados comprobacion alojameinto
        if(numalojamiento==0){
            out.println("{\"¿Quiere confirmar la reserva?\"}");
            out.println("{\"Deje un mensaje para el anfitrión y seleccione si desea fraccionar el pago.\"}");
        }else if(numalojamiento==1){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El alojamiento en cuestión está ocupado en las fechas propuestas.");
            return;
        }else if(numalojamiento==2){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ya hay una reserva vigente en el alojamiento en las fechas propuestas.");
            return;
        }

        //Creamos reserva para el cliente
        ModeloReserva.contructor(email, alojamiento, fechaEntrada, fechaSalida, numHuespedes, mensajeAnfitrion, fraccionPago, estado="realizada");

    }

    //Funciones que dan respuesta tras realizar las comprobaciones pertinentes
    //Comprobamos si hay alojamientos en la localidad
    private int comprobarLocalidad(String localidad, int numhuespedes) {
        
        if(localidad is in ModeloAlojamiento.localidad[]){
            if(numhuespedes>=1){
                if(ModeloAlojamiento.localidad[localidad].maxHuespedesAlojamiento>=numhuespedes){
                    return 0; //todo bien 
                }else{
                    return 3; //error disponibilidad
                }
            }else{
                return 2; //error num de huespedes no valido
            }
        }else{
            return 1; //error localidad inexistente
        }
    }
    //Comprobamos si el alojamiento esta disponible
    private int comprobarAlojamiento(String alojamientoSeleccionado, String fechaEntrada, String fechaSalida) {  
        
        if(ModeloAlojamiento.nombreApartamento[alojamientoSeleccionado].fechaEntrada.estado != "ocupado" && ModeloAlojamiento.nombreApartamento[alojamientoSeleccionado].fechaSalida.estado != "ocupado"){
            if(ModeloReserva.estado != "libre" || fechaEstrada<ModeloReserva.fechaSalida[] || fechaSalida>ModeloReseva.fechaEntrada[]){
                return 0; //todo bien
            }else{
                return 2; //coinciden las fechas con alguna reserva
            }
        }else{
            return 1; //error alojamiento ocupado
        }
    }
        
}
