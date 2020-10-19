import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//二叉树的中序遍历

public class No094 {
    static public class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        System.out.println(new Solution().inorderTraversal(root));
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if(root == null) return res;
            TreeNode itr = root;
            Stack<TreeNode> t = new Stack<>();
            while(itr != null || !t.empty()){
                while(itr != null){
                    t.add(itr);
                    itr = itr.left;
                }
                itr = t.pop();
                res.add(itr.val);
                itr = itr.right;
            }
            return res;
        }
    }


    static class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            dp(root, res);
            return res;           
        }

        public void dp(TreeNode root, List<Integer> res){
            if(root.left == null && root.right == null){
                res.add(root.val);
                return;
            }
            if(root.left != null){
                dp(root.left, res);
            } 
            res.add(root.val);
            if(root.right != null){
                dp(root.right, res);
            }
        }
    }
}