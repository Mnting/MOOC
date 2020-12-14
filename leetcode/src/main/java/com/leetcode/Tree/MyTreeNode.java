package main.java.com.leetcode.Tree;

import main.java.com.leetcode.KthSmallestElementinaBST230.test;

import java.util.ArrayDeque;

/**
 * @author Tao Tianhao
 */
public class MyTreeNode {
    public int val;
    public MyTreeNode left;
    public MyTreeNode right;

    MyTreeNode(int x) {
        val = x;
    }

    public static MyTreeNode createTree(Integer[] arr) {
        // 使用队列来存储每一层的非空节点，下一层的数目要比上一层高
        ArrayDeque<MyTreeNode> pre = new ArrayDeque<>();
        MyTreeNode root = new MyTreeNode(arr[0]);
        pre.addLast(root);
        // 表示要遍历的下一个节点
        int index = 0;
        while (!pre.isEmpty()) {

            ArrayDeque<MyTreeNode> cur = new ArrayDeque<>();
            while (!pre.isEmpty()) {
                MyTreeNode node = pre.removeFirst();
                MyTreeNode left = null;
                MyTreeNode right = null;
                // 如果对应索引上的数组不为空的话就创建一个节点,进行判断的时候，
                // 要先索引看是否已经超过数组的长度，如果索引已经超过了数组的长度，那么剩下节点的左右子节点就都是空了
                // 这里index每次都会增加，实际上是不必要的，但是这样写比较简单
                if (++index < arr.length && arr[index] != null) {
                    left = new MyTreeNode(arr[index]);
                    cur.addLast(left);
                }
                if (++index < arr.length && arr[index] != null) {
                    right = new MyTreeNode(arr[index]);
                    cur.addLast(right);
                }
                node.left = left;
                node.right = right;
            }
            pre = cur;
        }


        return root;
    }


    private static void prePrinTree(MyTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        prePrinTree(node.left);
        prePrinTree(node.right);
    }

    public static void main(String[] args) {
        //Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        Integer[] arr = {5, 3, 6, 2, 4, null, null, 1};
        MyTreeNode tree = createTree(arr);
        System.out.println(test.kthSmallest(tree, 3));
        prePrinTree(tree);
    }
}
