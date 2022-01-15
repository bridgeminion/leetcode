import java.util.Arrays;

public class P2126 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long temp = mass;
        Arrays.sort(asteroids);
        for (int i : asteroids){
            if (temp >= i){
                temp += i;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
