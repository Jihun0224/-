import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1759 {
	
	static int L,C;
	static char[] arr;
	static StringBuilder vowels = new StringBuilder("aeiou");
	static StringBuilder sb = new StringBuilder();
	static boolean[] vistied=new boolean[26];
	
	static void search(int depth,int start) {
		if(depth==L) {
			int vowelCnt=0;
			StringBuilder temp = new StringBuilder();
			for(int i=0;i<26;i++) {
				if(vistied[i]) {
					if(vowels.toString().contains(Character.toString((char)(i+97))))vowelCnt++;
					temp.append((char)(i+97));
				}
			}
			if(vowelCnt>=1&&temp.length()-vowelCnt>=2) {
				sb.append(temp+"\n");
			}
			return;
		}
		for(int i=start;i<C;i++) {
			if(!vistied[(int)arr[i]-97]) {
				vistied[(int)arr[i]-97]=true;
				search(depth+1,i+1);
				vistied[(int)arr[i]-97]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for(int i=0;i<C;i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		search(0,0);
		bw.write(sb.toString());
		bw.flush();
	}
}
