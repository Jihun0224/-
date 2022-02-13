package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B10157 {
	
	static int[][] arr;
	static int target,N,M;
	
	static void search() {
		int[] dx= {-1,0,1,0};
		int[] dy= {0,1,0,-1};
		int index=0,x=N,y=0,nx,ny;
		int cnt=1;
		while(cnt<N*M+1) {
			nx=x+dx[index%4];
			ny=y+dy[index%4];
			if(nx<0 || nx>=N || ny<0 || ny>=M || arr[nx][ny]!=0) {
				index++;
				nx=x+dx[index%4];
				ny=y+dy[index%4];
			}
			if(cnt==target) {
				System.out.println((ny+1)+" "+(N-nx));
				return;
			}
			arr[nx][ny]=cnt++;
			x=nx;
			y=ny;
		}
		System.out.println(0);
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		st = new StringTokenizer(br.readLine());
		target = Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws IOException {
		
		input();
		search();
		
	}
}
