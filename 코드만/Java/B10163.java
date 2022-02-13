package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10163 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[][]map = new boolean[1001][1001];
		int[]result = new int[N];
		int[][]arr = new int [N][4];
		for(int i=N-1;i>=0;i--) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++){
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int sum;
		for(int i=0;i<N;i++) {
			sum=0;
			for(int j=0;j<arr[i][2];j++) {
				for(int k=0;k<arr[i][3];k++) {
					if(!map[arr[i][0]+j][arr[i][1]+k]) {
						map[arr[i][0]+j][arr[i][1]+k]=true;
						sum++;
					}
				}
			}
			result[i]=sum;
		}
		for(int i=N-1;i>=0;i--) {
			System.out.println(result[i]);
		}
	}
}
