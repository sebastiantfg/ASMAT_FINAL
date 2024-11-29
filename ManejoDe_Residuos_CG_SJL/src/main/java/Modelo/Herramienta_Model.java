
package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;

public class Herramienta_Model {
    
    public Vector<Herramienta> Cargar(){
        String consulta = "SELECT Nombre ,Codigo";
        Vector<Herramienta> lista = new Vector<Herramienta>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Herramienta con = new Herramienta();
                 con.setNombre(resultado.getString(1));
                 con.setCodigo(resultado.getInt(2));
                
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public Herramienta Buscar(int Codigo){
        
        Herramienta con = new Herramienta();
        try {
            String consulta = "SELECT Nombre,Codigo where Codigo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setInt(1, Codigo);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setNombre(resultado.getString(1));
                 con.setCodigo(resultado.getInt(2));
                
            }
        } catch (SQLException e) {
        }
        return con;
    }
     public void Insertar(Herramienta con){
        
        try {
            String consulta = "insert into Herramienta values(?,?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getNombre());
            sentencia.setInt(2, con.getCodigo());
            sentencia.executeUpdate();
        } catch (SQLException e) {
     
       }
    }
      public void Modificar( Herramienta con){
        
        try {
            String consulta = "Update Herramienta set"
                            + " Nombre = ?,"
                            + " Codigo= ?,"
                            + " Where Codigo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getNombre());
            sentencia.setInt(2, con.getCodigo());
            
            sentencia.executeUpdate();
        } catch (SQLException e) {     
        }
    }  
       public void Eliminar(int Codigo){
        try {
            String consulta = "Delete Herramienta Where Codigo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setInt(1, Codigo );
            sentencia.executeUpdate();
        } catch (SQLException e) 
        {
        
 
        }
}}
    


