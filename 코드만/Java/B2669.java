package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2669 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[101][101];
		int sum=0;
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			for(int j=y1;j<y2;j++){
				for(int k=x1;k<x2;k++){
					arr[j][k]=1;
				}
			}
		}
		for(int[]a:arr) {
			for(int n:a) {
				sum+=n;
			}
		}
		
		System.out.println(sum);
	}
}