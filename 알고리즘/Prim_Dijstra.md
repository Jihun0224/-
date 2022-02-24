# Prim Vs Dijstra
## Prim  
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PRIM {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][]adjMatrix = new int[N][N];
        int[]minEdge = new int[N]; //타 정점에서 자신으로의 간선비용중 최소비용
        boolean[]visited = new boolean[N];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
				adjMatrix[i][j]=Integer.parseInt(st.nextToken());
			}
        	minEdge[i]= Integer.MAX_VALUE; // 충분히 큰 값으로 최소값 초기화
        }
        
        int result =0;
        minEdge[0]=0;
        
        for (int i = 0; i < N; i++) { //N개의 정점을 모두 연결
        	//신장트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택
        	int min = Integer.MAX_VALUE;
        	int minVertex =0;
        	for (int j = 0; j < N; j++) {
				if(!visited[j]&&min > minEdge[j]) {
					min = minEdge[j];
					minVertex=j;
				}
			}
        	//선택된 정점을 신장트리에 포함시킴
        	visited[minVertex]=true;
        	result+=min;
        	
        	//선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고 최소값 갱신
        	for (int j = 0; j <N; j++) {
				if(!visited[j]&&adjMatrix[minVertex][j]!=0&&minEdge[j]>adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
        	
		}
        System.out.println(result);
	}

}

```
## Dijstra  
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijstra {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;
		
		StringTokenizer st = null;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V]; // 출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[V]; // 최소비용 확정여부
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 시작점 0으로
		
		for (int i = 0; i < V; i++) {
			// 단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			int min=Integer.MAX_VALUE,current=0;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			// 단계2 :  선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjMatrix[current][j] != 0 && 
						distance[j] > distance[current] + adjMatrix[current][j]) {
					distance[j] =  distance[current] + adjMatrix[current][j];
				}
			}
		}
		
		System.out.println(Arrays.toString(distance)); 
	}
}


```
### 차이점  
1. 프림은 다익스트라와 달리 두 노드 사이가 최단거리가 아닐 수도 있다.
2. 프림은 무향 그래프에서만 작동하고, 다익스트라는 무향, 유향 그래프에서 모두 작동한다.
3. 프림이 다익스트라를, 다익스트라가 프림을 보장해주지 않는다.
   -> 최소스패닝트리가 최단경로트리를, 최단경로트리가 최소스패닝트리를 보장하지 않는다.