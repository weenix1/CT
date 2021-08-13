import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class StateTest1 {

	@Test
	void test() {
		SbSimple1.start();
		assertEquals(SbSimple1.getStateName(), "S1");
		SbSimple1.transition("b");
		assertEquals(SbSimple1.getStateName(), "S2");
		SbSimple1.transition("d");
		assertEquals(SbSimple1.getStateName(), "S3");
		SbSimple1.transition("d");
		assertEquals(SbSimple1.getStateName(), "S4");
		SbSimple1.transition("a");
		assertEquals(SbSimple1.getStateName(), "Final");
	}

	@Test
	void transitionCoverage1(){
		SbSimple1.start();
		assertEquals(SbSimple1.getStateName(), "S1");
		SbSimple1.transition("b");
		assertEquals(SbSimple1.getStateName(), "S2");
		SbSimple1.transition("c");
		assertEquals(SbSimple1.getStateName(), "S4");
		SbSimple1.transition("b");
		assertEquals(SbSimple1.getStateName(), "S2");
		SbSimple1.transition("d");
		assertEquals(SbSimple1.getStateName(), "S3");
		SbSimple1.transition("d");
		assertEquals(SbSimple1.getStateName(), "S4");
		SbSimple1.transition("a");
		assertEquals(SbSimple1.getStateName(), "Final");
	}

	@Test
	void transitionCoverage2(){
		SbSimple1.start();
		assertEquals(SbSimple1.getStateName(), "S1");
		SbSimple1.transition("b");
		assertEquals(SbSimple1.getStateName(), "S2");
		SbSimple1.transition("d");
		assertEquals(SbSimple1.getStateName(), "S3");
		SbSimple1.transition("b");
		assertEquals(SbSimple1.getStateName(), "S1");
		SbSimple1.transition("b");
		assertEquals(SbSimple1.getStateName(), "S2");
		SbSimple1.transition("a");
		assertEquals(SbSimple1.getStateName(), "Final");
	}

	// ------- DO NOT TOUCH BELOW THIS LINE -------
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		assertTrue(SbSimple1.evalCoverage(), "There are states or transitions left to cover!");

	}
	
}