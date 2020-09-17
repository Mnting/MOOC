package main.java.com.leetcode.Tree;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/17 16:25
 * @Version 1.0
 */
public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root==null) {
            return list;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            list.add(node.val);
            if (node.right!=null){
                stack.add(node.right);
            }
            if (node.left!=null){
                stack.add(node.left);
            }
        }
        return list;
    }
}
