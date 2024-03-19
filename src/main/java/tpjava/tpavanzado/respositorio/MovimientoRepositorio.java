package tpjava.tpavanzado.respositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tpjava.tpavanzado.stock.Movimiento;

public interface MovimientoRepositorio extends JpaRepository<Movimiento, Integer>{
    List<Movimiento> findByProducto_IdProducto(Integer idProducto);
}
