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
    private Moneda precioNoche = new Moneda();
    private Moneda precioFinDeSemana = new Moneda();
    private Moneda precioMes = new Moneda();
    private Date fechaIncio  = new Date();
    private Date fechaFin  = new Date();
    private String alojamiento_ubicacion_precisa = "";
    private String alojamiento_anfitrion_email = "";

    public void setPrecioNoche(Moneda precioNoche) {
        this.precioNoche = precioNoche;
    }

    public void setPrecioFinDeSemana(Moneda precioFinDeSemana) {
        this.precioFinDeSemana = precioFinDeSemana;
    }

    public void setPrecioMes(Moneda precioMes) {
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
    
        public Moneda getPrecioNoche() {
        return precioNoche;
    }

    public Moneda getPrecioFinDeSemana() {
        return precioFinDeSemana;
    }

    public Moneda getPrecioMes() {
        return precioMes;
    }

    public Date getFechaIncio() {
        return fechaIncio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getAlojamiento_ubicacion_precisa() {
        return alojamiento_ubicacion_precisa;
    }

    public String getAlojamiento_anfitrion_email() {
        return alojamiento_anfitrion_email;
    }
}


