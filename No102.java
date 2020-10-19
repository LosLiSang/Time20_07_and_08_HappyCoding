import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
//层序遍历

public class No102 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        new Solution().levelOrder(root);
    }

    //BFS  广度优先搜素
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null) return res;
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while(!nodes.isEmpty()){
                res.add(new LinkedList<>());
                for(int len = nodes.size(); len > 0; len--){
                    TreeNode t = nodes.poll();
                    res.get(res.size()-1).add(t.val);
                    if(t.left != null)
                        nodes.add(t.left);
                    if(t.right != null)
                        nodes.add(t.right);
                }
            }
            return res;
        }
    }

    //递归实现
    static class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null) return res;
            res.add(new LinkedList<>());
            dp(root, 1, res);
            return res;
        }
    
        private void dp(TreeNode root, int degree, List<List<Integer>> res){
            if(root.left == null && root.right == null){
                res.get(degree-1).add(root.val);
                return;
            }
            if(res.size() == degree) res.add(new LinkedList<Integer>());
            if(root.left != null){
                dp(root.left, degree+1, res);
            }
            res.get(degree-1).add(root.val);
            if(root.right != null){
                dp(root.right, degree+1, res);
            }
        }
    }
}
