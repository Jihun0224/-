package _0407;

import java.io.*;
import java.util.StringTokenizer;
//백준 17281 야구
public class Main_B17281 {
	static boolean[]visited;
	static int inning,answer,order[],record[][];
	static void perm(int depth) {
		if(depth==10) {
			play();
			return;
		}
		for(int i=1;i<=9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				order[i]=depth;
				perm(depth+1);
				visited[i]=false;
			}
		}
	}
	static void play() {
		int score=0,batter=1;
		for(int i=0;i<inning;i++) {
			int out=0;
			int base=0;
			while(out<3) {
				int player=record[i][order[batter]];
				if(player==0)out++;
				else {
					base=(base+1)<<player;
					score+=Integer.bitCount(base/16);
					base%=16;
				}
				batter=batter+1==10?1:batter+1;
			}
		}
		answer=Math.max(answer, score);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inning=Integer.parseInt(br.readLine());
		record=new int[inning][10];
		for(int i=0;i<inning;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				record[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		answer=0;
		visited=new boolean[10];
		order=new int[10];
		visited[4]=true;
		order[4]=1;
		perm(2);
		System.out.println(answer);
	}
}