package cg.algorithmsUnitTest;

import org.junit.Before;
import cg.algorithms.convexHull.Incremental;

public class IncrementalTest extends ConvexHullTest {

	@Before
	public void initObject() {
		convexHullTester = new Incremental();
	}
}
