import java.io.*;
import java.util.*;

public class GCJR1A_P2 {

    static List<Long> start = new ArrayList<>();
    static List<Long> pows = new ArrayList<>();
    static List<Long> bills = new ArrayList<>();
    static long[] pow = new long[35];
    static long getUnder;

    public static void print (){
        for (Long i : pows) start.add(i);
        for (Long i : bills) start.add(i);
        System.out.print(start.get(0));
        for (int i=1; i < 100; i++){
            System.out.print(" " + start.get(i));
        }
        System.out.println();
    }

    public static void solve (List<Long> list){
        long sum = 0;
        List<Long> all = new ArrayList<>();
        for (Long i : bills) all.add(i);
        for (Long i : list) all.add(i);
        Collections.sort(all);
        for (Long i : all){
            sum += i;
        }
        for (Long i : pows) sum += i;
        long target = sum/2;
//        System.out.println("target is " + target);
        List<Long> ans = new ArrayList<>();
        int index = 169;
        while (target > getUnder){
            target -= all.get(index);
            ans.add(all.get(index));
            index--;
        }
        for (int i=29; i >= 0; i--){
            if (pow[i] <= target){
                target -= pow[i];
                ans.add(pow[i]);
            }
        }
        System.out.print(ans.get(0));
        for (int i=1; i < ans.size(); i++){
            System.out.print(" " + ans.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        long val = 1;
        for (int i=0; i < 35; i++){
            pow[i] = val;
            val *= 2;
        }
        for (int i=0; i < 30; i++){
            pows.add(pow[i]);
        }
        getUnder = pow[30]-1;
        for (int i=0; i < 70; i++){
            bills.add(1000000000L-i);
        }
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            if (n == -1){
                System.out.println("FAIL");
                return;
            }
            print();
            List<Long> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < 100; j++){
                long temp = Long.parseLong(st.nextToken());
                if (temp == -1){
                    System.out.println("FAIL");
                    return;
                }
                list.add(temp);
            }
            solve (list);
        }
    }

}
