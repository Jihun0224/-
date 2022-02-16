import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//5644. [모의 SW 역량테스트] 무선 충전
public class SWEA5644 {
	//정답, 입력값N,BC수,(0,0)에서 시작하는 사람 움직임 순서,(10,10)에서 시작하는 사람 움직임 순서,입력받은 bc들
	static int answer,N,bcCnt,arr1[],arr2[],bc[][];
	//각 지점마다 얻을 수 있는 충전량 저장할 배열
	static int[][][]map;
	static int[]dx= {0,-1,0,1,0};
	static int[]dy= {0,0,1,0,-1};
	
	//위치 계산하여 반환
	static int getDis(int x1,int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	//맵 생성
	static void createMap() {
		map=new int[11][11][bcCnt];
		for(int i=1;i<11;i++) {
			for(int j=1;j<11;j++) {
				//각 bc의 거리안에 포함되면 map에 저장
				for(int k=0;k<bcCnt;k++) {
					if(getDis(j, i, bc[k][0], bc[k][1])<=bc[k][2]) {
						map[i][j][k]=bc[k][3];
					}
				}
			}
		}
	}
	//같은 bc에 포함되어 있을 경우 최고값 계산
	static void getMax(int nx1,int ny1,int nx2,int ny2) {

		int[] case1=new int[bcCnt];
		int[] case2=new int[bcCnt];
		for(int j=0;j<bcCnt;j++) {
				if(map[nx1][ny1][j]!=0) 
					case1[j]=map[nx1][ny1][j];
				if(map[nx2][ny2][j]!=0) 
					case2[j]=map[nx2][ny2][j];
			}
		int sum=0;
		for(int i=0;i<bcCnt;i++) {
			for(int j=0;j<bcCnt;j++) {
				if(i!=j) {
					sum=Math.max(case1[i]+case2[j], sum);
				}
			}
		}
		answer+=sum;
	}
	
	static void cal() {
		int nx1=1,ny1=1,nx2=10,ny2=10,temp1=0,temp2=0,cnt1=0,cnt2=0;
		//같은 bc쓰는 여부
		boolean sameBc=false;
		
		createMap();
		for(int i=0;i<=N;i++) {
			cnt1=0;
			cnt2=0;
			temp1=0;
			temp2=0;
			sameBc=false;
			for(int j=0;j<bcCnt;j++) {
				//bc[j]같이 사용가능
				if(map[nx1][ny1][j]!=0&&map[nx2][ny2][j]!=0) {
					temp1=map[nx1][ny1][j];
					cnt1++;cnt2++;
					sameBc=true;
				}
				else {
					//첫번째 사람만 사용가능
					if(map[nx1][ny1][j]!=0) {
						temp1=Math.max(temp1,map[nx1][ny1][j]);
						cnt1++;
					}
					//두번째 사람만 사용가능
					if(map[nx2][ny2][j]!=0){
						temp2=Math.max(temp2,map[nx2][ny2][j]);
						cnt2++;
						}
					}
				}
				//둘 다 사용가능한 게 공통된 하나 뿐
				if(sameBc&&cnt1==1&&cnt2==1) {
					answer+=temp1;
				}
				//공통도 있고 다른 것도 사용가능할 경우 
				else if(sameBc&&(cnt1>=1||cnt2>=1)) {
					getMax(nx1, ny1, nx2, ny2);
				}
				//나머지
				else{
					answer+=temp1;
					answer+=temp2;
				}
				//이동
				if(i!=N) {
					nx1+=dx[arr1[i]];ny1+=dy[arr1[i]];
					nx2+=dx[arr2[i]];ny2+=dy[arr2[i]];
				}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1,st2;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st1 = new StringTokenizer(br.readLine());
			answer=0;
			N = Integer.parseInt(st1.nextToken());
			arr1 = new int[N];
			arr2 = new int[N];
			bcCnt = Integer.parseInt(st1.nextToken());
			bc = new int[bcCnt][4];
			st1=new StringTokenizer(br.readLine());
			st2=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr1[i]=Integer.parseInt(st1.nextToken());
				arr2[i]=Integer.parseInt(st2.nextToken());
			}
			for(int i=0;i<bcCnt;i++) {
				st1=new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) {
					bc[i][j]=Integer.parseInt(st1.nextToken());
				}
			}
			
			cal();
			
			sb.append("#"+tc+" "+answer+"\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
