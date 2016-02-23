package cgui;

import cg.algorithms.*;
import cg.algorithms.segmentIntersection.*;
import cg.algorithms.convexHull.*;
import cg.algorithms.polygonTriangulation.*;

public enum AlgorithmesList {
	
	DrawMode("Draw Mode") {
		protected Algorithm getAlorithm() {
			return null;
		}
	},
	DivideAndConquer("Convex Hull - Divide & Conquer"){
		protected Algorithm getAlorithm() {
			return new DivideAndConquer();
		}
	},
	QuickHull("Convex Hull - Quick Hull"){
		protected Algorithm getAlorithm() {
			return new QuickHull();
		}
	},
	JarvisMarch("Convex Hull - Jarvis March"){
		protected Algorithm getAlorithm() {
			return new JarvisMarch();
		}
	},
	Incremental("Convex Hull - Incremental"){
		protected Algorithm getAlorithm() {
			return new Incremental();
		}
	},
	GrahamScan("Convex Hull - Graham Sca"){
		protected Algorithm getAlorithm() {
			return new GrahamScan();
		}
	},
	ExtremeSegments("Convex Hull - Extreme Segment"){
		protected Algorithm getAlorithm() {
			return new ExtremeSegments();
		}
	},
	ExtremePoints("Convex Hull - Extreme Points"){
		protected Algorithm getAlorithm() {
			return new ExtremePoints();
		}
	},
	InsertingDiagonals("Inserting Diagonals"){
		protected Algorithm getAlorithm() {
			return new InsertingDiagonals();
		}
	},
	MonotonePartitioning("Monotone Partitionin"){
		protected Algorithm getAlorithm() {
			return new MonotonePartitioning();
		}
	},
	MonotoneTriangulation("Monotone Triangulatio"){
		protected Algorithm getAlorithm() {
			return new MonotoneTriangulation();
		}
	},
	SubtractingEars("Subtracting Ear"){
		protected Algorithm getAlorithm() {
			return new SubtractingEars();
		}
	},
	SweepLine("Sweep Line"){
		protected Algorithm getAlorithm() {
			return new SweepLine();
		}
	};

	protected String value;
    protected abstract Algorithm getAlorithm();
	private AlgorithmesList(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
