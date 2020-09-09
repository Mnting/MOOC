package main.java.com.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TianHao Tao
 */
public class SymmetricTree101 {
    private List<Integer> list = new ArrayList();

    public boolean isSymmetric(TreeNode root) {
        addList(root);
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    TreeNode addList(TreeNode root) {
        if (root == null) {
            list.add(null);
            return null;
        }
        addList(root.left);
        list.add(root.val);
        addList(root.right);
        return root;
    }
}
