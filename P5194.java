import java.io.IOException;
import java.util.*;

public class P5194 {

    public class State {
        long val;
        int used;

        public State(long val, int used) {
            this.val = val;
            this.used = used;
        }
    }

    public int minMoves(int target, int maxDoubles) {
        Map<Long, Integer> least = new HashMap<>();
        int ans = 0;
        least.put(1L, 0);
        Queue<State> q = new LinkedList<>();
        q.add(new State (1L, 0));
        while (!q.isEmpty()){
            int temp = q.size();
            for (int i=0; i < temp; i++){
                State cur = q.remove();
                if (cur.val == target){
                    return ans;
                }
                if (!least.containsKey(cur.val+1) || cur.used < least.get(cur.val+1)){
                    least.put(cur.val, cur.used);
                    q.add(new State (cur.val+1, cur.used));
                }
                if (cur.used < maxDoubles && (!least.containsKey(cur.val*2) || cur.used+1 < least.get(cur.val*2)) && cur.val*2 <= target){
                    least.put(cur.val*2, cur.used+1);
                    q.add(new State (cur.val*2, cur.used+1));
                }
            }
            ans++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        P5194 test = new P5194();
        System.out.println(test.minMoves(19, 2));
    }
}
