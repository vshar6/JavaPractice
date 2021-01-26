import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/*
* The program converts Integer to its english representation
* https://leetcode.com/problems/integer-to-english-words/submissions/
* */

public class EnglishInteger {

    Map<Character, String> unitEnglish = new HashMap<>();
    //Map<Integer, String> smallsMap = new HashMap<>();
    Map<String, String> tensEnglish = new HashMap<>();
    Map<Character, String> hundredsEnglish = new HashMap<>();
    Map<Integer, String> digitsInBracket = new TreeMap<>(Collections.reverseOrder());

public EnglishInteger() {
    unitEnglish.put('1',"One");
    unitEnglish.put('2',"Two");
    unitEnglish.put('3',"Three");
    unitEnglish.put('4',"Four");
    unitEnglish.put('5',"Five");
    unitEnglish.put('6',"Six");
    unitEnglish.put('7',"Seven");
    unitEnglish.put('8',"Eight");
    unitEnglish.put('9',"Nine");
    unitEnglish.put('0',"Ten");

    //tensEnglish.put("0","");
    tensEnglish.put("2","Twenty");
    tensEnglish.put("3","Thirty");
    tensEnglish.put("4","Forty");
    tensEnglish.put("5","Fifty");
    tensEnglish.put("6","Sixty");
    tensEnglish.put("7","Seventy");
    tensEnglish.put("8","Eighty");
    tensEnglish.put("9","Ninety");
    tensEnglish.put("10","Ten");
    tensEnglish.put("11","Eleven");
    tensEnglish.put("12","Twelve");
    tensEnglish.put("13","Thirteen");
    tensEnglish.put("14","Fourteen");
    tensEnglish.put("15","Fifteen");
    tensEnglish.put("16","Sixteen");
    tensEnglish.put("17","Seventeen");
    tensEnglish.put("18","Eighteen");
    tensEnglish.put("19","Nineteen");

    hundredsEnglish.put('1',"One Hundred");
    hundredsEnglish.put('2',"Two Hundred");
    hundredsEnglish.put('3',"Three Hundred");
    hundredsEnglish.put('4',"Four Hundred");
    hundredsEnglish.put('5',"Five Hundred");
    hundredsEnglish.put('6',"Six Hundred");
    hundredsEnglish.put('7',"Seven Hundred");
    hundredsEnglish.put('8',"Eight Hundred");
    hundredsEnglish.put('9',"Nine Hundred");


}


    private  String englishValue(String value) {


        populateBracketMap(value,0);

        System.out.println(digitsInBracket);
        String englishPlaceValue = valueOfNumberInEnglish(digitsInBracket);
        return englishPlaceValue;

    }

    private String numberToWords(int num) {
    if(num==0) {
        return "Zero";
    }
        populateBracketMap(String.valueOf(num),0);

        System.out.println(digitsInBracket);
        String englishPlaceValue = valueOfNumberInEnglish(digitsInBracket).trim();
        return englishPlaceValue.trim();
    }

    public static void main(String [] args) {
        String value = new String("1,000,000,000");
        EnglishInteger e = new EnglishInteger();

       // e.numberToWords(1000000000);
        e.englishValue(value.replaceAll(",",""));
    }

    private String valueOfNumberInEnglish(Map<Integer, String> digitsInBracket) {
        StringBuilder accumulator = new StringBuilder();
        for(Map.Entry<Integer, String> digits : digitsInBracket.entrySet()) {
            if(digits.getKey()==3) {
                getPlaceAndDigitValue(digits.getValue(), accumulator,"Billion");
            }
            else if(digits.getKey()==2) {
                 getPlaceAndDigitValue(digits.getValue(), accumulator,"Million");
            } else if(digits.getKey()==1) {
                 getPlaceAndDigitValue(digits.getValue(), accumulator,"Thousand");
            } else {
                getPlaceAndDigitValue(digits.getValue(), accumulator, "");
            }
        }

        System.out.println(accumulator);
        return accumulator.toString();
    }

    private String getPlaceAndDigitValue(String digitValue, StringBuilder accumulator, String placeValue) {

        if(digitValue.length() == 3) {
            if(digitValue.charAt(0)!='0') {
                accumulator.append(hundredsEnglish.get(digitValue.charAt(0))).append(" ");
            }
            String tensValue = digitValue.substring(1);
            if(tensEnglish.containsKey(tensValue)) {
                accumulator.append(tensEnglish.get(tensValue)).append(" ");
            } else {
                 tensValue = digitValue.substring(1,2);
                if(!tensValue.equals("0")) {
                    accumulator.append(tensEnglish.get(tensValue)).append(" ");
                }
                char unitValue = digitValue.substring(2).charAt(0);
                if(unitValue != '0') {
                    accumulator.append(unitEnglish.get(unitValue)).append(" ");
                }
            }

        } else if(digitValue.length() == 2) {
            if(tensEnglish.containsKey(digitValue)) {
                accumulator.append(tensEnglish.get(digitValue)).append(" ");
            } else {
                String tensValue = digitValue.substring(0,1);
                if(!tensValue.equals("0")) {
                    accumulator.append(tensEnglish.get(tensValue)).append(" ");
                }
                char unitValue = digitValue.toCharArray()[1];
                if(unitValue != '0') {
                    accumulator.append(unitEnglish.get(unitValue)).append(" ");
                }
            }

        } else {
            accumulator.append(unitEnglish.get(digitValue.charAt(0))).append(" ");
        }
        if(!digitValue.equals("000")) {
            accumulator.append(placeValue).append(" ");
        }

        return accumulator.toString();
    }



    private Map<Integer, String> populateBracketMap(String value, int iteration) {


        if (value.equals("")) {
            return digitsInBracket;
        } else if(value.length() < 3) {
            digitsInBracket.put(iteration, value);
        }
        else {
            String bracket = value.substring(value.length() - 3, value.length());

            value = value.substring(0, value.length() - 3);

            digitsInBracket.put(iteration, bracket);

            iteration++;
            populateBracketMap(value, iteration);
        }

        return digitsInBracket;

    }



}
