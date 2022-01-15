public class P2124 {

    public boolean checkString(String s) {
        boolean bf = false;
        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == 'a' && bf){
                return false;
            }
            if (s.charAt(i) == 'b'){
                bf = true;
            }
        }
        return true;
    }
}
