import java.io.*;

public class QR1 {

    public static void solve (int n){
        int a = 0;
        int b = 1;
        n--;
        int pow = 1;
        while (n > 0){
            if (n % 10 == 4){
                a += 3 * pow;
                b += pow;
            }
            else {
                a += (n % 10)*pow;
            }
            n /= 10;
            pow *= 10;
        }
        System.out.print(a + " " + b);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.print("Case #" + i + ": ");
            solve (n);
        }
    }
}
