import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

//3499. 퍼펙트 셔플
public class SWEA3499 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++){
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int i=0;
			sb.append("#"+test_case+" ");
			while(st.hasMoreTokens()) {
				if(i<(N+1)/2)
					queue1.offer(st.nextToken());
				else
					queue2.offer(st.nextToken());
				i++;
			}

			i=0;
			while(!queue1.isEmpty()||!queue2.isEmpty()) {
				if(!queue1.isEmpty()&&i%2==0)
					sb.append(queue1.poll()+" ");
				else if(!queue2.isEmpty())
					sb.append(queue2.poll()+" ");
				i++;
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
