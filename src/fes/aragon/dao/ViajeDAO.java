/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.dao;

import fes.aragon.mysql.Conexion;
import fes.aragon.pojo.Profesor;
import fes.aragon.pojo.Viaje;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mez29
 */
public class ViajeDAO {
    private Conexion con;
    
    public ViajeDAO() throws ClassNotFoundException, SQLException{
        con= new Conexion();
    }
    public void insertar(Viaje tmpViaje) throws SQLException {
        String query ="{call almacen_viaje(?,?,?,?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setDate(1, tmpViaje.getFecha_Inicio());
        solicitud.setDate(2, tmpViaje.getFecha_Fin());
        solicitud.setInt(3, tmpViaje.getId_Pais());
        solicitud.setInt(4, tmpViaje.getId_Viaje());
        solicitud.execute();
        solicitud.close();
        con.getConexion().close();
    }
    public ArrayList<Viaje> buscarViaje() throws SQLException{
        String query ="select * from viajes";
        Statement solicitar = con.getConexion().createStatement();
        ArrayList<Viaje> info = new ArrayList<>();
        ResultSet datos = solicitar.executeQuery(query);
        if (!datos.next()) {
            System.out.println("No hay datos");
        } else {
            do {                
                Viaje viaje=new Viaje();
                viaje.setId_Viaje(datos.getInt(1));
                viaje.setFecha_Inicio(datos.getDate(2));
                viaje.setFecha_Fin(datos.getDate(3));
                viaje.setId_Pais(datos.getInt(4));
                viaje.setId_Viaje(datos.getInt(5));
                info.add(viaje);
            } while (datos.next());
        }
        solicitar.close();
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
