package payroll;

import java.util.Scanner;

public class Payroll {
	Scanner input = new Scanner(System.in);
	
	
	/*
	 * The Employee List
	 * currently allows for up to 100 employees
	 * List starts with zero employees 
	 */
	private Employee[] employeeList = new Employee[100];
	private int size = 0;
	

	
	//DISPLAY MENU METHOD
	public void displayOptions() {
		int choice =0;
		
		
		 /*OPTIONS MENU
		 * all options are listed here 
		 * Each options works with a different 
		 * User can exit and close program from the starting menu
		 */ 
		while (true) {
			System.out.println("Menu");
			System.out.println("Type 1 to: Create/add employee");
			System.out.println("Type 2 to: Search for Employee by last name");
			System.out.println("Type 3 to: Display an employee by employee number");
			System.out.println("Type 4 to: Run payroll");
			System.out.println("Type 5 to quit");
			System.out.println("Enter your choice");
			
			
			//If the user has not selected a valid input 1-5
			//The loop will return to the beginning 
			if(!input.hasNextInt()){
				System.out.println("enter valid");
				input.nextLine();
				continue;	
			}
			
			//Stores any valid input here
			choice = input.nextInt();
			input.nextLine();
			
			//option 5 is what breaks the loop and quits the program
			if(choice ==5) {
				System.out.println("Exit");
				break;
			}
			
			
		    //checks to see if answer is between 1-4
			//if invalid number is typed, the user will be looped back to the main menu
				if(choice > 5 || choice < 1) {
					System.out.println("invalid number");
					continue;
				}
				
				//each valid number corresponds to a different method created
				if (choice ==1) {
					createEmployee();
					continue;
				}else if(choice ==2) {
					
					searchemployeeByLastName();
				
					continue;
				}else if(choice ==3) {
					displayEmployeeByNumber();
					
					continue;
				}else if(choice ==4) {
					runPayroll();
					continue;
				}
		}	
	}
	
	
		private void createEmployee() {
			String first_name;
			String last_name;

		
			//loop
			//asks for first name 
			// sets input and also removes extra spaces
			while(true) {
			System.out.println("Please type first name");
			 first_name = input.nextLine().trim();
			 
			 //java regex 
			 //(.matches)sees if first name has valid input
			 // (!)if first name doses NOT match valid input 
			 //valid input includes - upper case and lower case letters, hyphens, and spaces 
			 if(!first_name.matches("[a-zA-Z\\-\\s]+")) {
			 
				 continue; //returns user to beginning of loop
			 }
			
			 
			 // if user types "q", they will be returned to the main menu
			if (first_name.equalsIgnoreCase("q")) {
				return;	
			
			}
				break; //breaks loop for getting for name
			}
			
			
			//loop
			//asks for first name 
			// sets input and also removes extra spaces
			while(true) {
			System.out.println("Please type your last name");
			last_name = input.nextLine().trim();
			
			//Java regex 
			//(!)if last name does not equal valid input 
			//valid input includes - upper case and lower case letters, hyphens, and spaces 
			if(!last_name.matches("[a-zA-Z\\-\\s]+")) {
				 
				 continue; //returns user to beginning of loop
			 }
			
			
			//return to the main menu
			//allows user to type either upper case or lower case and program will work
			if(last_name.equalsIgnoreCase("q")) {
				return;
			}
			
			//loop breaks 
			 break;
			}
			
			
			
			//ask question 
			System.out.println("Please say if you are hourly or salary");
			String salaryOrHourly = input.nextLine();
			
			//find if hourly
			//if hourly , displays employee using hourly constructor from HourlyEmployee file
			if(salaryOrHourly.toLowerCase().equals("hourly")) {
				System.out.println("Type your hourly rate: ");
				float payRate = input.nextFloat();
				input.nextLine();
				employeeList[size] = new HourlyEmployee(first_name, last_name, payRate);
				size++;
			}
			
			//find if salary
			//if salary , displays employee using salary constructor from SalariedEmployee file
			else if (salaryOrHourly.toLowerCase().equals("salary")) {	
				System.out.println("Type your salary pay: ");
				float yearlySalary = input.nextFloat();
				input.nextLine();
				employeeList[size] = new SalariedEmployee(first_name, last_name, yearlySalary);
				size++;
			}
			
			//allows user to quit back to menu
			else if(salaryOrHourly.equalsIgnoreCase("q")) {
				return;
			}
			
			//invalid response 
			else {
				System.out.println("Invalid");
			}
		}
			
			
			
			
		
	
	
