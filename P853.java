import java.util.*;

public class P853 {

    public class Car {
         int pos;
         int speed;

        public Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> list = new ArrayList<>();
        for (int i=0; i < n; i++) {
            list.add(new Car (position[i], speed[i]));
        }
        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.pos-o2.pos;
            }
        });
        double[] time = new double[n];
        for (int i=0; i < n; i++){
            Car cur = list.get(i);
            time[i] = ((double)target-cur.pos)/cur.speed;
        }
        Stack<Double> stack = new Stack<>();
        for (int i=0; i < n; i++){
            while (!stack.isEmpty() && stack.peek() <= time[i]){
                stack.pop();
            }
            stack.add(time[i]);
        }
        return stack.size();
    }
}
