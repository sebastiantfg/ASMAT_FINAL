
package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;

public class Zonas_Model {
    
     public Vector<Zonas> Cargar(){
        String consulta = "SELECT NomZona , Direccion ";
        Vector<Zonas> lista = new Vector<Zonas>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Zonas con = new Zonas();
                 con.setNomZona(resultado.getString(1));
                 con.setDireccion(resultado.getString(2));
                
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
     public Zonas Buscar(String NomZona){
        
        Zonas con = new Zonas();
        try {
            String consulta = "SELECT NomZona , Direccion  where NomZona = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, NomZona);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setNomZona(resultado.getString(1));
                 con.setDireccion(resultado.getString(2));
                
            }
        } catch (SQLException e) {
        }
        return con;
    }
      public void Insertar(Zonas con){
        
        try {
            String consulta = "insert into Zonas values(?,?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getNomZona());
            sentencia.setString(2, con.getDireccion());
            sentencia.executeUpdate();
        } catch (SQLException e) {
     
       }
    }
      public void Modificar( Zonas con){
        
        try {
            String consulta = "Update Zonas set"
                            + " NomZona = ?,"
                            + " Direccion = ?,"
                            + " Where NomZona = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getNomZona());
            sentencia.setString(2, con.getDireccion());
            
            sentencia.executeUpdate();
        } catch (SQLException e) {
            
        }       
    }
      public void Eliminar(String Zonas){
        try {
            String consulta = "Delete Zonas Where NomZona = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
              sentencia.setString(1,Zonas);
              sentencia.executeUpdate();
        } catch (SQLException e) 
        {
        
 
        }
      
     
     
    
}
