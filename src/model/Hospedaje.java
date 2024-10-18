/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Hospedaje extends Servicio {

    private String hospedaje;
    private double precioPorNoche;

    //Constructor
    public Hospedaje(String codigoServicio, String hospedaje, double precioPorNoche, double porcentajeDescuento, boolean enPromocion) throws IllegalArgumentException {
        super(codigoServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }
    
    
    
    //Metodo abstracto
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        //Chquea que el dia no sea ni sabado ni domingo para aplicar el descuento
        double retorno = precioPorNoche;  
        if(isEnPromocion()){
            if(dia.getDayOfWeek() != DayOfWeek.SATURDAY && dia.getDayOfWeek() != DayOfWeek.SUNDAY){
            retorno = precioPorNoche * (1 - porcentajeDescuento / 100);
            }
        }
        return retorno;
    }

    //Getters
    public String getHospedaje() {
        return hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
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

    @Override
    public String toString() {
        return "Hospedaje{" + "hospedaje=" + hospedaje + ", precioPorNoche=" + super.toString() + precioPorNoche + '}';
    }
    
}
