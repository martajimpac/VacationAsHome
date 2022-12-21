/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Modelo.Alojamiento;
import Modelo.CoordenadasGPS;
import Modelo.TipoServicio;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author marta
 */
public class AlojamientoDB {
    
    public static ArrayList <Alojamiento> buscarLocalidadyHuespedes(String provincia,String municipio, int numHuespedes) {
        
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //buscar alojamientos en la localidad y que tengan espacio para el numero de huespedes introducido
        String query = "SELECT * FROM ALOJAMIENTO a JOIN LOCALIDAD l"
        + "WHERE l.provincia = ? AND l.municipio = ? AND a.maxHuesped <= ?;";
        
        //Crear las variables
        ArrayList <Alojamiento> alojamientos = new ArrayList();
        Alojamiento aloj = null;
        TipoServicio servicio = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, provincia);
            ps.setString(1, municipio);
            ps.setInt(1, numHuespedes);
            rs = ps.executeQuery();
            while (rs.next()) {
                aloj = new Alojamiento();
                aloj.setUbicacionPrecisaGPS((CoordenadasGPS) rs.getObject("a.ubicacionPrecisa"));
                aloj.setFechaEntrada(rs.getDate("a.fechaEntrada"));
                aloj.setNombre(rs.getString("a.nombre"));
                aloj.setMaxHuespedes(rs.getInt("a.maxHuesped"));
                aloj.setNumDormitorios(rs.getInt("a.numDormitorios"));
                aloj.setNumCamas(rs.getInt("a.numCamas"));
                aloj.setNumBaños(rs.getInt("a.numBaños"));
                aloj.setUbicacionDescrita(rs.getString("a.ubicacionDescrita"));
                aloj.setCaracteristicas(rs.getString("a.caracteriticas"));
                aloj.setServicio((TipoServicio) rs.getObject("a.servicio"));
                aloj.setLocalidad(rs.getString("a.localidad"));
                aloj.setValoracionGlobal(rs.getInt("a.valoracionGlobal"));
                aloj.setAnfitrion_email(rs.getString("a.anfitrionEmail"));
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
    
    //FALTA COMPROBAR QUE ESTEN EN LA LOCALIDAD INDICADA, creo que falta la R en fecha salida
     public static ArrayList <Alojamiento> consulta(String prov, String muni,Date d1,Date d2,int num) {
        Conexion pool = Conexion.getInstance(); 
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ALOJAMIENTO A JOIN RESERVA r "
        + "WHERE A.MAXHUESPED >= ? AND A.ACEPTACIONRESERVA=FALSE OR R.FECHAENTRADA>? AND FECHASALIDA<?;";
        
        try {
             ArrayList<Alojamiento>lista= new ArrayList<Alojamiento>() ;
            ps = connection.prepareStatement(query);
            ps.setInt(1, num);
            ps.setDate(2, (java.sql.Date) d1);
            ps.setDate(3, (java.sql.Date) d2);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alojamiento alj = new Alojamiento();
                alj.setUbicacionPrecisaGPS((CoordenadasGPS) rs.getObject("UBICACIONPRECISA"));
                alj.setFechaEntrada(rs.getDate("FECHAENTRADA"));
                alj.setNombre(rs.getString("NOMBRE"));
                alj.setMaxHuespedes(rs.getInt("MAXHUESPED"));
                alj.setNumDormitorios(rs.getInt("NUMDORMITORIOS"));
                alj.setNumCamas(rs.getInt("NUMCAMAS"));
                alj.setNumBaños(rs.getInt("NUMBAÑOS"));
                alj.setUbicacionDescrita(rs.getString("UBICACIONDESCRITA"));
                alj.setCaracteristicas(rs.getString("CARACTERISTICAS"));
                alj.setServicio((TipoServicio) rs.getObject("SERVICIO"));
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
