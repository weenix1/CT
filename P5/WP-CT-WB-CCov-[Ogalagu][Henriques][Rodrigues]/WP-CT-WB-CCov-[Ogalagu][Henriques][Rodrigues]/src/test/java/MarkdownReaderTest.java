import com.beust.jcommander.internal.Lists;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.File;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkdownReaderTest {
    static final Boolean[][] ex0 = {
            {false, false, false, true},
            {false, false, true, true},
            {false, true, false, true},
            {false, true, true, true},
            {true, false, false, false},
            {true, false, true, true},
            {true, true, false, true},
            {true, true, true, true},
    };

    static final Boolean[][] ex1 = {
            {false, false, false, false},
            {false, false, true, true},
            {false, true, false, false},
            {false, true, true, true},
            {true, false, false, true},
            {true, false, true, false},
            {true, true, false, false},
            {true, true, true, false},
    };

    static final Boolean[][] ex2 = {
            {false, false, false, true},
            {false, false, true, true},
            {false, true, false, false},
            {false, true, true, false},
            {true, false, false, true},
            {true, false, true, true},
            {true, true, false, true},
            {true, true, true, true},
    };

    static final Boolean[][] ex3 = {
            {false, false, false, true},
            {false, false, true, true},
            {false, true, false, false},
            {false, true, true, true},
            {true, false, false, false},
            {true, false, true, false},
            {true, true, false, false},
            {true, true, true, true},
    };

    @ParameterizedTest
    @ArgumentsSource(ExampleArgumentsProvider.class)
    void readExamples(String filename, Boolean[][] expectedTable){
        var file = new File(filename);
        var table = new TruthTableIO().read(file);
        assertEquals(expectedTable[0].length - 1, table.atomCount());
        assertEquals(expectedTable.length, table.rowCount());

        for (int i = 0; i < expectedTable.length; i++) {
            var rowCheckCondition = Lists.newArrayList(table.row(i));
            rowCheckCondition.add(table.rowCondition(i));
            assertEquals(Lists.newArrayList(expectedTable[i]), rowCheckCondition, "error at row " + i);
        }
    }

    public static class ExampleArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context){
            return Stream.of(
                    Arguments.of("./exercises/ex0.md", ex0),
                    Arguments.of("./exercises/ex1.md", ex1),
                    Arguments.of("./exercises/ex2.md", ex2),
                    Arguments.of("./exercises/ex3.md", ex3)
            );
        }
    }
}
