
// Apporach: bottom dp
// TC = O(m*n)
// SC = O(m*n)

/*
*   decision making parameters are 2: coin denominations & amount
*   => use 2D array 
*       => rows= coins+1 & columns = amount+1
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        //null
        if(coins==null || coins.length == 0) return 0;
        
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int j = 1; j<dp[0].length; j++){
            dp[0][j] = amount +1;       // initialiazing the top row with infinity & by default all other cells are 0
        }
        
        for(int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                // till amount is not equal to denomination                
                if(j < coins[i-1]){     // not choose
                    dp[i][j] = dp[i-1][j];
                }else{
                    // choose
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        
        int result = dp[m][n];
        if(result > amount) //result is infinity
            return -1;
        return result;
    }   
    
}
