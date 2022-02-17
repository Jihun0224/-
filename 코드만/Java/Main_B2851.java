import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2851 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cur=0,pre=0;
		for(int i=0;i<10;i++) {
			pre=cur;
			cur+=Integer.parseInt(br.readLine());
			if(cur==100)break;
			else if(cur<100)continue;
			else {
				if(Math.abs(100-cur)>Math.abs(100-pre)) cur=pre;
				break;
			}
		}
		System.out.println(cur);
	}
}
