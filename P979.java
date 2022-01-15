import java.io.IOException;

public class P979 {

    public static class TreeNode {
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

    public static int distributeCoins(TreeNode root) {
        int ans = 0;
        ans += Math.abs(solve (root));
        if (root.left != null){
            ans += distributeCoins (root.left);
        }
        if (root.right != null){
            ans += distributeCoins (root.right);
        }
        return ans;
    }

    public static int solve (TreeNode cur){
        if (cur.left == null && cur.right == null){
            return cur.val-1;
        }
        int ans = cur.val-1;
        if (cur.left != null){
            ans += solve (cur.left);
        }
        if (cur.right != null){
            ans += solve (cur.right);
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        TreeNode t4 = new TreeNode (3, null, null);
        TreeNode t3 = new TreeNode (0, null, null);
        TreeNode t2 = new TreeNode (0, null, t4);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(solve (t1));
        System.out.println(solve (t2));
        System.out.println(solve (t3));
        System.out.println(solve (t4));
        System.out.println(distributeCoins(t1));
    }
}
