package tpjava.tpavanzado.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpjava.tpavanzado.respositorio.UsuarioRepositorio;
import tpjava.tpavanzado.stock.Usuario;

@Service
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        String nombreUsuario = usuario.getNombreUsuario();
        String password = usuario.getPassword();
        
        return usuarioRepositorio.findByNombreUsuarioAndPassword(nombreUsuario, password);
    }
    
}
