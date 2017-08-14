package ifpb.ads.jpa.modelo;

import ifpb.ads.jpa.infra.ConvertLocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/08/2017, 07:23:27
 */
//Entidade 
@Entity
@Table(name = "tbAluno")
@SequenceGenerator(name = "minha_seq",
        sequenceName = "MinhaSuperSequence",
        allocationSize = 1)
@TableGenerator(name = "minha_tb",
        table = "MinhaSuperTable",
        pkColumnName = "PK_Column",
        valueColumnName = "Value_Column",
        pkColumnValue = "CUST_ID")
public class Aluno implements Serializable {

    //Identidade
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "minha_tb")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minha_seq")
    private int id; //chave primaria
    @Column(name = "nome_aluno")
    private String nome;
    @Column(length = 15, unique = true)
    private String matricula;
    @Column(precision = 2, columnDefinition = "DECIMAL (10,2) default '150.00' ")
    private double bolsa;
//    @Version
//    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
//    private long version = 0L;

    @Embedded
    @AttributeOverride(name = "cidade",
            column = @Column(name = "cidade_pessoa", length = 100))
    private Endereco endereco;

//    @Convert(converter = ConvertLocalDate.class)
    private LocalDate dataDeNascimento;

    public Aluno() {
    }

    private Aluno(String nome, String matricula, double bolsa) {
        this.nome = nome;
        this.matricula = matricula;
        this.bolsa = bolsa;
        this.dataDeNascimento = LocalDate.now();
    }

    public static Aluno of(String nome, String matricula, double bolsa) {
        //regras de validação
        return new Aluno(nome, matricula, bolsa);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

}

//CREATE TABLE tbaluno
//(
//  id integer NOT NULL,
//  bolsa numeric(10,2) DEFAULT 150.00,
//  matricula character varying(15),
//  nome_aluno character varying(255),
//  CONSTRAINT tbaluno_pkey PRIMARY KEY (id),
//  CONSTRAINT tbaluno_matricula_key UNIQUE (matricula)
//)
