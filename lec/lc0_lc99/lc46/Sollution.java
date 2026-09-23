//package lc0_lc99.lc46;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Sollution {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        int visited[] = new int[nums.length];
//
//        method1(new ArrayList<Integer>(), visited, nums, res);
//
//        return res;
//    }
//
//    private void method1(List<Integer> path, int[] visited, int[] nums, List<List<Integer>> res) {
//        if (path.size() == nums.length) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < visited.length; i++) {
//            if (visited[i] == 0) {
//                path.add(nums[i]);
//                visited[i] = 1;
//                method1(path, visited, nums, res);
//                path.remove(path.size()-1);
//                visited[i] = 0;
//            }
//
//        }
//    }
//
//
//}