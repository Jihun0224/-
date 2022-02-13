package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//백준 2635 수 이어가기
public class B2635 {
	
	static int N;
	static int search(int num) {
		int count=2;
		int temp=N,result;
		while(true) {
			result=temp-num;
			temp=num;
			num=result;
			if(num<0)
				break;
			
			else count++;
		}
		return count;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
	    int max=0,MaxNum=0;
	    for(int i=N/2;i<=N;i++) {
	    	int temp=search(i);
	    	if(max<temp) {
	    		max=temp;
	    		MaxNum=i;
	    	}
	    }
	    
		int temp=N,result;
		sb.append(max+"\n");
		sb.append(N+" ");
		while(true) {
			sb.append(MaxNum+" ");
			result=temp-MaxNum;
			temp=MaxNum;
			MaxNum=result;
			if(MaxNum<0) break;
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
