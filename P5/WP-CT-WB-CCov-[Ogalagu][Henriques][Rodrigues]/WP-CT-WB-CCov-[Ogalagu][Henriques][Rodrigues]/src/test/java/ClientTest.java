import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientTest {
    @Test
    void run() throws IOException {
        var client = new Client();
        client.algorithms = new ArrayList<>();
        client.algorithms.add(SupportedAlgorithm.MCDC);
        client.algorithms.add(SupportedAlgorithm.MBCDT);

        client.inputFiles = new ArrayList<>();

        client.inputFiles.add(new File("./exercises/ex0.md"));
        client.inputFiles.add(new File("./exercises/ex1.md"));

        client.output = Files.createTempDirectory("mcdc test");

        client.run();

        assertTrue(Files.exists(Path.of(client.output.toString() + "/ex0_MCDC.md")));
        assertTrue(Files.exists(Path.of(client.output.toString() + "/ex0_MBCDT.md")));
        assertTrue(Files.exists(Path.of(client.output.toString() + "/ex1_MCDC.md")));
        assertTrue(Files.exists(Path.of(client.output.toString() + "/ex1_MBCDT.md")));
    }
}
