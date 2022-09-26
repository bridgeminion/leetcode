public class P2177 {

    public long[] sumOfThree(long num) {
        long[] emp = new long[0];
        if (num%3 != 0) return emp;
        long mid = num/3;
        long[] ans = {mid-1, mid, mid+1};
        return ans;
    }
}
