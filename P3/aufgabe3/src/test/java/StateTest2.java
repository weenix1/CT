import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class StateTest2 {

	@Test
	void stateCoverage1() {
		SbHard3.start();
		assertEquals("S1", SbHard3.getStateName());
		SbHard3.transition("c");
		assertEquals("S2", SbHard3.getStateName());
		SbHard3.transition("d");
		assertEquals("S6", SbHard3.getStateName());
		SbHard3.transition("a");
		assertEquals("Final", SbHard3.getStateName());
	}

	@Test
	void stateCoverage2() {
		SbHard3.start();
		assertEquals("S1", SbHard3.getStateName());
		SbHard3.transition("e");
		assertEquals("S2", SbHard3.getStateName());
		SbHard3.transition("b");
		assertEquals("S4", SbHard3.getStateName());
		SbHard3.transition("b");
		assertEquals("S3", SbHard3.getStateName());
		SbHard3.transition("c");
		assertEquals("S5", SbHard3.getStateName());
	}

		@Test
	void transitionCoverage1() {
		SbHard3.start();
		assertEquals("S1", SbHard3.getStateName());
		SbHard3.transition("c");
		assertEquals("S2", SbHard3.getStateName());
		SbHard3.transition("d");
		assertEquals("S6", SbHard3.getStateName());
		SbHard3.transition("a");
		assertEquals("Final", SbHard3.getStateName());
	}

	@Test
	void transitionCoverage2() {
		SbHard3.start();
		assertEquals("S1", SbHard3.getStateName());
		SbHard3.transition("e");
		assertEquals("S2", SbHard3.getStateName());
		SbHard3.transition("b");
		assertEquals("S4", SbHard3.getStateName());
		SbHard3.transition("b");
		assertEquals("S3", SbHard3.getStateName());
		SbHard3.transition("c");
		assertEquals("S5", SbHard3.getStateName());

	}

	@Test
	void transitionCoverage3() {
		SbHard3.start();
		assertEquals("S1", SbHard3.getStateName());
		SbHard3.transition("a");
		assertEquals("S4", SbHard3.getStateName());
		SbHard3.transition("c");
		assertEquals("S6", SbHard3.getStateName());
		SbHard3.transition("d");
		assertEquals("S5", SbHard3.getStateName());
		SbHard3.transition("a");
		assertEquals("S3", SbHard3.getStateName());
	}

	//states - 14
	//transitions - 11

	// ------- DO NOT TOUCH BELOW THIS LINE -------
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assertTrue(SbHard3.evalCoverage(), "There are states or transitions left to cover!");

	}

}
