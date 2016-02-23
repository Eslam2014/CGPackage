package cgui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cg.algorithms.Algorithm;
import cg.utilities.Line;
import cg.utilities.Point;
import cg.utilities.Polygon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import lombok.Getter;

public class MainWindowController implements Initializable {

	/**
	 * points : points which user draw rPoints : points result from algorithms
	 */
	@Getter
	private List<Point> points, rPoints;

	/**
	 * lines : line which user draw rLines : lines result from algorithms
	 */
	@Getter
	private List<Line> lines, rLines;

	/**
	 * polygons : polygon which user draw rPoints : polygon result from
	 * algorithms
	 */

	@Getter
	private List<Polygon> polygons, rPolygons;

	/**
	 * current drawing polygon
	 */

	@Getter
	private List<Line> currentPolygon;
	/**
	 * Indicates the Mouses Drag Detected.
	 */
	private boolean drageDatected = false;
	/**
	 * Indicates the right button is pressed
	 */
	private boolean rightBtnIsDragging = false;
	/**
	 * save start point when right button pressed
	 */
	private Point tmp;

	private javafx.scene.shape.Line drawLine;
	// private Ellipse drawEllipse;

	/**
	 * fxml components
	 */

	@FXML
	private Button clearButton;

	@FXML
	private ComboBox<AlgorithmesList> algorithmList;

	@FXML
	@Getter
	private Pane drawingCanvas;

