import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VirtualScreen {
	public Rectangle Screen;
	public ArrayList<Shape> listOfShapes;
	
	/**
	 * Constructor to set the instance variables
	 * @param x
	 * @param y
	 */
	public VirtualScreen(double x, double y) {
		Point p = new Point(0, 0);
		Screen = new Rectangle(x, y, p, 0);
		listOfShapes = new ArrayList<>();
	}
	
	/**
	 * Method to check if a point is inside screen or not
	 * @param p
	 * @return
	 */
	public boolean isPointInsideShape(Point p) {
		return Screen.isPointEnclosed(p);
	}
	
	/**
	 * Method to add a shape on the screen
	 * @param obj
	 * @return
	 */
	public boolean addShapeToScreen(Shape obj) {
		return listOfShapes.add(obj);
	}
	
	/**
	 * Method to delete a shape from the screen
	 * @param id
	 * @return
	 */
	public boolean deleteShapeFromScreen(int id) {
		try {
			for(Shape shape : listOfShapes) {
				if(shape.shapeId == id) {
					return listOfShapes.remove(shape);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in deleteShapeFromScreen method");
		}
		return false;
	}
	
	/**
	 * Method to delete all the shapes of the specific type
	 * @param type
	 * @return
	 */
	public boolean deleteShapeOfSpecificType(ShapeType type) {
		boolean flag = false;
		try {
			for(Shape shape : listOfShapes) {
				if(shape.shape == type) {
					flag |= listOfShapes.remove(shape);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in deleteShapeOfSpecificType method" + e.getMessage());
		}
		return flag;
	}
	
	/**
	 * Method to return all the shapes present on the screen
	 * @return
	 */
	public ArrayList<Shape> allShapesOnScreen() {
		ArrayList<Shape> temp = new ArrayList<Shape>();
		try {
			for(Shape shape : listOfShapes) {
				temp.add(shape);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in allShapesOnScreen method");
		}
		return temp;
	}
	
	/**
	 * Method to return all the shapes present on the screen
	 * sorted according to their area
	 * @return
	 */
	public ArrayList<Shape> sortByArea() {
		
		ArrayList<Shape> temp = new ArrayList<Shape>();
		
		try {
			Comparator<Shape> com = new Comparator<Shape>() {
				
				public int compare(Shape s1, Shape s2) {
					return (s1.getArea() <= s2.getArea()) ? -1 : 1;
				}
			};
			
			
			for(Shape shape : listOfShapes) {
				temp.add(shape);
			}
			
			Collections.sort(temp, com);
		}
		catch(Exception e) {
			System.out.println("Exception occured in sortByArea method");
		}
		return temp;
	}
	
	/**
	 * Method to return all the shapes present on the screen
	 * sorted according to their perimeter
	 * @return
	 */
	public ArrayList<Shape> sortByPerimeter() {
		
		ArrayList<Shape> temp = new ArrayList<Shape>();
		
		try {
			Comparator<Shape> com = new Comparator<Shape>() {
				
				public int compare(Shape s1, Shape s2) {
					return (s1.getPerimeter() <= s2.getPerimeter()) ? -1 : 1;
				}
			};
			
			for(Shape shape : listOfShapes) {
				temp.add(shape);
			}
			
			Collections.sort(temp, com);
		}
		catch(Exception e) {
			System.out.println("Exception occured in sortByPerimeter method");
		}
		return temp;
	}
	
	/**
	 * Method to return all the shapes present on the screen
	 * sorted according to their origin distance
	 * @return
	 */
	public ArrayList<Shape> sortByOriginDistance() {
		
		ArrayList<Shape> temp = new ArrayList<Shape>();
		
		try {
			Comparator<Shape> com = new Comparator<Shape>() {
				
				public int compare(Shape s1, Shape s2) {
					return (s1.getOriginDistance() <= s2.getOriginDistance()) ? -1 : 1;
				}
			};
			
			for(Shape shape : listOfShapes) {
				temp.add(shape);
			}
			
			Collections.sort(temp, com);
		}
		catch(Exception e) {
			System.out.println("Exception occured in sortByOriginDistance method");
		}
		return temp;
	}
	
	/**
	 * Method to get all the shapes on the screen
	 * which are enclosing the given point
	 * @param p
	 * @return
	 */
	public ArrayList<Shape> getShapesEnclosingPoint(Point p) {
		ArrayList<Shape> temp = new ArrayList<>();
		
		try {
			for(Shape shape : listOfShapes) {
				if(shape.isPointEnclosed(p)) temp.add(shape);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getShapesEnclosingPoint method");
		}
		return temp;
	}
	
	/**
	 * Method to check if a shape exists on the screen or not
	 * @param shapeId
	 * @return
	 */
	public boolean checkIfShapeExists(int shapeId) {
		try {
			for(Shape shape : listOfShapes) {
				if(shape.shapeId == shapeId) return true;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in checkIfShapeExists method");
		}
		return false;
	}
}
