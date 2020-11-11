/**
 * 
 */
package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Stuffing.stuffing;

/**
 * @author johnstauffer
 *
 */
public class calculateSavingsTest {

	/**
	 * Test method for {@link main.java.BearWorkshop#BearWorkshop()}.
	 */
	@Test
	public final void testBearWorkshop() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.java.BearWorkshop#BearWorkshop(java.lang.String)}.
	 */
	@Test
	public final void testBearWorkshopString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.java.BearWorkshop#getCost(main.java.Bear)}.
	 */
	@Test
	public final void testGetCost() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.java.BearWorkshop#getRawCost(main.java.Bear)}.
	 */
	@Test
	public final void testGetRawCost() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.java.BearWorkshop#calculateTax()}.
	 */
	@Test
	public final void testCalculateTax() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.java.BearWorkshop#addBear(main.java.Bear)}.
	 */
	@Test
	public final void testAddBear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.java.BearWorkshop#removeBear(main.java.Bear)}.
	 */
	@Test
	public final void testRemoveBear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.java.BearWorkshop#checkout()}.
	 */
	@Test
	public final void testCheckout() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.java.BearWorkshop#calculateSavings()}.
	 */
	@Test
	public void checkForFreeBears() {
		
		BearWorkshop workshop1 = new BearWorkshop("NY");
		Bear bear1 = new Bear(stuffing.FOAM);
		Bear bear2 = new Bear(stuffing.FOAM);
		Bear bear3 = new Bear(stuffing.FOAM);
		workshop1.addBear(bear1);
		workshop1.addBear(bear2);
		workshop1.addBear(bear3);
		
		assertEquals(50, workshop1.calculateSavings(), .005);
		
		
	}

}
