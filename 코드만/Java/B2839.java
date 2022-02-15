package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//백준 2839 설탕배달
public class B2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer=-1;
		int start=N/5;
		//N이 5로 나눈 몫부터 시작
		for(int i=start;i>0;i--) {
			
			if((N-5*i)%3==0) {
				answer=i+(N-5*i)/3;
				break;
			}
		}
		//5와 3의 조합으로 N표현 못 할 때 3으로만 표현가능한지 체크
		if(answer==-1&&N%3==0)answer=N/3;
		System.out.println(answer);
	}
}
