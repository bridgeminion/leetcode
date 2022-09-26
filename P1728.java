//public class P1728 {
//
//    int[] dr = {-1, 0, 1, 0};
//    int[] dc = {0, -1, 0, 1};
//
//    public boolean solve (int turn, int cr, int cc, int mr, int mc, int fr, int fc, int cj, int mj, int m, int n, boolean[][] grid){
//        if (cr == mr && cc == mc) return false;
//        if (cr == fr && cc == fc) return false;
//        if (mr == fr && mc == fc) return true;
//        if (turn == 0){ // defined as cat's turn
//            boolean works = true;
//            for (int i=0; i < cj; i++){
//                if (works){
//                    for (int j=0; j < 4; j++){
//                        int ncr = cr + dr[j]*i;
//                        int ncc = cc + dc[j]*i;
//                        if (ncr >= 0 && ncr < m && ncc >= 0 && ncc < n){
//                            if (grid[ncr][ncc]){
//                                works = false;
//                                break;
//                            }
//                            if (solve (1, ncr, ncc, mr, mc, fr, fc, cj, mj, m, n, grid)){
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//            return false;
//        }
//        else { // mouse's turn
//            for (int i=0; i < mj; i++){
//                for (int j=0; j < 4; j++){
//                    int nmr = mr + dr[j]*i;
//                    int nmc = mc + dc[j]*i;
//                }
//            }
//        }
//    }
//
//    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
//        int m = grid.length;
//        int n = grid[0].length();
//        boolean[][] block = new boolean[m][n];
//        int cr, cc, mr, mc, fr, fc;
//        for (int i=0; i < m; i++){
//            for (int j=0; j < n; j++){
//                char c = grid[i].charAt(j);
//                if (c == 'C'){
//                    cr = i;
//                    cc = j;
//                }
//                else if (c == 'M'){
//                    mr = i;
//                    mc = j;
//                }
//                else if (c == 'F'){
//                    fr = i;
//                    fc = j;
//                }
//                else if (c == '#'){
//                    block[i][j] = true;
//                }
//            }
//        }
//
//    }
//}
