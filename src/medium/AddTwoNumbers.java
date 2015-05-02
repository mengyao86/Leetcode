package medium;

public class AddTwoNumbers {	 
	 
	 public static void main(String[] args)
	 {
		 ListNode lList1 = new ListNode(9);
//		 ListNode lNodeA = new ListNode(1);
//		 ListNode lNodeB = new ListNode(1);
//		 ListNode lNodeC = new ListNode(1);
//		 lList1.next = lNodeA;
//		 lNodeA.next = lNodeB;
//		 lNodeB.next = lNodeC;
		 

		 ListNode lList2 = new ListNode(1);
		 ListNode lNodeD = new ListNode(9);
		 ListNode lNodeE = new ListNode(9);
		 ListNode lNodeF = new ListNode(9);	
		 ListNode lNodeG = new ListNode(9);		 
		 ListNode lNodeH = new ListNode(9);		 
		 ListNode lNodeI = new ListNode(9);		 
		 ListNode lNodeJ = new ListNode(9);		 
		 ListNode lNodeK = new ListNode(9);		 
		 ListNode lNodeL = new ListNode(9);		 

		 lList2.next = lNodeD;
		 lNodeD.next = lNodeE;
		 lNodeE.next = lNodeF;
		 lNodeF.next = lNodeG;
		 lNodeG.next = lNodeH;
		 lNodeH.next = lNodeI;
		 lNodeI.next = lNodeJ;
		 lNodeJ.next = lNodeK;
		 lNodeK.next = lNodeL;

		 
		 ListNode lRe = addTwoNumbers(lList1, lList2);
		 while( lRe!=null )
		 {
			 System.out.print(lRe.val);
			 lRe = lRe.next;
		 }
		 
		 System.out.println("\n"+Integer.MAX_VALUE);
	 }
	 
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	 {
		if( l1 == null || l2 == null )
		{
			return l1!=null?l1:l2;
		}
		
		ListNode lReturn = null;
		String lNum1 = String.valueOf(l1.val) ;
		String lNum2 = String.valueOf(l2.val) ;

		ListNode lTmp = l1.next;
		while( lTmp!=null )
		{
			lNum1 = String.valueOf(lTmp.val) + lNum1;
			lTmp = lTmp.next;

		}
		
		lTmp = l2.next;
		while( lTmp!=null )
		{
			lNum2 = String.valueOf(lTmp.val) + lNum2;
			lTmp = lTmp.next;
		}
		
		String lRe = String.valueOf( Long.parseLong(lNum1) + Long.parseLong(lNum2) );
		
		lReturn = new ListNode(lRe.charAt(lRe.length()-1) - '0');
		ListNode point = lReturn;
		for( int i=lRe.length()-2; i>=0; i-- )
		{
			ListNode lNode = new ListNode(lRe.charAt(i) - '0');
			point.next = lNode;
			point = point.next;
		}
		
		return lReturn;
	 }
}


