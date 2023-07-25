//solution 1 using Stack
class Solution {
    public int[] plusOne(int[] d) {
        int l=d.length;
        Stack<Integer> s=new Stack<>();
        int carry=0;
        int sum=1;
        for(int i=l-1;i>=0;i--){
            sum=sum+d[i]+carry;
            if(sum>=10){
              //  int temp=sum;
                carry=sum/10;
                sum=sum%10;
            }
            else{
                carry=0;
            }
            s.push(sum);
            sum=0;
           
        }
        if(carry>0)
        s.push(carry);
        int size=s.size();
        int[] res=new int[size] ;
        for(int i=0;i<size;i++){
            res[i]=s.pop();
        }
        return res;
    }
}
