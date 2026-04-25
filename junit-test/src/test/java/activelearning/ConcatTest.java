package activelearning;

import org.junit.Assert;
import org.junit.Test;

public class ConcatTest {

	MyJUnitClass junit = new MyJUnitClass();

    @Test
    public void testConcatSingleChars() {
        Assert.assertEquals("ab", junit.concat("a", "b"));
    }

    @Test
    public void testConcatStringAndEmpty() {
        Assert.assertEquals("Hello", junit.concat("Hello", ""));
    }

    @Test
    public void testConcatEmptyAndString() {
        Assert.assertEquals("World", junit.concat("", "World"));
    }

    @Test
    public void testConcatEmptyEmpty() {
        Assert.assertEquals("", junit.concat("", ""));
    }

    @Test
    public void testConcatWords() {
        Assert.assertEquals("HelloWorld", junit.concat("Hello", "World"));
    }

    @Test
    public void testConcatWithSpace() {
        Assert.assertEquals("Hello World", junit.concat("Hello ", "World"));
    }

    @Test
    public void testConcatNumberStrings() {
        Assert.assertEquals("1234", junit.concat("12", "34"));
    }

    @Test
    public void testConcatSpecialCharacters() {
        Assert.assertEquals("@#$%", junit.concat("@#", "$%"));
    }

    @Test
    public void testConcatNullString() {
        Assert.assertEquals("nullWorld", junit.concat(null, "World"));
    }

    @Test
    public void testConcatStringNull() {
        Assert.assertEquals("Hellonull", junit.concat("Hello", null));
    }

    @Test
    public void testConcatNullNull() {
        Assert.assertEquals("nullnull", junit.concat(null, null));
    }
}
