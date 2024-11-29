package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;
public class Repuesto_Model {
    public Vector<Repuesto> Cargar(){
        String consulta = "SELECT Codigo, Nombre, Precio, FecCambio FROM Repuesto";
        Vector<Repuesto> lista = new Vector<Repuesto>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Repuesto con = new Repuesto();
                con.setCodigo(resultado.getInt(1));
                con.setNombre(resultado.getString(2));
                con.setPrecio(resultado.getFloat(3));
                con.setFecCambio(resultado.getDate(4));
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public Repuesto Buscar(String CodConductor){
        
        Repuesto con = new Repuesto();
        try {
            String consulta = "SELECT Codigo, Nombre, Precio, FecCambio FROM Repuesto where Codigo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodConductor);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setCodigo(resultado.getInt(1));
                con.setNombre(resultado.getString(2));
                con.setPrecio(resultado.getFloat(3));
                con.setFecCambio(resultado.getDate(4));
            }
        } catch (SQLException e) {
        }
        return con;
    }
    public void Insertar(Repuesto con){
        
        try {
            String consulta = "insert into Repuesto values(?,?,?, ?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setInt(1, con.getCodigo());
            sentencia.setString(2, con.getNombre());
            sentencia.setFloat(3, con.getPrecio());
            sentencia.setDate(4, con.getFecCambio());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Modificar(Repuesto con){
        
        try {
            String consulta = "Update Repuesto set"
                            + " Nombre = ?,"
                            + " Precio = ?,"
                            + " FecCambio = ?"
                            + " Where Codigo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getNombre());
            sentencia.setFloat(2, con.getPrecio());
            sentencia.setDate(3, con.getFecCambio());
            sentencia.setInt(4, con.getCodigo());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Eliminar(String CodConductor){
        
        try {
            String consulta = "Delete Repuesto Where Codigo = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodConductor);
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
