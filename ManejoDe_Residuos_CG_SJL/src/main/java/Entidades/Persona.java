
package Entidades;


public class Persona {

    public Persona(){
        
    }
    public Persona(String Nombre, String Apellido, String Dni)
    {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Dni = Dni;
        
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }
    
    private String Nombre;
    private String Apellido;
    private String Dni;
    
    
}
