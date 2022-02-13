package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 수열 -> DP
public class B2491 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[]arr = new int[N];
		int answer=1;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[]dpUp = new int[N];
		int[]dpDown = new int[N];
		dpUp[0]=1;dpDown[0]=1;
		
		for(int i=1;i<N;i++) {
			if(arr[i-1]<=arr[i]) {
				dpUp[i]=dpUp[i-1]+1;
			}
			else dpUp[i]=1;
			answer=Math.max(answer, dpUp[i]);
			
			if(arr[i-1]>=arr[i]) {
				dpDown[i]=dpDown[i-1]+1;
			}
			else dpDown[i]=1;
			answer=Math.max(answer, dpDown[i]);
		}
		System.out.println(answer);
	}
}
