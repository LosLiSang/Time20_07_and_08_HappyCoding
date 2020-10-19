import java.util.ArrayList;
import java.util.List;

public class No257 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(5);

        System.out.println(new Solution().binaryTreePaths(root));    
    }

    static class Solution{
        public List<String> binaryTreePaths(TreeNode root){
            List<String> res = new ArrayList<>();
            
            
            return res;
        }
    }

    //递归法
    static class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if(root == null) return res;
            String temp = ""+root.val;
            if(root.left!= null)
                dp(root.left, res, temp);
            if(root.right != null)
                dp(root.right, res, temp);
            return res;
        }
        private void dp(TreeNode root, List<String> res, String temp){
            if(root.left == null && root.right == null){
                res.add(new String(temp+"->"+root.val));
                return;
            }
            if(root.left != null)
                dp(root.left, res, temp+"->"+root.val);
            if(root.right != null)
                dp(root.right, res, temp+"->"+root.val);
            
        }
    }
}
