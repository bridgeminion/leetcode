import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P2096 {

    public boolean done = false;
    public String ret;

    public void gen (TreeNode root, StringBuilder s, int endValue){
        if (done) {
            return;
        }
        if (root.val == endValue){
            done = true;
            ret = s.toString();
            return;
        }
        if (root.left != null){
            gen (root.left, s.append('L'), endValue);
            s.deleteCharAt(s.length()-1);
        }
        if (root.right != null){
            gen (root.right, s.append('R'), endValue);
            s.deleteCharAt(s.length()-1);
        }
    }


    public String getDirections(TreeNode root, int startValue, int destValue) {
        done = false;
        gen (root, new StringBuilder(), startValue);
        String s1 = ret;
        done = false;
        gen (root, new StringBuilder(), destValue);
        String s2 = ret;
        int index = 0;
        while (index < s1.length() && index < s2.length() && s1.charAt(index)==s2.charAt(index)){
            index++;
        }
        s1 = s1.substring(index);
        s2 = s2.substring(index);
        StringBuilder ans = new StringBuilder();
        for (int i=0; i < s1.length(); i++){
            ans.append("U");
        }
        ans.append(s2);
        return ans.toString();
    }

    public static void main(String[] args) throws IOException {
        P2096 test = new P2096();
        TreeNode n1 = new TreeNode (3);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode (1, n1, null);
        TreeNode n5 = new TreeNode(2, n2, n3);
        TreeNode n6 = new TreeNode(5, n4, n5);
        System.out.println(test.getDirections(n6, 3, 6));
    }
}
