package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K= Integer.parseInt(st.nextToken());
		int sum=0;
		int[]arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		if(N==K) {
			for(int i:arr) 
				sum+=i;
			System.out.println(sum);
			return;
		}

		int answer=Integer.MIN_VALUE;
		int start=0,end=K;

		while(end!=N+1) {
			sum=0;
			for(int j=start;j<end;j++) {
				sum+=arr[j];
			}
			start++;end++;
			answer=Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}
