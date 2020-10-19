import java.util.List;
import java.util.Stack;
import java.util.LinkedList;

//后序遍历

public class No145 {
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
        
    }

    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            TreeNode itr = root, vis = null;
            Stack<TreeNode> t = new Stack<>();
            while(!t.empty() || itr != null){
                if(itr != null){
                    t.add(itr);
                    itr = itr.left;
                }
                else{
                    TreeNode peek = t.peek();
                    if(peek.right != null && peek.right != vis)
                        itr = peek.right;
                    else{
                        res.add(peek.val);
                        vis = t.pop();
                    }
                }
            }
            return res;
        }
    }


    static class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            dp(root, res);
            return res;
        }
        private void dp(TreeNode root, List<Integer> res){
            if(root.left == null && root.right == null){
                res.add(root.val);
                return;
            }
            if(root.left != null){
                dp(root.left, res);
            }
            if(root.right != null){
                dp(root.right, res);
            }
            res.add(root.val);
        }

    }
}
