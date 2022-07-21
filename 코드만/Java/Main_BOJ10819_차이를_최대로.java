import java.util.*;
public class Main_BOJ10819_차이를_최대로 {
	static int N,answer,selected[],arr[];
	static boolean visited[];
	static void perm(int depth) {
		if(depth==N) {
			int result=0;
			for(int i=0;i<N-1;i++) result+=Math.abs(selected[i]-selected[i+1]);
			answer=Math.max(answer, result);
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				selected[depth]=arr[i];
				perm(depth+1);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		answer=0;
		arr=new int[N];
		selected=new int[N];
		visited=new boolean[N];
		for(int i=0;i<N;i++)arr[i]=sc.nextInt();
		perm(0);
		System.out.println(answer);
	}
}
