/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.esdev.cadclinicarest.model;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    /**
     * procura Medico com uma determinada descrição sem importar maiúsculas ou
     * minúsculas
     *
     * @param nome
     * @return
     */
    public List<Medico> findByNomeIgnoreCase(String nome);

    /**
     * pesquisa Medico com um 'pedaço' da descrição independente de maiúsculas
     * ou minúsculas nesse caso usa-se uma Query com as funções UPPER - para
     * transformar em maiúscula - e CONCAT - para concatenar com os sinais de
     * '%'
     *
     * @param nome
     * @return
     */
    @Query("select T from Medico T where UPPER(T.nome) like UPPER(CONCAT('%', ?1, '%'))")
    public List<Medico> procuraPorNome(String nome);

    /**
     *
     *
     * }
     * * faz a mesma coisa do método anterior mas agora pode receber ordenação
     *
     * @param nome
     * @param sort
     * @return
     */
    @Query("select T from Medico T where UPPER(T.nome) like UPPER(CONCAT('%', ?1, '%'))")
    public List<Medico> procuraPorNome(String nome, Sort sort);
}
