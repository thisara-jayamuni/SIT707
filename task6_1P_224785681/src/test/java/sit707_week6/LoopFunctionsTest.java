package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopFunctionsTest {
	 // ─────────────────────────────────────────────────────────────────
    // sumUpTo() – Part B (a): loop with simple statements
    // ─────────────────────────────────────────────────────────────────
 
    /**
     * Loop DOES NOT execute (n=0 → condition false on first check).
     * Covers the "loop body skipped" branch.
     */
    @Test
    public void testSumUpTo_Zero() {
        Assert.assertEquals(0, LoopFunctions.sumUpTo(0));
    }
 
    /**
     * Loop DOES NOT execute (negative n).
     */
    @Test
    public void testSumUpTo_Negative() {
        Assert.assertEquals(0, LoopFunctions.sumUpTo(-5));
    }
 
    /**
     * Loop executes exactly ONCE (n=1).
     * Covers the "loop body runs" branch.
     */
    @Test
    public void testSumUpTo_One() {
        Assert.assertEquals(1, LoopFunctions.sumUpTo(1));
    }
 
    /**
     * Loop executes multiple times (n=5 → 1+2+3+4+5 = 15).
     */
    @Test
    public void testSumUpTo_Five() {
        Assert.assertEquals(15, LoopFunctions.sumUpTo(5));
    }
 
    /**
     * Larger value to confirm correctness (n=10 → 55).
     */
    @Test
    public void testSumUpTo_Ten() {
        Assert.assertEquals(55, LoopFunctions.sumUpTo(10));
    }
 
    // ─────────────────────────────────────────────────────────────────
    // countEvens() – Part B (b): loop with conditional statement inside
    // ─────────────────────────────────────────────────────────────────
 
    /**
     * Loop DOES NOT execute (n=0).
     * Covers: outer loop condition false immediately.
     */
    @Test
    public void testCountEvens_Zero() {
        Assert.assertEquals(0, LoopFunctions.countEvens(0));
    }
 
    /**
     * Loop DOES NOT execute (negative n).
     */
    @Test
    public void testCountEvens_Negative() {
        Assert.assertEquals(0, LoopFunctions.countEvens(-3));
    }
 
    /**
     * n=1 → only odd number 1, inner-if is FALSE.
     * Covers: loop body runs + inner-if false branch.
     */
    @Test
    public void testCountEvens_OnlyOdd() {
        Assert.assertEquals(0, LoopFunctions.countEvens(1));
    }
 
    /**
     * n=2 → numbers {1,2}: inner-if TRUE for 2, FALSE for 1.
     * Covers: both branches of the inner conditional.
     */
    @Test
    public void testCountEvens_OneEven() {
        Assert.assertEquals(1, LoopFunctions.countEvens(2));
    }
 
    /**
     * n=6 → evens are {2,4,6} → count = 3.
     */
    @Test
    public void testCountEvens_MultipleEvens() {
        Assert.assertEquals(3, LoopFunctions.countEvens(6));
    }
 
    /**
     * n=7 → evens are {2,4,6} → count = 3.
     * Confirms odd upper bound handled correctly.
     */
    @Test
    public void testCountEvens_OddUpperBound() {
        Assert.assertEquals(3, LoopFunctions.countEvens(7));
    }
}
