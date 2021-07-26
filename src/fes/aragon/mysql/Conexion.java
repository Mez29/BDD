/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mez29
 */
public class Conexion {
    private String url="jdbc:mysql://localhost:3306/gastos_proyecto?serverTimezone=UTC";
    private String programador="Programador1";
    private String clave="12345";
    private Connection conexion;
    
    public Conexion() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion= DriverManager.getConnection(url,programador,clave);
    }

    public Connection getConexion() {
        return conexion;
    } 
}
