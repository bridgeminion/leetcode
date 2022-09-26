
public class P2209 {

    public int dp (int pos, int numCarpets, int carpetLen, boolean[] white, boolean[][] vis, int[][] val){
        if (pos >= white.length) return 0;
        int rem = white.length-pos;
        if (numCarpets*carpetLen > rem) return 0;
        if (vis[pos][numCarpets]){
            return val[pos][numCarpets];
        }
        vis[pos][numCarpets] = true;
        if (white[pos]){
            val[pos][numCarpets] = dp (pos+1, numCarpets, carpetLen, white, vis, val)+1;
            if (numCarpets > 0){
                val[pos][numCarpets] = Math.min(val[pos][numCarpets], dp (pos+carpetLen, numCarpets-1, carpetLen, white, vis, val));
            }
        }
        else {
            int nw = pos+1;
            while (nw < white.length && !white[nw]){
                nw++;
            }
            if (nw >= white.length) return 0;
            val[pos][numCarpets] = dp (nw, numCarpets, carpetLen, white, vis, val);
        }
        return val[pos][numCarpets];
    }

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        if (numCarpets*carpetLen >= n) return 0;
            boolean[] white = new boolean[n];
        for (int i=0; i < n; i++){
            white[i] = floor.charAt(i) == '1';
        }
        boolean[][] vis = new boolean[n][numCarpets+1];
        int[][] val = new int[n][numCarpets+1];
        return dp (0, numCarpets, carpetLen, white, vis, val);
    }
}
