public class P777 {

    public boolean canTransform(String start, String end) {
        int n = start.length();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i=0; i < n; i++){
            if (start.charAt(i) != 'X'){
                s1.append(start.charAt(i));
            }
            if (end.charAt(i) != 'X'){
                s2.append(end.charAt(i));
            }
        }
        if (!s1.toString().equals(s2.toString())) return false;
        int i1 = 0;
        int i2 = 0;
        for (int i=0; i < s1.length(); i++){
            while (start.charAt(i1) == 'X'){
                i1++;
            }
            while (end.charAt(i2) == 'X'){
                i2++;
            }
            if (start.charAt(i1) == 'L'){
                if (i1 < i2) return false;
            }
            else {
                if (i1 > i2) return false;
            }
            i1++;
            i2++;
        }
        return true;
    }
}
