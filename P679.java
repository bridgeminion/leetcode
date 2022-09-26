//public class P679 {
//
//    // +, -, *, /
//
//    public boolean solve (int a, int b, int c, int d){
//        for (int e=0; e < 4; e++){
//            for (int f=0; f < 4; f++){
//                for (int g=0; g < 4; g++){
//                    int v1 = eval (a, b, c, d, e, f, g, 1, 2, 3);
//                    int v2 = eval (a, b, c, d, e, f, g, 1, 3, 2);
//                    int v3 = eval (a, b, c, d, e, f, g, 2, 1, 3);
//                    int v4 = eval (a, b, c, d, e, f, g, 2, 3, 1);
//                    int v5 = eval (a, b, c, d, e, f, g, 3, 1, 2);
//                    int v6 = eval (a, b, c, d, e, f, g, 3, 2, 1);
//                    if (v1 == 24 || v2 == 24 || v3 == 24 || v4 == 24 || v5 == 24 || v6 == 24) return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public static int eval (int a, int b, int c, int d, int e, int f, int g, int fi, int se, int th){
//
//    }
//
//    public boolean judgePoint24(int[] cards) {
//        for (int a=0; a < 4; a++){
//            for (int b=0; b != a && b < 4; b++){
//                for (int c=0; c != a && c != b && c < 4; c++){
//                    for (int d=0; d != a && d != b && d != c && d < 4; d++){
//                        if (solve (cards[a], cards[b], cards[c], cards[d])) return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}
