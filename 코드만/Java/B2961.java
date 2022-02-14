package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준2961. 도영이가 만든 맛있는 음식  -> 부분집합
public class B2961 {
	static int N,answer=Integer.MAX_VALUE;
	static int[][]arr;
	
	static void search(int depth,boolean[] choice) {
		if(depth==N) {
			int s=1,ss=0,tCnt=0;
			for(int i=0;i<N;i++) {
				if(choice[i]) {
					s*=arr[i][0];
					ss+=arr[i][1];
					tCnt++;
				}
			}
			if(tCnt>0)
				answer=Math.min(answer, Math.abs(s-ss));
			return;
		}	
		
			choice[depth]=false;
			search(depth+1,choice);
			choice[depth]=true;
			search(depth+1,choice);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int [N][2];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		search(0,new boolean[N]);
		System.out.println(answer);
	}
}
