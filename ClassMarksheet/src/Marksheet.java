import java.util.Scanner;

public class Marksheet {
	
	// to store grades of the students
	private static double[] grades;
	
	/*
	 * Method to handle exception and validate integer inputed
	 */
	public static int takeIntInput() {
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
            if(value <= 0) {
            	System.out.println("Please enter a positive integer value");
            	continue;
            }
            else break;
        }
        return value;
    }
	
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
            if(value < 0 || value > 100) {
            	System.out.println("Grade must be between 0 and 100 inclusive");
            	continue;
            }
            else break;
        }
        return value;
    }
	
	/*
	 * Method to get average grade
	 * of all students
	 * 
	 * @param : int n - number of students
	 */
	private static double getAverageOfGrades(int n) {
		double sum = 0;
		for(int i = 0; i < n; i++) {
			sum += grades[i];
		}
		return (double)(sum / n);
	}
	
	/*
	 * Method to get maximum grade
	 * among all students
	 * 
	 * @param : int n - number of students
	 */
	private static double getMaximumGrade(int n) {
		double maxm = -1;
		for(int i = 0; i < n; i++) {
			maxm = Math.max(maxm, grades[i]);
		}
		return maxm;
	}
	
	/*
	 * Method to get minimum grade
	 * among all students
	 * 
	 * @param : int n - number of students
	 */
	private static double getMinimumGrade(int n) {
		double minm = 200;
		for(int i = 0; i < n; i++) {
			minm = Math.min(minm, grades[i]);
		}
		return minm;
	}
	
	/*
	 * Method to get percentage
	 * of the students passed
	 * 
	 * @param : int n - number of students
	 */
	private static double studentPassedPercentage(int n) {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(grades[i] >= 40.0) cnt++;
		}
		double ans = (double)((double)(cnt) / (double)(n));
		ans *= 100.0;
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter the number of students in the class");
		n = takeIntInput();
		grades = new double[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Enter the " + (i + 1) + " student grades");
			grades[i] = takeDoubleInput();
		}
		System.out.println("Average of all the grades : " + getAverageOfGrades(n));
		System.out.println("Maximum of all the grades : " + getMaximumGrade(n));
		System.out.println("Minimum of all the grades : " + getMinimumGrade(n));
		System.out.println("Percentage of students passed : " + studentPassedPercentage(n) + "%");
	}

}
