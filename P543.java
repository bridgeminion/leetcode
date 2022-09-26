public class P543 {

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

    public int len (TreeNode root){
        int more = 0;
        if (root.left != null){
            more = Math.max(more, len (root.left));
        }
        if (root.right != null){
            more = Math.max(more, len (root.right));
        }
        return 1+more;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int len = 0;
        int ans = 0;
        if (root.left != null){
            len += len(root.left);
            ans = Math.max(ans, diameterOfBinaryTree(root.left));
        }
        if (root.right != null){
            len += len(root.right);
            ans = Math.max(ans, diameterOfBinaryTree(root.right));
        }
        ans = Math.max(ans, len);
        return ans;
    }
}
