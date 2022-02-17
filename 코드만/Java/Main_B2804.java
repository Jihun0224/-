import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A=st.nextToken(),B=st.nextToken();
		int N=A.length(),M=B.length();
		int Aco=-1,Bco=-1;
		boolean find=false;
		for(int i=0;i<N;i++){
			if(!find) {
				for(int j=0;j<M;j++) {
					if(A.charAt(i)==B.charAt(j)) {
						Aco=j;
						Bco=i;
						find=true;
						break;
					}
				}
			}
		}
		int Ai=0,Bi=0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(j==Bco&&i==Aco) {
					System.out.print(B.charAt(Bi));
					Bi++;Ai++;
				}
				else if(j==Bco)System.out.print(B.charAt(Bi++));
				else if(i==Aco)System.out.print(A.charAt(Ai++));
				else System.out.print(".");
			}
			System.out.println();
		}
	}
}
