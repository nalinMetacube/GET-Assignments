import java.util.Scanner;

public class Main {
	
	/*
	 * To check for Integer input
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
            break;
        }
        return value;
    }
	
	/*
	 * Here in main method we are inputing
	 * all the processes(arrival and burst time)
	 * 
	 * and using JobSchedular class we are
	 * computing the different times for all
	 * the processes as asked in the question.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter the number of processes : ");
		n = takeIntInput();
		int[][] tasks = new int[n][2];
		System.out.println("Enter " + n + " processes with arrival and burst time in the order : ");
		for(int i = 0; i < n; i++) {
			tasks[i][0] = takeIntInput();
			tasks[i][1] = takeIntInput();
		}
		JobScheduler obj = new JobScheduler(tasks);
		JobScheduler.printCompletionTime();
		JobScheduler.printWaitingTime();
		JobScheduler.printTurnAroundTime();
		System.out.println(JobScheduler.getAverageWaitingTime());
		System.out.println(JobScheduler.getMaximumWaitingTime());
		
	}

}
