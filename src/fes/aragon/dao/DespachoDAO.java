/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.dao;

import fes.aragon.mysql.Conexion;
import fes.aragon.pojo.Despacho;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mez29
 */
public class DespachoDAO {
    private Conexion con;
    
    public DespachoDAO() throws ClassNotFoundException, SQLException{
        con=new Conexion();
    }
    public void guardar(String nombreDespacho) throws SQLException{
        String query ="{call almacen_despacho(?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setString(1, nombreDespacho);
        solicitud.execute();
        solicitud.close();
        con.getConexion().close();
    }
    public ArrayList<Despacho> obtenerDespacho() throws SQLException{
        String query ="select * from despachos";
        Statement solicitar = con.getConexion().createStatement();
        ArrayList<Despacho> info = new ArrayList<>();
        ResultSet datos = solicitar.executeQuery(query);
        if (!datos.next()) {
            System.out.println("No hay datos");
        } else {
            do {                
                Despacho tmp= new Despacho();
                tmp.setId_Despacho(datos.getInt(1));
                tmp.setNombre_Despacho(datos.getString(2));
                info.add(tmp);
            } while (datos.next());
        }
        solicitar.close();
        con.getConexion().close();
        datos.close();
        return info;
    }
}
