import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class QR3 {

    public static BigInteger gcd (BigInteger a, BigInteger b){
        if (a.equals(b) || b.equals(BigInteger.ZERO)) return a;
        if (a.compareTo(b) > 0){
            return gcd (a.mod(b), b);
        }
        return gcd (b, a);
    }

    public static void solve (List<BigInteger> list){
        int n = list.size();
        List<BigInteger> primes = new ArrayList<>();
        Map<Integer, BigInteger> ordered = new HashMap<>();
        Set<BigInteger> seen = new HashSet<>();
        int bp = 0;
        while (list.get(bp).equals(list.get(bp+1))){
            bp++;
        }
        BigInteger start = gcd (list.get(bp), list.get(bp+1));
        ordered.put(bp+1, start);
        primes.add(start);
        for (int i=bp; i >= 0; i--){
            BigInteger temp = list.get(i).divide(ordered.get(i+1));
            ordered.put(i, temp);
            primes.add(temp);
        }
        for (int i=bp+1; i < n; i++){
            BigInteger next = list.get(i).divide(ordered.get(i));
            primes.add(next);
            ordered.put(i+1, next);
        }
        Collections.sort(primes);
        Map<BigInteger, Character> map = new HashMap<>();
        int index = 0;
        for (BigInteger i : primes){
            if (!seen.contains(i)){
                seen.add(i);
                map.put(i, (char)('A'+index));
                index++;
            }
        }
        for (int i=0; i < n+1; i++){
            System.out.print(map.get(ordered.get(i)));
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            List<BigInteger> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < l; j++){
                list.add(new BigInteger (st.nextToken()));
            }
            System.out.print("Case #" + i + ": ");
            solve (list);
        }
    }
}
