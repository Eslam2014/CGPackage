package cg.algorithms;

import java.util.List;

import cg.utilities.Line;
import cg.utilities.Point;
import cg.utilities.Polygon;

/**
 * The primary algorithm abstract class to be used in the CG project.
 */
public abstract class Algorithm {

	/**
	 * Runs the algorithm and fills the out? parameters with the results.
	 * 
	 * @param points
	 *            The points to use.
	 * @param lines
	 *            The lines to use.
	 * @param polygons
	 *            The polygons to use.
	 * @param outPoints
	 *            The point list to populate with results
	 * @param outLines
	 *            The lines list to populate with results
	 * @param outPolygons
	 *            The polygons list to populate with results
	 */
	public abstract void run(List<Point> points, List<Line> lines, List<Polygon> polygons, List<Point> outPoints,
			List<Line> outLines, List<Polygon> outPolygons);

}
