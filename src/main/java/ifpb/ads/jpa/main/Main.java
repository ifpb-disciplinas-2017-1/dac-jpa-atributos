package ifpb.ads.jpa.main;

import ifpb.ads.jpa.modelo.Aluno;
import ifpb.ads.jpa.modelo.Endereco;
import ifpb.ads.jpa.modelo.Funcionario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/08/2017, 07:38:28
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Aluno chaves = Aluno.of("Chaves", "342552", 0.0d);
        chaves.setEndereco(Endereco.with("rua", "bairro", "cidade"));
//        Funcionario kiko = Funcionario
//                .of("Kiko", "kiko@org.com", Funcionario.Sexo.MASCULINO);
//
//        String text = new SmartPath()
//                .lines()
//                .collect(Collectors.joining());
//
//        byte[] foto = new SmartPath("src/main/resources/kiko.jpeg")
//                .toBytes();
//
//        kiko.novoCurriculo(text);
//        kiko.novaFoto(foto);
//        kiko.addEmail("kiko1@org.com");
//        kiko.addEmail("kiko2@org.com");

        EntityManager manager = Persistence
                .createEntityManagerFactory("PrimeiraAula")
                .createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        //iniciar a transação
        transaction.begin();
        manager.persist(chaves);
        //finalizar a transação
        transaction.commit();
//        manager.createQuery("FROM Funcionario f", Funcionario.class)
//                .getResultList()
//                .forEach(f -> {
//                    System.out.println(f.getDataDoNascimento());
//                    try {
//                        new SmartPath("src/main/resources/kiko2.jpeg")
//                                .write(f.getFoto());
//                    } catch (IOException ex) {
//                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                });
    }
}
