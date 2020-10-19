import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//二叉树的前序遍历

public class No144 {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        System.out.println(new Solution().preorderTraversal(root));
    }


    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root){
            TreeNode itr = root;
            List<Integer> res = new LinkedList<>();
            Stack<TreeNode> t = new Stack<>();
            t.add(root);
            while(!t.empty()){
                itr = t.pop();
                res.add(itr.val);
                if(itr.right != null)
                    t.add(itr.right); 
                if(itr.left != null)
                    t.add(itr.left);
            }
            return res;
        }
    }
    //递归法
    static class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            dp(root ,res);
            return res;
        }
        private void dp(TreeNode root, List<Integer> res){
            if(root == null) return;
            res.add(root.val);
            dp(root.left, res);
            dp(root.right, res);
        }
    }
}
