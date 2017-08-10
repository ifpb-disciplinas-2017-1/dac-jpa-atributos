package ifpb.ads.jpa.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 10/08/2017, 09:17:25
 */
@Embeddable
public class Endereco implements Serializable {

    public static Endereco with(String rua, String bairro, String cidade) {
        return new Endereco(rua, bairro, cidade);
    }

    @Column(name = "rua_pessoa", length = 85)
    private String rua;
    private String bairro;
    private String cidade;

    public Endereco() {
    }

    private Endereco(String rua, String bairro, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
