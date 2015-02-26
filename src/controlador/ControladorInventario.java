/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ClaseObservador;
import modelo.ModeloInvetario;
import modelo.OperacionesDB;
import modelo.PasarTabla;

/**
 *
 * @author hpclab
 */
public class ControladorInventario {
    
    ModeloInvetario objModel = new ModeloInvetario();
    OperacionesDB objOpDB = new OperacionesDB();
    ClaseObservador objClaseObservador = new ClaseObservador();
    PasarTabla objPasarTabla = new PasarTabla();
    
    
    
    public void calculoCompra(int codigo,int unidades,int valorU)
    {
        /*ArrayList array = new ArrayList();
        objModel.compraSaldoTotal(unidades, valorU);
        objModel.comprasCantidad(unidades);
        objModel.getCantidad();
        objModel.getValorTotal();
        
        array.add(0,objModel.getCantidad());
        array.add(1,objModel.promedioValorUt());
        array.add(2,objModel.getValorTotal());
        
        return array;*/
        
        objOpDB.operacion(codigo, "Compra", unidades, valorU);
        
        objClaseObservador.settabla(objPasarTabla.pasarvalores(codigo));
        
        
        
    }
    
    public void calculoVenta(int codigo,int unidades,int valorU)
    {
        /*ArrayList array = new ArrayList();
        objModel.ventaSaldoTotal(unidades, valorU);
        objModel.ventaCantidad(unidades);
        objModel.getCantidad();
        objModel.getValorTotal();
        
        array.add(0,objModel.getCantidad());
        array.add(1,objModel.promedioValorUt());
        array.add(2,objModel.getValorTotal());
        
        return array;*/
        
        objOpDB.operacion(codigo, "Venta", unidades, valorU);
        objClaseObservador.settabla(objPasarTabla.pasarvalores(codigo));
        
    }
    
    public void registra(int cod, String producto)
    {
        objOpDB.registrarProd(cod, producto);
        
    }
    
    
    
    
    
}
