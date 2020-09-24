package main.java.com.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/18 15:59
 * @Version 1.0
 */
public class BinaryTreeInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        if (root == null) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                root = root.left;
                stack.add(root);
            }
            list.add(root.val);
            stack.pollLast();
            while (root.right == null) {
                root = stack.pollLast();
                if (root == null) {
                    return list;
                }
                list.add(root.val);
            }
            root = root.right;
            stack.add(root);
        }
        return list;
    }
}
