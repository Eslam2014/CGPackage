package cg.algorithmsUnitTest;

import org.junit.Before;
import org.junit.Test;

import cg.algorithms.convexHull.DivideAndConquer;

public class DivideAndConquerTest extends ConvexHullTest {

	@Before
	public void initObject() {
		convexHullTester = new DivideAndConquer();
	}
	
}
