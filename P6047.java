public class P6047 {

    public String removeDigit(String number, char digit) {
        int n = number.length();
        int bad = -1;
        for (int i=0; i < n; i++){
            if (number.charAt(i) == digit){
                if (i+1 < n){
                    if (number.charAt(i+1) > digit){
                        bad = i;
                        break;
                    }
                    else {
                        bad = i;
                    }
                }
                else {
                    bad = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++){
            if (i != bad) sb.append(number.charAt(i));
        }
        return sb.toString();
    }
}
