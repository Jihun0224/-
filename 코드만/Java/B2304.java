package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2304 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		
		int sum=0,maxValue=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			if(maxValue<arr[i][1]) maxValue=arr[i][1];
		}
		Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
		for(int[]a:arr) {
			System.out.println(Arrays.toString(a));
		}
		int start=0,end=1;
		if(arr[start][1]==maxValue) {
			System.out.println(maxValue*(arr[N-1][0]-arr[start][0]));
			return;
		}
		while(maxValue!=arr[start][1]) {
			if(arr[start][1]<arr[end][1]) {
				sum+=(arr[end][0]-arr[start][0])*arr[start][1];
				start=end;
				end++;
			}
			else end++;
		}
		
		sum+=maxValue;
		
		start=N-1;end=start-1;
		while(maxValue!=arr[start][1]) {
			if(arr[start][1]<arr[end][1]) {
				sum+=(arr[start][0]-arr[end][0])*arr[start][1];
				start=end;
				end--;
			}
			else end--;
		}
		
		System.out.println(sum);
	}
}
