package problems.warm.up.exercises.I;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralOrderTraverseITest {

    @Test
    public void test_one() {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(9);
        expected.add(8);
        expected.add(7);
        expected.add(4);
        expected.add(5);

        SpiralOrderTraverseI st = new SpiralOrderTraverseI();
        List<Integer> result = st.spiral(matrix);
        assertEquals(expected, result);

    }

}