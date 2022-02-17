import java.util.Scanner;
public class Main_B8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(),answer=0;
		for(int i=0;i<N+1;i++) {
			for(int j=1;j<=i;j++) {
				if(i*j<=N)answer++;
			}
		}
		System.out.println(answer);
	}
}
