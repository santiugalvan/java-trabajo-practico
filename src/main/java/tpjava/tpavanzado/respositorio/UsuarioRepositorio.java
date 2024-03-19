package tpjava.tpavanzado.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tpjava.tpavanzado.stock.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
    Usuario findByNombreUsuarioAndPassword(String nombreUsuario, String password);
}
