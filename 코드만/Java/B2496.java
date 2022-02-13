package Beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준 2496번 탑
public class B2496 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		//높이를 저장할 스택
		Stack<Integer> stack = new Stack<Integer>();
		//인덱스를 저장할 스택
		Stack<Integer> index = new Stack<Integer>();
		String[] temp=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			//지금 탐색할 높이
			int cur = Integer.parseInt(temp[i]);
			while(!stack.isEmpty()) {
				//스택 탑이 cur보다 클 경우
				if(stack.peek()>=cur) {
					System.out.print(index.peek()+ " ");
					break;
				}
				//현재 탑보다 앞에 있는데 높이 낮은 것들은 무쓸모임
				stack.pop();
				index.pop();
			}
			//앞에 있는 것들이 현재 높이보다 다 낮음
			if(stack.empty()) 
				System.out.print("0 ");
			stack.push(cur);
			index.push(i+1);
		}	
	}
}