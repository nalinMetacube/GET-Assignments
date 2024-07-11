import java.util.Date;

enum ShapeType {
	CIRCLE, SQUARE, RECTANGLE, TRIANGLE;
}

public abstract class Shape {
	
	public Date timestamp;
	public ShapeType shape;
	public int shapeId;
	
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract Point getOrigin();
	public abstract boolean isPointEnclosed(Point p);
	public abstract double getOriginDistance();
}
