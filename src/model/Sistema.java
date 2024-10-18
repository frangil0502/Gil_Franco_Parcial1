/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Sistema {

    private List<Servicio> lstServicio;

    //Constyructor
    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public Servicio traerServicio(String codServicio) throws NotFoundException {
        //Busca un servivio, si lo encuentra lo retorna y sino lanza una Exception
        Servicio servicioEncontrado = null;

        for (Servicio s : lstServicio) {
            if (s.getCodigoServicio().equals(codServicio)) {
                servicioEncontrado = s;
            }
        }
        if (servicioEncontrado == null) {
            throw new NotFoundException("El servicio solicitado no se encuentra");
        }
        return servicioEncontrado;
    }

    public List<Servicio> traerServicio(boolean enPromocion) throws Exception {
        //Devuelve una lista con los servicios que concuerden el valor de su atributo de promocion con l¿el valor del poarametro. Sino encuentra ninguno, lanza una Exception 
        List serviciosPromo = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                serviciosPromo.add(s);
            }
        }
        if (serviciosPromo.isEmpty()) {
            throw new Exception("No hay ningun servicio con el parametro solicitado");
        }

        return serviciosPromo;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        //Trae los servicios que concuerden con ambos parametros. Que esten o no en promocion y sean de ese dia
        List<Servicio> serviciosPromocionDia = new ArrayList<>();

        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                if (servicio.getDiaSemana().equals(dia)) {
                    serviciosPromocionDia.add(servicio);
                }
            }
        }
        return serviciosPromocionDia;

    }

    //Busca si ya existe esa gastronomia y si la encuentra, lanza una Exception. Si no, la agrega
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception{
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodigoServicio().equals(codServicio)) {
                throw new Exception("El servicio con ese código ya existe.");
            }
        }
        Gastronomia gastronomiaAgregada = new Gastronomia(gastronomia, precio, diaSemDesc, codServicio, porcentajeDescuento, enPromocion);
        lstServicio.add(gastronomiaAgregada);
        return true;
    }

    // Busca si ya existe el hospedaje. Si existe lanza una Exception y sino lo agrega 
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodigoServicio().equals(codServicio)) {
                throw new Exception("El servicio con ese código ya existe.");
            }
        }
        Hospedaje hospedajeAgregado = new Hospedaje(codServicio, hospedaje, precioPorNoche, porcentajeDescuento, enPromocion);
        lstServicio.add(hospedajeAgregado);
        return true;
    }
    
//Retorna todos los servicios agregados a la lista
    public List<Servicio> traerListaServiciosCargados(){
        return lstServicio;
    }
    
    
}
