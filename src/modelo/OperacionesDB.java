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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Userwin8
 */
public class OperacionesDB {

    public String setRutas() {
        return System.getProperty("user.dir").toString();
    }

    public Connection conexion() {

        Connection conn = null;

        if (conn != null) {
            return conn;
        }
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir").toString()
                    + "/sqlitedb/inventario.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return conn;

    }

    public void registrarProd(int id_codigo, String nombre_cod) {

        Connection conn = null;
        Statement stmt = null;

        if (existeRegistro(id_codigo) < 1) {
            try {
                conn = conexion();
                conn.setAutoCommit(false);

                stmt = conn.createStatement();

                int z = stmt.executeUpdate(" INSERT INTO productos(ID_prod,nombre) VALUES ('" + id_codigo + "','" + nombre_cod + "')");
                if (z == 1) {
                     JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa");
                } else {
                    System.out.println("Ocurrio un problema al agregar el registro");
                }
                stmt.close();
                conn.commit();
                conn.close();

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "El Registro ya Existe intente de nuevo con otro codigo");
        }


    }

    public void operacion(int id_cod_prod, String nombre_op,int cant_Uni,int precio_uni) {

        Connection conn = null;
        Statement stmt = null;
        

        if (existeRegistro(id_cod_prod) == 1) {
            try {
                conn = conexion();
                conn.setAutoCommit(false);

                stmt = conn.createStatement();
                
                
                
                int z = stmt.executeUpdate(" INSERT INTO existencias (id_prod,cantidad_unid,precio_uni,nombre_oper) VALUES ('"+id_cod_prod+"','" +cant_Uni+"','"+
                                            precio_uni+"','"+nombre_op+"')");
                if (z == 1) {
                     JOptionPane.showMessageDialog(null, "Se registró la operación con exito");
                } else {
                    System.out.println("Ocurrio un problema al agregar el registro");
                }
                stmt.close();
                conn.commit();
                conn.close();

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe el registro, intente con otro código");
        }

    }

    public int existeRegistro(int idCodigo) {
        Connection conn = null;
        conn = conexion();
        

        Statement st = null;
        ResultSet rs = null;
        int rowCount = 0;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("Select * from productos where ID_prod =" + idCodigo);


            if (rs.next()) {
                rowCount += 1;
            }

            rs.close();
            st.close();


        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, rowCount);

        return rowCount;
    }
    
    
    public String existeRegistro1(int idCodigo) {
        Connection conn = null;
        conn = conexion();
        
        String s=null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from existencias where id_prod ="+ 1+ "order by id_exis DESC");


            if (rs.next()) {
                 s = rs.getString(1);
            }

            rs.close();
            st.close();


        } catch (SQLException ex) {
            Logger.getLogger(OperacionesDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, s);

        return s;
    }
}
