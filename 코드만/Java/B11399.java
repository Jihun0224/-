package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11399 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()),sum=0;
		String[]temp=br.readLine().split(" ");
		int[]arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			sum+=arr[i]*(n-i);
		}
		System.out.println(sum);
	}
}