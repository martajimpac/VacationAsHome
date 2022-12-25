/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Modelo.Alojamiento;
import Modelo.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author marta
 */
public class AlojamientoDB {
    
    public static ArrayList <Alojamiento> buscarLocalidadyHuespedes(String provincia, int numHuespedes) {
        
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //buscar alojamientos en la localidad y que tengan espacio para el numero de huespedes introducido
        String query = "SELECT * FROM ALOJAMIENTO A"
        + "WHERE A.LOCALIDAD LIKE ? AND A.MAXHUESPED >= ?;";
        
        //Crear las variables
        ArrayList <Alojamiento> alojamientos = new ArrayList();
        Alojamiento aloj = null;
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, provincia);
            ps.setInt(2, numHuespedes);
            rs = ps.executeQuery();
            while (rs.next()) {
                aloj = new Alojamiento();
                aloj.setUbicacionPrecisaGPS(rs.getString("ubicacionPrecisa"));
                aloj.setFechaEntrada(rs.getDate("fechaEntrada"));
                aloj.setNombre(rs.getString("nombre"));
                aloj.setMaxHuespedes(rs.getInt("maxHuesped"));
                aloj.setNumDormitorios(rs.getInt("numDormitorios"));
                aloj.setNumCamas(rs.getInt("numCamas"));
                aloj.setNumBaños(rs.getInt("numBaños"));
                aloj.setUbicacionDescrita(rs.getString("ubicacionDescrita"));
                aloj.setCaracteristicas(rs.getString("caracteriticas"));
                aloj.setServicio(rs.getString("servicio"));
                aloj.setLocalidad(rs.getString("localidad"));
                aloj.setValoracionGlobal(rs.getInt("valoracionGlobal"));
                aloj.setAnfitrion_email(rs.getString("anfitrionEmail"));
                alojamientos.add(aloj);
            }
            //de aqui tengo que sacar los alojamientos pero no se como
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return alojamientos;
          
        } catch (Exception e) {
            return null;
        }
    }
    
    public static ArrayList<Alojamiento> consulta(String prov, String muni, Date d1, Date d2, int num) {
      Conexion pool = Conexion.getInstance();
      Connection connection = pool.getConnection();
      PreparedStatement ps = null;
      ResultSet rs = null;
      String query = "SELECT * FROM ALOJAMIENTO A JOIN RESERVA r " +
                     "WHERE A.MAXHUESPED>=? AND A.LOCALIDAD LIKE ? AND r.Alojamiento_ubicacionPrecisa= A.ubicacionPrecisa AND (r.`fechaEntrada`<  ? AND r.`fechaSalida`<?);";
      try {
        ArrayList<Alojamiento> lista = new ArrayList<>();
        ps = connection.prepareStatement(query);
        java.sql.Date sqlDate1 = new java.sql.Date(d1.getTime());
        java.sql.Date sqlDate2 = new java.sql.Date(d2.getTime());
        ps.setInt(1, num);
        ps.setString(2, prov);
        ps.setDate(3, sqlDate1);
        ps.setDate(4, sqlDate2);
        rs = ps.executeQuery();
            while (rs.next()) {
              Alojamiento alj = new Alojamiento();
              alj.setUbicacionPrecisaGPS(rs.getString("UBICACIONPRECISA"));
              alj.setFechaEntrada(rs.getDate("FECHAENTRADA"));
              alj.setNombre(rs.getString("NOMBRE"));
              alj.setMaxHuespedes(rs.getInt("MAXHUESPED"));
              alj.setNumDormitorios(rs.getInt("NUMDORMITORIOS"));
              alj.setNumCamas(rs.getInt("NUMCAMAS"));
              alj.setNumBaños(rs.getInt("NUMBAÑOS"));
              alj.setUbicacionDescrita(rs.getString("UBICACIONDESCRITA"));
              alj.setCaracteristicas(rs.getString("CARACTERISTICAS"));
              alj.setServicio(rs.getString("SERVICIO"));
              alj.setLocalidad(rs.getString("LOCALIDAD"));
              alj.setValoracionGlobal(rs.getInt("VALORACIONGLOBAL"));
              alj.setAnfitrion_email(rs.getString("ANFITRION_EMAIL"));
              lista.add(alj);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
