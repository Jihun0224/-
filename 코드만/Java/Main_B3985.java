import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3985 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[]cake = new int[L+1];
		int[]people=new int[N+1];
		int wIndex=0,wValue=0;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(wValue<end-start+1) {
				wValue=end-start+1;
				wIndex=i;
			}
			for(int j=start;j<=end;j++) {
				if(cake[j]==0) {
					people[i]++;
					cake[j]=1;
				}
			}
		}
		int answer=0;
		for(int i=1;i<=N;i++) {
			answer = people[answer]<people[i]?i:answer;
		}
		System.out.println(wIndex);
		System.out.println(answer);
	}
}
