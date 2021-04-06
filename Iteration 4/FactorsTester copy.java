import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FactorsTester {

	ArrayList<Integer> dad = new ArrayList<Integer>();
	
	@Test
	void testPerfect1()
	{	
		// TEST 1: should throw the exception because the parameter value is less than 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.perfect(0));
	}
	
	@Test
	void testPerfect2()
	{	
		// TEST 2: should succeed because 1 is a valid parameter value, but is not a perfect number
		assertFalse(FactorsUtility.perfect(1));
	}
	
	@Test
	void testPerfect3()
	{	
		// TEST 3: should succeed because 6 is a valid parameter value, and is a perfect number
		assertTrue(FactorsUtility.perfect(6));
	}
	
	@Test
	void testPerfect4()
	{	
		// TEST 4: should succeed because 7 is a valid parameter value, but is not a perfect number
		// I've coded this using assertEquals to show that there's often more than one way to write a test 
		boolean expected = false;
		assertEquals(expected, FactorsUtility.perfect(7));
	}
	
	@Test
	void testgetfactors1() {
		
		//Test 1: should return [1] because parameter is 2
		ArrayList<Integer> dad = new ArrayList<Integer>();
		dad.equals((FactorsUtility.getFactors(2)));
		
		assertEquals(dad.size() == 1, FactorsUtility.getFactors(2));
	}
	
	@Test
	void testgetfactors2() {
		
		//Test 2: should return [] because parameter is 1
		assertEquals(null, FactorsUtility.getFactors(1));
	}
	
	@Test
	void testgefactors3() {
		
		//Test3: should return [] because parameter is 0
		dad.equals((FactorsUtility.getFactors(0)));
		assertEquals(dad.size() == 0, FactorsUtility.getFactors(2));	
	}

	@Test
	void testgetfactors4() {
		
		//Test 4: should throw exception because parameter is than 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.getFactors(-1));
	}
	
	@Test
	void testgefactors5() {
		
		//Test5: should return [1,2,3,4,6] because parameter is 12
		dad.equals((FactorsUtility.getFactors(12)));
		assertEquals(dad.size() == 5, FactorsUtility.getFactors(2));	
	}
	
	@Test
	void testfactor1() {
		
		//Test1: should throw exception because one of the parameters is less than 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-1, 2));
	}
	
	@Test
	void testfactor2() {
		
		//Test2: should throw exception because one of the parameters is less than 0 and another is less than 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-1, 0));
	}
	
	@Test
	void testfactor3() {
		
		//Test3: should return true as the remainder of 10%2 is 0
		boolean result = true;
		assertEquals(result, FactorsUtility.factor(10, 2));
	}
	
	@Test
	void testfactor4() {
		
		//Test4: should return false as 2 is not a factor of 3
		boolean result = false;
		assertEquals(result, FactorsUtility.factor(3, 2));
	}
	
	@Test
	void testfactor5() {
		
		//Test5: should throw exception because one of the parameters is less than 1 
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(2, 0));
	}
	
	
}
	

