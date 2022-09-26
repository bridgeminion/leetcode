import java.util.ArrayList;
import java.util.List;

public class P6016 {

    public List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<>();
        int startCol = s.charAt(0)-'A';
        int startRow = s.charAt(1)-'0';
        int endCol = s.charAt(3)-'A';
        int endRow = s.charAt(4)-'0';
        for (int i=startCol; i <= endCol; i++){
            for (int j=startRow; j <= endRow; j++){
                StringBuilder cur = new StringBuilder();
                cur.append((char)(i+'A'));
                cur.append(j);
                ans.add(cur.toString());
            }
        }
        return ans;
    }
}

