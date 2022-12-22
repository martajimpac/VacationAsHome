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
public class Alojamiento {
    private GPS ubicacionPrecisaGPS = new GPS();
    private Date fechaEntrada = new Date();
    private String nombre = "";
    private int maxHuespedes = 0;
    private int numDormitorios = 0;
    private int numCamas = 0;
    private int numBaños = 0;
    private String ubicacionDescrita = "";
    private String caracteristicas = "";
    private TipoServicio servicio;
    private boolean aceptacionReserva = false;
    private Localidad Localidad =  new Localidad(); 
    private int valoracionGlobal = 0;
    private String anfitrion_email = "";

    public void setUbicacionPrecisaGPS(GPS ubicacionPrecisaGPS) {
        this.ubicacionPrecisaGPS = ubicacionPrecisaGPS;
    }

    public void setFechaEntrada(Date fechaEntradda) {
        this.fechaEntrada = fechaEntradda;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaxHuespedes(int maxHuespedes) {
        this.maxHuespedes = maxHuespedes;
    }

    public void setNumDormitorios(int numDormitorios) {
        this.numDormitorios = numDormitorios;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public void setNumBaños(int numBaños) {
        this.numBaños = numBaños;
    }

    public void setUbicacionDescrita(String ubicacionDescrita) {
        this.ubicacionDescrita = ubicacionDescrita;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setServicio(TipoServicio servicio) {
        this.servicio = servicio;
    }

    public void setAceptacionReserva(boolean acepracionReserva) {
        this.aceptacionReserva = acepracionReserva;
    }

    public void setLocalidad(Localidad Localidad) {
        this.Localidad = Localidad;
    }

    public void setValoracionGlobal(int valoracionGlobal) {
        this.valoracionGlobal = valoracionGlobal;
    }

    public void setAnfitrion_email(String anfitrion_email) {
        this.anfitrion_email = anfitrion_email;
    }
    
    public GPS getUbicacionPrecisaGPS() {
        return this.ubicacionPrecisaGPS;
    }

    public Date getFechaEntradda() {
        return this.fechaEntrada;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getMaxHuespedes() {
        return this.maxHuespedes;
    }

    public int getNumDormitorios() {
        return this.numDormitorios;
    }

    public int getNumCamas() {
        return this.numCamas;
    }

    public int getNumBaños() {
        return this.numBaños;
    }

    public String getUbicacionDescrita() {
        return this.ubicacionDescrita;
    }

    public String getCaracteristicas() {
        return this.caracteristicas;
    }

    public TipoServicio getServicio() {
        return this.servicio;
    }

    public boolean isAceptacionReserva() {
        return this.aceptacionReserva;
    }

    public Localidad getLocalidad() {
        return this.Localidad;
    }

    public int getValoracionGlobal() {
        return this.valoracionGlobal;
    }

    public String getAnfitrion_email() {
        return this.anfitrion_email;
    }
}
