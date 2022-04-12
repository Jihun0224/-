package _0412;

import java.io.*;
import java.util.StringTokenizer;


public class SWEA_PokerGame {
	static int suit[],rank[];
	static void classification(char s,char r) {
		switch (s) {
		case 'S':
			suit[0]++;
			break;
		case 'D':
			suit[1]++;
			break;
		case 'H':
			suit[2]++;
			break;
		case 'C':
			suit[3]++;
			break;
		}
		switch (r) {
		case 'T':
			rank[10]++;
			break;
		case 'J':
			rank[11]++;
			break;
		case 'Q':
			rank[12]++;
			break;
		case 'K':
			rank[13]++;
			break;
		case 'A':
			rank[1]++;
			break;
		default:
			rank[r-'0']++;
			break;
		}
	}
	//연속된 수를 개수 배열 ex)5개가 연속된 카드면 result[5]=1
	static int[]getSequnce(){
		int[]result=new int [6];
		int cnt=1;
		for(int i=1;i<14;i++) {
			int temp=0;
			for(int j=2;j<14;j++) {
				if(rank[j]>0&&rank[i]>0&&j==i+1) temp++;
			}
			cnt+=temp;
			if(temp==0) {
				result[cnt]=result[cnt]+1;
				cnt=1;
			}
		}
		if(result[4]==1&&rank[13]>0&&rank[1]>0) {
			result[5]=1;
			result[4]=0;
		}
		return result;
	}
	static String print(int i) {
		switch (i) {
		case 1:
			return"Straight Flush";
		case 2:
			return"Four of a Kind";
		case 3:
			return"Full House";
		case 4:
			return"Flush";
		case 5:
			return"Straight";
		case 6:
			return"Three of a kind";
		case 7:
			return"Two pair";
		case 8:
			return"One pair";
		default:
			return"High card";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			suit=new int[4];
			rank=new int[14];
			for(int i=0;i<5;i++) {
				String temp=st.nextToken();
				classification(temp.charAt(0), temp.charAt(1));
			}
			int maxSameS=0;
			for(int i:suit) maxSameS=Math.max(maxSameS, i);
			int maxSameR=0,secSameR=0;
			for(int i:rank) {
				if(maxSameR<i) {
					secSameR=maxSameR;
					maxSameR=i;
				}
				else if(secSameR<i) {
					secSameR=i;
				}
			}
			int answer=9;
			int[] seq=getSequnce();
			if(maxSameS==5&&seq[5]==1)answer=1;
			else if(maxSameR==4)answer=2;
			else if(maxSameR==3&&secSameR==2)answer=3;
			else if(maxSameS==5)answer=4;
			else if(seq[5]==1)answer=5;
			else if(maxSameR==3)answer=6;
			else if(maxSameR==2&&secSameR==2)answer=7;
			else if(maxSameR==2)answer=8;
			System.out.println("#"+t+" "+print(answer));
		}
	}
}