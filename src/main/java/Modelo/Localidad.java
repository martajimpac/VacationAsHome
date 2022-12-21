/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author marta
 */
public class Localidad {
    private String provincia = "";
    private String municipio = "";

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public String getMunicipio() {
        return this.municipio;
    }
}
