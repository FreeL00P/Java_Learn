import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/19 14:17    since 1.0.0
 */
public class test {
     List<List<Integer>> res= new ArrayList<List<Integer>>();

    public static void main(String[] args) {

    }
    public void helper(TreeNode node,int level){
        if(res.size()==level){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        if(node.left!=null){
            helper(node.left,level+1);
        }
        if(node.right!=null){
            helper(node.right,level+1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return res;
        helper(root,0);
        return res;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}