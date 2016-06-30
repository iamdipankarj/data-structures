public class DerivativeSequence {
	
	public static int[] derSeq(int[] a, int n) {
		if ( n == 0 ) return a;
		int[] b = new int[a.length - 1];
		for (int i = 0; i < a.length-1; i++) {
			b[i] = a[i+1] - a[i];
		}
		return derSeq(b, n-1);
	}

	public static void main(String[] args) {
		int[] a = {5,6,3,9,-1};
		int[] b = derSeq(a, 4);
		
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

}
