package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	//test object
	private VendingMachineItem testVendingMachineItem;
	@Before
	public void setUp() throws Exception {
		//set up test object
		testVendingMachineItem = new VendingMachineItem(null, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void NormalTest() {
		//Normal operation
		//test variables for the test constructor
		String testName = "Chips";
		double testPrice = 0.99;
		//test VendingMachine constructor
		testVendingMachineItem = new VendingMachineItem(testName, testPrice);
		assertNotNull(testVendingMachineItem.getName());
		assertNotNull(testVendingMachineItem.getPrice());
		
		//test getName
		assertEquals("Chips",testVendingMachineItem.getName());
		//test getPrice
		assertEquals(0.99, 0.99,testVendingMachineItem.getPrice());
	}
	
	
	@Test (expected =  VendingMachineException.class)
	public void BreakTest() {
		//Attempt to break the program (negative price)
		//variables
		String testName = "Chips";
		double testPrice = -0.99;
		testVendingMachineItem = new VendingMachineItem(testName, testPrice);
				
	}

}
