package cg.utilities;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

public class Polygon{

	@NonNull
	@Getter
	@Setter
	List<Line> lines;

	/**
	 * Initialize the lines constructing the polygon with an empty list
	 */
	public Polygon() {
		lines = new ArrayList<>();
	}

	/**
	 * Initialize the lines constructing the polygon with a given list l
	 * 
	 * @param l
	 *            :List of lines representing a polygon
	 */
	public Polygon(List<Line> l) {
		this.lines = l;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Polygon(cloneLineList(lines));
	}
	
	private List<Line> cloneLineList(List<Line> list) throws CloneNotSupportedException {
	    List<Line> clone = new ArrayList<Line>(list.size());
	    for(Line line: list) clone.add((Line) line.clone());
	    return clone;
	}
}
