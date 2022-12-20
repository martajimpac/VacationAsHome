/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;

/**
 *
 * @author marta
 */
public class Imagen {
   private String etiqueta = "";
   private File imagen;
   private String alojamiento_ubicacionPrecisa = "";
   private String alojamiento_anfitrion_email = "";

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public void setAlojamiento_ubicacionPrecisa(String alojamiento_ubicacionPrecisa) {
        this.alojamiento_ubicacionPrecisa = alojamiento_ubicacionPrecisa;
    }

    public void setAlojamiento_anfitrion_email(String alojamiento_anfitrion_email) {
        this.alojamiento_anfitrion_email = alojamiento_anfitrion_email;
    }

    public String getEtiqueta() {
        return this.etiqueta;
    }

    public File getImagen() {
        return this.imagen;
    }

    public String getAlojamiento_ubicacionPrecisa() {
        return this.alojamiento_ubicacionPrecisa;
    }

    public String getAlojamiento_anfitrion_email() {
        return this.alojamiento_anfitrion_email;
    }
}
