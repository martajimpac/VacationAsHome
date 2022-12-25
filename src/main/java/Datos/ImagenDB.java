/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Modelo.Alojamiento;
import Modelo.Imagen;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author paula
 */
public class ImagenDB {
  //Buscamos las imagenes de un grupo de alojamientos
    public static ArrayList <Imagen> buscarImagenesAlojamientos(ArrayList <Alojamiento> alojamientos) {
        
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //buscar imagenes de los alojamientos de la lista
      
        String query = "SELECT * FROM IMAGEN i JOIN ALOJAMIENTO a WHERE i.`Alojamiento_ubicacionPrecisa` = a.`ubicacionPrecisa`AND i.`Alojamiento_ubicacionPrecisa` LIKE ?;";
        
        //Crear las variables
        ArrayList <Imagen> imagenes = new ArrayList();
        Imagen im = null;
      
        try {
            ps = connection.prepareStatement(query);
            for(int i=0;i<alojamientos.size();i++){
                ps.setString(1, alojamientos.get(i).getUbicacionPrecisaGPS());
                rs = ps.executeQuery();
                while (rs.next()) {
                im = new Imagen();
                im.setEtiqueta(rs.getString("etiqueta"));
                im.setImagen(rs.getBlob("imagen"));
                imagenes.add(im);
                }
            }
            //cerramos
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return imagenes;
          
        } catch (Exception e) {
            return null;
        }
    }
    public static Imagen buscarImagenesReserva(String ubicacion) {
        
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //buscar imagenes de los alojamientos de la lista
      
        String query = "SELECT * FROM IMAGEN i JOIN ALOJAMIENTO a WHERE i.`Alojamiento_ubicacionPrecisa` = a.`ubicacionPrecisa`AND i.`Alojamiento_ubicacionPrecisa` LIKE ?;";
        
        //Crear las variables
        Imagen imagen = null;
      
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ubicacion);
            rs = ps.executeQuery();
            while(rs.next()){
                imagen.setEtiqueta(rs.getString("etiqueta"));
                imagen.setImagen(rs.getBlob("imagen"));
                imagen.setAlojamiento_ubicacionPrecisa(rs.getString("Alojamiento_ubicacionPrecisa"));
            }
            //cerramos
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return imagen;
          
        } catch (Exception e) {
            return null;
        }
    }
}
