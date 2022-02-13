package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2605 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i=1,temp,N=Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			temp=Integer.parseInt(st.nextToken());
			arr.add(arr.size()-temp, i++);
		}
		for(int n:arr) {
			System.out.print(n+" ");
		}
	}
}
