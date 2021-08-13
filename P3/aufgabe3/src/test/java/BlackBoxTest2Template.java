import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BlackBoxTest2Template {

    @ParameterizedTest
    @MethodSource("TestCases")
    void test(int x, int y, boolean b, Color expected) {
        /* Colors: YELLOW, GREEN, RED */
        Color actual = BlackBox2.F(x, y, b);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> TestCases() {
        return Stream.of(

                Arguments.of(2, 1, true, Color.RED),
                Arguments.of(2, 1, false, Color.YELLOW),
                Arguments.of(2, -2, true, Color.YELLOW),
                Arguments.of(2, -2, false, Color.YELLOW),
                Arguments.of(10, 1, true, Color.YELLOW),
                Arguments.of(10, 1, false, Color.GREEN),
                Arguments.of(10, -2, true, Color.YELLOW),
                Arguments.of(10, -2, false, Color.GREEN),

                Arguments.of(1, 1, true, null),
                Arguments.of(1, 1, false, null),
                Arguments.of(1, -2, true, null),
                Arguments.of(1, -2, false, null),
                Arguments.of(1, -3, true, null),
                Arguments.of(1, -3, false, null),
                Arguments.of(1, 3, true, null),
                Arguments.of(1, 3, false, null),
                Arguments.of(17, 1, true, null),
                Arguments.of(17, 1, false, null),
                Arguments.of(17, -2, true, null),
                Arguments.of(17, -2, false, null),
                Arguments.of(17, -3, true, null),
                Arguments.of(17, -3, false, null),
                Arguments.of(17, 3, true, null),
                Arguments.of(17, 3, false, null),
                Arguments.of(2, -3, true, null),
                Arguments.of(2, -3, false, null),
                Arguments.of(10, -3, true, null),
                Arguments.of(10, -3, false, null),
                Arguments.of(2, 3, true, null),
                Arguments.of(2, 3, false, null),
                Arguments.of(10, 3, true, null),
                Arguments.of(10, 3, false, null)
        );
    }


    // ------- DO NOT TOUCH BELOW THIS LINE -------
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        assertTrue(BlackBox2.evalEqClasses(), "Not all equivalence classes covert!");
    }

}
