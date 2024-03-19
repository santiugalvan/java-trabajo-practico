package tpjava.tpavanzado.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpjava.tpavanzado.servicio.ProductoServicio;
import tpjava.tpavanzado.stock.Producto;
import tpjava.tpavanzado.utils.RecursoNoEncontradoExcepcion;

@RestController
@RequestMapping("main")
@CrossOrigin(origins = "*")
public class ProductoControlador {
    
    @Autowired
    private ProductoServicio productoServicio;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        var productos = productoServicio.listarProductos();
        return productos;
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id){
        Producto producto = productoServicio.buscarProductoPorId(id);
        if(producto == null){
            throw new RecursoNoEncontradoExcepcion(id + "No se encontro el empleado con id: " + id);
        }else{
            return ResponseEntity.ok(producto);
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        return productoServicio.guardarProducto(producto);
    }

    @CrossOrigin(origins = "*")    
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto productoRecibido){
        Producto producto = productoServicio.buscarProductoPorId(id);
        if(producto == null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe" + id);
        }
        producto.setNombreProducto(productoRecibido.getNombreProducto());
        producto.setDescripcion(productoRecibido.getDescripcion());
        productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Integer id){
        Producto producto = productoServicio.buscarProductoPorId(id);
        if(producto == null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe" + id);
        }
        productoServicio.eliminarProducto(producto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
