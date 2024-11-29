/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Sanchez Mesia
 */
public class Vehiculo {

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Float getCapacidadCarga() {
        return CapacidadCarga;
    }

    public void setCapacidadCarga(Float CapacidadCarga) {
        this.CapacidadCarga = CapacidadCarga;
    }
    
    private String Placa;
    private String Tipo;
    private Float CapacidadCarga;
    
    public String toString(){
        return this.Placa;
    }
}
