package problems.crosstraining.I.array.tree.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetKeysInBinaryTreeLayerByLayerZigZagOrderTest {
    @Test
    public void test_tree(){
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(11);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(3);
        expected.add(8);
        expected.add(11);
        expected.add(4);
        expected.add(1);


        GetKeysInBinaryTreeLayerByLayerZigZagOrder gk = new GetKeysInBinaryTreeLayerByLayerZigZagOrder();
        List<Integer> actual =  gk.zigZag(a);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}