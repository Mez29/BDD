/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.pojo;

/**
 *
 * @author mez29
 */
public class Profesor {
    private int Id_Profesor;
    private String Curp;
    private String Nombre;
    private String Ap_Paterno;
    private String Ap_Materno;
    private int Id_Despacho;

    public Profesor() {
    }

    public int getId_Profesor() {
        return Id_Profesor;
    }

    public void setId_Profesor(int Id_Profesor) {
        this.Id_Profesor = Id_Profesor;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAp_Paterno() {
        return Ap_Paterno;
    }

    public void setAp_Paterno(String Ap_Paterno) {
        this.Ap_Paterno = Ap_Paterno;
    }

    public String getAp_Materno() {
        return Ap_Materno;
    }

    public void setAp_Materno(String Ap_Materno) {
        this.Ap_Materno = Ap_Materno;
    }

    public int getId_Despacho() {
        return Id_Despacho;
    }

    public void setId_Despacho(int Id_Despacho) {
        this.Id_Despacho = Id_Despacho;
    }

    @Override
    public String toString() {
        return Curp + "-" + Ap_Paterno;
    }
}
