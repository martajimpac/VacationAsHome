/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author franc
 */
public class ClienteDB {
    
    // comprobamos si el email ha sido registrado anteriormente en la base de datos
    public static boolean emailExists(String emailAddress) {
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT EMAIL FROM CLIENTE "
        + "WHERE EMAIL = ?;";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            boolean res = rs.next();
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            
            return res;
        } catch (Exception e) {
            return false;
        }
    }
    
    // Comprobamos si existe ese Cliente en la base de datos
    public static boolean userExists(String emailAddress, String password) {
        Conexion pool = Conexion.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT EMAIL, PASSWORD FROM CLIENTE "
        + "WHERE EMAIL = ? AND PASSWORD = ?;";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            ps.setString(2, password);
            rs = ps.executeQuery();
            boolean res = rs.next();
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (Exception e) {
            return false;
        }
    }
}
