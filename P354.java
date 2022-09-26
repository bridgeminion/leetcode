import java.util.*;

public class P354 {

    public class Env {
        int w;
        int h;

        public Env(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        List<Env> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            list.add(new Env (envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(list, new Comparator<Env>() {
            @Override
            public int compare(Env o1, Env o2) {
                if (o1.w == o2.w){
                    return o2.h-o1.h;
                }
                return o1.w-o2.w;
            }
        });
        List<Integer> tails = new ArrayList<>();
        for (Env i : list){
            int index = Collections.binarySearch(tails, i.h);
            if (index < 0){
                index = -(index+1);
            }
            if (index >= tails.size()){
                tails.add(i.h);
            }
            else {
                tails.set(index, i.h);
            }
            System.out.println(index + " " + i.h);
        }
        return tails.size();
    }
}
