package eric;



import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
       
        Solution s = new Solution();
        List<List<Integer>> result = s.subsets(new int[]{1,2,3});
        System.out.println(result);
    }
}
