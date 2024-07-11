import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static final double XMAX = 100;
	public static final double YMAX = 100;
	public static Point screenDimension;
	
	/*
	 * Method to handle exception and validate integer inputed
	 * 
	 * return : inputted integer
	 */
	public static int takeIntInput(int type, int subtype) {
        Scanner sc = new Scanner(System.in);
        Integer value;
        while(true) {
            try {
            	value = sc.nextInt();
            	break;
            }
            catch(Exception e) {
                System.out.println("Please enter a integer value");
                sc.nextLine();
                continue;
            }
        }
        return value;
    }
	
	/**
	 * Method to handle exception and validate double value inputed
	 * @param type
	 * @param subtype
	 * @return
	 */
	public static double takeDoubleInput(int type, int subtype) {
        Scanner sc = new Scanner(System.in);
        Double value;
        while(true) {
            try {
            	value = sc.nextDouble();
            }
            catch(Exception e) {
                System.out.println("Please enter a double value");
                sc.nextLine();
                continue;
            }
            if(type == 1) {
            	if(subtype == 1 && (value > XMAX || value < 0)) {
            		System.out.println("Please enter the coordinate within the limit");
            		continue;
            	}
            	else if(subtype == 2 && (value > YMAX || value < 0)) {
            		System.out.println("Please enter the coordinate within the limit");
            		continue;
            	}
            	else break;
            }
            else if(type == 2) {
            	if(subtype == 1 && (value > screenDimension.xCoordinate || value < 0)) {
            		System.out.println("Please enter the coordinate within the limit");
            		continue;
            	}
            	else if(subtype == 2 && (value > screenDimension.yCoordinate || value < 0)) {
            		System.out.println("Please enter the coordinate within the limit");
            		continue;
            	}
            	else break;
            }
            else break;
        }
        return value;
    }
	
	/**
	 * Method to input a 2 dimension point
	 * @param type
	 * @return
	 */
	public static Point takePointInput(int type) {
		double x = 0, y = 0;
		try {
			System.out.println("Enter the X coordinate of the point : ");
			x = takeDoubleInput(type, 1);
			System.out.println("Enter the Y coordinate of the point : ");
			y = takeDoubleInput(type, 2);
		}
		catch(Exception e) {
			System.out.println("Exception occured in takePointInput method");
		}
		return new Point(x, y);
	}
	
	/**
	 * Method to print all the operations available
	 */
	public static void printMenu() {
		System.out.println("..........Main Menu............");
		System.out.println("1 : Add a shape object to the screen at a specified location with default orientation");
		System.out.println("2 : Delete a shape object from the screen");
		System.out.println("3 : Delete all shape objects of a specific type");
		System.out.println("4 : Return the shape objects on the screen sorted in ascending order");
		System.out.println("5 : Return the list of shape objects enclosing a specified point");
		System.out.println("6 : EXIT");
	}
	
	/**
	 * Method to print all the shapes available
	 */
	public static void printShapeType() {
		System.out.println("1 : CIRCLE");
		System.out.println("2 : RECTANGLE");
		System.out.println("3 : TRIANGLE");
		System.out.println("4 : SQUARE");
	}
	
	/**
	 * Method to print all the shape
	 * with specifications which are currently present on the screen
	 * @param listOfShapes
	 */
	public static void printShapesOnScreen(ArrayList<Shape> listOfShapes) {
		try {
			for(Shape shape : listOfShapes) {
				Point p = shape.getOrigin();
				System.out.println("ShapeId of the shape : " + shape.shapeId);
				System.out.println("Type of shape : " + shape.shape);
				System.out.println("TimeStamp of shape : " + shape.timestamp);
				System.out.println("Origin of shape : " + p.xCoordinate + ", " + p.yCoordinate);
				System.out.println("Area occupied by the shape : " + shape.getArea());
				System.out.println("Perimeter of the shape : " + shape.getPerimeter());
				System.out.println("Distance from the origin of the screen : " + shape.getOriginDistance());
				System.out.println("------------------------");
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in printShapesOnScreen method");
		}
	}
	
	/**
	 * Method to print all the sorting options
	 */
	public static void printSortOptions() {
		System.out.println("Select by which field you want to sort the shapes on screen : ");
		System.out.println("1 : Based on area occupied by the shape");
		System.out.println("2 : Based on perimeter of the shape");
		System.out.println("3 : Based on the timestamp the shape is added");
		System.out.println("4 : Based on the distance from the origin");
	}

	public static void main(String[] args) {
		System.out.println("Please enter the dimensions of the screen : ");
		System.out.println("Maximum X Coordinate : " + XMAX);
		System.out.println("Maximum Y Coordinate : " + YMAX);
		screenDimension = takePointInput(1);
		int shapeId = 1;
		VirtualScreen screen = new VirtualScreen(screenDimension.xCoordinate, screenDimension.yCoordinate);
		int option;
		do {
			printMenu();
			option = takeIntInput(0, 0);
			switch(option) {
				case 1 : {
					System.out.println("Please select the Shape Type to insert on the screen : ");
					printShapeType();
					int type = takeIntInput(0, 0);
					Shape obj = null;
					switch(type) {
						case 1 : {
							System.out.println("Enter the radius of the circle : ");
							double radius = takeDoubleInput(0, 0);
							System.out.println("Enter the coordinates of the center of the circle : ");
							Point p = takePointInput(2);
							obj = FactoryFunction.createShape(ShapeType.CIRCLE, 0, 0,radius, 0, p, shapeId);
							break;
						}
						case 2 : {
							System.out.println("Enter the length of the rectangle : ");
							double length = takeDoubleInput(0, 0);
							System.out.println("Enter the breadth of the rectangle : ");
							double breadth = takeDoubleInput(0, 0);
							System.out.println("Enter the coordinates of the origin of the rectangle : ");
							Point p = takePointInput(2);
							obj = FactoryFunction.createShape(ShapeType.RECTANGLE, length, breadth, 0, 0, p, shapeId);
							break;
						}
						case 3 : {
							System.out.println("Enter the length of the side of the triangle : ");
							double sideLength = takeDoubleInput(0, 0);
							System.out.println("Enter the coordinates of the origin of the triangle : ");
							Point p = takePointInput(2);
							obj = FactoryFunction.createShape(ShapeType.TRIANGLE, 0, 0, 0, sideLength, p, shapeId);
							break;
						}
						case 4 : {
							System.out.println("Enter the length of the side of the square : ");
							double sideLength = takeDoubleInput(0, 0);
							System.out.println("Enter the coordinates of the origin of the square : ");
							Point p = takePointInput(2);
							obj = FactoryFunction.createShape(ShapeType.SQUARE, 0, 0, 0, sideLength, p, shapeId);
							break;
						}
						default : {
							System.out.println("Please Enter a valid option");
							break;
						}
					}
					if(obj != null) {
						screen.addShapeToScreen(obj);
						System.out.println("Shapes present on the screen : ");
						printShapesOnScreen(screen.allShapesOnScreen());
						shapeId++;
					}
					break;
				}
				case 2 : {
					printShapesOnScreen(screen.allShapesOnScreen());
					System.out.println("Please enter the ShapeId of the shape you want to delete : ");
					int id = takeIntInput(0, 0);
					// check for valid input id
					if(screen.checkIfShapeExists(id)) {
						System.out.println("Shape with this shape Id does'nt exist on the screen");
						break;
					}
					screen.deleteShapeFromScreen(id);
					System.out.println("Shapes present on the screen after deletion : ");
					printShapesOnScreen(screen.allShapesOnScreen());
					break;
				}
				case 3 : {
					System.out.println("Please select the Shape Type to delete from the screen : ");
					printShapeType();
					int type = takeIntInput(0, 0);
					switch(type) {
						case 1 : {
							screen.deleteShapeOfSpecificType(ShapeType.CIRCLE);
							break;
						}
						case 2 : {
							screen.deleteShapeOfSpecificType(ShapeType.RECTANGLE);
							break;
						}
						case 3 : {
							screen.deleteShapeOfSpecificType(ShapeType.TRIANGLE);
							break;
						}
						case 4 : {
							screen.deleteShapeOfSpecificType(ShapeType.SQUARE);
							break;
						}
						default : {
							System.out.println("Please Enter a valid option");
							break;
						}
					}
					System.out.println("Shapes present on the screen after deletion : ");
					printShapesOnScreen(screen.allShapesOnScreen());
					break;
				}
				case 4 : {
					printSortOptions();
					int type = takeIntInput(0, 0);
					ArrayList<Shape> shapeList = null;
					switch(type) {
						case 1 : {
							shapeList = screen.sortByArea();
							break;
						}
						case 2 : {
							shapeList = screen.sortByPerimeter();
							break;
						}
						case 3 : {
							shapeList = screen.allShapesOnScreen();
							break;
						}
						case 4 : {
							shapeList = screen.sortByOriginDistance();
							break;
						}
						default : {
							System.out.println("Please enter a valid option");
							break;
						}
					}
					System.out.println("Shapes list after sorting : ");
					printShapesOnScreen(shapeList);
					break;
				}
				case 5 : {
					System.out.println("Enter the point on the screen : ");
					Point p = takePointInput(2);
					ArrayList<Shape> shapeList = screen.getShapesEnclosingPoint(p);
					if(shapeList.size() == 0) System.out.println("No shapes currently present on the screen enclosing this point");
					else {
						System.out.println("Shapes enclosing this point are : ");
						printShapesOnScreen(shapeList);
					}
					break;
				}
				default : {
					if(option != 6) System.out.println("Please enter a valid option");
					break;
				}
			}
		}while(option != 6);
	}

}
