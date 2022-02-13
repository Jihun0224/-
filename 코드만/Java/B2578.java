package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 빙고
public class B2578 {
		static int[][]map = new int[5][5];
		static int[][]cmd = new int[5][5];
		static boolean[][]visited = new boolean[5][5];
	
		static int bingo() {
			int count=0,totalCount=0;;
			for(int i=0;i<5;i++) {
				count=0;
				for(int j=0;j<5;j++) {
					if(visited[i][j]) {
						count++;
					}
				}
				if(count==5)totalCount++;
			}
			for(int i=0;i<5;i++) {
				count=0;
				for(int j=0;j<5;j++) {
					if(visited[j][i]) {
						count++;
					}
				}
				if(count==5) totalCount++;
			}	
			
			count=0;
			for(int i=0;i<5;i++)
				if(visited[i][i])count++;
			if(count==5) totalCount++;
			
			count=0;
			for(int i=0;i<5;i++) 
				if(visited[i][4-i])count++;
			if(count==5) totalCount++;
			
			return totalCount;
		}
		
		static void searchIndex(int target) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(map[i][j]==target) {
						visited[i][j]=true;
						return;
					}
				}
			}
		}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer=0;
		for(int i=0;i<5;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<5;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				cmd[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				searchIndex(cmd[i][j]);
				answer++;
				if(bingo()>=3) {
					System.out.println(answer);
					return;
				}
			}
		}
		
	}
}
