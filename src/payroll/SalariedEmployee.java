package payroll;

public class SalariedEmployee extends Employee{

	//declare salary 
	protected float yearlyPay;

	
	//Constructor sets first name, last name and salary pay
	public SalariedEmployee(String firstName, String lastName, float yearlyPay) {
		super(firstName, lastName);
		this.yearlyPay = yearlyPay;
	}
	
	//accessor
	public float getYearlyPay() {
		return yearlyPay;
	}
	//mutator 
	public void setYearlyPay(float yearlyPay) {
		this.yearlyPay = yearlyPay;
	}
	
	//pay is calculated 26 times a year, so we divide the yearly salary by 26
	public float getPaycheck() {
		return yearlyPay /26.0f;
	}
	
	@Override 
	//will be the output of the program 
	//formats decimals to integers for easy readability
	//gets first and last names from the toString method in Employee.java
	public String toString() {
		return "Salaried, Base: $" + String.format("%, .0f" , yearlyPay) + "; " +  super.toString();	}

	
	//main method
	//create new employee here 
	//print statements to output the names and salary pay
	public static void main (String[]args) {
		//TEST CASE
		SalariedEmployee one = new SalariedEmployee("Allison" , "Daunais " , 100000f);
		SalariedEmployee two = new SalariedEmployee("Arora" , "Shashank " , 100000f);
		System.out.println(one);
		System.out.println(two);
	}

}
