package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15649 {
	static int n,m;
	public static void search(int depth, boolean[] visited,int[]cur) {
		//m개를 선택했을 때 출력
		if(depth==m) {
			for(int i=0;i<m;i++) {
				if(i!=m-1)
					System.out.print(cur[i]+" ");
				else
					System.out.print(cur[i]);
			}
			System.out.println();
			return;
		}
		for(int i=1;i<n+1;i++) {
			if(!visited[i]) {
				visited[i]=true;
				cur[depth]=i;
				search(depth+1,visited,cur);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp=br.readLine().split(" ");
		n=Integer.parseInt(temp[0]);
		m=Integer.parseInt(temp[1]);
		search(0,new boolean[n+1],new int[m]);
	}
}