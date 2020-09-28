package main.java.com.leetcode.Tree;

import java.util.*;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/27 10:16
 * @Version 1.0
 */
public class BoundaryofBinaryTree545 {
    Set<TreeNode> temp = new HashSet<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        Set<TreeNode> res = new HashSet<>();
        return null;
    }

    public void leftBoundary(TreeNode root) {
        if (root != null) {
            temp.add(root);
            leftBoundary(root.left);
        }

    }

    public void rightBoundary(TreeNode root) {
        if (root != null) {
            temp.add(root);
            leftBoundary(root.right);
        }
    }

    public void findLeaf(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null||!stack.isEmpty()){

        }
    }
}
