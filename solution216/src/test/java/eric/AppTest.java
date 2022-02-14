package eric;

import static org.junit.Assert.assertTrue;

import java.util.List;

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
       List<List<Integer>> result = s.combinationSum3(3, 7);
       System.out.println(result);
    }
}