		/* Run Payroll Method 
		 * Loops through the list of all employees
		 * Displays all created employees
		 * Uses methods from other classes to display if
		 */
		
		private void runPayroll() {
			System.out.println("Running Payroll...");
		    for (int i = 0; i < size; i++) {
		        Employee emp = employeeList[i];
		        float pay = 0;

		        if (emp instanceof HourlyEmployee) {
		            HourlyEmployee h = (HourlyEmployee) emp;
		            pay = h.getpayRate(); 
		        } else if (emp instanceof SalariedEmployee) {
		            SalariedEmployee s = (SalariedEmployee) emp;
		            pay = s.getYearlyPay(); 
		        }

		        System.out.println("Employee ID: " + emp.getEmployeeNumber() + ", Name: " + emp.getFirstName() + " " + emp.getLastName() + ", Pay: $" + pay);
		    }
		    System.out.println("Payroll processing complete.");
		    System.out.println("Press Enter to return to the menu...");
		    input.nextLine();
	
			 }
		
		
		
		
		
		
		 //SEARCH BY LAST NAME
		 public void searchemployeeByLastName() {
			 if (size ==0) {
				 System.out.println("No one");
				 return;
			
			 }
			 
			 String lastName;
			 
			 
			 //loop
			 //will loop until the user types a valid first name
			 //will return to the main menu if the user types "q"
			 while (true) {
				 System.out.println("Enter a last name to find their employee number");
				 lastName = input.nextLine().trim();
				 
				 //makes input lower case
				 //returns user to menu if q is typed 
				 if(lastName.toLowerCase().equals("q")) {
					 return;
				 }
				 
				 if (!lastName.matches("[A-Za-z\\-\\s]+")) {
					 System.out.print("invalid ");
					 continue;
				 }
				 break;
			 }
			 
			 
			 //helper method being used so we can find employee 
			 //sorting so we can stop searching when we hit certain characters 
			 quickSortByName(employeeList, 0 , size -1);
			 
			 boolean found = false;
			 
			 //go through every employee that has been created and added to the array
			 //SEQUENTIAL SEARCH
			 for(int i = 0; i < size; i++) {
				 //where the found employee is going to be stored for now
				 Employee foundEmployee = employeeList[i];
			 
				 //if the employee name matches the name using the getter in Employee.java file
				 if(foundEmployee.getLastName().equalsIgnoreCase(lastName)) {
					 
					 //if name is found, change it to true (set to false now) 
					 if (!found) {
						 
						 //changed to true here 
						 found = true;
					 }
					 
					 //print statement, prints first name, last name and employee number
					 System.out.println(foundEmployee.getFirstName() + " " + foundEmployee.getLastName() + "Employee ID Number " + foundEmployee.getEmployeeNumber());
				 }
				 
				 //stops the search
				 else if (found && foundEmployee.getLastName().compareToIgnoreCase(lastName) > 0)
				 	break;
				 	
			 }
			 
				 
		 
		 //if no matching name was found
		 if (!found) {
			 	//print
		        System.out.println("No employees found with that last name.");
		    }
		 
		 //allows user to return to main menu
		 System.out.println("\nPress Enter to return to the menu...");
		    input.nextLine();
		}
	
	
		 //HELPER METHOD for the method ABOVE^^^
		 //QUICKSORT
	private void quickSortByName(Employee[] arr, int low, int high) {
		
		//base case
		if (low >= high) {
			return;
		}
		
		//declaring variables 
		//declaring middle point of array
		int left = low;
		int right = high;
		Employee middle = arr[(low + high) / 2];
		
		//loop
		while (left<= right) {
			while (compareNames(arr[left], middle) < 0) {
				left++;
			}
			while (compareNames(arr[right], middle) > 0) {
				right--;
			}
			if (left <= right) {
				Employee t = arr[left]; 
				arr[left] = arr[right]; 
				arr[right] = t;
	            left++; 
	            right--;
			}
			}
		
		
		if (low < right) {
			quickSortByName(arr, low, right);
		}
	    if (left < high) {
	    	quickSortByName(arr, left, high);
	    }
	}
		
