//public class P339 {
//
//    public int solve (List<NestedInteger> list, int dep){
//        int ans = 0;
//        for (NestedInteger i : list){
//            if (i.isInteger()){
//                ans += i.getInteger() * dep;
//            }
//            else {
//                ans += solve (i.getList(), dep+1);
//            }
//        }
//        return ans;
//    }
//    public int depthSum(List<NestedInteger> nestedList) {
//        return solve (nestedList, 1);
//    }
//
//}
