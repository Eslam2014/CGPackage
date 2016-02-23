package cg.utilitiesUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cg.utilities.Enums;
import cg.utilities.HelperMethods;
import cg.utilities.Line;
import cg.utilities.Point;

public class LineUtilTest {

	@Test
	public void CheckTurnLeftIfLeftInRange() {
		Line l = new Line(new Point(4, 5), new Point(2, 2));
		assertEquals(HelperMethods.CheckTurn(l, new Point(3, 3)), Enums.TurnType.Left);
	}

	@Test
	public void CheckTurnLeftIfLeftOutRange() {
		Line l = new Line(new Point(4, 5), new Point(2, 2));
		assertEquals(HelperMethods.CheckTurn(l, new Point(1, -2)), Enums.TurnType.Left);
	}

	

	
	@Test
	public void CheckTurnRightIfRightInRange() {
		Line l = new Line(new Point(4, 5), new Point(2, 2));
		assertEquals(HelperMethods.CheckTurn(l, new Point(2, 3)), Enums.TurnType.Right);
	}

	@Test
	public void CheckTurnRightIfRightOutRange() {
		Line l = new Line(new Point(4, 5), new Point(2, 2));
		assertEquals(HelperMethods.CheckTurn(l, new Point(4, 10)), Enums.TurnType.Right);
	}
	// Todo Add Colinear Cases;

}
