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
public class Mensaje {
    private String contenido = "";
    private Date fechaEnvio = new Date();
    private String cliente_email = "";
    private String anfitrion_email = "";

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    public void setAnfitrion_email(String anfitrion_email) {
        this.anfitrion_email = anfitrion_email;
    }

    public String getContenido() {
        return contenido;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public String getAnfitrion_email() {
        return anfitrion_email;
    }
}
