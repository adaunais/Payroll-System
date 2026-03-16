package payroll;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTests {
	
	@Test
	//test to see if the output in SalariedEmployee is correct
	public void test1() throws Exception {
		assertEquals("Salaried, Base : $ 800,000; Id:1-Allison, Daunais" , "" + new SalariedEmployee("Allison", "Daunais", 800000f));
		assertEquals("Salaried, Base : $ 100,000; Id:2-Arora, Shashank" , "" + new SalariedEmployee("Arora", "Shashank", 100000f));
		

	}
	
	
	
	@Test
	//test to see if yearly pay is correct 
	//0.0f - makes sure the number is exact
	public void test2() throws Exception {
		SalariedEmployee one = new SalariedEmployee("Allison" , "Daunais" , 100000f);
		assertEquals(100000, one.getYearlyPay(), 0.0f);
	}
	
	
	
	@Test 
	//test to see if pay rate is correct and we can access it 
	//0.0f - makes sure answer is exact 
	public void test3() throws Exception {
		HourlyEmployee one = new HourlyEmployee("Allison" , "Daunais" , 15.25f);
		assertEquals(15.25f, one.getpayRate(), 0.0f);
	}
	
	@Test
	//test to see if hours worked is correct and we can access hoursWorked 
	public void test4() throws Exception {
		HourlyEmployee one = new HourlyEmployee("Allison" , "Daunais" , 15.25f);
		one.setHoursWorked(40.23f);
		assertEquals(40.23f, one.getHoursWorked(), 0.0f);
		
		
	}

	
	@Test
	public void test5() throws Exception {
		HourlyEmployee one = new HourlyEmployee("Allison" , "Daunais" , 15.25f);
		one.setHoursWorked(40.25f);
		assertEquals(613.8125f, one.getPaycheck(), 0.0f);
	}
	
	@Test
	public void test6() throws Exception {
		SalariedEmployee one = new SalariedEmployee("Allison" , "Daunais " , 100000f);
		one.setYearlyPay(100000f);
		assertEquals(3846.15385f , one.getPaycheck(), 0.0f);
		
	}
}
