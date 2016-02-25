package cg.algorithmsUnitTest;

import org.junit.Before;
import org.junit.Test;
import cg.algorithms.convexHull.GrahamScan;

public class GrahamScanTest extends ConvexHullTest {

	@Before
	public void initObject() {
		convexHullTester = new GrahamScan();
	}

	@Test
	public void GrahamScanTestCase1() {

		Case1();
	}

	@Test
	public void GrahamScanTestCase2() {

		Case2();
	}

	@Test
	public void GrahamScanTestCase3() {

		Case3();
	}

	@Test
	public void GrahamScanTestCase4() {

		Case4();
	}

	@Test
	public void GrahamScanTestCase5() {

		Case5();
	}

	@Test
	public void GrahamScanTestCase6() {

		Case6();
	}

	@Test
	public void GrahamScanTestCase7() {

		Case7();
	}

	@Test
	public void GrahamScanTestCase8() {

		Case8();
	}

	@Test
	public void GrahamScanTestCase9() {

		Case9();
	}

	@Test
	public void GrahamScanTestCase10() {

		Case10();
	}

	@Test
	public void GrahamScanTestCase11() {

		Case11();
	}

	@Test
	public void GrahamScanTestCase12() {

		Case12();
	}

	@Test
	public void GrahamScanTestCase13() {

		Case13();
	}
}