	      //helper method 
		private int compareNames(Employee a, Employee b) {
		    int cmp = a.getLastName().compareToIgnoreCase(b.getLastName());
		    if (cmp != 0) return cmp;
		    return a.getFirstName().compareToIgnoreCase(b.getFirstName());
		}
		
		
	
	//DISPLAY EMPLOYEE BY NUMBER
		
		private void displayEmployeeByNumber() {
		int target = -1;
		
		
		while(true) {
			System.out.println("Enter the employee number");
			String idNumber = input.nextLine();
		
		//lets the user return to the main menu
		//turns inout to lower case
		if(idNumber.toLowerCase().equals("q")) {
			return;
		
		}
		
		//java regex 
		// if input is not numbers 
		//make user try again and print "digits only" statement 
		 if(!idNumber.matches("[0-9]+")) {
			System.out.println("Digits only");
			continue;
		}
		
		 //change string input to int input 
		 target = Integer.parseInt(idNumber); 
	
		 //ID numbers start at 1
		 //user MUST type a number above 0
		 if (target < 0) {
			System.out.println("cant be less than zero");
			continue;
		}
		 	// breaks when user types a valid number 
			break;
		}
			
		//HELPER METHOD being used 
		selectionSortByEmployeeNumber(employeeList, size);
		
		System.out.println("sorted");
		
		
	
		boolean found  =false;
		int high = size -1;
		int low = 0;
		
		while(low <= high) {
			int mid = (low + high) /2;
			int middleNumber = employeeList[mid].getEmployeeNumber();
			
			
			//if middle number is the target number 
			if (middleNumber == target) {
				System.out.println("Employee found");
				System.out.print("ID Number" + employeeList[mid].getEmployeeNumber());
				System.out.println(employeeList[mid].getFirstName() + "" + employeeList[mid].getLastName());
				found = true;
				break;
				
			}
			
			else if (middleNumber < target) { //if the number in the middle of the array is smaller than the number the user typed
				low = mid + 1; //search the right half
			}
			
			else { //if the number in the middle of the array is bigger than the number the user typed
				high = mid -1; //search the left have
			}
		}
		
		//if found stays false/ the number isnt found 
		if (!found) {
			System.out.println("Not found");//print 
		}
		
		
		System.out.println("\nPress Enter to return to the menu...");
	    input.nextLine();
		
		}
		
		//HELPER METHOD for method ABOVE ^^^^^^^^
		//Selection sort
		private void selectionSortByEmployeeNumber(Employee[] arr, int size) {
			for (int i = 0; i < size -1; i++) {
				
				//current smallest number is the number we start with in the array
				int min = i;
				
				//look at the next numbers
				//if the next number is smaller than the first number
				//store that number instead
				for(int j = i + 1; j < size; j++) {
					if (arr[j].getEmployeeNumber() < arr[min].getEmployeeNumber()) {
						min = j;
					}
				}
				
				//stores are smallest number which we found above^^
				Employee smallestIdNumber = arr[min]; //Storing the index, NOT THE ACTAUL NUMBER
				
				//swap the min's index with the index[i] which is 0/the first number in the array
				arr[min] = arr[i];
				
				//now we can store the first number of the array as the smallest number
				arr[i] = smallestIdNumber;
		    
		    
		    }
		}
		    
		
		    
		
		
		//Main method 
		public static void main (String[]args) {
			Payroll payroll = new Payroll();
			payroll.displayOptions();
			
		}
	
	}
