package main.java.com.leetcode.leetcode;

public class ConvertBSTtoGreaterTree538 {
    public TreeNode convertBST(TreeNode root) {
        if (root==null) {
            return null;
        }
        if ((root!=null)&&(root.right.val<root.val)){
            root.right.val+=root.val;
        }
        TreeNode node = convertBST(root.right);
        if (node!=null){
            int val = node.val;
            root.val+=val;
        }
        if (root.left!=null){
            root.left.val+=root.val;
        }
        convertBST(root.left);
        return root;
    }
}
