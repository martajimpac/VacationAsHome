/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;
/**
 *
 * @author marta
 */
public class Cliente {
    private String email = "";
    private Date fechaSubscripcion = new Date();
    private String password = "";

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaSubscripcion(Date fechaSubscripcion) {
        this.fechaSubscripcion = fechaSubscripcion;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaSubscripcion() {
        return fechaSubscripcion;
    }

    public String getPassword() {
        return password;
    }
}
