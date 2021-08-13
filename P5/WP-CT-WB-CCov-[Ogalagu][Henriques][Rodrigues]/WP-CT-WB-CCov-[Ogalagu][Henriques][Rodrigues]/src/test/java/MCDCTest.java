import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.File;
import java.util.stream.Stream;

public class MCDCTest {
    @ParameterizedTest
    @ArgumentsSource(ExampleArgumentsProvider.class)
    public void correctMCDC(File inputFile, File expectedFile){


    }

    private static class ExampleArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(new File ("./exercises/ex0.md"), new File("./solutions/MCDC/ex0.md"))
                    //Arguments.of(new File ("./exercises/ex1.md"), new File("./solutions/MCDC/ex1.md"))
                    //Arguments.of(new File ("./exercises/ex2.md"), new File("./solutions/MCDC/ex2.md"))
                    //Arguments.of(new File ("./exercises/ex3.md"), new File("./solutions/MCDC/ex3.md"))
                    //Arguments.of(new File ("./exercises/aufg1.2amd"), new File("./solutions/MCDC/aufg1.2a.md"))
            );
        }
    }
}
