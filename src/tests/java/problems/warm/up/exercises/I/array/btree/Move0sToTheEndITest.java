package problems.warm.up.exercises.I.array.btree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Move0sToTheEndITest {

    @Test
    public void test_basic() {
        Move0sToTheEndI mv = new Move0sToTheEndI();
        int[] array = new int[]{1,0,3,0,1};
        mv.moveZero(array);

        int[] expected = new int[]{1,3,1,0,0};
        assertArrayEquals(expected, array);
    }

    @Test
    public void test_one() {
        Move0sToTheEndI mv = new Move0sToTheEndI();
        int[] array = new int[]{1};
        mv.moveZero(array);

        int[] expected = new int[]{1};
        assertArrayEquals(expected, array);
    }
}