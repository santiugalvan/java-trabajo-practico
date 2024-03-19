package tpjava.tpavanzado.controlador;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpjava.tpavanzado.servicio.UsuarioServicio;
import tpjava.tpavanzado.stock.Usuario;
import tpjava.tpavanzado.utils.RecursoNoEncontradoExcepcion;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Boolean>> login(@RequestBody Usuario usuario){
        Usuario usuarioBuscado = usuarioServicio.buscarUsuario(usuario);
        if(usuarioBuscado == null){
            throw new RecursoNoEncontradoExcepcion("Usuario o Contrasena incorrecta");
        }
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("accessToken", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
}
