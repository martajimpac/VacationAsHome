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
    public static ArrayList <Imagen> buscarImagenesAlojamientos(Arraylist <Alojamiento> alojamientos) {
        
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //buscar imagenes de los alojamientos de la lista
      
        String query = "SELECT * FROM IMAGEN i JOIN ALOJAMIENTO a ON i.Anfitrion_email = a.Anfitrion_email";
        
        //Crear las variables
        ArrayList <Imagen> imagenes = new ArrayList();
        Imagen im = null;
      
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, provincia);
            ps.setString(1, municipio);
            ps.setInt(1, numHuespedes);
            rs = ps.executeQuery();
            while (rs.next()) {
                im = new Imagen();
                im.setEtiqueta(rs.getString("i.etiqueta"));
                im.setImagen(rs.getString("i.imagen"));
                
                imagenes.add(im);
            }
            //de aqui tengo que sacar los alojamientos pero no se como
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return imagenes;
          
        } catch (Exception e) {
            return null;
        }
    }
}
Footer
© 2022 GitHub, Inc.
Footer navigation
Terms
Privacy
Security
