package easy;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<String> lBracket = new Stack<String>();
		Stack<Integer> lBracketPos = new Stack<Integer>();
		Stack<String> lSquereBracket = new Stack<String>();
		Stack<Integer> lSquereBracketPos = new Stack<Integer>();
		Stack<String> lBrace = new Stack<String>();
		Stack<Integer> lBracePos = new Stack<Integer>();
		for( int i=s.length()-1; i>=0; i-- )
		{
			if( s.charAt(i) == ')' )
			{
				lBracket.push(")");
				lBracketPos.push(i);
			}
			else if( s.charAt(i) == '(' )
			{
				//decide if pop
				boolean lSucc = ifMerge(lBracket, lBracketPos,i);
				if( !lSucc )
				{
					return false;
				}				
			}
			else if( s.charAt(i) == ']' )
			{
				lSquereBracket.push("]");
				lSquereBracketPos.push(i);
			}
			else if( s.charAt(i) == '[' )
			{
				//decide if pop
				boolean lSucc = ifMerge(lSquereBracket, lSquereBracketPos,i);
				if( !lSucc )
				{
					return false;
				}				
			}
			else if( s.charAt(i) == '}' )
			{
				lBrace.push("}");
				lBracePos.push(i);
			}
			else if( s.charAt(i) == '{' )
			{
				//decide if pop
				boolean lSucc = ifMerge(lBrace, lBracePos,i);
				if( !lSucc )
				{
					return false;
				}				
			}
			
		}
		
		//last check
		if( !lBracket.isEmpty() || !lSquereBracket.isEmpty() || !lBrace.isEmpty() )
		{
			return false;
		}
		
		
		return true;
		
	}
	

	private boolean ifMerge(Stack<String> lBracket, Stack<Integer> lBracketPos, int lPos) {
		
		if( lBracket.isEmpty() || (lBracketPos.peek() - lPos)%2 ==0 )
		{
			return false;
		}
		else
		{
			lBracketPos.pop();
			lBracket.pop();
			return true;
		}	
	}


	public static void main(String[] args) {
		ValidParentheses lValidParentheses = new ValidParentheses();
		boolean lRe = lValidParentheses.isValid("]");
		System.out.println(lRe);
	}

}
