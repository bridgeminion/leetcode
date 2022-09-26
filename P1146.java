import java.util.*;

public class P1146 {
//
//    public class State {
//        int time;
//        int val;
//
//        public State(int time, int val) {
//            this.time = time;
//            this.val = val;
//        }
//    }

    class SnapshotArray {
        int count = 0;
        Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        public SnapshotArray(int length) {
            for (int i=0; i < length; i++){
                map.put(i, new TreeMap<>());
                map.get(i).put(0, 0);
            }
        }

        public void set(int index, int val) {
            TreeMap<Integer, Integer> cur = map.get(index);
            cur.put(count, val);
        }

        public int snap() {
            count++;
            return count-1;
        }

        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> cur = map.get(index);
            return cur.get(cur.floorKey(snap_id));
        }
    }
}
