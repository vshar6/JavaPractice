import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/*
* The program converts Integer to its english representation
*
* */

public class EnglishInteger {

    Map<Character, String> unitEnglish = new HashMap<>();
    Map<Character, String> tensEnglish = new HashMap<>();
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
    unitEnglish.put('0',"Zero");

    tensEnglish.put('1',"Ten");
    tensEnglish.put('2',"Twenty");
    tensEnglish.put('3',"Thirty");
    tensEnglish.put('4',"Forty");
    tensEnglish.put('5',"Fifty");
    tensEnglish.put('6',"Sixty");
    tensEnglish.put('7',"Seventy");
    tensEnglish.put('8',"Eighty");
    tensEnglish.put('9',"Ninety");

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


    public  String englishValue(String value) {


        populateBracketMap(value,0);

        System.out.println(digitsInBracket);
        String englishPlaceValue = valueOfNumberInEnglish(digitsInBracket);
        return englishPlaceValue;

    }

    public static void main(String [] args) {
        String value = new String("31,456,789");
        EnglishInteger e = new EnglishInteger();
        e.englishValue(value.replaceAll(",",""));
    }

    private String valueOfNumberInEnglish(Map<Integer, String> digitsInBracket) {
        StringBuilder digitValue = new StringBuilder();
        for(Map.Entry<Integer, String> digits : digitsInBracket.entrySet()) {
            if(digits.getKey()==2) {
                 getPlaceAndDigitValue(digits, digitValue, "millions");
            } else if(digits.getKey()==1) {
                 getPlaceAndDigitValue(digits, digitValue, "thousands");
            } else {
                getPlaceAndDigitValue(digits, digitValue, "");
            }
        }

        System.out.println(digitValue);
        return digitValue.toString();
    }

    private String getPlaceAndDigitValue(Map.Entry<Integer, String> digits,  StringBuilder digitValue, String placeValue) {

        if(digits.getValue().length() == 3) {
           digitValue.append(hundredsEnglish.get(digits.getValue().toCharArray()[0])).append(" ")
                   .append(tensEnglish.get(digits.getValue().toCharArray()[1])).append(" ")
                   .append(unitEnglish.get(digits.getValue().toCharArray()[2])).append(" ");
        } else if(digits.getValue().length() == 2) {
            digitValue.append(tensEnglish.get(digits.getValue().toCharArray()[0])).append(" ")
                    .append(unitEnglish.get(digits.getValue().toCharArray()[1])).append(" ");
        } else {
            digitValue.append(unitEnglish.get(digits.getValue().toCharArray()[0])).append(" ");

        }
        digitValue.append(placeValue).append(" ");

        return digitValue.toString();
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
