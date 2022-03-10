import java.io.*;
import java.util.*;

public class Main_B7562_나이트의이동 {
	
	static int n,curX,curY,tX,tY;
	static int[]dx = {1,2,2,1,-1,-2,-2,-1};
	static int[]dy = {2,1,-1,-2,2,1,-1,-2};
	static boolean visited[][];
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{curX,curY,0});
        visited[curX][curX]=true;
        while(!q.isEmpty()) {
            int[]cur = q.poll();
            if(cur[0]==tX&&cur[1]==tY)return cur[2];
            for (int d=0;d<8;d++) {
                int nx=cur[0]+dx[d];
                int ny=cur[1]+dy[d];
                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(visited[nx][ny])continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,cur[2]+1});
            }
        }
        return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			n=Integer.parseInt(br.readLine());
			visited=new boolean[n][n];
			st=new StringTokenizer(br.readLine());
			curX=Integer.parseInt(st.nextToken());
			curY=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			tX=Integer.parseInt(st.nextToken());
			tY=Integer.parseInt(st.nextToken());
			System.out.println(bfs());
		}
	}

}
