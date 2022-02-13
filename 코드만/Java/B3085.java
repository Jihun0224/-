package Beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3085 {
	char[][]data;
	int answer;
	int n;
	B3085(int n){
		data=new char[n][n];
		answer=0;
		this.n=n;
	}
	void swap(int x1,int y1,int x2,int y2) {
		char temp=data[x1][y1];
		data[x1][y1]=data[x2][y2];
		data[x2][y2]=temp;
	}
	void search() {
		int count;
		for(int i=0;i<n;i++) {
			count=1;
			for(int j=0;j<n-1;j++) {
	            if(data[i][j]==data[i][j+1]) {
	    			count+=1;
	    			answer=answer>count?answer:count;
	            }
	            else
	            	count=1;
			}
		}
		for(int i=0;i<n;i++) {
			count=1;
			for(int j=0;j<n-1;j++) {
	            if(data[j][i]==data[j+1][i]) {
	    			count+=1;
	    			answer=answer>count?answer:count;
	            }
	            else
	            	count=1;
			}
		}
	}
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n=Integer.parseInt(br.readLine());
			B3085 main = new B3085(n);
			for(int i=0;i<n;i++) {
				main.data[i] = br.readLine().toCharArray();
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n-1;j++) {
					main.swap(i, j, i, j+1);
					main.search();
					main.swap(i, j+1, i, j);
					main.swap(j+1, i, j, i);
					main.search();
					main.swap(j, i, j+1, i);
				}
			}
			System.out.println(main.answer);
		}
	}