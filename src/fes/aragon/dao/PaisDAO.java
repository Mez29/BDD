/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.dao;

import fes.aragon.mysql.Conexion;
import fes.aragon.pojo.Despacho;
import fes.aragon.pojo.Pais;
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
public class PaisDAO {
    private Conexion con;
    
    public PaisDAO() throws ClassNotFoundException, SQLException{
        con= new Conexion();
    }
    public void insertar(Pais tmpPais) throws SQLException {
        String query ="{call almacenar_pais(?)}";
        CallableStatement solicitud =con.getConexion().prepareCall(query);
        solicitud.setString(1, tmpPais.getNombre_Pais());
        solicitud.execute();
        solicitud.close();
        con.getConexion().close();
    }
    public ArrayList<Pais> buscarPais() throws SQLException{
        String query ="select * from paises";
        Statement solicitar = con.getConexion().createStatement();
        ArrayList<Pais> info = new ArrayList<>();
        ResultSet datos = solicitar.executeQuery(query);
        if (!datos.next()) {
            System.out.println("No hay datos");
        } else {
            do {                
               Pais pais=new Pais();
                pais.setId_Pais(datos.getInt(1));
                pais.setNombre_Pais(datos.getString(2));
                info.add(pais);
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
