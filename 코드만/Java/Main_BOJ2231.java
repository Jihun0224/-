import java.util.*;
public class Main_BOJ2231 {
	public static void main(String[] args) {
		int N=new Scanner(System.in).nextInt();
		int answer=0;
		for(int i=1;i<N;i++) {
			char[]now=String.valueOf(i).toCharArray();
			int res=i;
			for(char c:now)res+=c-48;
			if(res==N) {
				answer=i;
				break;
			}
		}
		System.out.println(answer);
	}
}