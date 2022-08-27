package br.com.esdev.cadclinicarest.control;


import java.util.List;
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
import br.com.esdev.cadclinicarest.model.CadastroUsuario;
import br.com.esdev.cadclinicarest.model.CadastroUsuarioRepository;

/**
 *
 * @author ericd
 */
@RestController
@RequestMapping("/usuario")
public class CadastroUsuarioController {

    @Autowired
    CadastroUsuarioRepository repository;

    /* método que retorna a listagem de medicos ordenada por descrição
        atende no endpoint /medico com verbo GET
     */
    @GetMapping({"", "/"})
    public List<CadastroUsuario> Usuarios() {
        return repository.findAll(Sort.by("nome"));
    }

//    @GetMapping({"/pesquisa"})
//    public List<Tarefa> getMedicos(String nome) {
//        nome = (nome == null) ? "" : nome;
//        return repository.buscaMedicos("%" + nome + "%");
//    }
    @GetMapping("/pesquisa")
    public List<CadastroUsuario> getMedicos(String nome) {
        return repository.procuraPorNome(nome, Sort.by("nome"));
    }

    /*
    método que recebe uma medico enviada na requisição e a insere no banco de dados
    retorta após inserir já com o ID
    atende no endpoint /medico com verbo POST
    a anotação @RequestBody é importante pois indica que os dados da requisição
    serão enviados no corpo da requisição (em JSON)
     */
    @PostMapping({"", "/"})
    public CadastroUsuario insere(@RequestBody CadastroUsuario cadastroUsuario) {
        return repository.save(cadastroUsuario);
    }

    /*
    método que recebe uma medico enviada na requisição (com id preenchido)
    e a atualiza no banco de dados
    
    retorta a medico atualizada
    caso não tenha id na requisição retorna null
    atende no endpoint /medico com verbo PUT
    a anotação @RequestBody é importante pois indica que os dados da requisição
    serão enviados no corpo da requisição (em JSON)
     */
    @PutMapping({"", "/"})
    public CadastroUsuario atualiza(@RequestBody CadastroUsuario cadastroUsuario) {
        if (cadastroUsuario.getId() != null) {
            return repository.save(cadastroUsuario);
        }
        return null;
    }

    /*
    método que recebe um id de medico enviada na requisição
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
