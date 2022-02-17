import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//1247. [S/W 문제해결 응용] 3일차 - 최적 경로 -> 순열
public class SWEA1247 {
	
	static int homeX,homeY,target[][],answer,N;
	//방문 여부
	static boolean[]visited;
	//거리 계산
	static int getDis(int x1,int y1,int x2,int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	static void visit(int depth,int x,int y,int curDis) {
		//현재값이 최소 이동 거리보다 크면 더 갈 필요 X
		if(answer<=curDis) return;
		//모든 집 다 방문
		if(depth==N) {
			answer=Math.min(curDis+getDis(x, y, homeX, homeY), answer);
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				int temp=getDis(x, y, target[i][0], target[i][1]);
				curDis+=temp;
				visit(depth+1,target[i][0],target[i][1],curDis);
				curDis-=temp;
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t=1,T=Integer.parseInt(br.readLine());t<=T;t++) {	
			answer=Integer.MAX_VALUE;
			N=Integer.parseInt(br.readLine());
			visited=new boolean[N];
			
			st=new StringTokenizer(br.readLine());
			int officeX=Integer.parseInt(st.nextToken());
			int officeY=Integer.parseInt(st.nextToken());
			homeX=Integer.parseInt(st.nextToken());
			homeY=Integer.parseInt(st.nextToken());
			
			target=new int[N][2];
			
			for(int i=0;i<N;i++) {
				target[i][0]=Integer.parseInt(st.nextToken());
				target[i][1]=Integer.parseInt(st.nextToken());		
			}
			visit(0,officeX,officeY,0);
			sb.append("#"+t+" "+answer+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
