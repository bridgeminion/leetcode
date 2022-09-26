import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P6018 {

    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        Set<Integer> children = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i=0; i < n; i++){
            int par = descriptions[i][0];
            int chi = descriptions[i][1];
            boolean left = descriptions[i][2] == 1;
            children.add(chi);
            map.putIfAbsent(par, new TreeNode(par));
            map.putIfAbsent(chi, new TreeNode(chi));
            if (left){
                map.get(par).left = map.get(chi);
            }
            else {
                map.get(par).right = map.get(chi);
            }
            all.add(par);
            all.add(chi);
        }
        for (int i : all){
            if (!children.contains(i)){
                return map.get(i);
            }
        }
        return null;
    }
}
