import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//6808. 규영이와 인영이의 카드게임
public class SWEA6808 {

	static int win;
	static int lose;
	static int[] arr1;
	static int[] arr2;
	static int[] cur=new int[9];
	static void caseCheck(int depth,boolean[]visited) {
		if(depth==9) {
			int arr1Sum=0,arr2Sum=0;
			for(int i=0;i<9;i++) {
				if(arr1[i]>cur[i])arr1Sum+=arr1[i]+cur[i];
				else arr2Sum+=arr1[i]+cur[i];
			}
			if(arr1Sum>arr2Sum)win++;
			else if(arr1Sum<arr2Sum)lose++;
			return;
		}
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				cur[depth]=arr2[i];
				caseCheck(depth+1,visited);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++){
			win=0;lose=0;
			st = new StringTokenizer(br.readLine());
			arr1=new int[9];
			arr2=new int[9];
			for(int i=0;i<9;i++) {
				arr1[i]=Integer.parseInt(st.nextToken());
			}
			boolean flag = true;
			int index=0;
			for(int i=1;i<=18;i++) {
				flag = true;
				for(int n:arr1) {
					if(i==n) {
						flag=false;
						break;
					}
				}
				if(flag)arr2[index++]=i;
			}
			caseCheck(0,new boolean[9]);
			sb.append("#"+test_case+" "+win+" "+lose);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
