import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA5432 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int answer=0,cur=0;
			String s = br.readLine();
			for(int i=0,size=s.length();i<size;i++) {
				if(i+1!=size&&s.charAt(i)=='('&&s.charAt(i+1)==')') {
					if(cur>0)
						answer+=cur;
					i++;
				}
				else if(s.charAt(i)=='('){
					cur+=1;
				}
				else {
					cur-=1;
					answer++;
				}
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
}
