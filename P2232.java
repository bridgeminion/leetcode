public class P2232 {

    public long calc (String s, int st, int en){
        long res = 0;
        for (int i=st; i < en; i++){
            res *= 10;
            res += s.charAt(i)-'0';
        }
        return res;
    }


    public long eval (String expression, int l, int r, int pi){
        long lv = 1;
        if (l > 0){
            lv = calc (expression, 0, l);
        }
        long rv = 1;
        if (r < expression.length()-1){
            rv = calc (expression, r+1, expression.length());
        }
        long mid = calc (expression, l, pi) + calc (expression,pi+1, r+1);
        return lv*rv*mid;
    }

    public String minimizeResult(String expression) {
        int n = expression.length();
        int pi = -1;
        for (int i=0; i < n; i++){
            if (expression.charAt(i) == '+') pi = i;
        }
        long ans = Long.MAX_VALUE;
        int lans = -1;
        int rans = -1;
        for (int i=0; i < pi; i++){ // left of this index
            for (int j=pi+1; j < n; j++){ // right of this index
                long cur = eval (expression, i, j, pi);
                if (cur < ans){
                    ans = cur;
                    lans = i;
                    rans = j;
                }
            }
        }
        System.out.println(lans + " " + rans);
        System.out.println(ans);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < expression.length(); i++){
            if (i == lans){
                sb.append('(');
            }
            sb.append(expression.charAt(i));
            if (i == rans){
                sb.append(')');
            }
        }
        return sb.toString();
    }
}