	@FXML
	private Pane resultCanvas;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		drawingCanvas.setDisable(false);
		resultCanvas.setVisible(false);
		algorithmList.getItems().addAll(AlgorithmesList.values());
		algorithmList.setValue(AlgorithmesList.DrawMode);
		drawLine = new javafx.scene.shape.Line();
		points = new ArrayList<>();
		lines = new ArrayList<>();
		polygons = new ArrayList<>();
		currentPolygon = new ArrayList<>();
		rLines = new ArrayList<>();
		rPoints = new ArrayList<>();
		rPolygons = new ArrayList<>();
	}

	/**
	 * handle change in combobox
	 * 
	 * @param event
	 *            : SelectionChanged
	 * @throws CloneNotSupportedException
	 */
	@FXML
	void algorithmList_SelectionChanged(ActionEvent event) throws CloneNotSupportedException {
		AlgorithmesList select = algorithmList.getSelectionModel().getSelectedItem();
		Algorithm algorithm = select.getAlorithm();
		if (algorithm == null) {
			clearResultLists();
			drawingCanvas.setDisable(false);
			resultCanvas.setVisible(false);
		} else {
			Preparation();
			run(algorithm);
			drawResults();
		}

	}

	/**
	 * clear every thing
	 * 
	 * @param event
	 */
	@FXML
	void clearButton_Click(ActionEvent event) {
		drawingCanvas.getChildren().clear();
		resultCanvas.getChildren().clear();
		algorithmList.setValue(AlgorithmesList.DrawMode);
		drageDatected = rightBtnIsDragging = false;
		points.clear();
		lines.clear();
		polygons.clear();
		currentPolygon.clear();
		/*
		 * rLines.clear(); rPoints.clear(); rPolygons.clear();
		 */
	}

	@FXML
	void mouseDragged(MouseEvent event) {
		drageDatected = true;
		setEndofLine(event.getX(), event.getY());
	}

	@FXML
	void mouseMoved(MouseEvent event) {
		if (rightBtnIsDragging) {
			setEndofLine(event.getX(), event.getY());
		}
	}

	@FXML
	void mousePressed(MouseEvent event) {
		drawLine.getStyleClass().add("resultLine");
		if (event.getButton() == MouseButton.SECONDARY && !rightBtnIsDragging) {
			rightBtnIsDragging = true;
			tmp = new Point(event.getX(), event.getY());
			iniNewLine(event.getX(), event.getY());
		} else if (!rightBtnIsDragging) {
			iniNewLine(event.getX(), event.getY());
		}

	}

	@FXML
	void mouseReleased(MouseEvent event) {
		if (drageDatected && rightBtnIsDragging) {
			drawLine.getStyleClass().add("resultLine");
			currentPolygon.add(FromMonitorToCoordinate(drawLine));
			iniNewLine(event.getX(), event.getY());
			drageDatected = false;
		} else if (drageDatected) {
			drawLine.getStyleClass().add("resultLine");
			drageDatected = false;
			lines.add(FromMonitorToCoordinate(drawLine));
		} else if (rightBtnIsDragging) {
			// System.out.println(drawLine.getStartX() + " " +
			// drawLine.getStartY() + " " + drawLine.getEndX() + " "
			// + drawLine.getEndY());
			currentPolygon.add(FromMonitorToCoordinate(drawLine));
			iniNewLine(event.getX(), event.getY());
		} else if (!rightBtnIsDragging && !drageDatected) {
			drawingCanvas.getChildren().remove(drawLine);
			drawingCanvas.getChildren().add(drawNewEllipse(event.getX(), event.getY(), "drawEllipse"));
			points.add(FromMonitorToCoordinate(event.getX(), event.getY()));
		}
	}

	private void setEndofLine(double x, double y) {
		drawLine.setEndX(x);
		drawLine.setEndY(y);
	}

	/**
	 * initialize new line
	 * 
	 * @param x
	 * @param y
	 */
	private void iniNewLine(double x, double y) {
		drawLine = new javafx.scene.shape.Line();
		drawLine.getStyleClass().add("drawLine");
		drawLine.setMouseTransparent(true);
		drawLine.setStartX(x);
		drawLine.setStartY(y);
		drawLine.setEndX(x);
		drawLine.setEndY(y);
		drawingCanvas.getChildren().add(drawLine);
		/*
		 * FadeTransition ft = new FadeTransition(Duration.millis(3000),
		 * drawLine); ft.setFromValue(1.0); ft.setToValue(0.1);
		 * ft.setCycleCount(Timeline.INDEFINITE); ft.setAutoReverse(true);
		 * ft.play();
		 */

	}

	/**
	 * create new Ellipse
	 * 
	 * @param x
	 * @param y
	 * @param styleId
	 *            :Style ID of the Ellipse in stylesheet
	 * @return new Ellipse
	 */
	private Ellipse drawNewEllipse(double x, double y, String styleId) {
		Ellipse ellipse = new Ellipse();
		ellipse.getStyleClass().add(styleId);
		ellipse.setCenterX(x);
		ellipse.setCenterY(y);
		ellipse.setRadiusX(7f);
		ellipse.setRadiusY(7f);
		return ellipse;
	}

	/**
	 * this function call from scane to notify that the control key is pressed
	 * 
	 * @throws CloneNotSupportedException
	 */
	public void keyPressed() throws CloneNotSupportedException {
		if (rightBtnIsDragging) {
			setEndofLine(tmp.getX(), tmp.getY());
			drawLine.getStrokeDashArray().clear();
			drawLine.getStyleClass().add("resultLine");
			drageDatected = false;
			rightBtnIsDragging = false;
			currentPolygon.add(FromMonitorToCoordinate(drawLine));
			polygons.add(new Polygon(cloneLineList(currentPolygon)));
			currentPolygon.clear();
		}
	}

	/**
	 * Transform the monitor coordinates where 0,0 is in the top left into a
	 * logical coordinate where 0, 0 is in the center
	 * 
	 * @param xVal
	 *            : Monitor x coordinat
	 * @param yVal
	 *            : Monitor y coordinate
	 * @return logical Point
	 */
	private Point FromMonitorToCoordinate(double xVal, double yVal) {
		double xRet = xVal - 0.5 * drawingCanvas.getMaxWidth();
		double yRet = 0.5 * drawingCanvas.getMaxHeight() - yVal;
		return new Point(xRet, yRet);
	}

	/**
	 * Transform the logical coordinates where 0,0 is in the center into screen
	 * coordinate where 0, 0 is in the top left
	 * 
	 * @param xVal
	 *            :logical x coordinate
	 * @param yVal
	 *            :logical x coordinate
	 * @return Monitor Point
	 */
	private Point FromCoordinateToMonitor(double xVal, double yVal) {
		double xRet = xVal + 0.5 * drawingCanvas.getMaxWidth();
		double yRet = -yVal + 0.5 * drawingCanvas.getMaxHeight();
		return new Point(xRet, yRet);
	}

	/**
	 * Transform the monitor coordinates where 0,0 is in the top left into a
	 * logical coordinate where 0, 0 is in the center
	 * 
	 * @param line
	 *            : shape line javafx
	 * @return logical line
	 */
	private Line FromMonitorToCoordinate(javafx.scene.shape.Line line) {
		Point p1 = FromMonitorToCoordinate(line.getStartX(), line.getStartY());
		Point p2 = FromMonitorToCoordinate(line.getEndX(), line.getEndY());
		return new Line(p1, p2);
	}

	private Line FromCoordinateToMonitor(Line line) {
		Point p1 = FromCoordinateToMonitor(line.getStart().getX(), line.getStart().getY());
		Point p2 = FromCoordinateToMonitor(line.getEnd().getX(), line.getEnd().getY());
		return new Line(p1, p2);
	}

	private javafx.scene.shape.Line drawNewLine(Line line) {
		Line tmp = FromCoordinateToMonitor(line);
		javafx.scene.shape.Line linefx = new javafx.scene.shape.Line();
		linefx.setStartX(tmp.getStart().getX());
		linefx.setEndX(tmp.getEnd().getX());
		linefx.setStartY(tmp.getStart().getY());
		linefx.setEndY(tmp.getEnd().getY());
		linefx.getStyleClass().add("finshLine");
		return linefx;

	}

	/**
	 * clone the lines list before sent it to the algorithm so we keep the main
	 * list without change
	 * 
	 * @param lines
	 * @return cloned lines
	 * @throws CloneNotSupportedException
	 */
	private List<Line> cloneLineList(List<Line> lines) throws CloneNotSupportedException {
		List<Line> clone = new ArrayList<Line>(lines.size());
		for (Line line : lines)
			clone.add((Line) line.clone());
		return clone;
	}

	/**
	 * clone list of points so we keep the main list without change after
	 * algorithm done
	 * 
	 * @param points
	 * @return cloned points
	 * @throws CloneNotSupportedException
	 */
	private List<Point> clonePointList(List<Point> points) throws CloneNotSupportedException {
		List<Point> clone = new ArrayList<Point>(points.size());
		for (Point point : points)
			clone.add((Point) point.clone());
		return clone;
	}

	/**
	 * clone list of polygons so we keep the main list without change after
	 * algorithm done
	 * 
	 * @param polygons
	 * @return cloned polygons
	 * @throws CloneNotSupportedException
	 */
	private List<Polygon> clonePolygonList(List<Polygon> polygons) throws CloneNotSupportedException {
		List<Polygon> clone = new ArrayList<Polygon>(polygons.size());
		for (Polygon polygon : polygons)
			clone.add((Polygon) polygon.clone());
		return clone;
	}

	private void clearResultLists() {
		rPoints = new ArrayList<>();
		rPolygons = new ArrayList<>();
		rLines = new ArrayList<>();

	}

	private void drawResults() {
		for (Point point : rPoints) {
			System.out.println(point);
			Point coorPoint = FromCoordinateToMonitor(point.getX(), point.getY());
			resultCanvas.getChildren().add(drawNewEllipse(coorPoint.getX(), coorPoint.getY(), "resultEllipse"));
		}
		for (Polygon polgon : rPolygons) {
			for (Line line : polgon.getLines()) {
				resultCanvas.getChildren().add(drawNewLine(line));
			}
		}
		for (Line line : rLines) {
			resultCanvas.getChildren().add(drawNewLine(line));
		}
	}

	private void run(Algorithm algorithm) throws CloneNotSupportedException {
		algorithm.run(clonePointList(points), cloneLineList(lines), clonePolygonList(polygons), rPoints, rLines,
				rPolygons);

	}

	

	/**
	 * Prepare windows and data lists when select change
	 */
	private void Preparation() {
		clearResultLists();
		drawingCanvas.setDisable(true);
		resultCanvas.getChildren().clear();
		resultCanvas.setVisible(true);
	}
}
