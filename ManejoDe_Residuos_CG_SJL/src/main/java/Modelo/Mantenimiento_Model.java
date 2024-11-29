
package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;
public class Mantenimiento_Model {
    
     public Vector<Mantenimiento> Cargar(){
        String consulta = "SELECT CodigoVehiculo , Secuencia , Fecha , Observacion ";
        Vector<Mantenimiento> lista = new Vector<Mantenimiento>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Mantenimiento con = new Mantenimiento();
                 con.setCodigoVehiculo(resultado.getString(1));
                 con.setSecuencia(resultado.getInt(2));
                  con.setFecha(resultado.getDate(3));
                 con.setObservacion(resultado.getString(4));
                
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
     public Mantenimiento Buscar(String CodigoVehiculo ){
        
        Mantenimiento con = new Mantenimiento();
        try {
            String consulta = "SELECT CodigoVehiculo , Secuencia , Fecha , Observacion  where CodigoVehiculo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1,CodigoVehiculo);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setCodigoVehiculo(resultado.getString(1));
                 con.setFecha(resultado.getDate(2));
                
            }
        } catch (SQLException e) {
        }
        return con;
    }
      public void Insertar(Mantenimiento con){
        
        try {
            String consulta = "insert into Mantenimiento values(?,?,?,?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getCodigoVehiculo());
            sentencia.setInt(2, con.getSecuencia());
            sentencia.setDate(3, con.getFecha());
            sentencia.setString(4, con.getObservacion());
            sentencia.executeUpdate();
        } catch (SQLException e) {
     
       }
    }
      
       public void Modificar( Mantenimiento con){
        
        try {
            String consulta = "Update Mantenimiento set"
                            + " CodigoVehiculo = ?,"
                            + " Secuencia = ?,"
                            + " Fecha = ?,"
                            + " Observacion  = ?,"
                            + " Where CodigoVehiculo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getCodigoVehiculo());
            sentencia.setInt(2, con.getSecuencia());
            sentencia.setDate(3, con.getFecha());
            sentencia.setString(4, con.getObservacion());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            
        }  
       } 
        public void Eliminar(String CodigoVehiculo){
        try {
            String consulta = "Delete Mantenimiento Where CodigoVehiculo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodigoVehiculo);
            sentencia.executeUpdate();
        } catch (SQLException e) 
        {
        
 
        }
        
        
     
    
}}
