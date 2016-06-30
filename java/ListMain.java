public class ListMain {
	
	public static class ListNode {
		int data;
		ListNode next;
		public ListNode(int val) { data = val; }
	}
	
	static void push(ListNode head, int data) {
		if (head == null) {
			return;
		} else if (head.next == null) {
			head.next = new ListNode(data);
			return ;
		}
		push(head.next, data);
	}
	
	static void print(ListNode head) {
		if (head == null) return;
		System.out.print(head.data + " ");
		print(head.next);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		push(head, 2);
		push(head, 2);
		push(head, 3);
		push(head, 4);
		push(head, 5);
		print(head);
	}
	
}







