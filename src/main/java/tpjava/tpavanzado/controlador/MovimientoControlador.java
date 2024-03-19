package tpjava.tpavanzado.controlador;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpjava.tpavanzado.servicio.MovimientoServicio;
import tpjava.tpavanzado.stock.Movimiento;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tpjava.tpavanzado.utils.RecursoNoEncontradoExcepcion;

@RestController
@RequestMapping("main")
@CrossOrigin(origins = "*")
public class MovimientoControlador {
    
    @Autowired
    private MovimientoServicio movimientoServicio;
    
    @GetMapping("/productos/{id}/movimientos")
    public List<Movimiento> obtenerMovimientos(@PathVariable Integer id) {
        return movimientoServicio.listarMovimientosPorIdProducto(id);
    }
    
    @PostMapping("/productos/{id}/movimientos")
    public Movimiento agregarMovimiento(@RequestBody Movimiento movimiento){
        return movimientoServicio.guardarMovimiento(movimiento);
    }
    
    @DeleteMapping("/productos/{id}/movimientos/{idMovimiento}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Integer idMovimiento){
        Movimiento movimiento = movimientoServicio.buscarMovimientoPorId(idMovimiento);
        if(movimiento == null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe" + idMovimiento);
        }
        movimientoServicio.eliminarMovimiento(movimiento);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    

}
