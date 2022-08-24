///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package br.com.esdev.cadclinicarest.control;

import java.util.List;
import br.com.esdev.cadclinicarest.model.Medicamento;
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
import br.com.esdev.cadclinicarest.model.MedicamentoRepository;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController{

    @Autowired
    MedicamentoRepository repository;

    /* método que retorna a listagem de medicamentos ordenada por descrição
        atende no endpoint /medicamento com verbo GET
     */
    @GetMapping({"", "/"})
    public List<Medicamento> getMedicamentos() {
        return repository.findAll(Sort.by("nome"));
    }

//    @GetMapping({"/pesquisa"})
//    public List<Tarefa> getMedicamentos(String nome) {
//        nome = (nome == null) ? "" : nome;
//        return repository.buscaMedicamentos("%" + nome + "%");
//    }
    @GetMapping("/pesquisa")
    public List<Medicamento> getMedicamentos(String nome) {
        return repository.procuraPorNome(nome, Sort.by("nome"));
    }

    /*
    método que recebe uma medicamento enviada na requisição e a insere no banco de dados
    retorta após inserir já com o ID
    atende no endpoint /medicamento com verbo POST
    a anotação @RequestBody é importante pois indica que os dados da requisição
    serão enviados no corpo da requisição (em JSON)
     */
    @PostMapping({"", "/"})
    public Medicamento insere(@RequestBody Medicamento medicamento) {
        return repository.save(medicamento);
    }

    /*
    método que recebe uma medicamento enviada na requisição (com id preenchido)
    e a atualiza no banco de dados
    
    retorta a medicamento atualizada
    caso não tenha id na requisição retorna null
    atende no endpoint /medicamento com verbo PUT
    a anotação @RequestBody é importante pois indica que os dados da requisição
    serão enviados no corpo da requisição (em JSON)
     */
    @PutMapping({"", "/"})
    public Medicamento atualiza(@RequestBody Medicamento medicamento) {
        if (medicamento.getId() != null) {
            return repository.save(medicamento);
        }
        return null;
    }

    /*
    método que recebe um id de medicamento enviada na requisição
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
