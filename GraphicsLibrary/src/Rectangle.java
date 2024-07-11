import java.util.ArrayList;
import java.util.Date;

public class Rectangle extends Shape {
	
	public double length;
	public double breadth;
	ArrayList<Point> vertices;
	
	/**
	 * Constructor to set the instance variables
	 * @param length
	 * @param breadth
	 * @param p
	 * @param id
	 */
	public Rectangle(double length, double breadth, Point p, int id) {
		this.shapeId = id;
		this.shape = ShapeType.RECTANGLE;
		this.timestamp = new Date();
		this.length = length;
		this.breadth = breadth;
		this.vertices = new ArrayList<Point>();
		vertices.add(p);
		findVertices();
	}
	
	/**
	 * Method to find vertices of the shape
	 */
	public void findVertices() {
		try {
			Point last = vertices.get(vertices.size() - 1);
			
			Point p1 = new Point(last.xCoordinate, last.yCoordinate + breadth);
			vertices.add(p1);
			last = vertices.get(vertices.size() - 1);
			
			Point p2 = new Point(last.xCoordinate + length, last.yCoordinate);
			vertices.add(p2);
			last = vertices.get(vertices.size() - 1);
			
			Point p3 = new Point(last.xCoordinate, last.yCoordinate - breadth);
			vertices.add(p3);
		}
		catch(Exception e) {
			System.out.println("Exception occured in findVertices method");
		}
	}
	
	/**
	 * Method to find area of the shape
	 */
	public double getArea() {
		return (length * breadth);
	}
	
	/**
	 * Method to find perimeter of the shape
	 */
	public double getPerimeter() {
		return  2 * (length + breadth);
	}
	
	/**
	 * Method to get origin of the shape
	 */
	public Point getOrigin() {
		return new Point(vertices.get(0).xCoordinate, vertices.get(0).yCoordinate);
	}
	
	/**
	 * Method to find distance from the origin of the shape to origin of the screen
	 */
	public double getOriginDistance() {
		Point origin = getOrigin();
		return Math.sqrt((origin.xCoordinate * origin.xCoordinate) + (origin.yCoordinate * origin.yCoordinate));
	}
	
	/**
	 * Method to find if a point is located on the edges of the shape or not
	 * @param p
	 * @return
	 */
	public boolean isLocatedOnBoundary(Point p) {
		try {
			double x = p.xCoordinate, y = p.yCoordinate;
			double x1, x2, y1, y2;
			double m,c;
			for(int i = 0; i < 4; i++) {
				if(i == 3) {
					x1 = vertices.get(i).xCoordinate;
					x2 = vertices.get(0).xCoordinate;
					y1 = vertices.get(i).yCoordinate;
					y2 = vertices.get(0).yCoordinate;
				}
				else {
					x1 = vertices.get(i).xCoordinate;
					x2 = vertices.get(i + 1).xCoordinate;
					y1 = vertices.get(i).yCoordinate;
					y2 = vertices.get(i + 1).yCoordinate;
				}
				m = (y2 - y1) / (x2 - x1);
				c = y1 - (m * x1);
				if((y - (m * x) + c) == 0) return true;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in isLocatedOnBoundary method");
		}
		return false;
	}
	
	/**
	 * Method to find if a point is enclosed within shape or not
	 */
	public boolean isPointEnclosed(Point p) {
		try {
			if(isLocatedOnBoundary(p)) return true;
			double x = p.xCoordinate, y = p.yCoordinate;
			double x1, x2, y1, y2;
			int cnt = 0;
			for(int i = 0; i < 4; i++) {
				if(i == 3) {
					x1 = vertices.get(i).xCoordinate;
					x2 = vertices.get(0).xCoordinate;
					y1 = vertices.get(i).yCoordinate;
					y2 = vertices.get(0).yCoordinate;
				}
				else {
					x1 = vertices.get(i).xCoordinate;
					x2 = vertices.get(i + 1).xCoordinate;
					y1 = vertices.get(i).yCoordinate;
					y2 = vertices.get(i + 1).yCoordinate;
				}
				if(x1 == x2 && (x1 >= x) && (Math.max(y1, y2) >= y && Math.min(y1, y2) <= y)) cnt++;
			}
			if((cnt % 2) == 1) return true;
		}
		catch(Exception e) {
			System.out.println("Exception occured in isPointEnclosed method");
		}
		return false;
	}
	
}
