package _0416;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B15684 {
	static int N,M,H,answer=4;
	static boolean[][]map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		map=new boolean[H+1][N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
		}
		dfs(0,1);
		if(answer==4)System.out.println(-1);
		else System.out.println(answer);
	}
	static void dfs(int depth,int height) {
		if(answer<=depth)return;
		if(play()) {
			answer=depth;
			return;
		}
		for(int i=height;i<=H;i++) {
			for(int j=1;j<N;j++) {
				if(!map[i][j]) {
					if(map[i][j-1])continue;
					if(map[i][j+1])continue;
					map[i][j]=true;
					dfs(depth+1,i);
					map[i][j]=false;
				}
			}
		}
	}
	static boolean play() {
		for(int i=1;i<=N;i++) {
			int now=i;
			for(int j=1;j<=H;j++) {
				if(map[j][now])now++;
				else if(map[j][now-1])now--;
			}
			if(i!=now)return false;
		}
		return true;
	}
}
