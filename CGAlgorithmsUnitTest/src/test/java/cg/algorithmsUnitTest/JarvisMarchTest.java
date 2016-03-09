package cg.algorithmsUnitTest;

import org.junit.Before;
import cg.algorithms.convexHull.JarvisMarch;

public class JarvisMarchTest extends ConvexHullTest {

	@Before
	public void initObject() {
		convexHullTester = new JarvisMarch();
	}
}
