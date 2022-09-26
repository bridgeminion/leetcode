public class P5980 {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] ans = new String[(n+k-1)/k];
        for (int i=0; i < n/k; i++){
            ans[i] = s.substring(i*k, (i+1)*k);
        }
        if (n%k != 0){
            StringBuilder temp = new StringBuilder();
            temp.append(s.substring((n/k)*k));
            for (int i=0; i < k-(n%k); i++){
                temp.append(fill);
            }
            ans[n/k] = temp.toString();
        }
        return ans;
    }
}
