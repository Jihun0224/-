package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20609 {
	static int gedGCD(int a, int b){
	    if(b == 0)
	        return a;
	    else
	        return gedGCD(b, a%b);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp=br.readLine().split(" ");
		int a=Integer.parseInt(temp[0]),b=Integer.parseInt(temp[1]);
		int gcd=gedGCD(a,b);
		System.out.println(gcd);
		System.out.println(a*b/gcd);
	}
}