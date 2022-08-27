/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.esdev.cadclinicarest.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.esdev.cadclinicarest.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aluno
 */
@Component
public class AutFilter implements Filter {//injeta automaticamente a classe de utilidades do JWT

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * esse método recebe todas as requisições e direciona corretamente a
     * resposta
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String caminho = ((HttpServletRequest) request).getRequestURI();
        String token = jwtUtil.recuperaTokenRequisicao(request);
        String nomeUsuario = jwtUtil.getUsuarioNoToken(token);
        if (nomeUsuario != null) {
            filterChain.doFilter(request, response);
        } else {
//caso não tenha usuário autenticado, não retorna nada
        }
    }
}
