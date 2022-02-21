import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_B17219 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap<String, String>password = new HashMap<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			password.put(st.nextToken(), st.nextToken());
		}
		for(int j=0;j<M;j++) {
			bw.append(password.get(br.readLine())+"\n");
		}
		bw.flush();
	}

}
