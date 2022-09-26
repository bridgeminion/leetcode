import java.io.*;
import java.util.StringTokenizer;

public class GCJ_PunchedCards {

    public static void solve (int a, int b){
        for (int i=0; i <= 2*a; i++){
            for (int j=0; j <= 2*b; j++){
                if (i+j < 2){
                    System.out.print(".");
                }
                else {
                    if (i%2 == 0){
                        if (j%2 == 0){
                            System.out.print("+");
                        }
                        else {
                            System.out.print("-");
                        }
                    }
                    else {
                        if (j%2 == 0){
                            System.out.print("|");
                        }
                        else  {
                            System.out.print(".");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println("Case #" + i + ":");
            solve (a, b);
        }
    }
}
