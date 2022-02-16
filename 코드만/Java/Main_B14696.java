import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B14696 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int[]A=new int[5];
			int[]B=new int[5];
			st=new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				A[Integer.parseInt(st.nextToken())]+=1;
			}
			st=new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				B[Integer.parseInt(st.nextToken())]+=1;
			}
			boolean draw=true;
			for(int j=4;j>0;j--) {
				if(A[j]>B[j]) {
					sb.append("A\n");
					draw=false;
					break;
				}
				else if(A[j]<B[j]) {
					sb.append("B\n");
					draw=false;
					break;
				}
			}
			if(draw) sb.append("D\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
