import java.io.IOException;
import java.util.HashMap;

public class P5995 {

    int[] pow = new int[30000];

    public int val (char c){
        return c-'a'+1;
    }

    public int hash (String s, int p, int m){
        long ans = 0;
        long pow = 1;
        for (int i=0; i < s.length(); i++){
            ans += val(s.charAt(i))*pow;
            ans %= m;
            pow *= p;
            pow %= m;
        }
        return (int)ans;
    }

    public int MM (long x, int modulo){
        x %= modulo;
        if (x < 0){
            x += modulo;
        }
        return (int)x;
    }

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long res = 1;
        pow[0] = 1;
        for (int i=1; i <= k; i++){
            res *= power;
            res %= modulo;
            pow[i] = (int)res;
        }
        String ans = "";
        long x = hash (s.substring(s.length()-k), power, modulo);
        if (x == hashValue){
            ans = s.substring(s.length()-k);
        }
        for (int i=0; i < s.length()-k; i++){
            long next = MM((x- (long)pow[k-1]*val(s.charAt(s.length()-1-i))), modulo);
            next *= power;
            next = MM(next, modulo);
            next += val (s.charAt(s.length()-k-i-1));
            next = MM(next, modulo);
            if (next == hashValue){
                ans = s.substring(s.length()-k-i-1, s.length()-i-1);
            }
            x = next;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P5995 test = new P5995();
        String s = "leetcode";
        int pow = 7;
        int mod = 20;
        int k = 2;
        int hashValue = 0;
        String s2 = "xqgfatvtlwnnkxipmipcpqwbxihxblaplpfckvxtihonijhtezdnkjmmk";
        int p2 = 22;
        int m2 = 51;
        int k2 = 41;
        int h2 = 9;
        String s3 = "fbxzaad";
        int p3 = 31;
        int m3 = 100;
        int k3 = 3;
        int h3 = 32;
        System.out.println(test.subStrHash(s3, p3, m3, k3, h3));
        System.out.println(test.subStrHash(s2, p2, m2, k2, h2));
    }
}
