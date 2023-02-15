package edu.towson.cis.cosc442.project2.vendingmachine; 
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineTest {
	//test object
	private VendingMachine testVendingMachine;
	private VendingMachineItem testChips;
	private VendingMachineItem testGum;
	@Before
	public void setUp() throws Exception {
		//set up test objects
		testVendingMachine = new VendingMachine();
		testChips = new VendingMachineItem("Chips", 0.99);
		testGum = new VendingMachineItem("Gum", 0.50);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void NormalTest() {
		//Test normal operations
		//test addItem
		testVendingMachine.addItem(testChips, "A");
		testVendingMachine.addItem(testGum, "B");
		assertNotNull(testVendingMachine.getItem("A"));
		assertNotNull(testVendingMachine.getItem("B"));
		
		//test removeItem
		testVendingMachine.removeItem("B");
		assertNull(testVendingMachine.getItem("B"));
		
		//test insertMoney and getBalance
		assertTrue(testVendingMachine.getBalance() == 0);
		testVendingMachine.insertMoney(1.00);
		assertTrue(testVendingMachine.getBalance() != 0);
		assertEquals(1.00, testVendingMachine.getBalance(), 0.001);
		
		//test makePurchase
		assertTrue(testVendingMachine.makePurchase("A"));
		
		//test returnChange
		assertEquals(0.01,testVendingMachine.returnChange(), 0.001);
	}
	
	
	//Abnormal operation tests
	@Test (expected =  VendingMachineException.class)
	public final void emptySlotTest() {
		//Try to remove item from an already empty slot
		testVendingMachine.removeItem("A");
	}
	
	@Test (expected =  VendingMachineException.class)
	public final void occupiedSlotTest() {
		//Add item to an already occupied slot
		testVendingMachine.addItem(testChips, "A");
		testVendingMachine.addItem(testGum, "A");
	}
	
	@Test (expected =  VendingMachineException.class)
	public final void invalidSlotTest() {
		//Add item to a nonexistent slot
		testVendingMachine.addItem(testChips, "E");
		
		//Get item from invalid slot
		testVendingMachine.getItem("E");
	}
	
	@Test (expected =  VendingMachineException.class)
	public final void invalidAmountTest(){
		//Add negative money to vending machine
		testVendingMachine.insertMoney(-2.00);
	}
	
	@Test 
	public final void emptyPurchaseTest() {
		//Purchase item from empty slot; if statement should prevent the transaction
		//from taking place
		assertFalse(testVendingMachine.makePurchase("B"));
	}
	
	@Test
	public final void noChangeTest() {
		//Return change if 0 balance already
		assertEquals(0.00, testVendingMachine.returnChange(), 0.001);
	}
}
