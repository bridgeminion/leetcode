public class P2069 {

    class Robot {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int dir = 0;
        int xpos = 0;
        int ypos = 0;
        int w;
        int h;
        int cyc;

        public Robot(int width, int height) {
            w = width;
            h = height;
            cyc = 2*(w+h-2);
        }

        public void step(int num) {
            int cur;
            if (num == 0) return;
            if (dir == 0){ // E
                if (xpos == w-1) dir = 1;
                cur = Math.min(num, w-1-xpos);
                xpos += cur;
                num -= cur;
            }
            else if (dir == 1){ // N
                if (ypos == h-1) dir = 2;
                cur = Math.min(num, h-1-ypos);
                ypos += cur;
                num -= cur;
            }
            else if (dir == 2){ // W
                if (xpos == 0) dir = 3;
                cur = Math.min(num, xpos);
                xpos -= cur;
                num -= cur;
            }
            else { // S
                if (ypos == 0) dir = 0;
                cur = Math.min(num, ypos);
                ypos -= cur;
                num -= cur;
            }
            if (num > 0){
                num %= cyc;
                if (num == 0){
                    if (xpos == 0 && ypos == 0){
                        dir = 3;
                    }
                    else if (xpos == w-1 && ypos == 0){
                        dir = 0;
                    }
                    else if (xpos == w-1 && ypos == h-1){
                        dir = 1;
                    }
                    else {
                        dir = 2;
                    }
                }
                while (num > 0){
                    if (dir == 0){ // E
                        if (xpos == w-1) dir = 1;
                        cur = Math.min(num, w-1-xpos);
                        xpos += cur;
                        num -= cur;
                    }
                    else if (dir == 1){ // N
                        if (ypos == h-1) dir = 2;
                        cur = Math.min(num, h-1-ypos);
                        ypos += cur;
                        num -= cur;
                    }
                    else if (dir == 2){ // W
                        if (xpos == 0) dir = 3;
                        cur = Math.min(num, xpos);
                        xpos -= cur;
                        num -= cur;
                    }
                    else { // S
                        if (ypos == 0) dir = 0;
                        cur = Math.min(num, ypos);
                        ypos -= cur;
                        num -= cur;
                    }
                }
            }
            System.out.println(xpos + " " + ypos);
        }

        public int[] getPos() {
            return new int[] {xpos, ypos};
        }

        public String getDir() {
            if (dir == 0) return "East";
            if (dir == 1) return "North";
            if (dir == 2) return "West";
            return "South";
        }
    }
}
