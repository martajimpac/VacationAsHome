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
public class Reserva {
    private int ID = 0;
    private Date fechaEntrada = new Date();
    private Date fechaSalida = new Date();
    private int numHuespedes = 0;
    private String comentarios = "";
    private EstadoReserva estado;
    private boolean dividePago = false;
    private String usuarioRegistrado_email = "";
    private String alojamiento_ubicacion_precisa = ""; //TODO
    private String alojamiento_anfitrion_email = "";

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setNumHuespedes(int numHuespedes) {
        this.numHuespedes = numHuespedes;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public void setDividePago(boolean dividePago) {
        this.dividePago = dividePago;
    }

    public void setUsuarioRegistrado_email(String usuarioRegistrado_email) {
        this.usuarioRegistrado_email = usuarioRegistrado_email;
    }

    public void setAlojamiento_ubicacion_precisa(String alojamiento_ubicacion_precisa) {
        this.alojamiento_ubicacion_precisa = alojamiento_ubicacion_precisa;
    }

    public void setAlojamiento_anfitrion_email(String alojamiento_anfitrion_email) {
        this.alojamiento_anfitrion_email = alojamiento_anfitrion_email;
    }

    public int getID() {
        return this.ID;
    }

    public Date getFechaEntrada() {
        return this.fechaEntrada;
    }

    public Date getFechaSalida() {
        return this.fechaSalida;
    }

    public int getNumHuespedes() {
        return this.numHuespedes;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public EstadoReserva getEstado() {
        return this.estado;
    }

    public boolean isDividePago() {
        return this.dividePago;
    }

    public String getUsuarioRegistrado_email() {
        return this.usuarioRegistrado_email;
    }

    public String getAlojamiento_ubicacion_precisa() {
        return this.alojamiento_ubicacion_precisa;
    }

    public String getAlojamiento_anfitrion_email() {
        return this.alojamiento_anfitrion_email;
    }
}
