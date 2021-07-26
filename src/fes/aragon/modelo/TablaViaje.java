/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import fes.aragon.pojo.CatalogoViaje;
import fes.aragon.pojo.Pais;
import fes.aragon.pojo.Viaje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mez29
 */
public class TablaViaje extends AbstractTableModel{
    private ArrayList<Viaje> datos= new ArrayList<Viaje>();
    private String[] nombreColumna={"Fecha_In","Fecha_Fin","Pais","Motivo"};
    private DefaultComboBoxModel modeloPais;
    private DefaultComboBoxModel modeloCatalogoViaje;

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
        String patron="dd/MM/yyyy";
        SimpleDateFormat formato=new SimpleDateFormat(patron);
        if (columnIndex==0) {
            String fecha=formato.format(datos.get(rowIndex).getFecha_Inicio());
            celda=fecha;
        }
        else if (columnIndex==1) {
            String fecha=formato.format(datos.get(rowIndex).getFecha_Fin());
            celda=fecha;
        }
        else if (columnIndex==2) {
            for (int i = 1; i < modeloPais.getSize(); i++) {
                Pais ps=(Pais)modeloPais.getElementAt(i);
                if(datos.get(rowIndex).getId_Pais()==ps.getId_Pais()){
                    celda=ps.getNombre_Pais();
                    break;
                }
            }
        } else{
            for (int i = 1; i < modeloCatalogoViaje.getSize(); i++) {
                CatalogoViaje mot=(CatalogoViaje)modeloCatalogoViaje.getElementAt(i);
                if(datos.get(rowIndex).getId_Viaje()==mot.getId_Motivo()){
                    celda=mot.getMotivo_Viaje();
                }
            }
         }
        return celda;
    }

    public ArrayList<Viaje> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Viaje> datos) {
        this.datos = datos;
    }

    public DefaultComboBoxModel getModeloPais() {
        return modeloPais;
    }

    public void setModeloPais(DefaultComboBoxModel modeloPais) {
        this.modeloPais = modeloPais;
    }

    public DefaultComboBoxModel getModeloCatalogoViaje() {
        return modeloCatalogoViaje;
    }

    public void setModeloCatalogoViaje(DefaultComboBoxModel modeloCatalogoViaje) {
        this.modeloCatalogoViaje = modeloCatalogoViaje;
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
