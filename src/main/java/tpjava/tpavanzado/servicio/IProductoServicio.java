package tpjava.tpavanzado.servicio;

import java.util.List;
import tpjava.tpavanzado.stock.Producto;

public interface IProductoServicio {
    public List<Producto> listarProductos();
    
    public Producto buscarProductoPorId(Integer idProducto);
    
    public Producto guardarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
}
