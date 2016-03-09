package cg.algorithmsUnitTest;

import org.junit.Before;
import cg.algorithms.convexHull.GrahamScan;

public class GrahamScanTest extends ConvexHullTest {

	@Before
	public void initObject() {
		convexHullTester = new GrahamScan();
	}
}
