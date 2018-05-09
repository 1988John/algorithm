package greedy;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/5.
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            if (prices[i]>=minPrice){
                maxProfit += (prices[i]-minPrice);
            }
            minPrice = prices[i];
        }
        return maxProfit;
    }
}
