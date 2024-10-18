/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.time.LocalDate;
import model.Gastronomia;
import model.Hospedaje;
import model.Sistema;

/**
 *
 * @author Usuario
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("1");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("1-1");
        try {
            Gastronomia gastronomia1 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "4892", 15.0, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("1-2");
        try {
            Gastronomia gastronomia1 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "489235", 15.0, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("1-3");
        try {
            Hospedaje hospedaje1 = new Hospedaje("2872", "Cabaña 3 personas", 1500.0, 10.0, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("1-4");
        try {
            Hospedaje hospedaje1 = new Hospedaje("287282", "Cabaña 3 personas", 1500.0, 10.0, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("2");
        try {
            Gastronomia gastronomia1 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "489235", 15.0, true);
            System.out.println(gastronomia1.calcularPrecioFinal(LocalDate.of(2020, 10, 28)));
            System.out.println("2-2");
            Hospedaje hospedaje1 = new Hospedaje("287282", "Cabaña 3 personas", 1500.0, 10.0, true);

            System.out.println(hospedaje1.calcularPrecioFinal(LocalDate.of(2020, 10, 27)));
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("3");
        Sistema sistemaPrincipal = new Sistema();
        
        try{
        sistemaPrincipal.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
        sistemaPrincipal.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
        sistemaPrincipal.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
        sistemaPrincipal.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
            System.out.println(sistemaPrincipal.traerListaServiciosCargados().toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("4");
        try{
            System.out.println(sistemaPrincipal.traerServicio(true));
            System.out.println(sistemaPrincipal.traerServicio(true, LocalDate.of(2020, 10, 28)));
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    
    }

}
