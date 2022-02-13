package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//중복순열
public class B15651 {
	
	static int N;
	static int K;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}
	
	static void search(int depth,int[]cur) {
		if(depth==K) {
			for(int n:cur) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			cur[depth]=i;
			search(depth+1,cur);
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		search(0,new int [K]);
		bw.write(sb.toString());
		bw.flush();
	}
}
