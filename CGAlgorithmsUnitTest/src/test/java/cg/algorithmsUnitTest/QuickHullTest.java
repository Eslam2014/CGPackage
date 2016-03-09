package cg.algorithmsUnitTest;

import org.junit.Before;

import cg.algorithms.convexHull.QuickHull;

public class QuickHullTest extends ConvexHullTest {

	@Before
	public void initObject() {
		convexHullTester = new QuickHull();
	}

}
