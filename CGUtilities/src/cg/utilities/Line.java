package cg.utilities;

import lombok.*;

/**
 * primary Line structure to be used in the CG project.
 */
public class Line {

	@Getter
	@NonNull
	@Setter
	protected Point start, end;

	/**
	 * Creates a line structure that has the specified start/end.
	 * 
	 * @param start
	 *            :The start point.
	 * @param end
	 *            :The end point.
	 */
	public Line(@NonNull Point start, @NonNull Point end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * Creates a line structure that has the specified start/end.
	 * 
	 * @param x1
	 *            :The X value for the start point
	 * @param y1
	 *            :The Y value for the start point
	 * @param x2
	 *            :The X value for the end point
	 * @param y2
	 *            :The Y value for the end point
	 */
	public Line(double x1, double y1, double x2, double y2) {
		this(new Point(x1, y1), new Point(x1, y2));
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Line((Point) start.clone(), (Point) end.clone());
	}

}
