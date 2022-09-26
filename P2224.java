public class P2224 {

    public int conv (String time){
        int ans = 0;
        ans += 60*((time.charAt(0)-'0')*10+(time.charAt(1)-'0'));
        ans += (time.charAt(3)-'0')*10+(time.charAt(4)-'0');
        return ans;
    }

    public int convertTime(String current, String correct) {
        int dif = conv (correct) - conv (current);
        int ans = 0;
        ans += dif/60;
        dif = dif%60;
        ans += dif/15;
        dif = dif%15;
        ans += dif/5;
        dif = dif%5;
        ans += dif;
        return ans;
    }
}
