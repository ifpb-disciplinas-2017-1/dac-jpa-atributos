package ifpb.ads.jpa.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 09/08/2017, 11:08:33
 */
public class SmartPath {

    private Path path;

    public SmartPath() {
        this("src/main/resources/exemplo.json");

    }

    public SmartPath(String pathFile) {
        this(Paths.get(pathFile));
    }

    public SmartPath(Path path) {
        this.path = path;
    }

    public byte[] toBytes() throws IOException {
        return Files.readAllBytes(path);
    }

    public Stream<String> lines() throws IOException {
        return Files.lines(path);
    }

    public Path write(byte[] bytes) throws IOException {
        return Files.write(this.path,bytes);
    }
}
