package eric;

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
        int result =s.findContentChildren(new int[]{1,2,3}, new int[]{1,1});
        System.out.println(result);
    }
}
