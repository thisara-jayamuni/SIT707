package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	// ---- Q1 Addition Tests ----
	 
		@Test
		public void testAddPositiveNumbers() {
			Assert.assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0);
		}
	 
		@Test
		public void testAddZeroAndZero() {
			Assert.assertEquals(0.0, MathQuestionService.q1Addition("0", "0"), 0);
		}
	 
		@Test
		public void testAddNegativeNumbers() {
			Assert.assertEquals(-5.0, MathQuestionService.q1Addition("-2", "-3"), 0);
		}
	 
		@Test
		public void testAddLargeNumbers() {
			Assert.assertEquals(1000000.0, MathQuestionService.q1Addition("500000", "500000"), 0);
		}
	 
		@Test
		public void testAddDecimalNumbers() {
			Assert.assertEquals(5.5, MathQuestionService.q1Addition("2.5", "3.0"), 0);
		}
	 
		@Test(expected = NumberFormatException.class)
		public void testAddEmptyNumber1() {
			MathQuestionService.q1Addition("", "2");
		}
	 
		@Test(expected = NumberFormatException.class)
		public void testAddEmptyNumber2() {
			MathQuestionService.q1Addition("2", "");
		}
	 
		@Test(expected = NullPointerException.class)
		public void testAddNullNumber1() {
			MathQuestionService.q1Addition(null, "2");
		}
	 
		@Test(expected = NumberFormatException.class)
		public void testAddNonNumericInput() {
			MathQuestionService.q1Addition("abc", "2");
		}
	 
		// ---- Q2 Subtraction Tests ----
	 
		@Test
		public void testSubtractPositiveNumbers() {
			Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("3", "2"), 0);
		}
	 
		@Test
		public void testSubtractResultIsZero() {
			Assert.assertEquals(0.0, MathQuestionService.q2Subtraction("5", "5"), 0);
		}
	 
		@Test
		public void testSubtractResultNegative() {
			Assert.assertEquals(-3.0, MathQuestionService.q2Subtraction("2", "5"), 0);
		}
	 
		@Test
		public void testSubtractDecimalNumbers() {
			Assert.assertEquals(0.5, MathQuestionService.q2Subtraction("3.0", "2.5"), 0);
		}
	 
		@Test(expected = NumberFormatException.class)
		public void testSubtractEmptyNumber1() {
			MathQuestionService.q2Subtraction("", "2");
		}
	 
		@Test(expected = NumberFormatException.class)
		public void testSubtractNonNumericInput() {
			MathQuestionService.q2Subtraction("abc", "2");
		}
	 
		// ---- Q3 Multiplication Tests ----
	 
		@Test
		public void testMultiplyPositiveNumbers() {
			Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0);
		}
	 
		@Test
		public void testMultiplyByZero() {
			Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("5", "0"), 0);
		}
	 
		@Test
		public void testMultiplyNegativeNumbers() {
			Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("-2", "-3"), 0);
		}
	 
		@Test(expected = NumberFormatException.class)
		public void testMultiplyEmptyInput() {
			MathQuestionService.q3Multiplication("", "3");
		}	
}
