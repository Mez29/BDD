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
public class Despacho {
    private int Id_Despacho;
    private String nombre_Despacho;

    public Despacho() {
    }

    public int getId_Despacho() {
        return Id_Despacho;
    }

    public void setId_Despacho(int Id_Despacho) {
        this.Id_Despacho = Id_Despacho;
    }

    public String getNombre_Despacho() {
        return nombre_Despacho;
    }

    public void setNombre_Despacho(String nombre_Despacho) {
        this.nombre_Despacho = nombre_Despacho;
    }

    @Override
    public String toString() {
        return nombre_Despacho;
    }   
}

