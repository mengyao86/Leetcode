package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

	 public List<Integer> getRow(int rowIndex) {
		
		 	return getRowMinusOne(rowIndex+1);		
	        
	    }
	 
	 private List<Integer> getRowMinusOne( int rowIndex ){
		 List<Integer> lReturn = new ArrayList<Integer>(rowIndex);
		 lReturn.add(0, 1);
		 
		 int i;
		 for( i=1; i<rowIndex; i++ )
		 {
			 Long lInt = 1l;
			 int j=1;
			 int pos=1;
			 while( pos<=i )
			 {			
				 long lTmp = lInt * (rowIndex-j);
				 lInt =  lTmp/j;
				 j++;
				 pos++;
			 }			 
			 lReturn.add(i, lInt.intValue());
		 }
		 
		 return lReturn;
	 }
	 
	 public static void main(String[] args) 
	 {
		 PascalsTriangle2 lPascalsTriangle2 = new PascalsTriangle2();
		 List<Integer> lList = lPascalsTriangle2.getRow(3);
		 
		 for( int i=0; i< lList.size(); i++ )
		 {
			 System.out.println(lList.get(i));
		 }
	 }
}
