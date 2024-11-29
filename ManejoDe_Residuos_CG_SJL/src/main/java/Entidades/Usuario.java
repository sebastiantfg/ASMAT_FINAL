
package Entidades;

public class Usuario extends Persona{
    
    public Usuario(){
        super();
    }
    public String getCodUsuario() {
        return CodUsuario;
    }

    public void setCodUsuario(String CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    private String CodUsuario;
    private String Correo;
    private String Contraseña;
    
    
}
