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
public abstract class Servicio {
    protected String codigoServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected LocalDate diaSemana;

    public Servicio(String codigoServicio, double porcentajeDescuento, boolean enPromocion) throws IllegalArgumentException{
        //Si no tiene justamente 6 caracteres o es nulo, tira una Exception
        if(codigoServicio.length() != 6 || codigoServicio == null){
        throw new IllegalArgumentException("El servicio debe tener justo 6 caracteres y no puede ser nulo");
        }
        
        this.codigoServicio = codigoServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
        this.diaSemana = LocalDate.now();
       
    }
    
    //Metodo abstracto
    public abstract double calcularPrecioFinal(LocalDate dia);

    //Getters
    public String getCodigoServicio() {
        return codigoServicio;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public LocalDate getDiaSemana() {
        return diaSemana;
    }

    //To string
    @Override
    public String toString() {
        return "Servicio{" + "codigoServicio=" + codigoServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion + ", diaSemana=" + diaSemana + '}';
    }

}


