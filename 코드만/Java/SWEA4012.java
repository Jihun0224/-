import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//4012. [모의 SW 역량테스트] 요리사
//nCn/2를 구해서 선택된 것과 선택되지 않은 재료의 합의 차가 최소인 값으로 answer값 갱신
public class SWEA4012 {
	static int answer,N,arr[][];
	static boolean[]vistied;
	static void search(int depth,int start) {
		
		if(depth==N/2) {
			int sum1=0, sum2=0;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(vistied[i]&&vistied[j]) {
						sum1+=arr[i][j];
						sum1+=arr[j][i];
					}
					else if(!vistied[i]&&!vistied[j]){
						sum2+=arr[i][j];
						sum2+=arr[j][i];
					}
				}
			}
			
			answer=Math.min(answer, Math.abs(sum1-sum2));
			return;
		}
		for(int i=start;i<N;i++) {
			vistied[i]=true;
			search(depth+1, i+1);
			vistied[i]=false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			vistied = new boolean[N];
			answer=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			search(0,0);
			sb.append("#"+tc+" "+answer+"\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
