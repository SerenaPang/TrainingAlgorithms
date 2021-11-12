package problems.recursionIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructBinaryTreeWithLevelorderAndInorder {
    public TreeNode reconstruct(int[] level, int[] in) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        List<Integer> levelList = new ArrayList<>();
        for (int j = 0; j < level.length; j++) {
            levelList.add(level[j]);
        }
        return helper(levelList, inMap);
    }

    public TreeNode helper(List<Integer> levelList, Map<Integer, Integer> inMap) {
        if (levelList.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(levelList.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < levelList.size(); i++) {
            if (inMap.get(levelList.get(i)) < inMap.get(root.key)) {
                left.add(levelList.get(i));
            } else {
                right.add(levelList.get(i));
            }
        }
        root.left = helper(left, inMap);
        root.right = helper(right, inMap);
        return root;
    }

}
