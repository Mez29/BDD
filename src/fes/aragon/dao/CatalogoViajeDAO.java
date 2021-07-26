/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.dao;

import fes.aragon.mysql.Conexion;
import fes.aragon.pojo.CatalogoViaje;
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
public class CatalogoViajeDAO {
    private Conexion con;
    
    public CatalogoViajeDAO() throws ClassNotFoundException, SQLException{
        con= new Conexion();
    }
    public void insertar(CatalogoViaje tmpCatalogoViaje) throws SQLException {
        String query ="{call almacen_catalogo_viaje(?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setString(1, tmpCatalogoViaje.getMotivo_Viaje());
        solicitud.execute();
        solicitud.close();
        con.getConexion().close();
    }
    public ArrayList<CatalogoViaje> buscarCatalogoViaje() throws SQLException{
        String query ="select * from catalogos_viajes";
        Statement solicitar = con.getConexion().createStatement();
        ArrayList<CatalogoViaje> info = new ArrayList<>();
        ResultSet datos = solicitar.executeQuery(query);
        if (!datos.next()) {
            System.out.println("No hay datos");
        } else {
            do {                
               CatalogoViaje viaje=new CatalogoViaje();
                viaje.setId_Motivo(datos.getInt(1));
                viaje.setMotivo_Viaje(datos.getString(2));
                info.add(viaje);
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
