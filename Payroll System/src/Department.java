import java.util.ArrayList;

public class Department {
	public String name;
	public int deptID;
	// ArrayList to store all the Employees within the department
	public ArrayList<Employee> allEmployees;
	
	/**
	 * Parameterized constructor of initializing the values
	 * @param name
	 * @param deptID
	 */
	public Department(String name, int deptID) {
		try {
			this.name = name;
			this.deptID = deptID;
			allEmployees = new ArrayList<Employee>();
		}
		catch(Exception e) {
			System.out.println("Exception occured in Department constructor");
		}
	}
	
	/**
	 * Method to join a Employee within the department
	 * @param emp
	 * @return
	 */
	public boolean joinDeveloper(Employee emp) {
		return allEmployees.add(emp);
	}
	
	/**
	 * Method to remove an employee from the department
	 * @param emp
	 * @return
	 */
	public boolean relieveDeveloper(Employee emp) {
		return allEmployees.remove(emp);
	}
	
	/**
	 * Method to get all the employee
	 * working in the department
	 * @return
	 */
	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		try {
			for(Employee emp : allEmployees) {
				temp.add(emp);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getEmployees method");
		}
		return temp;
	}
}
