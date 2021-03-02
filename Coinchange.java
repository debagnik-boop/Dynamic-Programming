// https://leetcode.com/problems/coin-change/
/*Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1 */
// Code:
class Solution {
    public int coinChange(int[] coins, int amount) {
        int len=amount+1;
        int dp[]=new int[len];
         Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<len;i++){
            for(int x: coins){
                if (x<=i)
                    dp[i]=Math.min(dp[i],dp[i-x]+1);
            }
        }
        if (dp[amount]>amount)
            return -1;
        return dp[amount];
    }
}
