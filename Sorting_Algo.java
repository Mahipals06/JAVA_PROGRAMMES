

public class Sorting_Arrays {
	//selection sort
	//in-place sorting algorithm
	//find minimum and put it at first place
	static int[] Selectionsort(int arr[]) {
		int l=arr.length;
	
		int minindex=0;
		for(int i=0;i<l;i++) {
			int min=arr[i];
			for(int j=i;j<l;j++) {
				if(min>=arr[j]) {
					minindex=j;
					min=arr[j];
				}
			}
			int temp=arr[i];
			arr[i]=min;
			arr[minindex]=temp;
		}
		return arr;
	}
	//bubble sort 
	//stable sorting algo
	//in-place 
	//swap elements from nearby is next is smaller
	//eg. [3,2,7,6,4]
	//3 swaps with 2
	//7 swaps with 6 and 4
	//after one loop [2,3,6,4,7]
	static int[] bubbleSort(int[] arr) {
		int n=arr.length;
		for(int k=0;k<n;k++) {
			int flag=0;
			for(int i=0;i<n-k-1;i++) {
				if(arr[i]>arr[i+1])
				{
					int temp=arr[i+1];
					arr[i+1]=arr[i];
					arr[i]=temp;
					flag++;
				}
			}
			if(flag==0)
				break;
		}
		return arr;
	}
	//insertion sort 
	//dividing array into two parts sorted and unsorted
	static int[] insertionSort(int[] arr ) {
		int l=arr.length;
		for(int i=1;i<l;i++) {
			int value=arr[i];
			int hole=i;
			while(hole>0 && value<arr[hole-1]) {
				arr[hole]=arr[hole-1];
				hole--;
			}
			arr[hole]=value;
		}
		return arr;
	}
	//merge sort
	//not in-place
	//recursion
	//divide in to sub-parts recursively and sort then merge back
	static int[] merge(int[] left,int[] right,int[] arr) {
		int ll=left.length;
		int lr=right.length;
		int i=0;
		int j=0;
		int k=0;
		while(i<ll && j<lr) {
			if(left[i]<=right[j]) {
				arr[k]=left[i];
				i++;
				k++;
			}
			else {
				arr[k]=right[j];
				j++;
				k++;
			}
		}
		while(i<ll) {
			arr[k]=left[i];
			i++;
			k++;
		}
		while(j<lr) {
			arr[k]=right[j];
			j++;
			k++;
		}
		return arr;
	}
	static void mergeSort(int[] arr) {
		int n=arr.length;
		int mid=n/2;
		if(n<2)
			return;
		int[] l=new int[mid];
		int[] r=new int[n-mid];
		for(int i=0;i<l.length;i++) {
			l[i]=arr[i];
		}
		for(int i=0;i<r.length;i++) {
			r[i]=arr[mid+i];
		}
		mergeSort(l);
		mergeSort(r);
		merge(l,r,arr);
	}
	//quick sort
	//in place sorting 
	//O(n2)worst case
	//O(nlogn)avg case
	// eg [2,8,5,1,3,7,4]
	//let pivot=4
	//pindex=0 at start
	//2<4 true pindex=1
	//8<4 false pindex=1
	//5<4 false pindex=1
	//1<4 true pindex=2 and swap 1 and 8 now [2,1,5,8,3,7,4]
	//3<4 true pindex=3 and swap 5 and 3 now[2,1,3,8,5,7,4]
	//7<4 false came out if loop
	//now swap pivot with pindex number i.e. [2,1,3,4,5,7,8]
	//and return pindex position of pivot i.e. 4
	//now sub arrays from pivot 
	//not stable
	static int partition(int[] arr,int start,int end) {
		int pivot=arr[end];
		int pIndex=start;
		for(int i=start;i<end;i++) {
			if(arr[i]<=pivot) {
				int temp=arr[i];
				arr[i]=arr[pIndex];
				arr[pIndex]=temp;
				pIndex++;
			}
		}
		int temp=arr[end];
		arr[end]=arr[pIndex];
		arr[pIndex]=temp;;
		
		return pIndex;		
	}
	static void quickSort(int[] arr,int start,int end){
		if(start<end) {
		int pIndex=partition(arr,start,end);
		quickSort(arr,start,pIndex-1);
		quickSort(arr,pIndex+1,end);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {3,2,1,8,9,7,6,5,4};
		quickSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
