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
public class Pais {
    private int Id_Pais;
    private String Nombre_Pais;

    public Pais() {
    }

    public int getId_Pais() {
        return Id_Pais;
    }

    public void setId_Pais(int Id_Pais) {
        this.Id_Pais = Id_Pais;
    }

    public String getNombre_Pais() {
        return Nombre_Pais;
    }

    public void setNombre_Pais(String Nombre_Pais) {
        this.Nombre_Pais = Nombre_Pais;
    }

    @Override
    public String toString() {
        return Nombre_Pais;
    }
}
