/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ModeloInvetario;
import modelo.OperacionesDB;

/**
 *
 * @author hpclab
 */
public class ControladorInventario {
    
    ModeloInvetario objModel = new ModeloInvetario();
    OperacionesDB objOpDB = new OperacionesDB();
    
    
    
    public ArrayList calculoCompra(int unidades,int valorU)
    {
        ArrayList array = new ArrayList();
        objModel.compraSaldoTotal(unidades, valorU);
        objModel.comprasCantidad(unidades);
        objModel.getCantidad();
        objModel.getValorTotal();
        
        array.add(0,objModel.getCantidad());
        array.add(1,objModel.promedioValorUt());
        array.add(2,objModel.getValorTotal());
        
        return array;
    }
    
    public ArrayList calculoVenta(int unidades,int valorU)
    {
        ArrayList array = new ArrayList();
        objModel.ventaSaldoTotal(unidades, valorU);
        objModel.ventaCantidad(unidades);
        objModel.getCantidad();
        objModel.getValorTotal();
        
        array.add(0,objModel.getCantidad());
        array.add(1,objModel.promedioValorUt());
        array.add(2,objModel.getValorTotal());
        
        return array;
        
    }
    
    public void registra(int cod, String producto)
    {
        objOpDB.registrarProd(cod, producto);
        
    }
    
    
    
    
    
}
