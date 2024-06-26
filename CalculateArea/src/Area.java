import java.util.Scanner;

public class Area {
	
	private static final double PIE = 3.14159265359;
	
	/*
	 * Method to handle exception and validate double value inputed
	 */
	public static double takeDoubleInput() {
        Scanner sc = new Scanner(System.in);
        Double value;
        while(true) {
            try {
            	value = sc.nextDouble();
            }
            catch(Exception e) {
                System.out.println("Please enter a valid value : " + e.getMessage());
                sc.nextLine();
                continue;
            }
            if(value <= 0) {
            	System.out.println("Dimension must be positive real number");
            	continue;
            }
            else break;
        }
        return value;
    }
	
	/*
	 * Method to get area of a triangle
	 * 
	 * @param : double width, double height
	 */
	private static double getTriangleArea(double width, double height) {
		double area = (double)((width * height) / (double)(2));
		return area;
	}
	
	/*
	 * Method to get area of a rectangle
	 * 
	 * @param : double width, double height
	 */
	private static double getRectangleArea(double width, double height) {
		double area = (double)(width * height);
		return area;
	}
	
	/*
	 * Method to get area of a square
	 * 
	 * @param : double width
	 */
	private static double getSquareArea(double width) {
		double area = (double)(width * width);
		return area;
	}
	
	/*
	 * Method to get area of a circle
	 * 
	 * @param : double radius
	 */
	private static double getCircleArea(double radius) {
		double area = (double)(PIE * radius * radius);
		return area;
	}
	
	/*
	 * Method to print all the operations we can perform
	 */
	private static void printMenu() {
		System.out.println("..........Main Menu.......");
		System.out.println("Calculate area of following shapes : ");
		System.out.println("1 : Triangle");
		System.out.println("2 : Rectangle");
		System.out.println("3 : Square");
		System.out.println("4 : Circle");
		System.out.println("5 : EXIT");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		double width, height, radius;
		do {
			printMenu();
			option = sc.nextInt();
			switch(option) {
				case 1 : {
					System.out.println("Enter the width of the triangle : ");
					width = takeDoubleInput();
					System.out.println("Enter the height of the triangle : ");
					height = takeDoubleInput();
					System.out.println("Area of the triangle : " + getTriangleArea(width, height));
					break;
				}
				case 2 : {
					System.out.println("Enter the width of the rectangle : ");
					width = takeDoubleInput();
					System.out.println("Enter the height of the rectangle : ");
					height = takeDoubleInput();
					System.out.println("Area of the rectangle : " + getRectangleArea(width, height));
					break;
				}
				case 3 : {
					System.out.println("Enter the width of the square : ");
					width = takeDoubleInput();
					System.out.println("Area of the square : " + getSquareArea(width));
					break;
				}
				case 4 : {
					System.out.println("Enter the radius of the circle : ");
					radius = takeDoubleInput();
					System.out.println("Area of the circle : " + getCircleArea(radius));
					break;
				}
				default : {
					if(option != 5) System.out.println("Please enter valid option");
					break;
				}
			}
		}while(option != 5);
	}

}
