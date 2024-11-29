package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;
public class Usuario_Model {
    public Vector<Usuario> Cargar(){
        String consulta = "SELECT CodUsuario, Nombre, Apellido, Dni, Correo, Contraseña FROM Usuario";
        Vector<Usuario> lista = new Vector<Usuario>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Usuario con = new Usuario();
                con.setCodUsuario(resultado.getString(1));
                con.setNombre(resultado.getString(2));
                con.setApellido(resultado.getString(3));
                con.setDni(resultado.getString(4));
                con.setCorreo(resultado.getString(5));
                con.setContraseña(resultado.getString(6));
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public Usuario Buscar(String CodUsuario){
        
        Usuario con = new Usuario();
        try {
            String consulta = "SELECT CodUsuario, Nombre, Apellido, Dni, Correo, Contraseña FROM Usuario where CodUsuario = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodUsuario);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setCodUsuario(resultado.getString(1));
                con.setNombre(resultado.getString(2));
                con.setApellido(resultado.getString(3));
                con.setDni(resultado.getString(4));
                con.setCorreo(resultado.getString(5));
                con.setContraseña(resultado.getString(6));
            }
        } catch (SQLException e) {
        }
        return con;
    }
    public void Insertar(Usuario con){
        
        try {
            String consulta = "insert into Usuario values(?,?,?,?,?,?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getCodUsuario());
            sentencia.setString(2, con.getNombre());
            sentencia.setString(3, con.getApellido());
            sentencia.setString(4, con.getDni());
            sentencia.setString(5, con.getCorreo());
            sentencia.setString(6, con.getContraseña());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Modificar(Usuario con){
        
        try {
            String consulta = "Update Usuario set"
                            + " Nombre = ?,"
                            + " Apellido = ?,"
                            + " Dni = ?,"
                            + " Correo = ?,"
                            + " Contraseña = ?"
                            + " Where CodUsuario = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getNombre());
            sentencia.setString(2, con.getApellido());
            sentencia.setString(3, con.getDni());
            sentencia.setString(4, con.getCorreo());
            sentencia.setString(5, con.getContraseña());
            sentencia.setString(6, con.getCodUsuario());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Eliminar(String CodUsuario){
        
        try {
            String consulta = "Delete Usuario Where CodUsuario = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodUsuario);
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
