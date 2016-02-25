package cg.algorithmsUnitTest;

import org.junit.Before;
import org.junit.Test;

import cg.algorithms.convexHull.QuickHull;

public class QuickHullTest extends ConvexHullTest {

	@Before
	public void initObject() {
		convexHullTester = new QuickHull();
	}

	@Test
	public void QuickHullTestCase1() {

		Case1();
	}

	@Test
	public void QuickHullTestCase2() {

		Case2();
	}

	@Test
	public void QuickHullTestCase3() {

		Case3();
	}

	@Test
	public void QuickHullTestCase4() {

		Case4();
	}

	@Test
	public void QuickHullTestCase5() {

		Case5();
	}

	@Test
	public void QuickHullTestCase6() {

		Case6();
	}

	@Test
	public void QuickHullTestCase7() {

		Case7();
	}

	@Test
	public void QuickHullTestCase8() {

		Case8();
	}

	@Test
	public void QuickHullTestCase9() {

		Case9();
	}

	@Test
	public void QuickHullTestCase10() {

		Case10();
	}

	@Test
	public void QuickHullTestCase11() {

		Case11();
	}

	@Test
	public void QuickHullTestCase12() {

		Case12();
	}

	@Test
	public void QuickHullTestCase13() {

		Case13();
	}

}
