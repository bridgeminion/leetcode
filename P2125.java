public class P2125 {

    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int ans = 0;
        int last = 0;
        for (int i=0; i < m; i++){
            int cur = 0;
            for (int j=0; j < n; j++){
                if (bank[i].charAt(j) == '1'){
                    cur++;
                }
            }
            ans += cur*last;
            if (cur != 0){
                last = cur;
            }
        }
        return ans;
    }

}
