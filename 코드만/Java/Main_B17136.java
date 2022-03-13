import java.io.*;
import java.util.StringTokenizer;

public class Main_B17136 {
	static int[][]map=new int[10][10];
	static int[] paper = {0,5,5,5,5,5};
	static int answer=Integer.MAX_VALUE;
	public static void dfs(int x,int y,int cnt) {
		if(x>=9&&y>9) {
			answer=Math.min(answer,cnt);
			return;
		}
		if(answer<=cnt) return;
		if(y>9) {
			dfs(x+1,0,cnt);
			return;
		}
		if(map[x][y]==1) {
			for(int i=5;i>=1;i--) {
				if(paper[i]>0&&check(x,y,i)) {
					papering(x,y,i,0);
					paper[i]--;
					dfs(x,y+1,cnt+1);
					papering(x,y,i,1);
					paper[i]++;
				}
			}
		} else dfs(x,y+1,cnt);
	}

	public static void papering(int x,int y,int n,int state) {
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				map[i][j]=state;
			}
		}
	}
 
	public static boolean check(int x, int y, int n) {
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(!(i>=0&&i<10&&j>=0&&j<10)||map[i][j]!=1) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map=new int[10][10];
		for(int i=0;i<10;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
}
