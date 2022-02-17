package eric;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses("0279245587303");
        System.out.println(result);
    }
}
