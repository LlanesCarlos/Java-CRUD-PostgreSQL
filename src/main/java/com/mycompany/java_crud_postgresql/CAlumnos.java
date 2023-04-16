package com.mycompany.java_crud_postgresql;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CAlumnos {
    int codigo;
    String nombreAlumno;
    String apellidoAlumno;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }
    
    public void mostrarAlumnos(JTable paramTablaTotalAlumnos){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        
        paramTablaTotalAlumnos.setModel(modelo);
        
        sql = "select * from Alumnos";
        
        String [] datos = new String[3];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                
                modelo.addRow(datos);
            }
            paramTablaTotalAlumnos.setModel(modelo);
        } catch (Exception e){ 
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }
    
    public void insertarAlumnos(JTextField paramNombre, JTextField paramApellido){
        setNombreAlumno(paramNombre.getText());
        setApellidoAlumno(paramApellido.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta  = "insert into Alumnos (nombres, apellidos) values (?, ?)";
        
        try{
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNombreAlumno());
            cs.setString(2, getApellidoAlumno());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se agregó correctamente.");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }
    
    public void seleccionarAlumnos(JTable paramTablaAlumnos, JTextField paramCodigo, JTextField paramNombre, JTextField paramApellido){
        try{
            int fila = paramTablaAlumnos.getSelectedRow();
            if (fila>=0){
                paramCodigo.setText(paramTablaAlumnos.getValueAt(fila, 0).toString());
                paramNombre.setText(paramTablaAlumnos.getValueAt(fila, 1).toString());       
                paramApellido.setText(paramTablaAlumnos.getValueAt(fila, 2).toString());       
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada.");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }
    
    public void modificarAlumnos(JTextField paramCodigo, JTextField paramNombre, JTextField paramApellido){
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombreAlumno(paramNombre.getText());
        setApellidoAlumno(paramApellido.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta  = "update Alumnos set nombres = ?, apellidos = ? where Alumnos.id = ?";
        
        try{
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNombreAlumno());
            cs.setString(2, getApellidoAlumno());
            cs.setInt(3, getCodigo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modificó correctamente.");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }
    
    public void eliminarAlumnos(JTextField paramCodigo){
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta  = "delete from Alumnos where Alumnos.id = ?";
        
        try{
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, getCodigo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente.");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }
};
