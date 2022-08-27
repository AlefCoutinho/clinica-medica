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

 //extends JpaRepository<Medicamento, Long>

public class Paciente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alergia;
    private double altura;
    private double peso;
    private String tipo_sanguineo;    
    private String doenca_cronica;
    
}
