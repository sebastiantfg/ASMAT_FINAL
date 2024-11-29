package Modelo;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import java.sql.PreparedStatement;
import java.util.Vector;
public class Conductor_Model {
    public Vector<Conductor> Cargar(){
        String consulta = "SELECT CodConductor, Nombre, Apellido, Dni, Sueldo, Licencia, NumCell, CodVehiculo FROM Conductor";
        Vector<Conductor> lista = new Vector<Conductor>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Conductor con = new Conductor();
                con.setCodConductor(resultado.getString(1));
                con.setNombre(resultado.getString(2));
                con.setApellido(resultado.getString(3));
                con.setDni(resultado.getString(4));
                con.setCodConductor(resultado.getString(5));
                con.setSueldo(resultado.getFloat(6));
                con.setLicencia(resultado.getString(7));
                con.setNumCell(resultado.getString(8));
                con.setCodVehiculo(resultado.getString(9));
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public Conductor Buscar(String CodConductor){
        
        Conductor con = new Conductor();
        try {
            String consulta = "SELECT CodConductor, Nombre, Apellido, Dni, Sueldo, Licencia, NumCell, CodVehiculo FROM Conductor where CodConductor = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodConductor);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setCodConductor(resultado.getString(1));
                con.setNombre(resultado.getString(2));
                con.setApellido(resultado.getString(3));
                con.setDni(resultado.getString(4));
                con.setCodConductor(resultado.getString(5));
                con.setSueldo(resultado.getFloat(6));
                con.setLicencia(resultado.getString(7));
                con.setNumCell(resultado.getString(8));
                con.setCodVehiculo(resultado.getString(9));
            }
        } catch (SQLException e) {
        }
        return con;
    }
    public void Insertar(Conductor con){
        
        try {
            String consulta = "insert into Conductor values(?,?,?,?,?,?,?,?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getCodConductor());
            sentencia.setString(2, con.getNombre());
            sentencia.setString(3, con.getApellido());
            sentencia.setString(4, con.getDni());
            sentencia.setFloat(5, con.getSueldo());
            sentencia.setString(6, con.getLicencia());
            sentencia.setString(7, con.getNumCell());
            sentencia.setString(8, con.getCodVehiculo());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Modificar( Conductor con){
        
        try {
            String consulta = "Update Conductor set"
                            + " Nombre = ?,"
                            + " Apellido = ?,"
                            + " Dni = ?,"
                            + " Sueldo = ?,"
                            + " Licencia = ?,"
                            + " NumCell = ?,"
                            + " CodVehiculo = ?"
                            + " Where CodConductor = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getNombre());
            sentencia.setString(2, con.getApellido());
            sentencia.setString(3, con.getDni());
            sentencia.setFloat(4, con.getSueldo());
            sentencia.setString(5, con.getLicencia());
            sentencia.setString(6, con.getNumCell());
            sentencia.setString(7, con.getCodConductor());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Eliminar(String CodConductor){
        
        try {
            String consulta = "Delete Conductor Where CodConductor = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodConductor);
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
