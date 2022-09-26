import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P2034 {

    class StockPrice {

        TreeMap<Integer, Integer> PAT = new TreeMap<>();
        TreeMap<Integer, Integer> count = new TreeMap<>();


        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            if (PAT.containsKey(timestamp)){
                int rem = PAT.get(timestamp);
                count.put(rem, count.get(rem)-1);
                if (count.get(rem) == 0){
                    count.remove(rem);
                }
            }
            PAT.put(timestamp, price);
            count.putIfAbsent(price, 0);
            count.put(price, count.get(price)+1);
        }

        public int current() {
            return PAT.get(PAT.lastKey());
        }

        public int maximum() {
            return count.lastKey();
        }

        public int minimum() {
            return count.firstKey();
        }
    }
}
