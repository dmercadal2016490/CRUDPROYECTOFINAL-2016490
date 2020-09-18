
package modeloDAO;

import ModeloDeDatos.Persona;
import configuracion.Conexion;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PersonaDAO implements CRUD {
    Conexion connect = new Conexion(); 
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    Persona nPersona = new Persona();
    @Override
    public List listar() {
        ArrayList<Persona> listaPersona = new ArrayList<Persona>();
        String sql = "select * from Persona";
        try{
            con= connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Persona nuevaPersona = new Persona();
                nuevaPersona.setCodigoPersona(rs.getInt("codigoPersona"));
                nuevaPersona.setDPI(rs.getString("DPI"));
                nuevaPersona.setNombrePersona(rs.getString("nombrePersona"));
                listaPersona.add(nuevaPersona);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaPersona;
    }

    @Override
    public Persona list(int id) {
       String sql = "select * from Persona where codigoPersona = " + id;
        try{
            con= connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                nPersona.setCodigoPersona(rs.getInt("codigoPersona"));
                nPersona.setDPI(rs.getString("DPI"));
                nPersona.setNombrePersona(rs.getString("nombrePersona"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nPersona;
    }

    @Override
    public boolean add(Persona per) {
       String sql = "insert into Persona(DPI,nombrePersona) values('" + per.getDPI() + "','" + per.getNombrePersona() + "')";
        try{
            con= connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editar(Persona per) {
        String sql = "update Persona set DPI = '" + per.getDPI() + "', nombrePersona = '" + per.getNombrePersona() + "' where codigoPersona = " + per.getCodigoPersona();
        try{
            con= connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from Persona where codigoPersona = " + id;
        try{
            con= connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
   
}
