import java.util.*;
import java.io.*;
public class Main_BOJ14889 {
	static int arr[][],N,answer;
	static boolean[]selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		selected=new boolean[N];
		answer=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0);
		System.out.println(answer);
	}
	static void solve(int depth,int start) {
		if(depth==N/2) {
			answer=Math.min(answer,Math.abs(getScore(true)-getScore(false)));
			return;
		}
		for(int i=start;i<N;i++) {
			if(!selected[i]) {
				selected[i]=true;
				solve(depth+1, i);
				selected[i]=false;
			}
		}
	}
	static int getScore(boolean state) {
		int tmp=0;
		for(int i=0;i<N;i++) {
			if(selected[i]==state) {
				for(int j=0;j<N;j++) {
					if(selected[j]==state) tmp+=arr[i][j];
				}
			}
		}
		return tmp;
	}
}