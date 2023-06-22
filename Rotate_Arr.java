public class Rotation{
// space O(n)
	static int[] rotatearr(int arr[],int k) {
		int l=arr.length;
		k=k%l;
		int[] a=new int[l];
		for(int i=0;i<l;i++) {
			a[(i+k)%l]=arr[i];
		}
		return a;
	}
	//inplace rotation 
	// 1st reverse complete array
	//2nd reverse from pivot both sides
	//eg.[1,2,3,4,5,6] by 3 place
	//reverse whole [6,5,4,3,2,1]
	//from 3rd place rotate 1st part
	//[4,5,6,3,2,1]
	//from 4th place rotate 2nd part [4,5,6,1,2,3]
	static int[] rotateinplace(int arr[],int k) {
		int l=arr.length;
		k=k%l;
		int start=0;
		int end=l-1;
		while(end>=start) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			end--;
			start++;
		}
		start=0;
		end=k-1;
		while(end>=start) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			end--;
			start++;
		}
		start=k;
		end=l-1;
		while(end>=start) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			end--;
			start++;
		}
		return arr;
		
	}
  public staic void main(String args[]){
    int a[]={1,2,3,4,5,6,7,8,9,10};
    a=rotateinplace(a,3);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
  }
}
