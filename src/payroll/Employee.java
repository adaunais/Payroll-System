package payroll;

public abstract class Employee {
	
	//declaring 
	//declare the first employee id number as one 
	//Starting integer number for employee number
	private static int nextEmployeeNumber = 1;
	private final int employeeNumber;
	private String firstName;
	private String lastName;
	
	
	//Constructor sets first name, last name, and employee number
	//increments the employee id number by one, every time a new Employee object is created 
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = nextEmployeeNumber;
		nextEmployeeNumber++;
		
	}
	
	
	//abstract method 
	//calculates employee paycheck
	public abstract float getPaycheck();
	
	@Override
	//return output string in the form of...
	//EXAMPLE OUTPUT: Id: Allison, Daunais
	public String toString() {
		return "Id:" + employeeNumber + "-" + firstName + ", " + lastName;
	}
	
	

	public String getFirstName() {
	    return firstName;
	}

	public String getLastName() {
	    return lastName;
	}

	public int getEmployeeNumber() {
	    return employeeNumber;
	}
	
	
	
	
	//main method
	public static void main (String[] args) {
		
		
	}

}
