public class P2217 {

    public long[] kthPalindrome(int[] queries, int intLength) {
        if (intLength%2 == 0){
            int nl = intLength/2;
            int index = 0;
            long[] ans = new long[queries.length];
            for (int i : queries){
                long max = (long) (9*Math.pow(10, nl-1));
                if (i > max){
                    ans[index] = -1;
                    index++;
                    continue;
                }
                i--;
                long cur = 0;
                for (int j=nl-1; j >= 0; j--){
                    long dig = ((i/((long)Math.pow(10, j)))%10);
                    if (j == nl-1){
                        dig++;
                    }
                    cur += dig*(Math.pow(10, j+nl) + Math.pow(10, nl-1-j));
                }
                ans[index] = cur;
                index++;
            }
            return ans;
        }
        else {
            int nl = (intLength+1)/2;
            int index = 0;
            long[] ans = new long[queries.length];
            for (int i : queries){
                long max = (long) (9*Math.pow(10, nl-1));
                if (i > max){
                    ans[index] = -1;
                    index++;
                    continue;
                }
                i--;
                long cur = 0;
                for (int j=nl-1; j >= 0; j--){
                    long dig = ((i/((long)Math.pow(10, j)))%10);
                    if (j == nl-1){
                        dig++;
                    }
                    System.out.println(i + " " + j + " " + dig);
                    cur += dig*(Math.pow(10, j+nl-1));
                    if (j!=0) cur += dig*Math.pow(10, nl-1-j);
                }
                ans[index] = cur;
                index++;
            }
            return ans;
        }
    }
}
