/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import fes.aragon.pojo.CatalogoViaje;
import fes.aragon.pojo.Pais;
import fes.aragon.pojo.ProfesorViaje;
import fes.aragon.pojo.Viaje;
import fes.aragon.pojo.ViajeAsignar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mez29
 */
public class TablaViajeProfesorAsignar extends AbstractTableModel{
    private ArrayList<ProfesorViaje> datos= new ArrayList<ProfesorViaje>();
    private String[] nombreColumna={"Nombre","Ap_Paterno","Pais","Motivo"};
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumna.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String celda=""; 
        if (columnIndex==0){
            celda=datos.get(rowIndex).getProfesor().getNombre();
        }
        else if (columnIndex==1) {
            celda=datos.get(rowIndex).getProfesor().getAp_Paterno();
        }
        else if (columnIndex==2) {
            celda=datos.get(rowIndex).getViaje().getPais();
        }
        else {
            celda=datos.get(rowIndex).getViaje().getMotivo();
        }
        return celda;
    }

    public ArrayList<ProfesorViaje> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<ProfesorViaje> datos) {
        this.datos = datos;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumna[column];
    }  
}
