package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class B1929 {
	static boolean isPrime(int n) {
		if(n == 1)return false;
		for(int i=2;i<=(int)Math.pow(n, 0.5)+1;i++) {
			if(n%i==0) 
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken()),N=Integer.parseInt(st.nextToken());
		for(int i=M;i<=N;i++) {
			if(isPrime(i))
				bw.write(i+"\n");
		}		
		bw.flush();
	}
}