//sieve of eratosthenes
import java.util.*;
public class Prime_Numbers {
	static boolean[] prime(int n) {
		boolean[] nums=new boolean[n+1];
		Arrays.fill(nums, true);
		try {
		nums[0]=false;
		nums[1]=false;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(nums[i]==true) {
				for(int j=2;j*i<=n;j++) {
					nums[i*j]=false;
				}
			}
		}	
		}catch(Exception e) {
			System.out.print("Enter Nummber grater than 1");
		}
		return nums;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Upto which you need to find prime number ");
		int digit=sc.nextInt();
		boolean b[]=prime(digit);
		for(int i=0;i<=digit;i++) {
			if(b[i]==true) {
				System.out.print(i+" ");
			}
		}
		sc.close();
	}

}
