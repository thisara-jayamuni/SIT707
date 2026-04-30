package sit707_week6;

public class LoopFunctions {
	 
    /**
     * Part B (a): Conditional loop with SIMPLE statements.
     *
     * Sums all integers from 1 up to n (inclusive).
     * The loop is the conditional element – it may execute 0 or more times.
     *
     * @param n upper bound (if <= 0 the loop body never runs → returns 0)
     * @return sum of 1 + 2 + … + n
     */
    public static int sumUpTo(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {         // <-- conditional loop
            sum += i;            //     simple statement in body
            i++;
        }
        return sum;
    }
 
    /**
     * Part B (b): Conditional loop WITH a conditional statement inside.
     *
     * Counts how many integers between 1 and n (inclusive) are even.
     * The outer while loop is the conditional loop; the if-statement
     * inside it is the inner conditional.
     *
     * @param n upper bound (if <= 0 the loop body never runs → returns 0)
     * @return count of even numbers in [1 … n]
     */
    public static int countEvens(int n) {
        int count = 0;
        int i = 1;
        while (i <= n) {              // <-- conditional loop
            if (i % 2 == 0) {        //     conditional statement in body
                count++;
            }
            i++;
        }
        return count;
    }
}
