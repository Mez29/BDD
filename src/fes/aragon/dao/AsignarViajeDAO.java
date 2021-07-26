/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.dao;

import fes.aragon.mysql.Conexion;
import fes.aragon.pojo.Profesor;
import fes.aragon.pojo.Viaje;
import fes.aragon.pojo.ViajeAsignar;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mez29
 */
public class AsignarViajeDAO {
    private Conexion con;
    
    public AsignarViajeDAO() throws ClassNotFoundException, SQLException{
        con= new Conexion();
    }
    public void almacenarAsignarViaje(int Id_Profesor,int Id_Viaje) throws SQLException {
        String query ="{call almacenar_profesor_viaje(?,?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setInt(1, Id_Profesor);
        solicitud.setInt(2, Id_Profesor);
        solicitud.execute();
        solicitud.close();
        con.getConexion().close();
    }
    public ArrayList<Profesor> buscarProfesor(String patron) throws SQLException{
        String query ="{call buscar_profesor(?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setString(1, patron);
        ArrayList<Profesor> info = new ArrayList<>();
        ResultSet datos = solicitud.executeQuery();
        if (!datos.next()) {
            System.out.println("No hay datos");
        } else {
            do {                
                Profesor prof=new Profesor();
                prof.setId_Profesor(datos.getInt(1));
                prof.setCurp(datos.getString(2));
                prof.setNombre(datos.getString(3));
                prof.setAp_Paterno(datos.getString(4));
                info.add(prof);
            } while (datos.next());
        }
        solicitud.close();
        con.getConexion().close();
        datos.close();
        return info;
    }
     public ArrayList<ViajeAsignar> buscarViaje(Date fecha_uno, Date fecha_dos) throws SQLException{
        String query ="{call buscar_viaje(?,?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setDate(1, fecha_uno);
        solicitud.setDate(2, fecha_dos);
        ArrayList<ViajeAsignar> info = new ArrayList<>();
        ResultSet datos = solicitud.executeQuery();
        if (!datos.next()) {
            System.out.println("No hay datos");
        } else {
            do {                
                ViajeAsignar asig=new ViajeAsignar();
                asig.setId_Viaje(datos.getInt(1));
                asig.setId_Pais(datos.getInt(2));
                asig.setId_Motivo(datos.getInt(3));
                asig.setPais(datos.getString(4));
                asig.setMotivo(datos.getString(5));
                info.add(asig);
            } while (datos.next());
        }
        solicitud.close();
        con.getConexion().close();
        datos.close();
        return info;
     
    }
     public void modificar(Viaje tmpViaje) throws SQLException {
        String query ="{call modificar_viaje(?,?,?,?,?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setInt(1, tmpViaje.getId_Viaje());
        solicitud.setDate(2, tmpViaje.getFecha_Inicio());
        solicitud.setDate(3, tmpViaje.getFecha_Fin());
        solicitud.setInt(4, tmpViaje.getId_Pais());
        solicitud.setInt(5, tmpViaje.getId_Viaje());
        solicitud.execute();
        solicitud.close();
        con.getConexion().close();
    }
}
