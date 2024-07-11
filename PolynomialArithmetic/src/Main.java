import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	/*
	 * Method to handle exception and validate integer inputed
	 * 
	 * return : inputted integer
	 */
	public static int takeIntInput(int type) {
        Scanner sc = new Scanner(System.in);
        Integer value;
        while(true) {
            try {
            	value = sc.nextInt();
            }
            catch(Exception e) {
                System.out.println("Please enter a integer value");
                sc.nextLine();
                continue;
            }
            if(type == 1) {
            	if(value > 20) {
            		System.out.println("Maximum value of power can be 20");
            		continue;
            	}
            	else if(value < 0) {
            		System.out.println("Power must be a non negative value");
            		continue;
            	}
            	else break;
            }
            else if(type == 2 && value <= 0) {
            	System.out.println("Please enter positive integer value");
            	continue;
            }
            else if(type == 3 && value == 0) {
            	System.out.println("Coefficient must be non zero value");
            	continue;
            }
            else break;
        }
        return value;
    }
	
	/**
	 * Method to handle exception and validate double value inputed
	 * @return
	 */
	public static double takeDoubleInput() {
        Scanner sc = new Scanner(System.in);
        Double value;
        while(true) {
            try {
            	value = sc.nextDouble();
            	break;
            }
            catch(Exception e) {
                System.out.println("Please enter a double value");
                sc.nextLine();
                continue;
            }
        }
        return value;
    }
	
	/**
	 * Method to input/create a polynomial
	 * @return
	 */
	public static ArrayList<Pair> takePolynomialInput() {
		ArrayList<Pair> temp = new ArrayList<>();
		try {
			System.out.println("Input a single variable polynomial : ");
			System.out.println("Enter the number of elements in the polynomial");
			int n = takeIntInput(2);
			for(int i = 0; i < n; i++) {
				System.out.println("Enter the power of the " + i + "th element");
				int power = takeIntInput(1);
				System.out.println("Enter the coefficient of the " + i + "th element");
				int coefficient = takeIntInput(3);
				Pair p = new Pair(power, coefficient);
				temp.add(p);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in takePolynomialInput method");
		}
		return temp;
	}
	
	/**
	 * Method to print all the available operations
	 */
	public static void printMenu() {
		System.out.println(".........Main Menu............");
		System.out.println("1 : evaluate the value of the polynomial for the given value of the variable");
		System.out.println("2 : return the degree of the polynomial");
		System.out.println("3 : add two polynomials");
		System.out.println("4 : multiply two polynomials");
		System.out.println("5 : print the polynomial");
		System.out.println("6 : EXIT");
	}
	
	/**
	 * Method to print the polynomial
	 * @param elementList
	 */
	public static void printPolynomial(ArrayList<Pair> elementList) {
		
		try {
			Comparator<Pair> com = new Comparator<Pair>() {
				
				public int compare(Pair p1, Pair p2) {
					return (p1.power < p2.power) ? -1 : 1;
				}
			};
			
			Collections.sort(elementList, com);
			
			boolean flag = true;
			System.out.println("Resultant polynomial : ");
			for(int i = elementList.size() - 1; i >= 0; i--) {
				if(flag) {
					System.out.print(elementList.get(i).coefficient + "X^" + elementList.get(i).power + " ");
					flag = false;
				}
				else {
					if(elementList.get(i).coefficient >= 0) System.out.print("+");
					System.out.print(elementList.get(i).coefficient + "X^" + elementList.get(i).power + " ");
				}
			}
			System.out.println();
		}
		catch(Exception e) {
			System.out.println("Exception occured in printPolynomial method");
		}
	}

	public static void main(String[] args) {
		ArrayList<Pair> elementList = takePolynomialInput();
		Polynomial poly1 = new Polynomial(elementList);
		int option;
		do {
			printMenu();
			option = takeIntInput(0);
			switch(option) {
				case 1 : {
					System.out.println("Enter the value of the variable : ");
					double X = takeDoubleInput();
					System.out.println("Value of the polynomial is : " + poly1.evaluateValue(X));
					break;
				}
				case 2 : {
					System.out.println("Degree of the polynomial is : " + poly1.degreeOfPolynomial());
					break;
				}
				case 3 : {
					System.out.println("Enter the second polynomial");
					ArrayList<Pair> elementList2 = takePolynomialInput();
					Polynomial poly2 = new Polynomial(elementList2);
					printPolynomial(poly1.addPolynomial(poly2));
					break;
				}
				case 4 : {
					System.out.println("Enter the second polynomial");
					ArrayList<Pair> elementList2 = takePolynomialInput();
					Polynomial poly2 = new Polynomial(elementList2);
					printPolynomial(poly1.multiplyPolynomial(poly2));
					break;
				}
				case 5 : {
					printPolynomial(poly1.getPolynomial());
					break;
				}
				default : {
					if(option != 6) System.out.println("Please enter a valid option");
				}
			}
		}while(option != 6);
	}

}
