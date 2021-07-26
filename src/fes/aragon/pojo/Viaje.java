/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.pojo;

import java.sql.Date;

/**
 *
 * @author mez29
 */
public class Viaje {
    private int Id_Viaje;
    private Date Fecha_Inicio;
    private Date Fecha_Fin;
    private int Id_Pais;
    private int Id_Motivo;

    public Viaje() {
    }

    public int getId_Viaje() {
        return Id_Viaje;
    }

    public void setId_Viaje(int Id_Viaje) {
        this.Id_Viaje = Id_Viaje;
    }

    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(Date Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(Date Fecha_Fin) {
        this.Fecha_Fin = Fecha_Fin;
    }

    public int getId_Pais() {
        return Id_Pais;
    }

    public void setId_Pais(int Id_Pais) {
        this.Id_Pais = Id_Pais;
    }

    public int getId_Motivo() {
        return Id_Motivo;
    }

    public void setId_Motivo(int Id_Motivo) {
        this.Id_Motivo = Id_Motivo;
    }

    @Override
    public String toString() {
        return Fecha_Inicio + "-" + Fecha_Fin ;
    }
}
