package cg.utilities;

import lombok.*;

/**
 * The primary Point structure to be used in the CG project.
 */

public class Point  {

	@Getter
	@Setter
	protected double x, y;

	/**
	 * Creates a point structure with the given coordinates.
	 * 
	 * @param x
	 *            :The X value
	 * @param y
	 *            :The y value
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static Point identity() {
		return new Point(0, 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return Math.abs(this.x - p.x) < Constants.Epsilon && Math.abs(this.x - p.x) < Constants.Epsilon;
		}
		return false;
	}

	public static Point operatorDivide(Point p, double d) {
		return new Point(p.x / d, p.y / d);
	}

	public Point Vector(Point to) {
		return new Point(to.x - this.x, to.y - this.y);
	}

	public double Magnitude() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public Point Normalize() {
		double mag = this.Magnitude();
		Point ans = operatorDivide(this, mag);
		return ans;
	}

	/**
	 * Make a new instance of Point
	 * 
	 * @return new instance of Point
	 */

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Point(x, y);
	}


	@Override
	public String toString() {
		return x+" "+y;
	}

}
