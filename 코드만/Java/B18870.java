package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class B18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int[]arr=new int[n];  
		for(int i=0;i<n;i++) {
	           arr[i] = Integer.parseInt(st.nextToken());
	        }
		int[]sortArr=arr.clone();
		Arrays.sort(sortArr);
        HashMap<Integer, Integer> dic = new HashMap<>();
        int count = 0;
        for(int i: sortArr){
            if(!dic.containsKey(i)){
            	dic.put(i,count++);
            }
        }
		for(int i: arr) {
			bw.write(dic.get(i)+ " ");
		}
		bw.flush();
	}
}