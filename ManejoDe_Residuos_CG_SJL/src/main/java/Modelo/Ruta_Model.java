
package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;

public class Ruta_Model {
    
     public Vector<Ruta> Cargar(){
        String consulta = "SELECT IdRuta";
        Vector<Ruta> lista = new Vector<Ruta>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Ruta con = new Ruta();
                 con.setIdRuta(resultado.getString(1));
                
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
       public Ruta Buscar(String IdRuta){
        
        Ruta con = new Ruta();
        try {
            String consulta = "SELECT IdRuta where IdRuta = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, IdRuta);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
              con.setIdRuta(resultado.getString(1));
                
                
            }
        } catch (SQLException e) {
        }
        return con;
    }
       public void Insertar(Ruta con){
        
        try {
            String consulta = "insert into Ruta values(?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getIdRuta());

            sentencia.executeUpdate();
        } catch (SQLException e) {
     
       }
    }
         public void Modificar( Ruta con){
        
        try {
            String consulta = "Update Ruta set"
                            + " IdRuta = ?,"                    
                            + " Where IdRuta = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getIdRuta());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            
        }       
    } 
         public void Eliminar(String IdRuta ){
        try {
            String consulta = "Delete Ruta Where IdRuta = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, IdRuta );
            sentencia.executeUpdate();
        } catch (SQLException e) 
        {
        
 
        }
    }   
    
    
}
