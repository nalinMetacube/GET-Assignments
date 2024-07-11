import java.util.ArrayList;
import java.util.Date;

public class Circle extends Shape {
	
	public double PIE = 3.14159265359;
	public Point center;
	public double radius;
	public Point origin;
	
	/**
	 * Constructor to set the instance variables
	 * @param radius
	 * @param p
	 * @param id
	 */
	public Circle(double radius, Point p, int id) {
		this.shapeId = id;
		this.shape = ShapeType.CIRCLE;
		this.timestamp = new Date();
		center = new Point(p.xCoordinate, p.yCoordinate);
		this.radius = radius;
		findOrigin();
	}
	
	/**
	 * Method to find origin of the shape
	 */
	public void findOrigin() {
		try {
			double x1 = center.xCoordinate, y1 = center.yCoordinate;
			double m = y1 / x1;
			double C = y1 - (m * x1);
			C -= y1;
			double b =  2 * ((m * C) - x1) , a = (1 + (m * m));
			double c = (x1 * x1) + (C * C) - (radius * radius);
			double x = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
			C += y1;
			double y = (m * x) + C;
			origin = new Point(x, y);
		}
		catch(Exception e) {
			System.out.println("Exception occured in findOrigin method");
		}
	}
	
	/**
	 * Method to find area of the shape
	 */
	public double getArea() {
		return PIE * (radius * radius);
	}
	
	/**
	 * Method to find perimeter of the shape
	 */
	public double getPerimeter() {
		return 2 * PIE * radius;
	}
	
	/**
	 * Method to get origin of the shape
	 */
	public Point getOrigin() {
		return new Point(origin.xCoordinate, origin.yCoordinate);
	}
	
	/**
	 * Method to find distance from the origin of the shape to origin of the screen
	 */
	public double getOriginDistance() {
		Point origin = getOrigin();
		return Math.sqrt((origin.xCoordinate * origin.xCoordinate) + (origin.yCoordinate * origin.yCoordinate));
	}
	
	/**
	 * Method to find if a point is enclosed within shape or not
	 */
	public boolean isPointEnclosed(Point p) {
		double x = p.xCoordinate, y = p.yCoordinate;
		double x1 = center.xCoordinate, y1 = center.yCoordinate;
		double distance = Math.sqrt(((x - x1) * (x - x1)) + ((y - y1) * (y - y1)));
		return distance <= radius;
	}
}
