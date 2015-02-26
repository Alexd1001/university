/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Userwin8
 */
public class PasarTabla {
    
    
    OperacionesDB coexion=new OperacionesDB();
    
    
    public DefaultTableModel pasarvalores(int codigo){
     
         Connection connection1 = null;
         DefaultTableModel dtm = null ;
         String[] filas = null;
         
    try {
            connection1=coexion.conexion();
            Statement stmt = connection1.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from productos, existencias where productos.id_prod=existencias.id_prod and productos.id_prod="+codigo);
            String [] columnas = {"Codigo","Nombre","Movimiento","Cantidad","Valor"};
            dtm = new DefaultTableModel(null,columnas);
            
            
            while (rs.next())
            {
               
                String[] filas1 = {Integer.toString(codigo),rs.getString("NOMBRE"),rs.getString("nombre_oper"),String.valueOf(rs.getInt("cantidad_unid")),String.valueOf(rs.getInt("precio_uni"))};
                filas = filas1;
                
                
                
                dtm.addRow(filas1);
                for(String pa:filas)
            {
             System.out.println(pa);
            }
                  
            }
                
                stmt.close();
                
                connection1.close();  
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
         
        
                return dtm;
        

        
    }
    
}
