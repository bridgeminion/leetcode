import java.io.*;

public class GCJR1B_P3 {

    public static void solve (int n, int step){
        if (n == 8) System.out.println("11111111");
        else if (n == 1) System.out.println("10000000");
        else if (n == 2) {
            if (step%2 == 0) System.out.println("10010000");
            else System.out.println("10001000");
        }
        else if (n == 3){
            System.out.println("10001011");
        }
        else if (n == 4){
            System.out.println("11000101");
        }
        else if (n == 5){
            System.out.println("01110100");
        }
        else if (n == 6){
            if (step%2 == 0) System.out.println("01101111");
            else System.out.println("01110111");
        }
        else if (n == 7) System.out.println("11111110");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            System.out.println("00000001");
            int n = Integer.parseInt(br.readLine());
            int step = 1;
            while (n > 0){
                solve (n, step);
                n = Integer.parseInt(br.readLine());
                step++;
            }
            if (n == -1) return;
        }
    }
}
