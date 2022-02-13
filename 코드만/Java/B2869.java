package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2869 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp=br.readLine().split(" ");
		int a=Integer.parseInt(temp[0]);
		int b=Integer.parseInt(temp[1]);
		int v=Integer.parseInt(temp[2]);
		int i=(v-b)/(a-b);
		if((v-b)%(a-b)!=0) 
			i++;
		System.out.println(i);
	}
}