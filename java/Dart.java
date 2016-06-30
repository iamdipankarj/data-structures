public class Dart {
	
	static class Point {
		int x;
		int y;
		public Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	static int dist(Point a, Point b) {
		return (int)Math.sqrt( Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) );
	}
	
	public static void main(String[] args) {
		
		Point a = new Point(2,2);
		Point b = new Point(0,1);
		
		System.out.println(dist(a, b));
		
	}

}








