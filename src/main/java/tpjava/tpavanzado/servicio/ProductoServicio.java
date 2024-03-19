package tpjava.tpavanzado.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpjava.tpavanzado.respositorio.ProductoRepositorio;
import tpjava.tpavanzado.stock.Producto;

@Service
public class ProductoServicio implements IProductoServicio{
    
    @Autowired
    private ProductoRepositorio productoRepositorio;
    
    @Override
    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepositorio.delete(producto);
    }
    
}
