class Solution {
  public int minimumRounds(int[] tasks) {
      int n = tasks.length;

      HashMap<Integer , Integer> map = new HashMap<>();
      for(int val : tasks) {
          map.put(val , map.getOrDefault(val , 0) + 1);
      }

      int count = 0;
      int[] dp = new int[n + 1];
      Arrays.fill(dp , -2);

      for(int val : map.values()) {
          int ans = getMinSteps(val , dp);
          if(ans != -1) {
              count += ans;
          } else {
              return ans;
          }
      }

      return count;
  }

  public int getMinSteps(int val , int[] dp) {
      if(val < 2) {
          return dp[val] = -1;
      }

      if(val == 2 || val == 3) {
          return dp[val] = 1;
      }

      if(dp[val] != -2) {
          return dp[val];
      } 

      int res1 = getMinSteps(val - 2 , dp);
      int res2 = getMinSteps(val - 3 , dp);
      int count1 = (res1 == -1) ? Integer.MAX_VALUE : res1;
      int count2 = (res2 == -1) ? Integer.MAX_VALUE : res2;

      int ans = Math.min(count1 , count2) + 1;
      return dp[val] = ans;
  }
}