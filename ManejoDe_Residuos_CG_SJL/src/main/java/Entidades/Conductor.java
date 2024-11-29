/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Sanchez Mesia
 */
public class Conductor extends Persona{
    private String CodConductor;
    private Float Sueldo;
    private String Licencia;
    private String NumCell;
    private String CodVehiculo;

    public Conductor(){
        super();
    }
    public String getCodConductor() {
        return CodConductor;
    }

    public void setCodConductor(String CodConductor) {
        this.CodConductor = CodConductor;
    }

    public Float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(Float Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getLicencia() {
        return Licencia;
    }

    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }

    public String getNumCell() {
        return NumCell;
    }

    public void setNumCell(String NumCell) {
        this.NumCell = NumCell;
    }

    public String getCodVehiculo() {
        return CodVehiculo;
    }

    public void setCodVehiculo(String CodVehiculo) {
        this.CodVehiculo = CodVehiculo;
    }
    
}
