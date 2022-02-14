package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//백준 3040. 백설 공주와 일곱 난쟁이
public class B3040 {
	static int[]nums=new int[9];
	static int[]cur=new int[7];
	public static void search(int depth,boolean[] visited) {
		if(depth==7) {
			int sum=0;
			for(int n:cur) {
				sum+=n;
			}
			if(sum==100) {
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
				cur[depth]=nums[i];
				search(depth+1,visited);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			nums[i]=Integer.parseInt(br.readLine());
		}
		search(0,new boolean[9]);
	}
}
