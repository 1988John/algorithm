package easy.number;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/28.
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {2,10,4,8,1,6,99,15,3};
//        int maxProfit = maxProfit(prices);
        int point = 2;
        int[] des = new int[prices.length-point];
        System.arraycopy(prices,point,des,0,prices.length-point);
        int indexMax = findArrayMax(des);

        int arrayMin = findArrayMin(des);
        System.out.println(indexMax);
        System.out.println(arrayMin);

    }

    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    /**
     *  O(N*N)
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        int min;
        for(int i=0;i<prices.length-1;i++){
            min = prices[i];
            for(int j=i+1;j<prices.length;j++){

                if(prices[j] - min>profit){
                    profit = prices[j] - min;
                }
            }

        }
        return profit;
    }

    public static int findArrayMax(int[] arr){
        int point = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[point]){
                point = i;
            }
        }
        return point;
    }

    public static int findArrayMin(int[] arr){
        int point = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[point]){
                point = i;
            }
        }
        return point;
    }
}
