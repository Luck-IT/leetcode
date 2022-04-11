package eric;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

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
        boolean result = s.wordBreak("leetcode",Arrays.asList("leet","code"));
        System.out.println(result);
        
    }
}
