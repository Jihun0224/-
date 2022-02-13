package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15664 {
	
	static int N;
	static int K;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
	}
	
	static void search(int depth,int[]cur,boolean[] vistied,int start) {
		if(depth==K) {
				for(int n:cur) {
					sb.append(n+" ");
				}
				sb.append("\n");
				return;
			}
			
		
		int preNum = -1;
		for(int i=start;i<N;i++) {
			if(!vistied[i]&&arr[i]!=preNum) {
				vistied[i]=true;
				preNum=arr[i];
				cur[depth]=arr[i];
				search(depth+1,cur,vistied,i);
				vistied[i]=false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		search(0,new int [K],new boolean [N],0);
		bw.write(sb.toString());
		bw.flush();
	}
}
