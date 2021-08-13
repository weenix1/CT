import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BlackBoxTest1Template {

	@ParameterizedTest
	@MethodSource("TestCases")
	void test(int x, int y, Color expected) {
		/* Colors: YELLOW, GREEN, RED */
		Color actual = BlackBox1.G(x, y);
		assertEquals(expected, actual);
	}

	static Stream<Arguments> TestCases(){
		return Stream.of(
				Arguments.of(-20, -1, Color.RED),
				Arguments.of(-20, 0, Color.YELLOW),
				Arguments.of(-20, 11, Color.YELLOW),
				Arguments.of(0, -1, Color.YELLOW),
				Arguments.of(0, 0, Color.YELLOW),
				Arguments.of(0, 11, Color.YELLOW),
				Arguments.of(100, -1, Color.YELLOW),
				Arguments.of(100, 0, Color.YELLOW),
				Arguments.of(100, 11, Color.GREEN),

				Arguments.of(-20, -2, null),
				Arguments.of(-20, 101, null),
				Arguments.of(0, -2, null),
				Arguments.of(0, 101, null),
				Arguments.of(100, -2, null),
				Arguments.of(100, 101, null),
				Arguments.of(-21, -1, null),
				Arguments.of(-21, 0, null),
				Arguments.of(-21, 11, null),
				Arguments.of(-21, -2, null),
				Arguments.of(-21, 101, null),
				Arguments.of(117, -1, null),
				Arguments.of(117, 0, null),
				Arguments.of(117, 11, null),
				Arguments.of(117, -2, null),
				Arguments.of(117, 101, null)
		);
	}
	
	
	// ------- DO NOT TOUCH BELOW THIS LINE -------
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assertTrue(BlackBox1.evalEqClasses(), "Not all equivalence classes covert!");
	}

}
