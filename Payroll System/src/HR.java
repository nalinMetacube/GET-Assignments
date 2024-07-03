
public class HR extends Employee {
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
	public HR(int empId, String firstName, String lastName, double basicSalary) {
		super(empId, firstName, lastName, "HR");
		this.basicSalary = basicSalary;
		this.bonus = (this.basicSalary * (0.05));
		this.compensation = this.basicSalary + this.bonus;
	}
	
	/**
	 * Method to get employee basic salary
	 */
	public double getBasicSalary() {
		return basicSalary + 15000;
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
