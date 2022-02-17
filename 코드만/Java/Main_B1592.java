import java.util.Scanner;

public class Main_B1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(),M=sc.nextInt(),L=sc.nextInt(),answer=0,cur=1;
		int[]arr = new int[N+1];
		while(true) {
			arr[cur]++;
			if(arr[cur]==M)break;
			else {
				if(arr[cur]%2==0)cur=(cur+L)%N;
				else cur=(cur+N-L)%N;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
