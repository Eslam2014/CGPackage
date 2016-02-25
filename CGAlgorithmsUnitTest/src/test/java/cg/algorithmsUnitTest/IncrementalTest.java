package cg.algorithmsUnitTest;

import org.junit.Before;
import org.junit.Test;
import cg.algorithms.convexHull.Incremental;

public class IncrementalTest extends ConvexHullTest {

	@Before
	public void initObject() {
		convexHullTester = new Incremental();
	}

	@Test
	public void IncrementalTestCase1() {

		Case1();
	}

	@Test
	public void IncrementalTestCase2() {

		Case2();
	}

	@Test
	public void IncrementalTestCase3() {

		Case3();
	}

	@Test
	public void IncrementalTestCase4() {

		Case4();
	}

	@Test
	public void IncrementalTestCase5() {

		Case5();
	}

	@Test
	public void IncrementalTestCase6() {

		Case6();
	}

	@Test
	public void IncrementalTestCase7() {

		Case7();
	}

	@Test
	public void IncrementalTestCase8() {

		Case8();
	}

	@Test
	public void IncrementalTestCase9() {

		Case9();
	}

	@Test
	public void IncrementalTestCase10() {

		Case10();
	}

	@Test
	public void IncrementalTestCase11() {

		Case11();
	}

	@Test
	public void IncrementalTestCase12() {

		Case12();
	}

	@Test
	public void IncrementalTestCase13() {

		Case13();
	}
}
