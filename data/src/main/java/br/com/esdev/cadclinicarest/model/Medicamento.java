package br.com.esdev.cadclinicarest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Aluno
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int codigo_barras;
    private String data_validade;
    private double dosagem;
    private String descricao;
    private String categoria;
    private String tipo_medicamento;
    private String fabricante;
    private String cidade_origem;
    private String lote;
    private String instrucao_uso;
    private String composicao;
    private String componentes_quimicos;
    private String contra_indicacao;
    private boolean ativo; // ATIVADO OU DESATIVADO NO PEDIDO
    private boolean prescricao_medica; // NECESSITA DE AUTO MÉDICO
}
