package _0411;

import java.io.*;
import java.util.*;

public class Main_B1708 {
	static Point first;
	static class Point implements Comparable<Point>{
		long x,y;
		Point(long x,long y) {
			this.x=x;
			this.y=y;
		}
	    @Override
	    public int compareTo(Point p) {
	        if(this.x > p.x) {
	            return 1;
	        }
	        else if(this.x == p.x) {
	            if(this.y > p.y) {
	                return 1;
	            }
	        }
	        return -1;
	    }
	}
	static int ccw(Point p, Point a, Point b) {
		long result =cross(vec(p,a),vec(a,b));
    	if (result > 0) {   
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
	}
	static long cross(Point a, Point b) {
		return a.x*b.y-a.y*b.x;
	}
	static Point vec(Point a, Point b) {
		long x=b.x-a.x;
		long y=b.y-a.y;
		return new Point(x,y);
	}

	static long getDist(Point p1,Point p2) {
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		ArrayList<Point>points=new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(points);
		first=points.remove(0);
        points.sort(new Comparator<Point>() {
    		@Override
    	    public int compare(Point second, Point third) {
    			long ccwR=ccw(first, second, third);
    	        if(ccwR>0)return -1;
    	        else if(ccwR<0)return 1;
    	        else {
    	        	long distR1=getDist(first, second);
    	            long distR2=getDist(first, third);
    	            if (distR1>distR2)return 1;
    	            else return -1;
    	        }
    	    }
        });
        Stack<Point>stack = new Stack<>();
        stack.push(first);
        stack.push(points.remove(0));
        
		for (int i=0,size=points.size();i<size;i++) {
			Point third=points.get(i);
			while(stack.size()>=2) {
				Point second=stack.pop();  
				Point first=stack.peek();
				long ccwR=ccw(first,second,third);
				if(ccwR>0) {
					stack.push(second);
					break;
				}
			}
			stack.push(third);
		}
		System.out.println(stack.size());
	}
}
