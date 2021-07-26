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
public class ViajeAsignar {
    private int Id_Viaje;
    private int Id_Pais;
    private int Id_Motivo;
    private String pais;
    private String motivo;

    public ViajeAsignar() {
    }

    public int getId_Viaje() {
        return Id_Viaje;
    }

    public void setId_Viaje(int Id_Viaje) {
        this.Id_Viaje = Id_Viaje;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return motivo;
    } 
}
