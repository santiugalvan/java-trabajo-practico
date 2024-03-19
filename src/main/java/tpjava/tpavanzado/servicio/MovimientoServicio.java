package tpjava.tpavanzado.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpjava.tpavanzado.respositorio.MovimientoRepositorio;
import tpjava.tpavanzado.stock.Movimiento;

@Service
public class MovimientoServicio implements IMovimientoServicio {

    @Autowired
    private MovimientoRepositorio movimientoRepositorio; 
    
    @Override
    public List<Movimiento> listarMovimientosPorIdProducto(Integer idProducto) {
        return movimientoRepositorio.findByProducto_IdProducto(idProducto);
    }
    
    @Override
    public Movimiento buscarMovimientoPorId(Integer idMovimiento) {
        Movimiento movimiento = movimientoRepositorio.findById(idMovimiento).orElse(null);
        return movimiento;
    }

    @Override
    public Movimiento guardarMovimiento(Movimiento movimiento) {
        return movimientoRepositorio.save(movimiento);
    }

    @Override
    public void eliminarMovimiento(Movimiento movimiento) {
        movimientoRepositorio.delete(movimiento);
    }
    
}
