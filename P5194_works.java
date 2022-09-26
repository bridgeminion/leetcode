public class P5194_works {

    public int solve (int cur, int left){
        if (cur == 1){
            return 0;
        }
        if (left == 0){
            return cur-1;
        }
        if (cur%2 == 0){
            return 1+solve (cur/2, left-1);
        }
        else {
            return 2+solve (cur/2, left-1);
        }
    }

    public int minMoves(int target, int maxDoubles) {
        return solve (target, maxDoubles);
    }
}
