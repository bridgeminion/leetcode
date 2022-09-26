import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Verify {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        Set<Long> set = new HashSet<>();
        while (st.hasMoreTokens()){
            long cur = Long.parseLong(st.nextToken());
            sum += cur;
            if (set.contains(cur) || cur > 1000000000){
                System.out.println("FAIL");
                return;
            }
            set.add(cur);
        }
        System.out.println(sum);
    }
}
