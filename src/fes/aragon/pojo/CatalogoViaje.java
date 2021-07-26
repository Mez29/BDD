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
public class CatalogoViaje {
    private int Id_Motivo;
    private String Motivo_Viaje;

    public CatalogoViaje() {
    }

    public int getId_Motivo() {
        return Id_Motivo;
    }

    public void setId_Motivo(int Id_Motivo) {
        this.Id_Motivo = Id_Motivo;
    }

    public String getMotivo_Viaje() {
        return Motivo_Viaje;
    }

    public void setMotivo_Viaje(String Motivo_Viaje) {
        this.Motivo_Viaje = Motivo_Viaje;
    }

    @Override
    public String toString() {
        return Motivo_Viaje;
    }
}
