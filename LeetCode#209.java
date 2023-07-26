class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length=nums.length;
        int min=Integer.MAX_VALUE;
        int num=0;
        int sum=0;
        for(int i=0;i<length;i++){
            sum=sum+nums[i];
            while(sum>=target){
                sum=sum-nums[num]; 
                min=Math.min(min,(i-num+1)); 
                num++;
            }         
        }
        if(sum==target && num==0)
        return length;
        if(num==0)
        return 0;
        return min;
    }
}
