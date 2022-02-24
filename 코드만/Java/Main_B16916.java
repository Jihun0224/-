import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B16916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] S = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		int s = S.length, p = P.length;
		int[]pi = new int[p];
		
		for(int i=1, j=0; i<p; i++) {
			while(j>0 && P[i]!=P[j]) j=pi[j-1];
			if(P[i]==P[j])pi[i]=++j;
		}
		for(int i=0, j=0; i<s; i++) {
			while(j>0 && S[i]!=P[j]) j = pi[j-1];
			if(S[i]==P[j]&&++j==p) {
				System.out.println(1);
				System.exit(0);
			}
		}
		System.out.println(0);
	}
}
