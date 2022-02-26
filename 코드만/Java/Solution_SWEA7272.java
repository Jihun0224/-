import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Solution_SWEA7272 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String arr1,arr2;
		String one = "ADOPQR";
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			arr1 = st.nextToken();
			arr2 = st.nextToken();
			if(arr1.length()!=arr2.length()) {
				sb.append("#"+t+" DIFF\n");
				continue;
			}
			for(int i=0,size=one.length();i<size;i++) {
				arr1=arr1.replace(Character.toString(one.charAt(i)), "1");
				arr2=arr2.replace(Character.toString(one.charAt(i)), "1");
			}
			arr1=arr1.replace("B", "2");
			arr2=arr2.replace("B", "2");

			arr1=arr1.replaceAll("[A-Z]", "0");
			arr2=arr2.replaceAll("[A-Z]", "0");

			boolean flag = true;
			for(int i=0,size=arr1.length();i<size;i++) {
				if(arr1.charAt(i)!=arr2.charAt(i)) {
					flag=false;
					break;
				}
			}
			if(flag)sb.append("#"+t+" SAME\n");
			else sb.append("#"+t+" DIFF\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
