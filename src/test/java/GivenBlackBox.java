import main.java.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import main.java.BearWorkshop;

import static org.junit.Assert.*;

/***
 * This class provides a framework to implement black box tests for various
 * implementations of the BearWorkshop Class. The BearWorkshop is having a
 * blowout sale and is offering the following savings.
 *
 * Bears are Buy 2 bears, get 1 free. It is 10% off the cost of a bear when a
 * single bear has 10 or more accessories (Note that embroidery, stuffing, and
 * the material used for the bear casing is not considered an accessory).
 * Additionally, clothes are buy 2, get one free on each bear.
 */
@RunWith(Parameterized.class)
public class GivenBlackBox {
    private Class<BearWorkshop> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {
        this.classUnderTest = (Class<BearWorkshop>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {BearWorkshop1.class},
                {BearWorkshop2.class},
                {BearWorkshop3.class},
                {BearWorkshop4.class},
                {BearWorkshop5.class}

        };
        return Arrays.asList(classes);
    }

    private BearWorkshop createBearWorkshop(String name) throws Exception {
        Constructor<BearWorkshop> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }

    BearWorkshop oneBear;
    Double oneBearExpected;

    BearWorkshop threeBears;
    Double threeBearsExpected;

    BearWorkshop twoBears;
    Double twoBearsExpected;
    
    BearWorkshop removeBear;
    Double removeBearExpected;
    
    BearWorkshop downBears;
    Double downBearsExpected;

    @Before
    public void setUp() throws Exception {
    	
    	//3 Bears with down stuffing
    	downBears = createBearWorkshop("NY");
    	downBears.addBear(new Bear(Stuffing.stuffing.DOWN));
    	downBears.addBear(new Bear(Stuffing.stuffing.DOWN));
    	downBears.addBear(new Bear(Stuffing.stuffing.DOWN));
    	downBearsExpected = 40.00;

    	//Remove a free bear
    	removeBear = createBearWorkshop("NY");
    	removeBear.addBear(new Bear(Stuffing.stuffing.BASE));
    	removeBear.addBear(new Bear(Stuffing.stuffing.BASE));
    	removeBear.addBear(new Bear(Stuffing.stuffing.BASE));
    	removeBear.removeBear(new Bear(Stuffing.stuffing.BASE));
    	removeBearExpected = 0.00;
    	
        // One Bear base stuffing, no saving expected
        oneBear = createBearWorkshop("NY");
        oneBear.addBear(new Bear(Stuffing.stuffing.BASE));
        oneBearExpected = 0.00; // no savings
        
        // Three Bears expected to not pay for cheapest one
        threeBears = createBearWorkshop("AZ");
        threeBears.addBear(new Bear(Stuffing.stuffing.BASE));
        threeBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        threeBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        threeBearsExpected = 30.00;
        
        
    }

    @After
    public void tearDown() throws Exception {
    }

    // sample test

    /**
     * Test examines a BearFactory with 1 simple bear in it. The bear costs $30
     * and there are no savings.
     */
    @Test
    public void oneBearNoSavings() {
        Double ans = oneBear.calculateSavings();
        assertEquals(oneBearExpected, ans);
    }


    // sample test
    @Test
    public void threeBearsSaveOnCheapest() {
        Double ans = threeBears.calculateSavings();
        assertEquals(threeBearsExpected, ans);
    }

    // sample test
 
    @Test
    public void oneBearTest3clothingsExpectSaving() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        Bear customBear = new Bear(Stuffing.stuffing.BASE);
        bears.addBear(customBear);

	    customBear.clothing.add(new Clothing(4, "Hat"));
	    customBear.clothing.add(new Clothing(4, "Sunglasses"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    
        Double bearsExpected = 4.0;
        Double ans = bears.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    //Test a Bear with 10 paid items of clothing.
    @Test
    public void oneBearTest15ClothesSavings() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        Bear customBear = new Bear(Stuffing.stuffing.BASE);
        bears.addBear(customBear);

	    customBear.clothing.add(new Clothing(4, "Hat"));
	    customBear.clothing.add(new Clothing(4, "Sunglasses"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(3, "Gloves"));
	    customBear.clothing.add(new Clothing(3, "Socks"));
	    customBear.clothing.add(new Clothing(3, "Necklace"));
	    customBear.clothing.add(new Clothing(3, "Shirt"));
	    customBear.clothing.add(new Clothing(3, "Shorts"));
	    
	    
        Double bearsExpected = 22.0;
        Double ans = bears.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    //Test a Bear with 10 paid items of clothing.
    @Test
    public void oneBearTest14ClothesSavings() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        Bear customBear = new Bear(Stuffing.stuffing.BASE);
        bears.addBear(customBear);

	    customBear.clothing.add(new Clothing(4, "Hat"));
	    customBear.clothing.add(new Clothing(4, "Sunglasses"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    customBear.clothing.add(new Clothing(3, "Gloves"));
	    customBear.clothing.add(new Clothing(3, "Socks"));
	    customBear.clothing.add(new Clothing(3, "Necklace"));
	    customBear.clothing.add(new Clothing(3, "Shirt"));
	    
	    
	    
        Double bearsExpected = 19.0;
        Double ans = bears.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    //Test if a Bear is removed, is it's saving removed.
    @Test
    public void removeBearNoSavings() {
    	Double ans = removeBear.calculateSavings();
    	assertEquals(removeBearExpected, ans);		
    }
    
    //Test if proper discount is applied with down bears
    @Test
    public void downBearsSaving() {
    	Double ans = downBears.calculateSavings();
    	assertEquals(downBearsExpected, ans);
    }
    

}
