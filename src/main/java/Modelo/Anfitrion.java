/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author paula
 */
public class Anfitrion {
    private String nombre = "";
    private String email = "";
    private String idiomas = "";
    private boolean identidadIdentificada = false;
    private int ratioRespuesta =0;
    private int tiempoMedioRespuesta =0;
    private boolean superAnfitrion = false;
    private Date fechaSubscripcion = new Date();
    private String password = "";

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public boolean isIdentidadIdentificada() {
        return identidadIdentificada;
    }

    public int getRatioRespuesta() {
        return ratioRespuesta;
    }

    public int getTiempoMedioRespuesta() {
        return tiempoMedioRespuesta;
    }

    public boolean isSuperAnfitrion() {
        return superAnfitrion;
    }

    public Date getFechaSubscripcion() {
        return fechaSubscripcion;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public void setIdentidadIdentificada(boolean identidadIdentificada) {
        this.identidadIdentificada = identidadIdentificada;
    }

    public void setRatioRespuesta(int ratioRespuesta) {
        this.ratioRespuesta = ratioRespuesta;
    }

    public void setTiempoMedioRespuesta(int tiempoMedioRespuesta) {
        this.tiempoMedioRespuesta = tiempoMedioRespuesta;
    }

    public void setSuperAnfitrion(boolean superAnfitrion) {
        this.superAnfitrion = superAnfitrion;
    }

    public void setFechaSubscripcion(Date fechaSubscripcion) {
        this.fechaSubscripcion = fechaSubscripcion;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
