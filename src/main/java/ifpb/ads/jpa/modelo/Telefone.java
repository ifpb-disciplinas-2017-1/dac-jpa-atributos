package ifpb.ads.jpa.modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 14/08/2017, 07:47:25
 */
@Entity
@IdClass(TelefoneChave.class)
public class Telefone implements Serializable {

    private String codigoPais = "+55";
    @Id
    private String ddd;
    @Id
    private String numero;
    
//    @EmbeddedId
//    private TelefonePK chave;

    public Telefone() {
    }

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
//        this.chave = new TelefonePK(ddd, numero);
    }

    public String numero() {
        return String.format("%s (%s) %s", codigoPais, ddd, numero);
//        return String.format("%s (%s) %s", codigoPais, chave.getDdd(), chave.getNumero());
    }

}
