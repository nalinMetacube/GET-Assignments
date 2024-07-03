import java.util.ArrayList;

public class PayRoll {
	
	/**
	 * Method to print the paySlips of all the
	 * employees within the given organization
	 * @param org
	 */
	public static void printEmployeeSalarySlip(Organization org) {
		try {
			System.out.println("Salary PaySlips of " + org.name + " Employees : ");
			ArrayList<Employee> allEmployees = org.getAllEmployees();
			for(Employee emp : allEmployees) {
				System.out.println("..................");
				System.out.println("Employee ID : " + emp.empID);
				System.out.println("Employee name : " + emp.firstName + " " + emp.lastName);
				System.out.println("Employee Department : " + emp.deptName);
				System.out.print("Employee Salary : Rs ");
				System.out.printf("%.2f", emp.getBasicSalary());
				System.out.println();
				System.out.print("Employee Quarterly Bonus : Rs ");
				System.out.printf("%.2f", emp.getBonus());
				System.out.println();
				System.out.print("Employee compensation : Rs ");
				System.out.printf("%.2f", emp.getCompensation());
				System.out.println();
				System.out.print("Tax Paid by employee : Rs ");
				System.out.printf("%.2f", (emp.getCompensation() * (0.18)));
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in printEmployeeSalarySlip method");
		}
	}

	public static void main(String[] args) {
		
		// Organization 1 (MetaCube)
		Organization org1 = new Organization("Metacube");
		
		Department dept1 = new Department("Development", 1);
		Department dept2 = new Department("Human Resources", 2);
		Department dept3 = new Department("Management", 3);
		
		org1.addDepartment(dept1);
		org1.addDepartment(dept2);
		org1.addDepartment(dept3);
		
		Employee emp1 = new Developer(1, "Nalin", "Gupta", 39000.98);
		Employee emp2 = new Developer(2, "Gaurav", "Kumar", 45000.56);
		Employee emp3 = new HR(3, "Pooja", "Saxena", 31000.027);
		Employee emp4 = new HR(4, "Mena", "Suresh", 45000.576);
		Employee emp5 = new Manager(5, "Neetima", "Sharma", 51800.78);
		Employee emp6 = new Manager(6, "Ashish", "Dadhich", 63080.89);
		
		dept1.joinDeveloper(emp1);
		dept1.joinDeveloper(emp2);
		dept2.joinDeveloper(emp3);
		dept2.joinDeveloper(emp4);
		dept3.joinDeveloper(emp5);
		dept3.joinDeveloper(emp6);
		
		
		PayRoll.printEmployeeSalarySlip(org1);
		
		dept1.relieveDeveloper(emp2);
		dept3.relieveDeveloper(emp5);
		org1.removeDepartment(dept2);
		
		
		System.out.println("After recession Employee details are as follows : ");
		PayRoll.printEmployeeSalarySlip(org1);
		
		System.out.println();
		
//		Organization 2 (Tech Innovators) 
		Organization org2 = new Organization("Tech Innovators");
		
		Department dept4 = new Department("Engineering", 4); 
		Department dept5 = new Department("Marketing", 5);
		
		org2.addDepartment(dept4); 
		org2.addDepartment(dept5);
		Employee emp7 = new Developer(7, "John", "Doe", 40000.0);
		Employee emp8 = new Developer(8, "Jane", "Smith", 42000.0);
		Employee emp9 = new Manager(9, "Michael", "Johnson", 55000.0);
		Employee emp10 = new Manager(10, "Emily", "Brown", 60000.0);
		
		dept4.joinDeveloper(emp7);
		dept4.joinDeveloper(emp8);
		dept5.joinDeveloper(emp9);
		dept5.joinDeveloper(emp10);
		
		PayRoll.printEmployeeSalarySlip(org2); 
		
		dept5.relieveDeveloper(emp9); 
		org2.removeDepartment(dept5); 
		
		System.out.println("After restructuring Employee details are as follows : ");
		PayRoll.printEmployeeSalarySlip(org2);
	}

}
