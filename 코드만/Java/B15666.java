package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B15666 {
    private static Set<String> answer = new HashSet<>();
    private static void dfs(int[] nums, int[] selected, int n, int m, int start, int k) {
        if(k==m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            if (!answer.contains(sb.toString())) {
                answer.add(sb.toString());
                System.out.println(sb);
            }
            return;
        }
        for (int i = start; i < n; i++) {
            selected[k] = nums[i];
            dfs(nums, selected, n, m, i, k + 1);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        dfs(nums, new int[n], n, m, 0, 0);
    }
}
