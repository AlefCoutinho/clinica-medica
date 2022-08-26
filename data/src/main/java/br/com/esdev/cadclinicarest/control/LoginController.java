/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.esdev.cadclinicarest.control;

//import java.util.HashMap;
//import java.util.Map;
import br.com.esdev.cadclinicarest.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@RestController
public class LoginController {
    //injeta automaticamente a classe de utilidades do JWT

    @Autowired
    JWTUtil jwtUtil;

    /**
     * recebe um usuario e senha via POST valida se for: 1 - usuario = usuario 2
     * - senha = 1234
     *
     * @param usuario
     * @param senha
     * @return
     */
    @PostMapping("/login")
    public String logar(String usuario, String senha) {
        if (usuario != null && !usuario.isEmpty() && senha != null && !senha.isEmpty()) {
            if (usuario.equals("usuario") && senha.equals("1234")) {
                String token = jwtUtil.geraTokenUsuario(usuario);
                return token;
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USUÁRIO OU SENHA INVÁLIDOS");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "CREDENCIAIS INVÁLIDAS");
        }
    }
}
