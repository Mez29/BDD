/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import fes.aragon.pojo.Despacho;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mez29
 */
public class TablaDespacho extends AbstractTableModel{
    private ArrayList<Despacho> datos= new ArrayList<Despacho>();
    private String[] nombreColumna={"Despacho"};

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
            celda=datos.get(rowIndex).getNombre_Despacho();
        }
        return celda;
    }

    public ArrayList<Despacho> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Despacho> datos) {
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
