package tpjava.tpavanzado.servicio;

import java.util.List;
import tpjava.tpavanzado.stock.Movimiento;

public interface IMovimientoServicio {
    List<Movimiento> listarMovimientosPorIdProducto(Integer idProducto);
    
    public Movimiento buscarMovimientoPorId(Integer idMovimiento);
    
    public Movimiento guardarMovimiento(Movimiento movimiento);
    
    public void eliminarMovimiento(Movimiento movimiento);
}
