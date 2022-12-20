/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author marta
 */
public class Moneda {
    private int cantidad = 0;
    private char simbolo = ' ';

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public char getSimbolo() {
        return this.simbolo;
    }
    
}
