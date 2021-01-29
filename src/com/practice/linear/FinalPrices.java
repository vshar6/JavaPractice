package linear;


// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

public class FinalPrices {


    public static int[] finalPrices(int[] prices) {

        //int[] helperArray = new int[prices.length];

        //LinkedHashMap<Integer, Integer> discountMap = new LinkedHashMap<>();
        int counter = 0;

        while (counter < prices.length) {
            //int currentPrice = prices[counter];
            int discountForThisPrice = 0;
            boolean discountFound = false;
            for (int i = counter + 1; i < prices.length; i++) {
                if (prices[counter] >= prices[i]) {
                    //discountMap.put(prices[counter], prices[i]);
                    discountForThisPrice = prices[i];
                    discountFound = true;
                    break;
                }
            }

            if (discountFound) {
                prices[counter] = prices[counter] - discountForThisPrice;
            }
            counter++;
        }
        //array.Practice.printArray(prices);


        Practice.printArray(prices);
        return prices;
    }

    public static void main(String[] args) {
        int[] array = {9, 9, 10};//{3,2,4,5,66,7,5,44,6,3};

        int[] prices = {1, 2, 3, 4, 5, 6, 7};
        finalPrices(array);
        //System.out.println(arePricesSorted(prices));

    }
}