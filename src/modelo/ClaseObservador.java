/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author proveedor_amdavila
 */
public class ClaseObservador extends Observable {
    
    DefaultTableModel dtm = null ;
    
    
  
    
    public void settabla(DefaultTableModel dtm)
    {
        this.dtm=dtm;
        setChanged();
        notifyObservers();
    }
    
    public DefaultTableModel gettabla()
    {
        return dtm;
        
    }
    
    
    
}
