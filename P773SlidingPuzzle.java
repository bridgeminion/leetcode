import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P773SlidingPuzzle {

    public String swap0 (String or, int zi, int ni){
        StringBuilder ret = new StringBuilder();
        for (int i=0; i < 6; i++){
            if (i == ni){
                ret.append('0');
            }
            else if (i == zi){
                ret.append(or.charAt(ni));
            }
            else {
                ret.append(or.charAt(i));
            }
        }
        return ret.toString();
    }


    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int i=0; i < 2; i++){
            for (int j=0; j < 3; j++){
                start.append(board[i][j]);
            }
        }
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start.toString());
        vis.add(start.toString());
        int ans = 0;
        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i < size; i++){
                String cur = q.remove();
                System.out.println(ans + " " + cur);
                if (cur.equals(target)) return ans;
                int zi = -1;
                for (int j=0; j < 6; j++){
                    if (cur.charAt(j) == '0'){
                        zi = j;
                        break;
                    }
                }
                for (int j : dir[zi]){
                    String next = swap0 (cur, zi, j);
                    if (!vis.contains(next)){
                        q.add(next);
                        vis.add(next);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
