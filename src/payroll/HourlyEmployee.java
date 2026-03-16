package payroll;

public class HourlyEmployee extends Employee {
	
	//declaring variables 
	private float hoursWorked;
	private float payRate;
	
	
	public HourlyEmployee(String firstName, String lastName, float payRate) {
		super(firstName, lastName);
		this.payRate = payRate;
		
	} 
	
	@Override 
	public float getPaycheck() {
		return hoursWorked * payRate;
	}
	//accessor
	public float getHoursWorked() {
		return hoursWorked;
	}
	
	//mutator 
	public void setHoursWorked(float hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	//accessor 
	public float getpayRate() {
		return payRate;
	}
	
	//mutator 
	public void setpayrate(float payRate) {
		this.payRate = payRate;
	}
	
	public String toString() {
		return "Hourly: $" + String.format("%.2f" , payRate) + "; "  + super.toString() ;
	}
	
	
	
	public static void main(String[]args) {
		
		HourlyEmployee one = new HourlyEmployee("Allison" , "Daunais" , 15.25f);
		//HourlyEmployee two = new HourlyEmployee("Arora" , "Shashank " , 15.25f);
		System.out.println(one);
		//System.out.println(two);
		
	}
}
