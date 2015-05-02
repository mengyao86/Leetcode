package easy;

import java.util.HashSet;

public class IntersectionOfLinkedLists {	

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		HashSet<Integer> lHashHash = new HashSet<Integer>();
		
		int size =0;
		ListNode lListNode = headA;
		while( lListNode!=null )
		{
			lHashHash.add(lListNode.hashCode());
			lListNode = lListNode.next;
			size ++;
		}
		
		lListNode = headB;
		
		while( lListNode!=null )
		{
			lHashHash.add(lListNode.hashCode());
			size ++;

			if( lHashHash.size() < size )
			{
				return lListNode;
			}
			lListNode = lListNode.next;
		}
		
		return null;
	}

	public static void main(String[] args) {
		
		ListNode lListNode1 = new ListNode(1); 
		ListNode lListNode2 = new ListNode(2); 
		ListNode lListNode3 = new ListNode(3); 
		ListNode lListNode4 = new ListNode(4); 
		ListNode lListNode5 = new ListNode(5); 
		ListNode lListNode6 = new ListNode(6); 
		ListNode lListNode7 = new ListNode(7); 
		ListNode lListNode8 = new ListNode(8); 
		
		lListNode1.setNext(lListNode2);
		lListNode2.setNext(lListNode3);
		lListNode3.setNext(lListNode4);
		lListNode4.setNext(lListNode7);
		
		lListNode5.setNext(lListNode6);
		lListNode6.setNext(lListNode7);
		lListNode7.setNext(lListNode8);
		lListNode8.setNext(null);
		
		IntersectionOfLinkedLists lIntersectionOfLinkedLists = new IntersectionOfLinkedLists();
		ListNode lListNode = lIntersectionOfLinkedLists.getIntersectionNode(lListNode1, lListNode5);
		System.out.println(lListNode.getVal());
		
	}
}
