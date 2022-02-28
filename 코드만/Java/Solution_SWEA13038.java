import java.util.Scanner;

public class Solution_SWEA13038 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for (int t = 1; t <=T; t++) {
			int N = sc.nextInt();
			int[]week = new int[7];
			for (int i = 0; i < 7; i++) {
				week[i]=sc.nextInt();
			}
			int min = Integer.MAX_VALUE;
			for (int start = 0; start < 7; start++) {
				if(week[start]==0)continue;
				int day=start,cnt=0;
				while(true) {
					if(week[day%7]==1)cnt++;
					++day;
					
					if(N==cnt) {
						day-=start;
						if(min>day)min=day;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+ min);
		}
	}
}
