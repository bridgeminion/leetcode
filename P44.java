import java.io.*;

public class P44 {

    public boolean solve (int p1, int p2, String s, String p, int n, int m, boolean[][] vis, boolean[][] val){
        if (vis[p1][p2]){
            return val[p1][p2];
        }
        vis[p1][p2] = true;
        while (p1 < n && p2 < m && (s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '?')){
            p1++;
            p2++;
        }
        if (p1 == n && p2 == m){
            val[p1][p2] = true;
            return val[p1][p2];
        }
        if (p1 == n){
            val[p1][p2] = true;
            for (int i=p2; i < m; i++){
                if (p.charAt(i) != '*'){
                    val[p1][p2] = false;
                    break;
                }
            }
            return val[p1][p2];
        }
        if (p2 == m){
            val[p1][p2] = false;
            return val[p1][p2];
        }
        if (p.charAt(p2) != '*'){
            val[p1][p2] = false;
            return val[p1][p2];
        }
        val[p1][p2] = false;
        for (int i=p1; i <= n; i++){
            val[p1][p2] = val[p1][p2] || solve (i, p2+1, s, p, n, m, vis, val);
        }
        return val[p1][p2];
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return solve (0, 0, s, p, n, m, new boolean[n+1][m+1], new boolean[n+1][m+1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        P44 test = new P44();
        System.out.println(test.isMatch ("", "******"));
        System.out.println(test.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
    }
}
