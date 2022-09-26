public class P2207 {

    public long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();
        if (pattern.charAt(0) == pattern.charAt(1)){
            long count = 0;
            for (int i=0; i < n; i++){
                if (text.charAt(i) == pattern.charAt(0)) count++;
            }
            count++;
            long ans = count*(count-1);
            ans /= 2;
            return ans;
        }
        else {
            char a = pattern.charAt(0);
            char b = pattern.charAt(1);
            long ca = 0;
            long cb = 0;
            long ans = 0;
            for (int i=0; i < n; i++){
                if (text.charAt(i) == a){
                    ca++;
                }
                else if (text.charAt(i) == b){
                    ans += ca;
                    cb++;
                }
            }
            ans += Math.max(ca, cb);
            return ans;
        }
    }
}
