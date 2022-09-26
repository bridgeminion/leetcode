import java.util.*;

public class P1834 {

    public class Task {
        int start;
        int pt;
        int index;

        public Task(int start, int pt, int index) {
            this.start = start;
            this.pt = pt;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.pt == o2.pt) return o1.index-o2.index;
                return o1.pt-o2.pt;
            }
        });
        List<Task> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            list.add(new Task (tasks[i][0], tasks[i][1], i));
        }
        Collections.sort(list, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.start == o2.start) return o1.index-o2.index;
                return o1.start-o2.start;
            }
        });
        int pointer = 0;
        int ai = 0;
        int time = 0;
        int[] ans = new int[n];
        while (pointer < n){
            pq.add(list.get(pointer));
            time = Math.max(time, list.get(pointer).start);
            pointer++;
            while (pointer < n && list.get(pointer).start <= time){
                pq.add(list.get(pointer));
                pointer++;
            }
            while (!pq.isEmpty()){
                Task cur = pq.poll();
                ans[ai] = cur.index;
                ai++;
                time += cur.pt;
                while (pointer < n && list.get(pointer).start <= time){
                    pq.add(list.get(pointer));
                    pointer++;
                }
            }
        }
        return ans;
    }
}
