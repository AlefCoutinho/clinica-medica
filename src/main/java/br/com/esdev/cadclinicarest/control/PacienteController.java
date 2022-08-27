/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.esdev.cadclinicarest.control;

import java.util.List;
import br.com.esdev.cadclinicarest.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.esdev.cadclinicarest.model.PacienteRepository;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    /* método que retorna a listagem de pacientes ordenada por descrição
        atende no endpoint /paciente com verbo GET
     */
    @GetMapping({"", "/"})
    public List<Paciente> getPacientes() {
        return repository.findAll(Sort.by("nome"));
    }

//    @GetMapping({"/pesquisa"})
//    public List<Tarefa> getPacientes(String nome) {
//        nome = (nome == null) ? "" : nome;
//        return repository.buscaPacientes("%" + nome + "%");
//    }
    @GetMapping("/pesquisa")
    public List<Paciente> getPacientes(String nome) {
        return repository.procuraPorNome(nome, Sort.by("nome"));
    }

    /*
    método que recebe uma paciente enviada na requisição e a insere no banco de dados
    retorta após inserir já com o ID
    atende no endpoint /paciente com verbo POST
    a anotação @RequestBody é importante pois indica que os dados da requisição
    serão enviados no corpo da requisição (em JSON)
     */
    @PostMapping({"", "/"})
    public Paciente insere(@RequestBody Paciente paciente) {
        return repository.save(paciente);
    }

    /*
    método que recebe uma paciente enviada na requisição (com id preenchido)
    e a atualiza no banco de dados
    
    retorta a paciente atualizada
    caso não tenha id na requisição retorna null
    atende no endpoint /paciente com verbo PUT
    a anotação @RequestBody é importante pois indica que os dados da requisição
    serão enviados no corpo da requisição (em JSON)
     */
    @PutMapping({"", "/"})
    public Paciente atualiza(@RequestBody Paciente paciente) {
        if (paciente.getId() != null) {
            return repository.save(paciente);
        }
        return null;
    }

    /*
    método que recebe um id de paciente enviada na requisição
    caso tenha enviado o id, é excluída no banco de dados
    retorta uma mensagem
    o id é passado no path (caminho da url) por isso
    se usa o @PathVariable indicativo
     */
    @DeleteMapping("/{id}")
    public String atualiza(@PathVariable("id") Long id) {
        if (id != null) {
            repository.deleteById(id);
            return "Excluído";
        }
        return null;
    }
}
