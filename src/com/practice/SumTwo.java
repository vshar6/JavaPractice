package com.walmart;

import java.util.*;
import java.util.stream.Collectors;


public class SumTwo {


    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //You can return the answer in any order.

    public static int [] returnAddends(int[] array, int target) {

        for(int iterator=0;iterator<array.length;iterator++) {
            int newTarget = target - array[iterator];
            System.out.println("number to search in the array:"+newTarget);

            for(int arrayIterator=0;iterator!=arrayIterator && arrayIterator<array.length;arrayIterator++) {
                if(array[arrayIterator]==newTarget) {
                    System.out.println("target achieved:"+array[arrayIterator]+","+array[iterator]);
                    return new int []{array[arrayIterator],array[iterator]};
                }
            }

        }
        return null;
    }


    public static int [] returnTargetNumbers(int[] array, int target) {

        for(int i = 0;i<array.length;i++) {
            for(int j=1;j!=i && j< array.length -1; j++) {
                int sum = array[i] + array[j];
                if (sum == target) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    public static int reverse(int number) {
        try {
            if (number > 0) {
                if (number > Math.pow(2, 31) || number < Math.pow(2, -31)) {
                    return 0;
                }
                StringBuilder numberString = new StringBuilder(String.valueOf(number));
                return Integer.valueOf(numberString.reverse().toString()).intValue();
            } else if (number < 0) {
                StringBuilder numberString = new StringBuilder(String.valueOf(0 - number));
                return 0 - Integer.valueOf(numberString.reverse().toString()).intValue();
            }

        }catch(NumberFormatException ex)  {

        }
        return 0;


    }

    public static boolean isNumber(String s) {
        String trimmedString = s.trim();

        if(trimmedString.contains("e")) {
            //Pattern ePattern = Pattern.compile("[^e]*e");
            //Matcher matcher = ePattern.matcher(s);

            int charCount = trimmedString.length() - trimmedString.replaceAll("e", "").length();
            //int decimalCount = trimmedString.length() - trimmedString.replaceAll(".", "").length();
//            int count =0;
//
//            while(matcher.find()) {
//                count++;
//            }
            if(charCount > 1 ) {
                System.out.println("Inside this check");
                return false;
            }
            try {
                Double.parseDouble(trimmedString);
                System.out.println("Here");
                return true;
            } catch(NumberFormatException ex) {
                System.out.println("Exception");
                return false;
            }

        } else {
            if(trimmedString.startsWith("-") || trimmedString.startsWith("+") || trimmedString.startsWith("/")) {
                trimmedString = trimmedString.substring(1);
            }
            if(trimmedString.startsWith(".") && trimmedString.length() > 1 ) {
                trimmedString = "0"+trimmedString;
            } else if(trimmedString.endsWith(".") && trimmedString.length() > 1 ) {
                trimmedString = trimmedString+ "0";
            }
            if(!trimmedString.matches("[0-9]+(\\.[0-9]*)?")) {
                System.out.println("Invalid String");
                return false;
            }

            System.out.println("in the else part");
            try {
                Double.parseDouble(trimmedString);
                System.out.println("Here");
                return true;
            } catch(NumberFormatException ex) {
                System.out.println("Exception");
                return false;
            }
        }
    }

    public static boolean checkPossibility(int[] nums) {
        int countofNonDecreasingElements = 0;

        if(nums.length <= 1 || nums.length > Math.pow(10,4)) {
            System.out.println("Invalid array size:"+nums.length);
            return false;
        }
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] > Math.pow(10,5) || nums[i] < Math.pow(-10,5)  ) {
                System.out.println("Invalid index:"+nums[i]);
                return false;
            }
            if(countofNonDecreasingElements > 1) {
                System.out.println("more than one non decreasing number found:");
                return false;
            }
            System.out.println("nums[i]="+nums[i]);
            System.out.println("nums[i+1]="+nums[i+1]);
            if(nums[i] <= nums[i+1]) {
                System.out.println("non-decreasing array pattern:"+nums[i]+","+nums[i+1]);
//                if((i+2)<nums.length && nums[i]>=nums[i+2]) {
//                    countofNonDecreasingElements++;
//                    //i++;
//                }
            } else {
                if(i>0 && nums[i-1]>nums[i+1]) {
                    nums[i]=nums[i-1];
                    System.out.println("found a non decreasing number:"+nums[i+1]);
                    //countofNonDecreasingElements++;
                } else {
                    nums[i+1]=nums[i];
                }

                countofNonDecreasingElements++;

               // System.out.println("found a non decreasing number:"+nums[i]);
            }
        }
        if(countofNonDecreasingElements <= 1) {
            return true;
        }
        return false;
    }

