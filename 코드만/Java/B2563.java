package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][]map=new int[100][100];
		int N = Integer.parseInt(st.nextToken()),x,y,sum=0;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			for(int j=y;j<y+10;j++) {
				for(int k=x;k<x+10;k++) {
					map[j][k]=1;
				}
			}
		}
		for(int[]a:map) for(int n:a)sum+=n;
		System.out.println(sum);
	}
}
