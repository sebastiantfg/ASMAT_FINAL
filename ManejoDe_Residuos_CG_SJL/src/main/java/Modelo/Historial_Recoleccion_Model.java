
package Modelo;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;


public class Historial_Recoleccion_Model {
    
    public Vector<Historial_Recoleccion> Cargar(){
        String consulta = "SELECT Historial";
        Vector<Historial_Recoleccion> lista = new Vector<Historial_Recoleccion>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Historial_Recoleccion con = new Historial_Recoleccion();
                 con.setHistorial(resultado.getString(1));
                 
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
     public Historial_Recoleccion Buscar(String Historial){
        
        Historial_Recoleccion con = new Historial_Recoleccion();
        try {
            String consulta = "SELECT Historial where Historial = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, Historial);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setHistorial(resultado.getString(1));
                 
                
            }
        } catch (SQLException e) {
        }
         return con;
    }
     public void Insertar(Historial_Recoleccion con){
        
        try {
            String consulta = "insert into Historial_Recoleccion values(?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getHistorial());
            
            sentencia.executeUpdate();
        } catch (SQLException e) {
     
       }
    }
     public void Eliminar(String Historial){
        try {
            String consulta = "Delete Historial Where Historial = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, Historial);
            sentencia.executeUpdate();
        } catch (SQLException e) 
        {
        
 
        }
     }
     
    
}
