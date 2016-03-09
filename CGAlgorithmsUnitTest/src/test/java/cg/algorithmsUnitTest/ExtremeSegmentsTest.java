package cg.algorithmsUnitTest;


import org.junit.Before;

import cg.algorithms.convexHull.ExtremeSegments;
/**
 * Unit Test for Convex Hull
 */
public class ExtremeSegmentsTest extends ConvexHullTest {

	@Before
	public void initOject() {
		convexHullTester = new ExtremeSegments();
	}
}
