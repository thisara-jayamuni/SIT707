package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224785681";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Thisara Jayamuni";
		Assert.assertNotNull("Student name is null", studentName);
	}
    
    // ─────────────────────────────────────────────────────────────────
    // weatherAdvice() tests  –  covers all branches
    // ─────────────────────────────────────────────────────────────────
 
    /**
     * CANCEL – windSpeed > DANGEROUS_WINDSPEED (70.0)
     * Boundary: 70.1 mph, 0.0 in rainfall
     */
    @Test
    public void testCancelWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }
 
    /**
     * CANCEL – precipitation > DANGEROUS_RAINFALL (6.0)
     * Boundary: 0.0 mph, 6.1 in rainfall
     */
    @Test
    public void testCancelHighRainfallAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }
 
    /**
     * CANCEL – windSpeed > CONCERNING_WINDSPEED AND precipitation > CONCERNING_RAINFALL
     * (45.0 < wind ≤ 70.0  AND  4.0 < rain ≤ 6.0)
     * Both "moderate" thresholds combined → still CANCEL
     */
    @Test
    public void testCancelCombinedWindAndRainfallAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 5.0));
    }
 
    /**
     * WARN – windSpeed > CONCERNING_WINDSPEED only (no dangerous levels)
     * 46.0 mph, 0.0 in rainfall
     */
    @Test
    public void testWarnHighWindAdvice() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 0.0));
    }
 
    /**
     * WARN – precipitation > CONCERNING_RAINFALL only (no dangerous levels)
     * 0.0 mph, 4.1 in rainfall
     */
    @Test
    public void testWarnHighRainfallAdvice() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 4.1));
    }
 
    /**
     * ALL CLEAR – both values safely below all thresholds
     */
    @Test
    public void testAllClearAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(0.0, 0.0));
    }
 
    /**
     * ALL CLEAR – values exactly AT the concerning thresholds (not above)
     * Boundary value: 45.0 mph, 4.0 in rainfall  → should NOT trigger WARN
     */
    @Test
    public void testAllClearBoundaryAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 4.0));
    }
 
    /**
     * IllegalArgumentException – negative wind speed
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWindSpeedThrowsException() {
        WeatherAndMathUtils.weatherAdvice(-1.0, 0.0);
    }
 
    /**
     * IllegalArgumentException – negative precipitation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrecipitationThrowsException() {
        WeatherAndMathUtils.weatherAdvice(0.0, -1.0);
    }
 
    // ─────────────────────────────────────────────────────────────────
    // isEven() tests
    // ─────────────────────────────────────────────────────────────────
 
    /** Even number → true */
    @Test
    public void testTrueNumberIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }
 
    /** Odd number → false  (fixes the placeholder test from the original file) */
    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(3));
    }
 
    /** Zero is even */
    @Test
    public void testZeroIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
    }
 
    /** Negative even number */
    @Test
    public void testNegativeEvenNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(-2));
    }
 
    /** Negative odd number */
    @Test
    public void testNegativeOddNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(-3));
    }
 
    // ─────────────────────────────────────────────────────────────────
    // isPrime() tests
    // ─────────────────────────────────────────────────────────────────
 
    /** 1 → treated as prime (matches source implementation) */
    @Test
    public void testIsPrimeForOne() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
    }
 
    /** 2 is prime (loop does not execute) */
    @Test
    public void testIsPrimeForTwo() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }
 
    /** 3 is prime */
    @Test
    public void testIsPrimeForThree() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
    }
 
    /** 4 is NOT prime (even, loop executes → returns false) */
    @Test
    public void testIsNotPrimeForFour() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }
 
    /** 7 is prime */
    @Test
    public void testIsPrimeForSeven() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
    }
 
    /** 9 is NOT prime (odd but composite) */
    @Test
    public void testIsNotPrimeForNine() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(9));
    }
}
