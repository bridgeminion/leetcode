public class P1216ValidPalindrome {

//    public boolean isPali (String s, int start, int end){
//        while (start < end){
//            if (s.charAt(start) != s.charAt(end)){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

    boolean[][] vis = new boolean[1005][1005];
    int[][] val = new int[1005][1005];

    public int calc (String s, int start, int end){
        if (start >= end){
            return 0;
        }
        if (vis[start][end]){
            return val[start][end];
        }
        vis[start][end] = true;
        if (s.charAt(start) == s.charAt(end)){
            val[start][end] = calc (s, start+1, end-1);
            return val[start][end];
        }
        val[start][end] = Math.min(calc(s, start+1, end), calc(s, start, end-1))+1;
        return val[start][end];
    }

    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        return calc (s, 0, n-1) <= k;
    }
}
