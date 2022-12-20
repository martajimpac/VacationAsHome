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
    private CoordenadasGPS ubicacionPrecisaGPS = new CoordenadasGPS();
    private Date fechaEntradda = new Date();
    private String nombre = "";
    private int maxHuespedes = 0;
    private int numDormitorios = 0;
    private int numCamas = 0;
    private int numBaños = 0;
    private String ubicacionDescrita = "";
    private String caracteristicas = "";
    private TipoServicio servicio;
    private boolean acepracionReserva = false;
    private String Localidad =  "" ; //TODO
    private int valoracionGlobal = 0;
    private String anfitrion_email = "";

    public void setUbicacionPrecisaGPS(CoordenadasGPS ubicacionPrecisaGPS) {
        this.ubicacionPrecisaGPS = ubicacionPrecisaGPS;
    }

    public void setFechaEntradda(Date fechaEntradda) {
        this.fechaEntradda = fechaEntradda;
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

    public void setAcepracionReserva(boolean acepracionReserva) {
        this.acepracionReserva = acepracionReserva;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public void setValoracionGlobal(int valoracionGlobal) {
        this.valoracionGlobal = valoracionGlobal;
    }

    public void setAnfitrion_email(String anfitrion_email) {
        this.anfitrion_email = anfitrion_email;
    }
    
    public CoordenadasGPS getUbicacionPrecisaGPS() {
        return ubicacionPrecisaGPS;
    }

    public Date getFechaEntradda() {
        return fechaEntradda;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaxHuespedes() {
        return maxHuespedes;
    }

    public int getNumDormitorios() {
        return numDormitorios;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public int getNumBaños() {
        return numBaños;
    }

    public String getUbicacionDescrita() {
        return ubicacionDescrita;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public TipoServicio getServicio() {
        return servicio;
    }

    public boolean isAcepracionReserva() {
        return acepracionReserva;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public int getValoracionGlobal() {
        return valoracionGlobal;
    }

    public String getAnfitrion_email() {
        return anfitrion_email;
    }
}
