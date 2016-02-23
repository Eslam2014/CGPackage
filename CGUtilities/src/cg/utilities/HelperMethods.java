package cg.utilities;

public class HelperMethods {

	public static Enums.PointInPolygon PointInTriangle(Point p, Point a, Point b, Point c) {
		if (a.equals(b) && b.equals(c)) {
			if (p.equals(a) || p.equals(b) || p.equals(c))
				return Enums.PointInPolygon.OnEdge;
			else
				return Enums.PointInPolygon.Outside;
		}

		Line ab = new Line(a, b);
		Line bc = new Line(b, c);
		Line ca = new Line(c, a);

		if (GetVector(ab).equals(Point.identity()))
			return (PointOnSegment(p, ca.start, ca.end)) ? Enums.PointInPolygon.OnEdge : Enums.PointInPolygon.Outside;
		if (GetVector(bc).equals(Point.identity()))
			return (PointOnSegment(p, ca.start, ca.end)) ? Enums.PointInPolygon.OnEdge : Enums.PointInPolygon.Outside;
		if (GetVector(ca).equals(Point.identity()))
			return (PointOnSegment(p, ab.start, ab.end)) ? Enums.PointInPolygon.OnEdge : Enums.PointInPolygon.Outside;

		if (CheckTurn(ab, p) == Enums.TurnType.Colinear)
			return PointOnSegment(p, a, b) ? Enums.PointInPolygon.OnEdge : Enums.PointInPolygon.Outside;
		if (CheckTurn(bc, p) == Enums.TurnType.Colinear && PointOnSegment(p, b, c))
			return PointOnSegment(p, b, c) ? Enums.PointInPolygon.OnEdge : Enums.PointInPolygon.Outside;
		if (CheckTurn(ca, p) == Enums.TurnType.Colinear && PointOnSegment(p, c, a))
			return PointOnSegment(p, a, c) ? Enums.PointInPolygon.OnEdge : Enums.PointInPolygon.Outside;

		if (CheckTurn(ab, p) == CheckTurn(bc, p) && CheckTurn(bc, p) == CheckTurn(ca, p))
			return Enums.PointInPolygon.Inside;
		return Enums.PointInPolygon.Outside;
	}

	public static Enums.TurnType CheckTurn(Point vector1, Point vector2) {
		double result = CrossProduct(vector1, vector2);
		if (result < 0)
			return Enums.TurnType.Right;
		else if (result > 0)
			return Enums.TurnType.Left;
		else
			return Enums.TurnType.Colinear;
	}

	public static double CrossProduct(Point a, Point b) {
		return a.x * b.y - a.y * b.x;
	}

	public static boolean PointOnRay(Point p, Point a, Point b) {
		if (a.equals(b))
			return true;
		if (a.equals(p))
			return true;
		Point q = a.Vector(p).Normalize();
		Point w = a.Vector(b).Normalize();
		return q.equals(w);
	}

	public static boolean PointOnSegment(Point p, Point a, Point b) {
		if (a.equals(b))
			return p.equals(a);

		if (b.x == a.x)
			return p.x == a.x && (p.y >= Math.min(a.y, b.y) && p.y <= Math.max(a.y, b.y));
		if (b.y == a.y)
			return p.y == a.y && (p.x >= Math.min(a.x, b.x) && p.x <= Math.max(a.x, b.x));
		double tx = (p.x - a.x) / (b.x - a.x);
		double ty = (p.y - a.y) / (b.y - a.y);

		return (Math.abs(tx - ty) <= Constants.Epsilon && tx <= 1 && tx >= 0);
	}

	/**
	 * Get turn type from cross product between two vectors (l.start -> l.end)
	 * and (l.end -> p)
	 * 
	 * @param l
	 * @param p
	 * @return
	 */
	
	public static Enums.TurnType CheckTurn(Line l, Point p) {
		Point a = l.start.Vector(l.end);
		Point b = l.end.Vector(p);
		return HelperMethods.CheckTurn(a, b);
	}

	public static Point GetVector(Line l) {
		return l.start.Vector(l.end);
	}
}
