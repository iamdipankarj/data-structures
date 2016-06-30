public class Greedy {
	
	static class Act {
		String name;
		int start;
		int finish;
		public Act(String n, int s, int f) {
			name = n;
			start = s;
			finish = f;
		}
	}
	
	static void activities(Act[] act) {
		int i = 0;
		System.out.print(act[i].name + " ");
		
		for(int j = 1; j < act.length; j++) {
			if (act[j].start >= act[i].finish) {
				System.out.print(act[j].name + " ");
				i = j;
			}
		}
	}
	
	static void printActivities(int[] s, int[] f) {
		int i;
		i = 0;
		System.out.print(i + " ");
		
		// consider other activities
		for (int j = 1; j < s.length; j++) {
			if (s[j] >= f[i]) {
				System.out.print(j + " ");
				i = j;
			}
		}
	}

	public static void main(String[] args) {
		/*int s[] =  {1, 3, 0, 5, 8, 5};
	    int f[] =  {2, 4, 6, 7, 9, 9};*/
	    Act[] act = {
	    			new Act("(1,2)", 1, 2),
	    			new Act("(3,4)", 3, 4),
	    			new Act("(0,6)", 0, 6),
	    			new Act("(5,7)", 5, 7),
	    			new Act("(8,9)", 8, 9),
	    			new Act("(5,9)", 5, 9)
	    			};
	    activities(act);
	}

}




