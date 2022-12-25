/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Modelo.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author paula
 */
public class ReservaBD {
    public static void insertarReserva(Reserva res){
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "INSERT INTO reserva (ID, fechaEntrada, fechaSalida, numHuespedes, comentarios, estado, dividePago, Cliente_email, Alojamiento_ubicacionPrecisa, Alojamiento_Anfitrion_email)\n" +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            ps = connection.prepareStatement(query);
            //ps.setString(1, );
            java.sql.Date sqlDate1 = new java.sql.Date(res.getFechaEntrada().getTime());
            java.sql.Date sqlDate2 = new java.sql.Date(res.getFechaSalida().getTime());
            ps.setDate(2,sqlDate1 );
            ps.setDate(3, sqlDate2);
            ps.setInt(4, res.getNumHuespedes());
            ps.setString(5, res.getComentarios());
            ps.setString(6, res.getEstado());
            ps.setBoolean(7, res.isDividePago());
            ps.setString(8, res.getUsuarioRegistrado_email());
            ps.setString(9, res.getAlojamiento_ubicacion_precisa());
            ps.setString(10, res.getAlojamiento_anfitrion_email());
            rs = ps.executeQuery();
            rs.close();
            ps.close();
            pool.freeConnection(connection);
        }catch (SQLException e) {
        }
    }
}
