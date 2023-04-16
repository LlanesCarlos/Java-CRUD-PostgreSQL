package com.mycompany.java_crud_postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class CConexion {
    Connection conectar = null;
    String usuario = "postgres";
    String contrasena = "contrasena";
    String bd = "bd";
    String ip = "localhost"; 
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try{
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Conexión exitosa.");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos:"+e.toString());
        }
        return conectar;
    }
}