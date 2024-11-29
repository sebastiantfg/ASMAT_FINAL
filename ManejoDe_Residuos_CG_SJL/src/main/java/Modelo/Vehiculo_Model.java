package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;
public class Vehiculo_Model {
    public Vector<Vehiculo> Cargar(){
        String consulta = "SELECT Placa, Tipo, CapacidadCarga FROM Vehiculo";
        Vector<Vehiculo> lista = new Vector<Vehiculo>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Vehiculo con = new Vehiculo();
                con.setPlaca(resultado.getString(1));
                con.setTipo(resultado.getString(2));
                con.setCapacidadCarga(resultado.getFloat(3));
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public Vehiculo Buscar(String CodConductor){
        
        Vehiculo con = new Vehiculo();
        try {
            String consulta = "SELECT Placa, Tipo, CapacidadCarga FROM Vehiculo where Placa = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodConductor);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setPlaca(resultado.getString(1));
                con.setTipo(resultado.getString(2));
                con.setCapacidadCarga(resultado.getFloat(3));
            }
        } catch (SQLException e) {
        }
        return con;
    }
    public void Insertar(Vehiculo con){
        
        try {
            String consulta = "insert into Vehiculo values(?,?,?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getPlaca());
            sentencia.setString(2, con.getTipo());
            sentencia.setFloat(3, con.getCapacidadCarga());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Modificar(Vehiculo con){
        
        try {
            String consulta = "Update Vehiculo set"
                            + " Tipo = ?,"
                            + " CapacidadCarga = ?"
                            + " Where Placa = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getTipo());
            sentencia.setFloat(2, con.getCapacidadCarga());
            sentencia.setString(3, con.getPlaca());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Eliminar(String CodConductor){
        
        try {
            String consulta = "Delete Vehiculo Where Placa = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodConductor);
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
