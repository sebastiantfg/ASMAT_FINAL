package Entidades;
public class Trabajador extends Persona{
    public Trabajador(){
        super();
    }
    public String getCodTrabajador() {
        return codTrabajador;
    }

    public void setCodTrabajador(String codTrabajador) {
        this.codTrabajador = codTrabajador;
    }

    public Float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(Float Sueldo) {
        this.Sueldo = Sueldo;
    }

    public Trabajador getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(Trabajador Supervisor) {
        this.Supervisor = Supervisor;
    }
    
    private String codTrabajador;
    private Float  Sueldo;
    private Trabajador Supervisor;
    
    
}
