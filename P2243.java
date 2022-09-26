import java.util.ArrayList;
import java.util.List;

public class P2243 {

    public String digitSum(String s, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < s.length(); i++){
            list.add(s.charAt(i)-'0');
        }
        while (list.size() > k){
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i <= list.size()/k; i++){
                if (i*k == list.size()) continue;
                List<Integer> reversed = new ArrayList<>();
                int sum = 0;
                for (int j=i*k; j < Math.min(i*k+k, list.size()); j++){
                    sum += list.get(j);
                }
//                System.out.println(sum);
                if (sum == 0) reversed.add(sum);
                while (sum > 0){
                    reversed.add(sum%10);
                    sum /= 10;
                }
                for (int j=reversed.size()-1; j >= 0; j--){
                    temp.add(reversed.get(j));
//                    System.out.println(reversed.get(j));
                }
//                System.out.println("Break");
            }
            list.clear();
            list.addAll(temp);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : list){
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        P2243 test = new P2243();
        System.out.println(test.digitSum("1234", 2));
    }
}
