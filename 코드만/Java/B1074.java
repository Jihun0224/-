package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 Z
public class B1074 {
	
	static int N,answer;
	
	static void search(int x,int y) {
	        if (N==0) {
	        	System.out.println(answer);
	        	return;
	        }
	        //현재 변길이
	        int len=(int)Math.pow(2,N);
	        //현재 넓이
	        int size=len*len;
	        //크기 -1
	        N--;
	        if(x>=len/2) {
	        	answer+=size/4;
	        	x-=len/2;
	        }
	        if(y>=len/2) {
	        	answer+=size/2;
	        	y-=len/2;
	        }
	        search(x,y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		search(c,r);
		
	}
}