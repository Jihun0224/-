package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {
	static int[]height=new int[9];
	static int[]cur=new int[7];
	public static void search(int depth,boolean[] visited) {
		if(depth==7) {
			int sum=0;
			for(int n:cur) {
				sum+=n;
			}
			if(sum==100) {
				Arrays.sort(cur);
				for(int n:cur) {
					System.out.println(n);
				}
				System.exit(0);
			}
			return;
		}
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				cur[depth]=height[i];
				search(depth+1,visited);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			height[i]=Integer.parseInt(br.readLine());
		}
		search(0,new boolean[9]);
	}
}
