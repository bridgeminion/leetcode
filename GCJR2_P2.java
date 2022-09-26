import java.io.*;

public class GCJR2_P2 {

    public static void right (boolean[][] grid, int r){
        for (int i=0; i <= r; i++){
            for (int j=0; j <= r; j++){
                if (i*i+j*j <= (r+0.5)*(r+0.5)){
                    grid[i][j] = true;
                    grid[j][i] = true;
                }
            }
        }
    }

    public static void perimeter (boolean[][] grid, int r){
        for (int i=0; i <= r; i++){
            int j = (int)Math.round(Math.sqrt(r*r-i*i));
            grid[i][j] = true;
            grid[j][i] = true;
        }
    }

    public static void wrong (boolean[][] grid, int r){
        for (int i=0; i <= r; i++){
            perimeter(grid, i);
        }
    }

    public static void solve (int r){
        boolean[][] grid1 = new boolean[r+1][r+1];
        right (grid1, r);
        boolean[][] grid2 = new boolean[r+1][r+1];
        wrong (grid2, r);
        int ans = 0;
        for (int i=0; i <= r; i++){
            for (int j=0; j <= r; j++){
                if (grid1[i][j] != grid2[i][j]){
                    ans++;
                }
            }
        }
        System.out.println(ans*4);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            int R = Integer.parseInt(br.readLine());
            System.out.print("Case #" + i + ": ");
            solve (R);

        }
    }
}
