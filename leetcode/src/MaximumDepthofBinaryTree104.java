/**
 * @Author Tianhao Tao
 * @Date 2020/8/28 16:48
 * @Version 1.0
 */
public class MaximumDepthofBinaryTree104 {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    public int depth(TreeNode treeNode){
        if (treeNode==null){return 0;}
        int l = depth(treeNode.left);
        int r = depth(treeNode.right);
        return Math.max(l,r)+1;
    }
}
