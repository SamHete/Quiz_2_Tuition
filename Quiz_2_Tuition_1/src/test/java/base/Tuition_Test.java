package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class Tuition_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		assertTrue(1==1);
		assertFalse(1!=1);
		//tests for findTuitionCost method
		assertTrue((TuitionQuiz2.findTuitionCost(25040, .02)) == 103205.06);
		assertTrue((TuitionQuiz2.findTuitionCost(25040, .03)) == 104758.02);
		assertTrue((TuitionQuiz2.findTuitionCost(25040, .10)) == 116210.64);
		//tests for findPaymentPerMonth method
		assertTrue((TuitionQuiz2.findPaymentPerMonth(4, 48, 103205.06) == 1493.46));
		assertTrue((TuitionQuiz2.findPaymentPerMonth(5, 48, 104758.02) == 1803.15));
		assertTrue((TuitionQuiz2.findPaymentPerMonth(10, 48, 116210.64) == 3731.22));
	}
}
