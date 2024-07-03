
public abstract class Employee {
	
	// attributes of the employee within organization
	public int empID;
	public String firstName;
	public String lastName;
	public String deptName;
	
	/**
	 * Parameterized constructor to initailize the employee attributes
	 * @param empId
	 * @param firstName
	 * @param lastName
	 * @param deptName
	 */
	public Employee(int empId, String firstName, String lastName, String deptName) {
		try {
			this.empID = empId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.deptName = deptName;
		}
		catch(Exception e) {
			System.out.println("Exception occured in Employee constructor");
		}
	}
	
	// abstract methods to get implemented by different types of employees
	
	public abstract double getBasicSalary();
	public abstract double getBonus();
	public abstract double getCompensation();
}
