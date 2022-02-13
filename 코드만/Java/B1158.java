package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); 
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i=1;i<=n;i++) {
			queue.offer(i);
		}		
		sb.append("<");
		while(!queue.isEmpty()) {
			//k번째 수를 뽑기 위해 k-1만큼 넣었다 뺏다 반복
			for (int i=1;i<k;i++) {
				queue.offer(queue.poll());
			}
			//k번째 수 append
			sb.append(queue.poll()).append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.print(sb.toString());
	}
}
