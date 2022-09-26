import java.io.*;

public class QR2 {

    public static void solve (String s){
        int n = s.length();
        for (int i=0; i < n; i++){
            if (s.charAt(i) == 'E') System.out.print('S');
            if (s.charAt(i) == 'S') System.out.print('E');
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            br.readLine();
            String s = br.readLine();
            System.out.print("Case #" + i + ": ");
            solve (s);
        }
    }
}
