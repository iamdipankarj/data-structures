public class Geometry {
	
	static class Line {
		Point p1;
		Point p2;
	}
	
	static class Point {
		int x;
		int y;
		public Point() {}
		public Point(int u, int v) {
			x = u;
			y = v;
		}
	}
	
	static int dot(Point a, Point b, Point c) {
		Point ab = new Point(b.x - a.x, b.y - a.y);
		Point bc = new Point(c.x - b.x, c.y - b.y);
		int dot = ab.x * bc.x + ab.x * bc.x;
		return dot;
	}
	
	static int cross(Point a, Point b, Point c) {
		Point ab = new Point(b.x - a.x, b.y - a.y);
		Point ac = new Point(c.x - a.x, c.y - a.y);
		int cross = ab.x * ac.y - ab.y * ac.x;
		return cross;
	}
	
	static double dist(Point a, Point b) {
		int d1 = a.x - b.x;
		int d2 = a.y - b.y;
		return Math.sqrt(d1*d1 + d2*d2);
	}
	
	static double linePointDist(Point a, Point b, Point c, boolean isSegment) {
		double dist = cross(a,b,c) / dist(a,b);
		if (isSegment) {
			int dot1 = dot(a,b,c);
			if (dot1 > 0) return dist(b,c);
			int dot2 = dot(b,a,c);
			if (dot2 > 0) return dist(a,c);
		}
		return Math.abs(dist);
	}
	
	static double area(Point[] p) {
		int cross = 0;
		int n = p.length;
		for(int i = 1; i + 1 < n; i++) {
			int x1 = p[i].x - p[0].x;
			int y1 = p[i].y - p[0].y;
			int x2 = p[i+1].x - p[0].x;
			int y2 = p[i+1].y - p[0].y;
			cross += x1*y2 - x2*y1;
		}
		
		return Math.abs(cross/2.0);
	}
	
	static boolean doIntersect(Line a, Line b) {
		return false;
	}

	public static void main(String[] args) {
		
		Point[] p = {new Point(2,3), new Point(4,5), new Point(2,9), new Point(6,12), new Point(8,9)};
		
		System.out.println(area(p));
	}

}
