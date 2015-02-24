/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Userwin8
 */
public class OperacionesDB {
    
   private  Connection conn = null;
    public String setRutas()
    {
        return System.getProperty("user.dir").toString();
    }

    
    
    
    public Connection conexion() {
     
    
    
    if (conn != null) {
            return conn;
        }
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir").toString()
              +"/sqlitedb/inventario.db");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Opened database successfully");
        
        return conn;
        
    }
    
    
    public void registrarProd(int id_codigo, String nombre_cod){
    
        Connection conn = null;
        Statement stmt = null;
        
       
         try {
            conn = conexion();
            conn.setAutoCommit(false);
            
            stmt = conn.createStatement();
            
            int z = stmt.executeUpdate(" INSERT INTO productos(ID_prod,nombre) VALUES ('"+id_codigo+"','"+nombre_cod+"')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");
            }
            stmt.close();
            conn.commit();
            conn.close();
            
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }  
         
        public void operacion(int id_codigo, String nombre_cod){
    
        Connection conn = null;
        Statement stmt = null;
        
        conexion();
         try {
            conn = conexion();
            conn.setAutoCommit(false);
            
            stmt = conn.createStatement();
            //int z = s.executeUpdate(" INSERT INTO codigo (id_codigo) VALUES ('"+id_codigo+"')");
            int z = stmt.executeUpdate(" INSERT INTO productos (ID_prod,nombre) VALUES ('"+id_codigo+"','"+nombre_cod+"')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");
            }
            
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

    }
    
    
    
    
    
    
    
}
