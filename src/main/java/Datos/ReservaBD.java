/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Alojamiento;
import Modelo.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author marta
 */
public class ReservaBD {
      public static Reserva getDatos(String ubicacionGPS) {
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ALOJAMIENTO A JOIN RESERVA r " +
                       "WHERE A.UBICACIONPRECISA LIKE ? AND r.Alojamiento_ubicacionPrecisa= A.ubicacionPrecisa;";
        try {
          
          Reserva res = new Reserva();
          ps = connection.prepareStatement(query);
          ps.setString(1, ubicacionGPS);

          rs = ps.executeQuery();
              while (rs.next()) { 
                res.setEstado(rs.getString("ESTADO"));
                res.setFechaEntrada(rs.getDate("FECHAENTRADA"));
                res.setFechaSalida(rs.getDate("FECHASALIDA"));
              }
              rs.close();
              ps.close();
              pool.freeConnection(connection);
              return res;
          } catch (Exception e) {
              return null;
          }
    }
}
