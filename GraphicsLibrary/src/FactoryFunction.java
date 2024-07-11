
public class FactoryFunction {
	
	/**
	 * Method to create Shape object according to the shape required
	 * @param s
	 * @param length
	 * @param breadth
	 * @param radius
	 * @param sideLength
	 * @param p
	 * @param id
	 * @return
	 */
	public static Shape createShape(ShapeType s, double length, double breadth, double radius, double sideLength, Point p, int id) {
		Shape obj = null;
		try {
			switch(s) {
				case RECTANGLE : {
					obj = new Rectangle(length, breadth, p, id);
					break;
				}
				case SQUARE : {
					obj = new Square(sideLength, p, id);
					break;
				}
				case TRIANGLE : {
					obj = new Triangle(sideLength, p, id);
					break;
				}
				case CIRCLE : {
					obj = new Circle(radius, p, id);
					break;
				}
				default : {
					System.out.println("Please enter valid object");
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in createShape method");
		}
		return obj;
	}
}
