/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import fes.aragon.pojo.CatalogoViaje;
import fes.aragon.pojo.Pais;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mez29
 */
public class TablaCatalogoViaje extends AbstractTableModel{
    private ArrayList<CatalogoViaje> datos= new ArrayList<CatalogoViaje>();
    private String[] nombreColumna={"Viaje"};

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
        if (columnIndex==0) {
            celda=datos.get(rowIndex).getMotivo_Viaje();
        }
        return celda;
    }

    public ArrayList<CatalogoViaje> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<CatalogoViaje> datos) {
        this.datos = datos;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumna[column];
    }   
}