    private static boolean checkPossibilities(int[] arr) {
        int count=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if( arr[i]>arr[i+1] )
            {
                if(i>0)
                {
                    if(arr[i-1]<=arr[i+1])
                        arr[i]=arr[i-1];
                    else
                        arr[i+1]=arr[i];
                }
                count++;
                if(count>1)
                    return false;
            }
        }
        return true;
    }

    public static int lengthOfLastWord(String s) {
//        if(s.trim().length()==0) {
//            return 0;
//        }
        //String[] words = s.split(" ");
        //System.out.println("words.length"+words.length+":");
        return  s.trim().length()==0 || s.split(" ").length==0?0:s.split(" ")[s.split(" ").length-1].length();
//        List<String> words = Arrays.asList(s.split(" "));
//        if(words.size()>0) {
//            String lastWord = words.get(words.size()-1);
//            return lastWord.length();
//        } else {
//            return 0;
//        }

    }

    public static String thousandSeparator(int n) {
        String number = String.valueOf(n);
        String returnString = "";
        while(number.length()>=0) {
            if(number.length() <= 3) {
                returnString=number+returnString;
                return returnString;
            }
            returnString = number.substring(number.length()-3)+returnString;
            number = number.substring(0,number.length()-3);
            returnString = "."+returnString;
        }


        return returnString;
    }



    public static String decodeAtIndex(String s, int K) {
        if(s.length()>=2 && s.length()<=100) {
            char [] characters=s.toCharArray();
            String decodedString="";
            for(Character character: characters) {
                if(decodedString.length() <= K) {
                    if(Character.isDigit(character)) {

                        int integerCharacterValue = Integer.parseInt(String.valueOf(character));
                        String sequenceToAdd=decodedString;
                        while(integerCharacterValue!=1) {

                            K%=decodedString.length();
                            decodedString= decodedString + sequenceToAdd;
                            integerCharacterValue-- ;
                            if(decodedString.length() >= K) {
                                break;
                            }
                        }

                    } else {
                        decodedString = decodedString+ character;
                    }
                } else {
                    break;
                }
            }


            System.out.println(decodedString);
            K=K-1;
            //System.out.println("character at:"+K+":"+decodedString.charAt(K));
            return String.valueOf(decodedString.charAt(K));
        } else {
            return null;
        }


    }
    public static int gcdOfIntegers(int a, int b) {
        while(b!=0) {
           int tmp = a;
           a=b;
            b = tmp % b;
        }
        return a;
    }

    protected static void printArray(int[] args) {
        for(int i=0;i<args.length; i++) {
            System.out.print(args[i]+",");
        }
    }


    protected static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean buddyStrings(String A, String B) {
        //List<Integer> indexes = new ArrayList<>();
        int [] indexes = new int[26];
        int uniqueCharacters=0;
        boolean isDuplicateCharacterPresent= false;
        if(A.length() != B.length()) {
            return false;
        } else {
             if(A.length() <= 1) {
                return false;
            }
            for(int i=0;i<A.length();i++) {
                //count[A.charAt(i) - 'a']++;

                //int x = A.charAt(i) - 'a';

                if(A.charAt(i) != B.charAt(i)) {
                    indexes[A.charAt(i) - 'a']++;
                }
                if(indexes[0]>1) {
                    return false;
                }
                for(int j =i+1;j<A.length()-1;j++) {
                    if (A.charAt(i)==A.charAt(j)) {
                        isDuplicateCharacterPresent=true;
                        break;
                    }
                }
            }

            if(indexes.length==0) {
                if(isDuplicateCharacterPresent) {
                    return true;
                }
                for(int j=1;j < A.length();j++) {
                    if(A.charAt(j-1)!=A.charAt(j) || B.charAt(j-1)!=B.charAt(j)) {
                        return false;
                    }
                }
                return true;
            }  if(indexes.length==1) {
                return false;
            }

            if(A.charAt(indexes[0])==(B.charAt(indexes[1])) && A.charAt(indexes[1])==(B.charAt(indexes[10]))) {
                return true;
            }

        }
        return false;
    }

    private int getMax(int [] array) {
        int max = 0;

        for(int i=0;i<array.length;i++) {
            if(array[max] < array[i]) {
                max=i;
            }
        }

        System.out.println("largest in the array:"+array[max]);

        return max;
    }

    public static int[] replaceElements(int[] arr) {
         for(int i=0;i<arr.length-1;i++) {
            int indexOfGreatestInSubArray = i+1;
            for(int j=i+1; j<arr.length; j++) { //find the largest in the subarray
                if(arr[indexOfGreatestInSubArray] < arr[j]) {
                    indexOfGreatestInSubArray = j;
                }
            }

            arr[i] = arr[indexOfGreatestInSubArray];
        }
         arr[arr.length-1] = -1;

        printArray(arr);
        return arr;
    }

    private static int []replaceElementx(int[] arr) {

        int max = arr[arr.length-1];
        //int newmax = 0;
        int [] replacedArray = new int[arr.length];
        for(int i =arr.length-1; i>=0  ;i--) {
            replacedArray[i]=max;
            if(max < arr[i]) {
                max=arr[i];
            }

        }
        replacedArray[replacedArray.length-1] = -1;
        //printArray(arr);
        return replacedArray;
    }

    public int[] ReplaceElementx(int[] arr) {
        int oldmax = -1;
        int newmax = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            newmax = Math.max(arr[i], oldmax);
            arr[i] = oldmax;
            if(newmax > oldmax) oldmax = newmax;
        }
        printArray(arr);
        return arr;
    }
    public static int[] replaceElement(int[] arr) {
        int l=arr.length;
        int nge[]=new int[l];
        int max=-1;
        for(int i=l-1;i>=0;i--){
            nge[i]=max;
            max=(arr[i]>max)?arr[i]:max;
        }

        //printArray(arr);
        return nge;
    }

    public static int[] sumZero(int n) {
        boolean isEven = false;

        int[] sumZeroArray = new int [n];
        //int remainingCounters = n;
        int totalSum = 0;
        if(n==1) {
            sumZeroArray[0] = 0;
        } else {
            for(int i = 0;i<n-1;i++) {
                sumZeroArray[i] = 1+i;
                totalSum = sumZeroArray[i] + totalSum;
            }
            sumZeroArray[n-1] = -totalSum;
        }

            printArray(sumZeroArray);
            return  sumZeroArray;

        }


    public static int uniqueMorseRepresentations(String [] words) {
        String [] morseCodeArray = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Map<Character, String> alphabetMap = new WeakHashMap<Character, String>();
        int i = 0;
        for(char c = 'a';c<='z';c++) {
            alphabetMap.put(c,morseCodeArray[i]);
            i++;
        }



        int uniqueCount = 1;
        String morseValue = "";
        //Set<String> morseSet = new HashSet<>();
        for(final String word: words) {
            String wordMorseValue = "";
            //System.out.println("word:"+word);
            for(char alphabet: word.toCharArray()) {
                //System.out.println("alphabet:"+alphabet+"map:");

                wordMorseValue = wordMorseValue + alphabetMap.get(String.valueOf(alphabet));
           }
//            "gin" -> "--...-."
//            "zen" -> "--...-."
//            "gig" -> "--...--."
//            "msg" -> "--...--."
            //morseSet.add(wordMorseValue);
            //System.out.println("uniqueCount:"+uniqueCount+",morseValue:"+morseValue+",wordMorseValue:"+wordMorseValue);
            if(morseValue == "") {
                morseValue = wordMorseValue;
            }
            if(! wordMorseValue.equals(morseValue)) {
                //System.out.println("word:"+word+",morseValue:"+morseValue+",wordMorseValue:"+wordMorseValue);
                uniqueCount ++;
                morseValue = wordMorseValue;

                System.out.println("uniqueCount:"+uniqueCount);
            }

            System.out.println("word:"+word+",morseValue:"+morseValue+",wordMorseValue:"+wordMorseValue);

        }

        return uniqueCount;
    }

    public static int uniqueMorseRepresentation(String [] words) {
        String [] morseCodeArray = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Map<Character, String> alphabetMap = new HashMap<Character, String>();
        int i = 0;
        for(char c = 'a';c<='z';c++) {
            alphabetMap.put(c,morseCodeArray[i]);
            i++;
        }

        //String [] wordsInMorseCode = new String[words.length];
        i=0;
        for(final String word: words) {
            String wordMorseValue = "";

            for(char alphabet: word.toCharArray()) {
                wordMorseValue = wordMorseValue + alphabetMap.get(alphabet);
            }
            words[i] = wordMorseValue;
        }
        int uniqueCount = 0;
        for(int j = words.length - 1; j >= 0; j--) {

            if(words[j]!=words[j-1]) {
                words[j-1] = words[j];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    public static int thirdMax(int[] nums) {

        int thirdMax = 0;

        HashSet<Integer> numbers = new HashSet<>();

       for(int number:nums) {
           numbers.add(number);
       }

       List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
       System.out.println("sorted numbers:"+sortedNumbers);
       if(sortedNumbers.size()<=2) {
           thirdMax = sortedNumbers.get(0);
       } else if(sortedNumbers.size()>2) {
           thirdMax= sortedNumbers.get(sortedNumbers.size()-3);
       }

        return thirdMax;
    }

    public static int getNMax(int [] array) {


            int max = 0;
            int maxIndex = 0;

            //Set<Integer> numbers = new HashSet<>();
            List<Integer> numbers = new ArrayList<>();
            for(int number:array) {
                if(!numbers.contains(number)) {
                    numbers.add(number);
                }
            }
            if(numbers.size()==2) {
                return numbers.get(0)<numbers.get(1)?numbers.get(1):numbers.get(0);
            } else if(numbers.size()==1) {
                return numbers.get(0);
            }
            for(maxIndex=0;maxIndex<3;maxIndex++) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(max) <= numbers.get(i)) {
                        max = i;
                    }
                }

                if(maxIndex==2) {
                    break;
                } else {
                    if(numbers.size() >= 2) {
                        numbers.remove(max);
                        max=0;
                    }  else {
                        break;
                    }
                }
            }
            System.out.println("3rd largest:"+numbers.get(max));
            return numbers.get(max);

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int elem: nums){
            if(!pq.contains(elem)){
                if(pq.size() < k)
                    pq.add(elem);
                else{
                    pq.add(elem);
                    pq.poll();
                }
            }
        }
        if(pq.size()<k){
            while(pq.size()>1)
                pq.poll();
        }
        return pq.peek();
    }

    public static boolean isAdditiveNumber(String number) {

        boolean isAdditive = false;
        if (number.length() < 3) {
            return false;
        }
        for (int i = 0; i <= number.length() / 2; i++) {

            if (number.charAt(0) == '0' && i > 0) {
                break;
            }
            int addendOne = Integer.parseInt(number.substring(0, i + 1));

            for(int j = i+1;j<number.length() - i-1; j++) {
                int startIndexOfSum = j+1;
                if(number.length()==startIndexOfSum) {
                    isAdditive = true;
                    return isAdditive;
                } else {
                    int addendTwo = Integer.parseInt(number.substring(i+1,startIndexOfSum));
                    int sum =addendOne + addendTwo;
                    int lengthOfSum = Math.max(String.valueOf(addendOne).length(),String.valueOf(addendTwo).length()) + 1;
                    for(int k = 1;k<=lengthOfSum;k++)
                        if((startIndexOfSum+k)<number.length() && sum == Integer.parseInt(number.substring(startIndexOfSum,startIndexOfSum+k))) {
                            isAdditive= true;
                            addendOne = addendTwo;
                            sum=addendTwo;
                            startIndexOfSum=startIndexOfSum+k;
                        } else {
                            isAdditive = false;
                        }
                }
            }

        }

        if(isAdditive) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean canConvertString(String s, String t, int k) {
        if(s.equals(t)) {
            return true;
        }
        char [] firstCharArray = s.toCharArray();
        char [] secondCharArray = t.toCharArray();

        int [] diffIndexes = new int [firstCharArray.length];
        Set<Integer> setOfPasses = new HashSet<>();

        setOfPasses.add(0);
        //store dissimilar indexes
        if(firstCharArray.length != secondCharArray.length || k<firstCharArray.length) {
            return false;
        }

        //aab bbb
        for(int i = 0;i < firstCharArray.length;i++) {
            diffIndexes[i] = secondCharArray[i]-firstCharArray[i];
            System.out.println("for i="+i+", difference between "+secondCharArray[i]+" and "+firstCharArray[i]+" is "+diffIndexes[i]);
            if(diffIndexes[i] < 0) {
                if(26 - diffIndexes[i] <= k) {
                    setOfPasses.add(26-diffIndexes[i]);
                } else {
                    System.out.println(diffIndexes[i]+" pass is greater than the allowed number of passes:"+k);
                    return false;
                }
            }
            else if((diffIndexes[i]!=0) && setOfPasses.contains(diffIndexes[i])) {
                System.out.println(diffIndexes[i] + " pass has already been executed, it can not be executed again");
                return false;
            } else if(diffIndexes[i] > k) {
                System.out.println(diffIndexes[i]+" pass is greater than the allowed number of passes:"+k);
                return false;
           } else {
                setOfPasses.add(diffIndexes[i]);
            }
        }
        return true;

    }

    public static boolean oneEditInsert(String s1, String s2) {

        int index1 = 0;
        int index2 = 0;
        while(index1 <s1.length() && index2< s2.length()) {
            if(s1.charAt(index1)!=s2.charAt(index2)) {
                if(index1!=index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean oneEditAway(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        int diffCount =0;
        while(index1 <s1.length() && index2< s2.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                diffCount++;
                if(diffCount>1) {
                    return false;
                }
            } else {
                return true;
            }

        }
        return true;
    }

    public static String stringCompression(String str) {
        StringBuilder compressedString = new StringBuilder();
        Hashtable<Character, Integer> compressionMap  = new Hashtable<>();

        for(int i=0;i<str.length();i++) {
            if(null==compressionMap.get(str.charAt(i))) {
                compressionMap.put(str.charAt(i),1);
            } else {
                compressionMap.put(str.charAt(i),compressionMap.get(str.charAt(i))+1);
            }
        }

        for(Map.Entry<Character, Integer> entry: compressionMap.entrySet()) {
            compressedString.append(entry.getKey()).append(entry.getValue());
        }

        System.out.println("map:"+compressionMap);
        System.out.println("compressedString:"+compressedString);

        return compressedString.toString();
    }

//    public static int countWays(int n) {
//        if(n < 0) {
//            return 0;
//        } else if(n ==0) {
//            return 1;
//        }
//        else {
//            int count = countWays(n-1)+countWays(n-2)+ countWays(n-3);
//            System.out.println("count:"+count);
//            return count;
//        }
//
//
//    }

    public static int countWays(int n) {
        int [] memArray = new int[n+1];
        Arrays.fill(memArray,-1);
        return cachedCountWays(n,memArray);
    }

    public static int cachedCountWays(int n, int [] memArray) {
        if(n < 0) {
            return 0;
        } else if(n ==0) {
            return 1;
        } else if(memArray[n]>-1) {
            return memArray[n];
        }

        memArray[n]= cachedCountWays(n-1,memArray)+cachedCountWays(n-2,memArray)+cachedCountWays(n-3,memArray);
        return memArray[n];
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;

        if(set.size()==index) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else {

            allSubsets = getSubsets(set, index + 1);
            System.out.println(allSubsets);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }

        //System.out.println(allSubsets);
        return allSubsets;

    }

    public static int multiplyWithoutAsterisk(int number, int multiplier) { //number = 15, multiplier = 5 -> answer = 75
        System.out.println("Enter:"+System.currentTimeMillis());
        return multiplyWithoutAsteriskTemp(number,multiplier,1);
    }

    private static int multiplyWithoutAsteriskTemp(int number, int multiplier, int tempMultiplier) {
        if (multiplier == tempMultiplier) {
            System.out.println("Exit:" + System.currentTimeMillis());
            return number;
        }
        if (tempMultiplier == 0) {
            tempMultiplier = 1;
        } else {
            number = number + (number >> tempMultiplier);
            tempMultiplier++;
        }
        return multiplyWithoutAsteriskTemp(number, multiplier, tempMultiplier);
    }

    private static void swap(int first, int second) {
        int temp=first;
        first = second;
        second=temp;
    }

    public static void main(String [] args) {
        int[] array = {11,2,4,65,32,22,9,44,31}; //{3,2,3,1,2,4,5,5,6};//
        int target = 6;

        String [] words = {"zocd","gjkl","hzqk","hzgq","gjkl"};//{"gin", "zen", "gig", "msg"}; //"zocd","gjkl","hzqk","hzgq","gjkl"
        ArrayList<Integer> set = new ArrayList<>(){{add(1);add(2);add(3);}};
        String first = "ple";
        String second = "pale";
        char a = 'a';
        char b = 'b';

        MergeSort.mergeSort(array);
        //System.out.println(multiplyWithoutAsterisk(16000,5000));
        //getSubsets(set,0);
        //System.out.println(countWays(1000));
        //stringCompression("aaaaabbdbddgggggeejejeeeooksssuueee");
        //System.out.println(oneEditInsert(first,second));
        //System.out.println("result:"+(a-b));)
        //System.out.println(canConvertString("ixlbrogzj","rrawkdyhd",28));
        //System.out.println(reverse(0));
        //System.out.println(isNumber("84656e656D"));
       // System.out.println(lengthOfLastWord("Hello World"));
       // System.out.println(thousandSeparator(110));
        //System.out.println(decodeAtIndex("apple3",6));
        //System.out.println(gcdOfIntegers(20,8));
       // printArray(replaceElementx(array));
       // bubbleSort(array);
        //selectionSort(array);
        //insertionSort(array);
        //shellSort(array);
        //partition(array);
        //System.out.println(partition(array,0,array.length-1));
        //sumZero(1);
       // System.out.println("Unique Count:"+uniqueMorseRepresentation(words));
        //System.out.println("Third max:"+getNMax(array));
        //System.out.println("3rd largest:"+findKthLargest(array,3));
        //replaceElement(array);
        //System.out.println(buddyStrings(first,second));
        //System.out.println(isAdditiveNumber("199100199"));

        //System.out.println("vikrant".charAt());
        //System.out.println(checkPossibilities(array));
        //System.out.println(returnTargetNumbers(array,target));
    }

}
