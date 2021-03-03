//Input  : arr[] = {3, 10, 2, 11}
// Answer is 3 -(3,10,11)
//LIS[] = {1, 1, 1, 1} (initially)
/*  Iteration-wise simulation :

    arr[2] > arr[1] {LIS[2] = max(LIS [2], LIS[1]+1)=2}
    arr[3] < arr[1] {No change}
    arr[3] < arr[2] {No change}
    arr[4] > arr[1] {LIS[4] = max(LIS [4], LIS[1]+1)=2}
    arr[4] > arr[2] {LIS[4] = max(LIS [4], LIS[2]+1)=3}
    arr[4] > arr[3] {LIS[4] = max(LIS [4], LIS[3]+1)=3}
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==1 && nums[0]==0)return 1;
        int dp[]=new int[nums.length];
        Arrays.fill(dp,1);
        int res=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if (nums[j]<nums[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            res=Math.max(dp[i],res);
        }
        return res;
    }
}
