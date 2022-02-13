package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2527 {
	static int x1,y1,p1,q1,x2,y2,p2,q2;
	
	static void judge() {
		//접하는 부분 X
		if(p1<x2||p2<x1||q1<y2||q2<y1) {
			System.out.println("d");
		}
		//한점
		else if(y1==q2||q1==y2) {
			if(x1==p2||x2==p1){
				System.out.println("c");
			}
			else {
				System.out.println("b");
			}
		}
		//선분 
		else if(x1==p2||x2==p1) {
			System.out.println("b");
		}
		//나머지
		else {
			System.out.println("a");
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				
		for(int t=0;t<4;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			p1=Integer.parseInt(st.nextToken());
			q1=Integer.parseInt(st.nextToken());
			x2=Integer.parseInt(st.nextToken());
			y2=Integer.parseInt(st.nextToken());
			p2=Integer.parseInt(st.nextToken());
			q2=Integer.parseInt(st.nextToken());
			judge();
		}
	}
}

