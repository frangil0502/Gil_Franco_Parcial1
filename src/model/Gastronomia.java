/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Gastronomia extends Servicio {

    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    //Constructor
    public Gastronomia(String gastronomia, double precio, int diaSemDesc, String codigoServicio, double porcentajeDescuento, boolean enPromocion) throws IllegalArgumentException {
        super(codigoServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    //Getters
    public String getGastronomia() {
        return gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    //Metodo abstracto
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
       //Si el numero del dia es igual al ingresado por parametros, aplica el descuento
        double retorno = precio;
        if (isEnPromocion()) {
            if (dia.getDayOfWeek().getValue() == diaSemDesc) {
                retorno = precio * (1 - porcentajeDescuento / 100);
            }
        }
        return retorno;
    }
    
    //To string
    @Override
    public String toString() {
        return "Gastronomia{" + "gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + super.toString()+ diaSemDesc + '}';
    }

}
