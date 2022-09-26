import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GCJR1A_P1 {

    public static void solve (String s) {
        int n = s.length();
        List<Character> list = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        int index = 0;
        while (index < n){
            char c = s.charAt(index);
            int len = 0;
            while (index < n && s.charAt(index) == c){
                index++;
                len++;
            }
            list.add(c);
            count.add(len);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < list.size(); i++){
            if (i < list.size()-1 && list.get(i) < list.get(i+1)){
                for (int j=0; j < count.get(i)*2; j++){
                    sb.append(list.get(i));
                }
            }
            else {
                for (int j=0; j < count.get(i); j++){
                    sb.append(list.get(i));
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            String s = br.readLine();
            System.out.print("Case #" + i + ": ");
            solve (s);
        }
    }
}
