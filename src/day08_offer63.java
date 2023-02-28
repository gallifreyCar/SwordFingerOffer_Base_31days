class Solution63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] - prices[j] > max) {
                    max = prices[i] - prices[j];
                }
            }
        }
        return max;
    }

    //dp 动态规划优化
    public int maxProfit2(int[] prices) {
        //利润
        int profit = 0;
        //成本
        int cost = Integer.MAX_VALUE;
        for (int price : prices) {
            profit = Math.max(profit, price - cost);
            cost = Math.min(cost, price);
        }

        return profit;
    }
}

public class day08_offer63 {


    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        int[] arr = {2, 4, 1};
        System.out.println(solution63.maxProfit(arr));
    }

}
