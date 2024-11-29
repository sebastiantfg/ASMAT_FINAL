package Modelo;

import Entidades.Trabajador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Trabajador_Model {
    public Vector<Trabajador> Cargar(){
        String consulta = "SELECT CodTrabajador, Nombre, Apellido, Dni, Sueldo, Supervisor FROM Trabajador";
        Vector<Trabajador> lista = new Vector<Trabajador>();
        try {
            Statement sentencia = Conexion.conectarMySQL().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                Trabajador con = new Trabajador();
                con.setCodTrabajador(resultado.getString(1));
                con.setNombre(resultado.getString(2));
                con.setApellido(resultado.getString(3));
                con.setDni(resultado.getString(4));
                con.setSueldo(resultado.getFloat(5));
                //con.setSupervisor(resultado.get(3));
                lista.add(con);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public Trabajador Buscar(String CodTrabajador){
        
        Trabajador con = new Trabajador();
        try {
            String consulta = "SELECT CodTrabajador, Nombre, Apellido, Dni, Sueldo, Supervisor FROM Trabajador where CodTrabajador = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodTrabajador);
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while (resultado.next())
            {
                con.setCodTrabajador(resultado.getString(1));
                con.setNombre(resultado.getString(2));
                con.setApellido(resultado.getString(3));
                con.setDni(resultado.getString(4));
                con.setSueldo(resultado.getFloat(5));
                //con.setSupervisor(resultado.get(3));
            }
        } catch (SQLException e) {
        }
        return con;
    }
    public void Insertar(Trabajador con){
        
        try {
            String consulta = "insert into Trabajador values(?,?,?,?,?,?)";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getCodTrabajador());
            sentencia.setString(2, con.getNombre());
            sentencia.setString(3, con.getApellido());
            sentencia.setString(4, con.getDni());
            sentencia.setFloat(5, con.getSueldo());
            sentencia.setString(6, con.getSupervisor().getCodTrabajador());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Modificar(Trabajador con){
        
        try {
            String consulta = "Update Trabajador set"
                            + " Nombre = ?,"
                            + " Apellido = ?,"
                            + " Dni = ?,"
                            + " Sueldo = ?"
                            + " Supervisor = ?"
                            + " Where CodTrabajador = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, con.getNombre());
            sentencia.setString(2, con.getApellido());
            sentencia.setString(3, con.getDni());
            sentencia.setFloat(4, con.getSueldo());
            sentencia.setString(5, con.getSupervisor().getCodTrabajador());
            sentencia.setString(6, con.getCodTrabajador());
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void Eliminar(String CodTrabajador){
        
        try {
            String consulta = "Delete Trabajador Where CodTrabajador = ?";
            PreparedStatement sentencia = Conexion.conectarMySQL().prepareStatement(consulta);
            sentencia.setString(1, CodTrabajador);
            sentencia.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
