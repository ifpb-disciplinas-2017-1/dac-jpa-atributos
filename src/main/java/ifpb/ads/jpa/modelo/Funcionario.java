package ifpb.ads.jpa.modelo;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 10/08/2017, 07:23:13
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
//    @Transient
//    private int idade;
    @Transient
    private LocalDate dataDaCriacao = LocalDate.now();
//    private transient LocalDate dataDaCriacao = LocalDate.now();

    @Lob //    BLOB
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;

    @Lob //    CLOB
    @Basic(fetch = FetchType.EAGER)
    private String curriculo;

    @Temporal(TemporalType.DATE)
    private Date dataDoNascimento = Date.from(Instant.now());

    @ElementCollection
    @CollectionTable(name = "Emails")
    private List<String> emails;

//     @Embedded
//  private CPF cpf;
    public Funcionario() {
        this.emails = new ArrayList<>();
    }

    private Funcionario(String nome, String email, Sexo sexo) {
        this();
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
    }

    public static Funcionario of(String nome, String email, Sexo sexo) {
        //validação
        return new Funcionario(nome, email, sexo);
    }

    public void novaFoto(byte[] bytes) {
        this.foto = bytes;
    }

    public void novoCurriculo(String bytes) {
        this.curriculo = bytes;
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }

    public Sexo getSexo() {
        return sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public Date getDataDoNascimento() {
        return dataDoNascimento;
    }

    public enum Sexo {
        OUTRO,
        FEMININO,
        MASCULINO
    }

}

//@Embeddable
//class CPF{
//  private String valor;
//
//  public String simples(){
//    return valor; //12345678910
//  }
//  public String formatado(){
//    return valor; //123.456.789-10
//  }
//  public boolean valido(){
//      return true; //false
//  }
//}
