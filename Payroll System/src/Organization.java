import java.util.ArrayList;

public class Organization {
	
	public String name;
	// ArrayList to store the all the departments in the organization
	public ArrayList<Department> allDepartments;
	
	/**
	 * Parameterized constructor for initializing the values
	 * @param name
	 */
	public Organization(String name) {
		try {
			this.name = name;
			allDepartments = new ArrayList<Department>();
		}
		catch(Exception e) {
			System.out.println("Exception occured in Organization constructor");
		}
	}
	
	/**
	 * Method to add a department
	 * in the organization
	 * @param dept
	 * @return
	 */
	public boolean addDepartment(Department dept) {
		return allDepartments.add(dept);
	}
	
	/**
	 * Method to remove a department
	 * from the organization
	 * @param dept
	 * @return
	 */
	public boolean removeDepartment(Department dept) {
		return allDepartments.remove(dept);
	}
	
	/**
	 * Method to get all the employees of all the departments
	 * within the organization
	 * @return
	 */
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> result = new ArrayList<Employee>();
		try {
			for(Department dept : allDepartments) {
				for(Employee emp : dept.getEmployees()) {
					result.add(emp);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getAllEmployees method");
		}
		return result;
	}
}
