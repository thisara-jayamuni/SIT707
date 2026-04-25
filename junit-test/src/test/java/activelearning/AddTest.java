package activelearning;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {

	 MyJUnitClass junit = new MyJUnitClass();

	    @Test
	    public void testAddZeroZero() {
	        Assert.assertEquals(0, junit.add(0, 0));
	    }

	    @Test
	    public void testAddZeroPositive() {
	        Assert.assertEquals(2, junit.add(0, 2));
	    }

	    @Test
	    public void testAddPositiveZero() {
	        Assert.assertEquals(2, junit.add(2, 0));
	    }

	    @Test
	    public void testAddNegativeZero() {
	        Assert.assertEquals(-2, junit.add(-2, 0));
	    }

	    @Test
	    public void testAddZeroNegative() {
	        Assert.assertEquals(-2, junit.add(0, -2));
	    }

	    @Test
	    public void testAddPositivePositive() {
	        Assert.assertEquals(4, junit.add(2, 2));
	    }

	    @Test
	    public void testAddNegativeNegative() {
	        Assert.assertEquals(-4, junit.add(-2, -2));
	    }

	    @Test
	    public void testAddPositiveNegative() {
	        Assert.assertEquals(0, junit.add(2, -2));
	    }

	    @Test
	    public void testAddMaxBoundary() {
	        Assert.assertEquals(Integer.MAX_VALUE, junit.add(Integer.MAX_VALUE, 0));
	    }

	    @Test
	    public void testAddMinBoundary() {
	        Assert.assertEquals(Integer.MIN_VALUE, junit.add(Integer.MIN_VALUE, 0));
	    }
}
