package _0405;

import java.io.*;
import java.util.*;

//정올 2577 회전 초밥
public class Jungol_2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int answer=0;
		int[]arr=new int[n];
		int[]sushi = new int[d+1];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int cnt=0;
		for(int i=0;i<k;i++) {
			if(sushi[arr[i]]==0)cnt++;
			sushi[arr[i]]++;
		}
		answer=cnt;
		for(int i=1;i<n;i++) {
			if(answer<=cnt) {
				answer=cnt;
				if(sushi[c]==0)answer++;
			}
			sushi[arr[i-1]]--;
			if(sushi[arr[i-1]]==0)cnt--;
			if(sushi[arr[(i+k-1)%n]]==0)cnt++;
			sushi[arr[(i+k-1)%n]]++;
		}
		System.out.println(answer);
	}
}