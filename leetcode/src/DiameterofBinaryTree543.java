import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Enumeration;

/**
 * @Author Tianhao Tao
 * @Date 2020/8/28 15:37
 * @Version 1.0
 */
public class DiameterofBinaryTree543 {
    int len = 0;
    public int diameterOfBinaryTree(TreeNode node) {
        length(node);
        return len;
    }

    public int length(TreeNode node){
        if(node==null){return 0;}
        int l = length(node.left);
        int r = length(node.right);
        len = Math.max(len, l+r);
        return Math.max(l, r)+1;
    }
}
