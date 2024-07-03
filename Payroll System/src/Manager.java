
public class Manager extends Employee {
	public double basicSalary;
	public double bonus;
	public double compensation;
	
	/**
	 * Parameterized constructor to initailize the employee attributes
	 * @param empId
	 * @param firstName
	 * @param lastName
	 * @param basicSalary
	 */
	public Manager(int empId, String firstName, String lastName, double basicSalary) {
		super(empId, firstName, lastName, "Manager");
		this.basicSalary = basicSalary;
		this.bonus = (this.basicSalary * (0.25));
		this.compensation = this.basicSalary + this.bonus;
	}
	
	/**
	 * Method to get employee basic salary
	 */
	public double getBasicSalary() {
		return basicSalary + 50000;
	}
	
	/**
	 * Method to get employee quarterly bonus
	 */
	public double getBonus() {
		return bonus;
	}
	
	/**
	 * Method to get employee compensation
	 */
	public double getCompensation() {
		return compensation;
	}
}
