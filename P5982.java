public class P5982 {

    boolean[] vis = new boolean[100005];
    long[] val = new long[100005];

    public long solve (int cur, int[][] questions, int n){
        if (cur >= n){
            return 0;
        }
        if (vis[cur]){
            return val[cur];
        }
        vis[cur] = true;
        val[cur] = Math.max(questions[cur][0]+solve (cur+questions[cur][1]+1, questions, n), solve (cur+1, questions, n));
        return val[cur];
    }

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        return solve (0, questions, n);
    }
}
