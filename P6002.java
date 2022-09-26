public class P6002 {

    class Bitset {

        int tot = 0;
        int len;
        boolean[] bits;
        boolean flipped = false;

        public Bitset(int size) {
            len = size;
            bits = new boolean[size];
        }

        public void fix(int idx) {
            if (!flipped){
                if (!bits[idx]){
                    tot++;
                }
                bits[idx] = true;
            }
            else {
                if (bits[idx]){
                    tot++;
                }
                bits[idx] = false;
            }
        }

        public void unfix(int idx) {
            if (!flipped){
                if (bits[idx]){
                    tot--;
                }
                bits[idx] = false;
            }
            else {
                if (!bits[idx]){
                    tot--;
                }
                bits[idx] = true;
            }
        }

        public void flip() {
            tot = len - tot;
            flipped = !flipped;
        }

        public boolean all() {
            return tot == len;
        }

        public boolean one() {
            return tot > 0;
        }

        public int count() {
            return tot;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < len; i++){
                if (flipped){
                    if (!bits[i]){
                        sb.append("1");
                    }
                    else {
                        sb.append("0");
                    }
                }
                else {
                    if (!bits[i]){
                        sb.append("0");
                    }
                    else {
                        sb.append("1");
                    }
                }
            }
            return sb.toString();
        }
    }

}
