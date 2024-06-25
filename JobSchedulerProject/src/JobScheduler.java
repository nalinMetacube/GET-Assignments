
public class JobScheduler {
	
	/*
	 * Arrays to store the calculated values and processes
	 * i.e. completionTime, waitingTime, etc.
	 */
	public static int[][] processes;
	public static int[] completionTime;
	public static int[] waitingTime;
	public static int[] turnAroundTime;
	
	/*
	 * Constructor used to allocate the memory
	 * according to the inputed processes.
	 * 
	 * @param : int[][] tasks - the processes inputed from user
	 * 							with both arrival and burst time
	 */
	public JobScheduler(int[][] tasks) {
		processes = tasks;
		int n = processes.length;
        completionTime = new int[n];
        waitingTime = new int[n];
        turnAroundTime = new int[n];
        calculateTimes();
	}
	
	/*
	 * Mehod to calculate different times as 
	 * asked in the problem statement.
	 * 
	 * logic for computation of different times 
	 * is mentioned in the method itself
	 */
	public static void calculateTimes() {
        int n = processes.length;
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            int arrivalTime = processes[i][0];
            int burstTime = processes[i][1];
            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }
            completionTime[i] = currentTime + burstTime;
            turnAroundTime[i] = completionTime[i] - arrivalTime;
            waitingTime[i] = turnAroundTime[i] - burstTime;
            currentTime = completionTime[i];
        }
    }
	
	/*
	 * Method to get average waiting time
	 * of all the processes
	 */
	public static double getAverageWaitingTime() {
		int totalTime = 0, n = processes.length;
        for(int i = 0; i < n; i++) {
        	totalTime += waitingTime[i];
        }
        return (double)(totalTime / n);
	}
	
	/*
	 * Method to get maximum waiting time
	 * among all processes waiting time.
	 */
	public static int getMaximumWaitingTime() {
		int n = processes.length, maximumTime = -1;
		for(int i = 0; i < n; i++) {
			maximumTime = Math.max(maximumTime, waitingTime[i]);
		}
		return maximumTime;
	}
	
	/*
	 * Method to print Completion Time
	 * of all the processes
	 */
	public static void printCompletionTime() {
		int n = processes.length;
		for(int i = 0; i < n; i++) {
			System.out.print(completionTime[i] + " ");
		}
		System.out.println();
	}
	
	/*
	 * Method to print Waiting Time
	 * of all the processes
	 */
	public static void printWaitingTime() {
		int n = processes.length;
		for(int i = 0; i < n; i++) {
			System.out.print(waitingTime[i] + " ");
		}
		System.out.println();
	}
	
	/*
	 * Method to print TurnAround Time
	 * of all the processes
	 */
	public static void printTurnAroundTime() {
		int n = processes.length;
		for(int i = 0; i < n; i++) {
			System.out.print(turnAroundTime[i] + " ");
		}
		System.out.println();
	}

}
