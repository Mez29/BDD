/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.dao;

import fes.aragon.mysql.Conexion;
import fes.aragon.pojo.Despacho;
import fes.aragon.pojo.Profesor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mez29
 */
public class ProfesorDAO {
    private Conexion con;
    
    public ProfesorDAO() throws ClassNotFoundException, SQLException{
        con= new Conexion();
    }
    public void insertar(Profesor tmpProfesor) throws SQLException {
        String query ="{call almacen_profesor(?,?,?,?,?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setString(1, tmpProfesor.getCurp());
        solicitud.setString(2, tmpProfesor.getNombre());
        solicitud.setString(3, tmpProfesor.getAp_Paterno());
        solicitud.setString(4, tmpProfesor.getAp_Materno());
        solicitud.setInt(5, tmpProfesor.getId_Despacho());
        solicitud.execute();
        solicitud.close();
        con.getConexion().close();
    }
    public ArrayList<Profesor> buscarProfesor() throws SQLException{
        String query ="select * from profesor";
        Statement solicitar = con.getConexion().createStatement();
        ArrayList<Profesor> info = new ArrayList<>();
        ResultSet datos = solicitar.executeQuery(query);
        if (!datos.next()) {
            System.out.println("No hay datos");
        } else {
            do {                
                Profesor prof=new Profesor();
                prof.setId_Profesor(datos.getInt(1));
                prof.setCurp(datos.getString(2));
                prof.setNombre(datos.getString(3));
                prof.setAp_Materno(datos.getString(4));
                prof.setAp_Paterno(datos.getString(5));
                prof.setId_Despacho(datos.getInt(6));
                info.add(prof);
            } while (datos.next());
        }
        solicitar.close();
        con.getConexion().close();
        datos.close();
        return info;
    }
     public void modificar(Profesor tmpProfesor) throws SQLException {
        String query ="{call modificar_profesor(?,?,?,?,?,?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setInt(1, tmpProfesor.getId_Profesor());
        solicitud.setString(2, tmpProfesor.getCurp());
        solicitud.setString(3, tmpProfesor.getNombre());
        solicitud.setString(4, tmpProfesor.getAp_Paterno());
        solicitud.setString(5, tmpProfesor.getAp_Materno());
        solicitud.setInt(6, tmpProfesor.getId_Despacho());
        solicitud.execute();
        solicitud.close();
        con.getConexion().close();
    }
}
