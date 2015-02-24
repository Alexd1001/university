/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author hpclab
 */
public class ModeloInvetario {
    
    
    private int cantidad=0;
    private double valorUnitario=0;
    private double valorTotal=0;

    public int getCantidad() {
        return cantidad;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    
    
    
    public void compraSaldoTotal(int unidadesC, int valorUC)
    {
        valorTotal+=unidadesC*valorUC;
    }
    
    public void comprasCantidad(int unidadesC)
    {
        cantidad+=unidadesC;
    }
    
    
    public double promedioValorUt()
    {
        return valorUnitario=valorTotal/cantidad;
    }
    
    public void ventaSaldoTotal(int unidadesV, int valorUV)
    {
         valorTotal-=unidadesV*valorUV;
    }
    
    public void ventaCantidad(int unidadesv)
    {
        cantidad-=unidadesv;
    }
    
    
    
}
