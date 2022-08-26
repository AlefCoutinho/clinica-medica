/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.esdev.cadclinicarest.control;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
public class HomeController {

    /**
     * esse método maracado com requestmapping sem definição de verbo HTTP é
     * capaz de receber qualquer requisição (GET, POST etc.) e retorna uma
     * mensagem
     *
     * @return
     */
    @GetMapping(value = "/")
    public String index() {
        return "API de Clínica rodando";
    }

}
