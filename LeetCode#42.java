//Space Complexity O(2n)  two extra arrays

class Solution {
    public int trap(int[] height) {
        int l=height.length;
        int[] lmax=new int[l];
        int[] rmax=new int[l];
        lmax[0]=0;
        rmax[l-1]=0;
        int sum=0;
        for(int i=1;i<l;i++){
            if(height[i-1]>lmax[i-1])
            lmax[i]=height[i-1];
            else
            lmax[i]=lmax[i-1];
           
            if(height[l-i]>rmax[l-i])
            rmax[l-i-1]=height[l-i];
            else
            rmax[l-i-1]=rmax[l-i];
           
        } 
        for(int i=0;i<l;i++){
            int temp=Math.min(lmax[i],rmax[i])-height[i];
            if(temp<0)
            temp=0;
            sum=sum+temp;
            
        }
        return sum;
    }
}

// O(1) space 
class Solution {
    public int trap(int[] height) {
        int l=height.length;
        if(l==1)
        return 0;
        int lmax=height[0];
        int rmax=height[l-1];
        int res=0;
        int lpoit=0;
        int rpoit=l-1;
        while(rpoit>lpoit){
            if(lmax<rmax){
                lpoit++;
                lmax=Math.max(lmax,height[lpoit]);
                res+=lmax-height[lpoit];
            }
            else
            {
                rpoit--;
                rmax=Math.max(rmax,height[rpoit]);
                res+=rmax-height[rpoit];
            
            }
        }
        return res;

    }
}


