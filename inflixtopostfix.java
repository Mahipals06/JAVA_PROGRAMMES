//USED FOR SIMPLE CALCULATOR
import java.util.*;
public class PostfixEvaluation {
	static int Evaluateprefix(String exp) {
		Stack<Integer> s=new Stack<Integer>();
		for(int i=0;i<exp.length();i++) {
			char c=exp.charAt(i);
			if(c==' '||c==',') {
				;
			}
			else if(isNUM(c)) {
				int num=0;
				
				while(i<exp.length() && isNUM(c)) {
					
					num=num*10+(c-'0');
					i++;
					c=exp.charAt(i);
				}
				i--;
				s.push(num);
				System.out.println(s);
			}
			else if(isOperator(c)) {
				int op2=s.pop();
				int op1=s.pop();
				int result=0;
				if(c=='+')
					result=op1+op2;
				else if(c=='-')
					result=op1-op2;
				else if(c=='*')
					result=op1*op2;
				else if(c=='/')
					result=op1/op2;
				else {
					System.out.print("unexpected error");
					result=-1;
				}
			
				s.push(result);
				System.out.println(s);
			}
			
		}
		System.out.println(s);
		return s.get(0);
	}
	static boolean isNUM(char c){
		return (c>='0' && c<='9');
	}
	static boolean isOperator(char c) {
		return c=='+'||c=='-'||c=='*'||c=='/';
	}
	static int getoperatorweight(char c) {
		if(c=='+'||c=='-')
			return 1;
		else if(c=='*'||c=='/')
			return 2;

		else 
			return -1;
	}

	static boolean HasHigherPrecedence(char op1,char op2) {
		return getoperatorweight(op1)>=getoperatorweight(op2);		
	}
	static String infixtopostfix(String exp) {
		Stack<Character> s=new Stack<>();
		String postfix="";
		
		for(int i=0;i<exp.length();i++) {
			char c=exp.charAt(i);
			if(c==' '||c==',') {
				
			}
			else if(isOperator(c)) {
				postfix+=' ';
				while(!s.isEmpty()&& s.peek()!='(' && HasHigherPrecedence(s.peek(),c)) {
					postfix+=s.pop();
				}
				s.push(c);
				System.out.println(s);
			}
			else if(isNUM(c)) {
				postfix+=c;
			}
			else if(c=='(') {
				s.push(c);
				System.out.println(s);
			}
			else if(c==')') {
				while(!s.isEmpty() && s.peek()!='(') {
					postfix+=s.pop();
					System.out.println(s);
				}
				s.pop();
			}
			
		}
		while(!s.isEmpty()) {
			postfix+=s.pop();
			System.out.println(s);
		}
		return postfix;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String post="9/3+(5-7*2)";
//			String post="99 33 / 50 70 20-*+";
			String s=infixtopostfix(post);
			System.out.println(s);
			System.out.println(Evaluateprefix(s));
			
			
	}

}
