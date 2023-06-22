public class Binary_Search {
	//Iterative Method 
	static int  binarySearch(int arr[],int key) {
		int length=arr.length;
		int start=0;
		int end=length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==key)
				return mid;
			else if(key<arr[mid])
				end=mid-1;
			else
				start=mid+1;
		}
		return -1;
		
	}
	
	//Recursive Method
	static int binarySearchR(int arr[],int start,int end,int key) {
		if(start>end)
			return -1;
		int mid=start+(end-start)/2;
		if(arr[mid]==key)
			return mid;
		else if(arr[mid]<key)
			return binarySearchR(arr,mid+1,end,key);
		else
			return binarySearchR(arr,start,mid-1,key);
		
	}
	
	// Find 1st Occurrence
	static int  binarySearchfirst(int arr[],int key) {
		int length=arr.length;
		int start=0;
		int end=length-1;
		int result=-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==key) {
				result=mid;
				end=mid-1;
			}
			else if(key<arr[mid])
				end=mid-1;
			else
				start=mid+1;
		}
		return result;
		
	}
	// Find last Occurrence
		static int  binarySearchlast(int arr[],int key) {
			int length=arr.length;
			int start=0;
			int end=length-1;
			int result=-1;
			
			while(start<=end) {
				int mid=start+(end-start)/2;
				if(arr[mid]==key) {
					result=mid;
					start=mid+1;
				}
				else if(key<arr[mid])
					end=mid-1;
				else
					start=mid+1;
			}
			return result;
			
		}
		//Search Number of occurrence 
		static int countOccurrence(int arr[],int key){
			int first=binarySearchfirst(arr,key);
			if(first==-1) {
				return -1;
			}
			else {
			int last=binarySearchlast(arr,key);
			return (last-first+1);
			}
		}
		//count number of times array rotated
		static int countRotation(int arr[]) {
			int low=0;
			int n=arr.length;
			int high=n-1;
			while(low<=high) {
				if(arr[low]<=arr[high]) {
					return low;
				}
				int mid=low+(high-low)/2;
				int prev=(mid-1)%n;
				int next=(mid+1)%n;
				if(arr[mid]<=arr[prev]&&arr[next]<=arr[next])
					return mid;
				else if(arr[mid]>=arr[low]) 
					low=mid+1;
				else
					high=mid-1;
				
			}
			return -1;
		}
		//search rotated array
		static int searchRotated(int arr[],int key) {
			int n=arr.length;
			int start=0;
			int end=n-1;
			while(start<=end) {
				int mid=start+(end-start)/2;
				if(arr[mid]==key)
					return mid;
				else if(arr[mid]>=arr[start]) {
					if(arr[mid]>key && arr[start]<=key)
						end=mid-1;
					else
						start=mid+1;
				}
				else {
					if(arr[mid]<key && arr[end]>=key)
						start=mid+1;
					else
						end=mid-1;
				}
			}
			return -1;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] a= {1,2,3,4,5,10,10,10,10,10,10,12,14,16,18,20,22,23};
			int[] a1= {12,14,16,18,20,22,23,1,2,3,4,5,10};
			System.out.println("index of 22 is at index "+binarySearch(a,22));
			System.out.println("first occurrence  of 10 is at index "+binarySearchfirst(a,10));
			System.out.println("last occurrence  of 10 is at index "+binarySearchlast(a,10));
			System.out.println("Total occurrence  of 10 :"+countOccurrence(a,10));
			System.out.println("Array Rotated :"+countRotation(a1)+" times");
			System.out.println("3 occurred at index : "+searchRotated(a1,3));
			
			
	}

}
