package main.java.com.leetcode.Tree;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/28 11:17
 * @Version 1.0
 */
public class LowestCommonAncestorofaBinarySearchTree235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val<root.val)&&(q.val<root.val)){
            root = root.left;
            return lowestCommonAncestor(root, p, q);
        }else if ((p.val>root.val)&&(q.val>root.val)){
            root = root.right;
            return lowestCommonAncestor(root, p, q);
        }
        return root;
    }
}
