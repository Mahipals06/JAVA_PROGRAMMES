import java.util.*;
public class Prime_Factorization {

	public static void main(String[] args) {
		List<Integer> a=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number");
		int n=sc.nextInt();
		for(int i=1;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				a.add(i);
				if(i!=Math.sqrt(n))
					a.add(n/i);
			}
		}
		
		System.out.println("Factors : "+a);
		for(int i=2;i<=Math.sqrt(n);i++) {
			int pw=0;
			if(n%i==0) {
			while(n%i==0) {
				n=n/i;
				pw++;
			}
			System.out.print(i+"^"+pw+" ");
			}
		}
		if(n>Math.sqrt(n)){
			System.out.print(n+"^"+1);
    }
		sc.close();
	}
}
