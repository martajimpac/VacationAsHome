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
public class Precio {
    private float precioNoche =0;
    private float precioFinDeSemana = 0;
    private float precioMes = 0;
    private Date fechaIncio  = new Date();
    private Date fechaFin  = new Date();
    private String alojamiento_ubicacion_precisa = null;
    private String alojamiento_anfitrion_email = "";

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

    public void setPrecioFinDeSemana(float precioFinDeSemana) {
        this.precioFinDeSemana = precioFinDeSemana;
    }

    public void setPrecioMes(float precioMes) {
        this.precioMes = precioMes;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setAlojamiento_ubicacion_precisa(String alojamiento_ubicacion_precisa) {
        this.alojamiento_ubicacion_precisa = alojamiento_ubicacion_precisa;
    }

    public void setAlojamiento_anfitrion_email(String alojamiento_anfitrion_email) {
        this.alojamiento_anfitrion_email = alojamiento_anfitrion_email;
    }
    
        public float getPrecioNoche() {
        return this.precioNoche;
    }

    public float getPrecioFinDeSemana() {
        return this.precioFinDeSemana;
    }

    public float getPrecioMes() {
        return this.precioMes;
    }

    public Date getFechaIncio() {
        return this.fechaIncio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public String getAlojamiento_ubicacion_precisa() {
        return this.alojamiento_ubicacion_precisa;
    }

    public String getAlojamiento_anfitrion_email() {
        return this.alojamiento_anfitrion_email;
    }
}


