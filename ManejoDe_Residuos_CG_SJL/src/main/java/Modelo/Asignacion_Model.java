
package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;
public class Asignacion_Model {
    
    public Vector<Asignacion> Cargar(){
        String consulta = "SELECT Numero , Fecha";
        Vector<Asignacion> lista = new Vector<Asignacion>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Asignacion con = new Asignacion();
                 con.setNumero(resultado.getInt(1));
                 con.setFecha(resultado.getDate(2));
                
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public Asignacion Buscar(int Numero){
        
        Asignacion con = new Asignacion();
        try {
            String consulta = "SELECT Numero, Fecha where Numero = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setInt(1, Numero);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setNumero(resultado.getInt(1));
                 con.setFecha(resultado.getDate(2));
                
            }
        } catch (SQLException e) {
        }
        return con;
    }
     public void Insertar(Asignacion con){
        
        try {
            String consulta = "insert into Asignacion values(?,?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setInt(1, con.getNumero());
            sentencia.setDate(2, con.getFecha());
            sentencia.executeUpdate();
        } catch (SQLException e) {
     
       }
    }
     
      public void Modificar( Asignacion con){
        
        try {
            String consulta = "Update Asignacion set"
                            + " Numero = ?,"
                            + " Fecha = ?,"
                            + " Where Numero = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setInt(1, con.getNumero());
            sentencia.setDate(2, con.getFecha());
            
            sentencia.executeUpdate();
        } catch (SQLException e) {
            
        }       
    } 
      
      public void Eliminar(int Numero){
        try {
            String consulta = "Delete Asignacion Where Numero = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setInt(1, Numero );
            sentencia.executeUpdate();
        } catch (SQLException e) 
        {
        
 
        }
        
}}
      

