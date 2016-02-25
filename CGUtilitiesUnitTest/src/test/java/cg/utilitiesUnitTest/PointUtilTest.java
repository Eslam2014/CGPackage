package cg.utilitiesUnitTest;

import static org.junit.Assert.*;

import java.util.Random;

import cg.utilities.*;

import org.junit.Test;

public class PointUtilTest {

	@Test
	public void CheckCrossProduct() {
		Point a = new Point(3, 5);
		Point b = new Point(4, 12);
		assertEquals(HelperMethods.CrossProduct(a, b), 16, 0);
		
	}

	// region In Triangle Tests
	@Test
	public void InsideTriangleClockwise() {
		Point a = new Point(2, 2);
		Point b = new Point(4, 5);
		Point c = new Point(6, 1);

		Point p = new Point(3, 3);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.Inside, res);
	}

	@Test
	public void InsideTriangleCounterClockwise() {
		Point a = new Point(6, 1);
		Point b = new Point(4, 5);
		Point c = new Point(2, 2);

		Point p = new Point(3, 3);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.Inside, res);
	}

	@Test
	public void OnTriangleBorder() {
		Point a = new Point(3, 4);
		Point b = new Point(6, 6);
		Point c = new Point(3, 8);

		Point p = new Point(3, 6);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.OnEdge, res);
	}

	@Test
	public void OnBorderIfOnHead() {
		Point a = new Point(3, 4);
		Point b = new Point(6, 6);
		Point c = new Point(3, 8);

		Point p = new Point(3, 4);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.OnEdge, res);
	}

	@Test
	public void OutsideTriangle() {
		Point a = new Point(3, 4);
		Point b = new Point(6, 6);
		Point c = new Point(3, 8);

		Point p = new Point(1, 1);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.Outside, res);
	}

	@Test
	public void OnBorderIfOnBorderAndTriangleIsSegment() {
		Point a = new Point(1, 1);
		Point b = new Point(3, 3);
		Point c = new Point(3, 3);

		Point p = new Point(2, 2);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.OnEdge, res);
	}

	@Test
	public void OutsideIfTriangleIsSegmentAndPointIsCollinearAfterEnd() {
		Point a = new Point(1, 1);
		Point b = new Point(3, 3);
		Point c = new Point(3, 3);

		Point p = new Point(4, 4);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.Outside, res);
	}

	@Test
	public void OutsideIfTriangleIsSegmentAndPointIsCollinearBeforeStart() {
		Point a = new Point(1, 1);
		Point b = new Point(3, 3);
		Point c = new Point(3, 3);

		Point p = new Point(0, 0);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.Outside, res);
	}

	@Test
	public void OnBorderIfTriangleIsThePoint() {
		Point a = new Point(3, 3);
		Point b = new Point(3, 3);
		Point c = new Point(3, 3);

		Point p = new Point(3, 3);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.OnEdge, res);
	}

	@Test
	public void OutsideIfTriangleIsPointNotEqualThePoint() {
		Point a = new Point(3, 3);
		Point b = new Point(3, 3);
		Point c = new Point(3, 3);

		Point p = new Point(2, 1);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.Outside, res);
	}

	@Test
	public void OutsideIfPointIsColinearButNotOnEdge() {
		Point a = new Point(1, 0);
		Point b = new Point(2, 0);
		Point c = new Point(3, 0);

		Point p = new Point(0, 0);
		Enums.PointInPolygon res = HelperMethods.PointInTriangle(p, a, b, c);
		assertEquals(Enums.PointInPolygon.Outside, res);
	}

	// #endregion

	// #region Point On Ray

	@Test
	public void PointOnRayReturnsTrueIfExistsOnSegment() {
		Point p = new Point(2, 2);
		boolean onRay = HelperMethods.PointOnRay(p, new Point(1, 1), new Point(3, 3));
		assertEquals(true, onRay);
	}

	@Test
	public void PointOnRayReturnsTrueIfAfterEnd() {
		Point p = new Point(4, 4);
		boolean onRay = HelperMethods.PointOnRay(p, new Point(1, 1), new Point(3, 3));
		assertEquals(true, onRay);
	}

	@Test
	public void PointOnRayReturnsTrueIfExistsOnStart() {
		Point p = new Point(1, 1);
		boolean onRay = HelperMethods.PointOnRay(p, new Point(1, 1), new Point(3, 3));
		assertEquals(true, onRay);
	}

	@Test
	public void PointOnRayReturnsTrueIfExistsOnEnd() {
		Point p = new Point(3, 3);
		boolean onRay = HelperMethods.PointOnRay(p, new Point(1, 1), new Point(3, 3));
		assertEquals(true, onRay);
	}

	@Test
	public void PointOnRayReturnsTrueIfStartEqualsEnd() {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			Point p = new Point(random.nextDouble(), random.nextDouble());
			boolean onRay = HelperMethods.PointOnRay(p, new Point(1, 1), new Point(1, 1));
			assertEquals(true, onRay);
		}
	}

	@Test
	public void PointOnRayReturnsFalseIfPointBeforeStart() {
		Point p = new Point(1, 1);
		boolean onRay = HelperMethods.PointOnRay(p, new Point(2, 2), new Point(3, 3));
		assertEquals(false, onRay);
	}

	@Test
	public void PointOnRayReturnsFalseIfPointNotColinear() {
		Point p = new Point(2, 3);
		boolean onRay = HelperMethods.PointOnRay(p, new Point(2, 2), new Point(3, 3));
		assertEquals(false, onRay);
	}

	// #endregion

	// #region Point On Segment

	@Test
	public void PointOnSegmentReturnsTrueIfExistsOnSegment() {
		Point p = new Point(2, 2);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 1), new Point(3, 3));
		assertEquals(true, onSegment);
	}

	@Test
	public void PointOnSegmentReturnsTrueIfExistsOnSegmentStart() {
		Point p = new Point(1, 1);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 1), new Point(3, 3));
		assertEquals(true, onSegment);
	}

	@Test
	public void PointOnSegmentReturnsTrueIfExistsOnSegmentEnd() {
		Point p = new Point(3, 3);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 1), new Point(3, 3));
		assertEquals(true, onSegment);
	}

	@Test
	public void PointOnSegmentReturnsFalseIfExistsBeforeSegmentStart() {
		Point p = new Point(0, 0);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 1), new Point(3, 3));
		assertEquals(false, onSegment);
	}

	@Test
	public void PointOnSegmentReturnsFalseIfExistsAfterSegmentEnd() {
		Point p = new Point(4, 4);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 1), new Point(3, 3));
		assertEquals(false, onSegment);
	}

	@Test
	public void PointOnSegmentReturnsFalseIfDoesnotExistsOnSegment() {
		Point p = new Point(3, 4);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 1), new Point(3, 3));
		assertEquals(false, onSegment);
	}

	@Test
	public void PointOnSegmentReturnsTrueIfStartEqualsEndEqualsPoint() {
		Point p = new Point(1, 1);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 1), new Point(1, 1));
		assertEquals(true, onSegment);
	}

	@Test
	public void PointOnSegmentReturnsFalseIfStartEqualsEndDoesnotEqualPoint() {
		Point p = new Point(1, 1);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 1), new Point(1, 1));
		assertEquals(true, onSegment);
	}

	@Test
	public void PointOnSegmentHorizontalNotOnSegmentColinear() {
		Point p = new Point(0, 2);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 2), new Point(3, 2));
		assertEquals(false, onSegment);
	}

	@Test
	public void PointOnSegmentHorizontalNotOnSegmentNotColinear() {
		Point p = new Point(-1, 9);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 2), new Point(3, 2));
		assertEquals(false, onSegment);
	}

	@Test
	public void PointOnSegmentHorizontalOnSegment() {
		Point p = new Point(2, 2);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(1, 2), new Point(3, 2));
		assertEquals(true, onSegment);
	}

	@Test
	public void PointOnSegmentVerticalNotOnSegmentColinear() {
		Point p = new Point(0, 1);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(0, 2), new Point(0, 4));
		assertEquals(false, onSegment);
	}

	@Test
	public void PointOnSegmentVerticalNotOnSegmentNotColinear() {
		Point p = new Point(3, 1);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(0, 2), new Point(0, 4));
		assertEquals(false, onSegment);
	}

	@Test
	public void PointOnSegmentVerticalOnSegment() {
		Point p = new Point(0, 3);
		boolean onSegment = HelperMethods.PointOnSegment(p, new Point(0, 2), new Point(0, 4));
		assertEquals(true, onSegment);
	}

	// #endregion

}
