package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
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

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		// January min boundary: min+1  →  2 January
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2, date.getDay());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		// January min boundary: min-1  →  31 December of previous year
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(2023, date.getYear());
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	
	// -----------------------------------------------------------------------
    // Table A  –  Previous date (decrement) test cases
    // -----------------------------------------------------------------------
 
    /** 1A: Day=1, Month=6, Year=1994  →  previous = 31-5-1994 */
    @Test
    public void test1A_June1ShouldDecrementToMay31() {
        DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("1A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 2A: Day=2, Month=6, Year=1994  →  previous = 1-6-1994 */
    @Test
    public void test2A_June2ShouldDecrementToJune1() {
        DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("2A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 3A: Day=15, Month=6, Year=1994  →  previous = 14-6-1994 */
    @Test
    public void test3A_June15ShouldDecrementToJune14() {
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("3A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 4A: Day=30, Month=6, Year=1994  →  previous = 29-6-1994 */
    @Test
    public void test4A_June30ShouldDecrementToJune29() {
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("4A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 5A: Day=31, Month=6  →  Invalid Date (June has only 30 days) */
    @Test(expected = RuntimeException.class)
    public void test5A_June31ShouldBeInvalid() {
        // June has 30 days; day 31 must throw
        new DateUtil(31, 6, 1994);
    }
 
    /** 6A: Day=15, Month=1, Year=1994  →  previous = 14-1-1994 */
    @Test
    public void test6A_January15ShouldDecrementToJanuary14() {
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("6A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(1,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 7A: Day=15, Month=2, Year=1994  →  previous = 14-2-1994 */
    @Test
    public void test7A_February15ShouldDecrementToFebruary14() {
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("7A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(2,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 8A: Day=15, Month=11, Year=1994  →  previous = 14-11-1994 */
    @Test
    public void test8A_November15ShouldDecrementToNovember14() {
        DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("8A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 9A: Day=15, Month=12, Year=1994  →  previous = 14-12-1994 */
    @Test
    public void test9A_December15ShouldDecrementToDecember14() {
        DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("9A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 10A: Day=15, Month=6, Year=1700  →  previous = 14-6-1700 */
    @Test
    public void test10A_June15Year1700ShouldDecrementToJune14() {
        DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("10A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(1700, date.getYear());
    }
 
    /** 11A: Day=15, Month=6, Year=1701  →  previous = 14-6-1701 */
    @Test
    public void test11A_June15Year1701ShouldDecrementToJune14() {
        DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("11A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(1701, date.getYear());
    }
 
    /** 12A: Day=15, Month=6, Year=2023  →  previous = 14-6-2023 */
    @Test
    public void test12A_June15Year2023ShouldDecrementToJune14() {
        DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("12A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
 
    /** 13A: Day=15, Month=6, Year=2024  →  previous = 14-6-2024 */
    @Test
    public void test13A_June15Year2024ShouldDecrementToJune14() {
        DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("13A: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
 
 
    // -----------------------------------------------------------------------
    // Table B  –  Next date (increment) test cases
    // -----------------------------------------------------------------------
 
    /** 1B: Day=1, Month=6, Year=1994  →  next = 2-6-1994 */
    @Test
    public void test1B_June1ShouldIncrementToJune2() {
        DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("1B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 2B: Day=2, Month=6, Year=1994  →  next = 3-6-1994 */
    @Test
    public void test2B_June2ShouldIncrementToJune3() {
        DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("2B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 3B: Day=15, Month=6, Year=1994  →  next = 16-6-1994 (nominal) */
    @Test
    public void test3B_June15ShouldIncrementToJune16() {
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("3B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 4B: Day=29, Month=6, Year=1994  →  next = 30-6-1994 (max-1) */
    @Test
    public void test4B_June29ShouldIncrementToJune30() {
        DateUtil date = new DateUtil(29, 6, 1994);
        System.out.println("4B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 5B: Day=30, Month=6, Year=1994  →  next = 1-7-1994 (max+1 rolls over) */
    @Test
    public void test5B_June30ShouldIncrementToJuly1() {
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("5B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 6B: Day=15, Month=1, Year=1994  →  next = 16-1-1994 */
    @Test
    public void test6B_January15ShouldIncrementToJanuary16() {
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("6B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 7B: Day=15, Month=2, Year=1994  →  next = 16-2-1994 */
    @Test
    public void test7B_February15ShouldIncrementToFebruary16() {
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("7B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(2,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 8B: Day=15, Month=11, Year=1994  →  next = 16-11-1994 */
    @Test
    public void test8B_November15ShouldIncrementToNovember16() {
        DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("8B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 9B: Day=15, Month=12, Year=1994  →  next = 16-12-1994 */
    @Test
    public void test9B_December15ShouldIncrementToDecember16() {
        DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("9B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** 10B: Day=15, Month=6, Year=1700  →  next = 16-6-1700 */
    @Test
    public void test10B_June15Year1700ShouldIncrementToJune16() {
        DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("10B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(1700, date.getYear());
    }
 
    /** 11B: Day=15, Month=6, Year=1701  →  next = 16-6-1701 */
    @Test
    public void test11B_June15Year1701ShouldIncrementToJune16() {
        DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("11B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(1701, date.getYear());
    }
 
    /** 12B: Day=15, Month=6, Year=2023  →  next = 16-6-2023 */
    @Test
    public void test12B_June15Year2023ShouldIncrementToJune16() {
        DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("12B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
 
    /** 13B: Day=15, Month=6, Year=2024  →  next = 16-6-2024 */
    @Test
    public void test13B_June15Year2024ShouldIncrementToJune16() {
        DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("13B: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6,  date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
 
 
    // -----------------------------------------------------------------------
    // Extra: February leap year / non-leap year boundary tests
    // -----------------------------------------------------------------------
 
    /** Leap year 2024: Feb 28 +1 → Feb 29 (leap year has 29 days) */
    @Test
    public void testFebruaryLeapYear_28ShouldIncrementTo29() {
        DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("Feb leap +1: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2,  date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
 
    /** Leap year 2024: Feb 29 +1 → Mar 1 (last day of leap February) */
    @Test
    public void testFebruaryLeapYear_29ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Feb leap max+1: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
 
    /** Leap year 2024: Feb 29 -1 → Feb 28 */
    @Test
    public void testFebruaryLeapYear_29ShouldDecrementToFebruary28() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Feb leap max-1: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2,  date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
 
    /** Non-leap year 1994: Feb 28 +1 → Mar 1 (no Feb 29) */
    @Test
    public void testFebruaryNonLeapYear_28ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(28, 2, 1994);
        System.out.println("Feb non-leap max+1: " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** Non-leap year 1994: day 29 in February is invalid */
    @Test(expected = RuntimeException.class)
    public void testFebruaryNonLeapYear_29ShouldBeInvalid() {
        new DateUtil(29, 2, 1994);
    }
 
    /** Non-leap year 1994: Feb 28 -1 → Feb 27 */
    @Test
    public void testFebruaryNonLeapYear_28ShouldDecrementToFebruary27() {
        DateUtil date = new DateUtil(28, 2, 1994);
        System.out.println("Feb non-leap max-1: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(27, date.getDay());
        Assert.assertEquals(2,  date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
 
    /** Feb 1 -1 → Jan 31 (min boundary across month in leap year) */
    @Test
    public void testFebruaryLeapYear_1ShouldDecrementToJanuary31() {
        DateUtil date = new DateUtil(1, 2, 2024);
        System.out.println("Feb leap min-1: " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1,  date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }
}
