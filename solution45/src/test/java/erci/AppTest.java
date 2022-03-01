package erci;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Solution s = new Solution();
        int result = s.jump(new int[]{2,3,1,1,4});
        System.out.println(result);
    }
}
