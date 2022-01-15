import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class P437 {

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

    public int solve (TreeNode cur, long val, long targetSum){
        int ans = 0;
        if (val + cur.val == targetSum){
            ans++;
        }
        if (cur.left != null){
            ans += solve (cur.left, val + cur.val, targetSum);
        }
        if (cur.right != null){
            ans += solve (cur.right, val + cur.val, targetSum);
        }
        return ans;
    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        int ans = solve (root, 0, targetSum);
        if (root.left != null){
            ans += pathSum (root.left, targetSum);
        }
        if (root.right != null){
            ans += pathSum (root.right, targetSum);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P437 test = new P437();
        TreeNode t9 = new TreeNode(1, null, null);
        TreeNode t8 = new TreeNode(-2, null, null);
        TreeNode t7 = new TreeNode(3, null, null);
        TreeNode t6 = new TreeNode(11, null, null);
        TreeNode t5 = new TreeNode(2, t9, null);
        TreeNode t4 = new TreeNode(3, t7, t8);
        TreeNode t3 = new TreeNode(-3, t6, null);
        TreeNode t2 = new TreeNode(5, t4, t5);
        TreeNode t1 = new TreeNode(10, t2, t3);
        System.out.println(test.pathSum(t1, 8));
        System.out.println();
        System.out.println();
    }

//    public int solve (TreeNode cur, Map<Long, Integer> count, long targetSum){
//        int ans = 0;
//        if (count.containsKey(targetSum-cur.val)){
//            ans += count.get(targetSum-cur.val);
//        }
//        Map<Long, Integer> next = new HashMap<>();
//        next.put(0L, 1);
//        for (Long i : count.keySet()){
//            next.putIfAbsent(i+cur.val, 0);
//            next.put(i+cur.val, next.get(i+cur.val)+1);
//        }
//        if (cur.left != null){
//            ans += solve (cur.left, next, targetSum);
//        }
//        if (cur.right != null){
//            ans += solve (cur.right, next, targetSum);
//        }
//        return ans;
//    }
//
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null){
//            return 0;
//        }
//        Map<Long, Integer> count = new HashMap<>();
//        count.put(0L, 1);
//        return solve (root, count, targetSum);
//    }
}
