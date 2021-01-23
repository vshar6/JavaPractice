import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;



// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

public class FinalPrices {



    public static int[] finalPrices(int[] prices) {

        //int[] helperArray = new int[prices.length];

        //LinkedHashMap<Integer, Integer> discountMap = new LinkedHashMap<>();
        int counter =0;

            while(counter < prices.length) {
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

                if(discountFound) {
                    prices[counter]=prices[counter] - discountForThisPrice;
                }
                counter ++;
            }
            //Practice.printArray(prices);


        Practice.printArray(prices);
        return prices;
    }

    public static void main(String [] args) {
        int[] array = {9,9,10};//{3,2,4,5,66,7,5,44,6,3};

        int[] prices = {1,2,3,4,5,6,7};
        finalPrices(array);
        //System.out.println(arePricesSorted(prices));

    }

//    private static int[] ifPricesSorted(int[] prices) {
//        for(int i=1;i<prices.length;i++) {
//            if(prices[i-1]>prices[i]) {
//                return false;
//            }
//        }
//
//        return true;
//    }
/*
* while(counter < prices.length) {
                //int currentPrice = prices[counter];
                int discountForThisPrice = 0;
                boolean noDiscountFound = true;
                for(int i=counter+1;i<prices.length;i++) {
                    if(prices[counter] > prices[i]) {
                        discountMap.put(prices[counter],prices[i]);
                        noDiscountFound=false;
                        break;
                    }

                }
                if(noDiscountFound) {
                    discountMap.put(prices[counter],prices[counter]);
                } else {
                    discountMap.put(prices[counter],prices[counter]);
                }
                counter++;
            }
            counter=0;
            System.out.println(discountMap);

        }

        for(Map.Entry<Integer, Integer> discountEntry :discountMap.entrySet()) {

            int discount =discountEntry.getKey()-discountEntry.getValue();
            prices[counter]=discount==0?discountEntry.getKey():discount;
            counter++;

        }
        Practice.printArray(prices);
        return prices;
    }

    private static boolean arePricesSorted(int[] prices) {
        for(int i=1;i<prices.length;i++) {
            if(prices[i-1]>prices[i]) {
                return false;
            }
        }

        return true;
    }
    * */
}
