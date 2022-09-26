import java.util.*;

public class P2218 {

    public class State {
        int numPiles;
        int numCoins;

        public State(int numPiles, int numCoins) {
            this.numPiles = numPiles;
            this.numCoins = numCoins;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return numPiles == state.numPiles && numCoins == state.numCoins;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numPiles, numCoins);
        }
    }

    public int dp (int numPiles, int numCoins, List<List<Integer>> prefix, Map<State, Integer> val){
        if (numPiles < 0 || numCoins <= 0) return 0;
        State cur = new State (numPiles, numCoins);
        if (val.containsKey(cur)) return val.get(cur);
        int ans = 0;
        for (int i=0; i <= Math.min(numCoins, prefix.get(numPiles).size()-1); i++){
            ans = Math.max(ans, dp (numPiles-1, numCoins-i, prefix, val)+prefix.get(numPiles).get(i));
        }
        val.put(cur, ans);
        return ans;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        Map<State, Integer> val = new HashMap<>();
        List<List<Integer>> prefix = new ArrayList<>();
        for (List<Integer> pile : piles) {
            List<Integer> sums = new ArrayList<>(pile.size() + 1);
            sums.add(0);
            for (int j = 0; j < pile.size(); j++) {
                sums.add(sums.get(j) + pile.get(j));
            }
            prefix.add(sums);
        }
        return dp (n-1, k, prefix, val);
    }
}
