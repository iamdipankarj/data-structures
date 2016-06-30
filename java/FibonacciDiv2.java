public class FibonacciDiv2 {
	
	public static int find(int N) {
		int f1 = 0, f2 = 1, w;
		int res = Integer.MAX_VALUE;
		
		while(f1 < N) {
			w = f1;
			f1 = f2;
			f2 = w + f2;
			
			res = Math.min(res, Math.abs(f1-N));
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(find(1000000));
	}

}
