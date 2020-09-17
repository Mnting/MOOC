package main.java.com.leetcode.Tree;

public class ConvertBSTtoGreaterTree538 {
    int temp = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root==null) {
            return null;
        }
        convertBST(root.right);
        root.val+=temp;
        temp = root.val;
        convertBST(root.left);
        return root;
    }
}
