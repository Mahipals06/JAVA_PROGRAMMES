//decimal to binary using stack
import java.util.*;
public class Decimal_to_Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Number- ");
		int digit=sc.nextInt();
		int r=0;
		int binary=0;
		Stack<Integer> s=new Stack<Integer>();
		while(digit>0) {
		
			r=digit%2;
			digit=digit/2;
			s.push(r);
		}
		while(!s.isEmpty()) {
			binary=binary*10+s.pop();
		}
		System.out.print("binary number is " +binary);
		sc.close();
	}

}
