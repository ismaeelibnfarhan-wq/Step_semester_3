package main.java.week_4.class_problems;
public class beststock {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0]; 
        int maxProfit = 0;

        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update the minimum price
            }
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit; // Update the maximum profit
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println("Maximum profit: " + profit);
    }
}
