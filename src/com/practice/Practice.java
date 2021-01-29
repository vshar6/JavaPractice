import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.


public class Practice {

    String test = "abcdefgh";


    // String a = new String [] {"66650506","66664142","66664742","66665808","66670608","66671253","66672366","66674089","66681180","66686223","66687538","66690250","66690530","66693156","66701251","66701251","66704877","66713166","66714421","66733250","66733258","66733288","66733291","66733300","66734559","66735256","66735278","66737462","66738258","66738325","66741037","66743510","66743924","66746072","66746259","66746337","66747424","66748122","66751976","66752634","66753354","66759544","66759710","66762985","66764670","66765113","66767713","66767791","66767816","66767867","66767885","66767925","66767931","66768581","66768715","66768856","66768926","66768961","66768964","66769584","66769590","66769623","66769707","66769814","66769841","66769854","66769907","66769944","66770602","66770675","66770688","66770811","66770813","66770819","66770820","66770848","66770849","66770849","66770881","66770948","66770968","66771535","66771556","66771608","66771696","66771751","66771921","66771952","66771967","66772517","66772531","66772557","66772594","66772636","66772652","66772784","66772791","66772834","66772889","66772903","66772913","66772997","66773423","66773442","66773463","66773693","66773760","66773823","66773877","66773895","66774233","66774257","66774598","66774648","66774701","66774768","66774836","66774923","66775260","66775351","66775351","66775354","66775373","66775398","66775428","66775516","66775593","66775596","66775798","66775980","66776202","66776235","66776278","66776404","66776433","66776475","66776478","66776548","66776569","66776655","66776820","66776907","66776907","66776972","66776974","66776990","66777146","66777151","66777231","66777259","66777275","66777325","66777329","66777384","66777409","66777413","66777494","66777531","66777533","66777560","66777657","66777673","66777712","66777737","66777795","66777896","66777929","66778028","66778132","66778137","66778140","66778229","66778390","66778393","66778422","66778438","66778443","66778450","66778468","66778521","66778521","66778565","66778658","66778732","66778852","66778982","66779006","66779037","66779265","66779310","66779356","66779369","66779394","66779408","66779409","66779412","66779417","66779459","66779525","66779676","66779687","66779756","66779850","66779904","66779925","66780157","66780169","66780179","66780330","66780379","66780431","66780535","66780557","66780598","66780682","66780754","66780858","66780897","66780925","66780977","66781089","66781126","66781218","66781244","66781276","66781316","66781480","66781499","66781609","66781622","66781628","66781688","66781763","66781781","66781784","66781850","66781866","66782001","66782149","66782184","66782200","66782212","66782220","66782246","66782315","66782391","66782674","66782679","66782725","66782727","66782781","66782920","66783031","66783041","66783089","66783145","66783187","66783198","66783200","66783206","66783210","66783211","66783241","66783408","66783557","66783557","66783619","66783621","66783689","66783742","66783746","66783764","66783891","66783893","66783909","66783934","66783972","66784007","66784019","66784150","66784224","66784246","66784297","66784371","66784410","66784424","66784431","66784469","66784490","66784538","66784622","66784654","66784720","66784788","66784896","66784978","66785271","66785317","66785336","66785346","66785563","66785644","66785700","66785844","66785923","66786050","66786115","66786242","66786292","66786336","66786425","66786487","66786488","66786598","66786617","66786664","66786707","66786720","66786860","66786937","66787063","66787088","66787098","66787143","66787159","66787171","66787379","66787422","66787429","66787541","66787565","66787566","66787844","66787892","66787971","66788062","66788119","66788123","66788143","66788182","66788185","66788317","66788391","66788642","66788667","66788755","66788780","66788791","66788800","66788823","66788847","66788848","66788855","66788887","66788908","66788918","66788920","66788933","66788934","66788941","66788951","66788969","66788991","66789153","66789170","66789212","66789217","66789234","66789324","66789617","66789626","66789731","66789759","66789760","66789764","66789771","66789795","66789816","66789826","66789827","66789848","66789908","66789913","66789917","66789918","66789994","66790003","66790048","66790139","66790239","66790246","66790396","66790411","66790412","66790420","66790495","66790506","66790528","66790530","66790531","66790555","66790589","66790625","66790659","66790663","66790676","66790687","66790697","66790703","66790711","66790737","66790760","66790792","66790812","66790840","66790855","66790879","66790921","66790937","66790938","66790939","66790942","66790948","66790974","66790979","66790988","66790997","66791185","66791221","66791421","66791447","66791454","66791502","66791508","66791519","66791525","66791545","66791557","66791561","66791589","66791590","66791596","66791615","66791616","66791617","66791620","66791639","66791646","66791750","66791769","66791778","66791785","66791797","66791801","66791813","66791818","66791826","66791832","66791845","66791862","66791879","66791889","66791897","66791904","66791916","66791920","66792079","66792146","66792193","66792287","66792393","66792430","66792449","66792451","66792452","66792460","66792462","66792470","66792476","66792492","66792556","66792562","66792568","66792579","66792592","66792630","66792694","66792704","66792705","66792713","66792719","66792742","66792777","66792798","66792815","66792821","66792836","66792860","66792867","66792874","66793161","66793170","66793311","66793396","66793454","66793458","66793470","66793489","66793494","66793514","66793536","66793626","66793680","66793702","66793733","66793740","66793771","66793774","66793796","66793800","66793843","66793868","66793896","66793897","66793898","66793898","66793912","66793913","66793918","66793919","66793926","66793927","66793937","66793939","66793949","66794061","66794275","66794283","66794288","66794289","66794301","66794302","66794308","66794311","66794340","66794360","66794365","66794371","66794397","66794444","66794453","66794456","66794473","66794478","66794542","66794597","66794617","66794645","66794645","66794677","66794702","66794724","66794725","66794730","66794736","66794746","66795105","66795109","66795217","66795239","66795240","66795251","66795254","66795301","66795330","66795333","66795334","66795435","66795448","66795453","66795505","66795562","66795565","66795567","66795577","66795589","66795595","66795599","66795606","66795608","66795609","66795610","66795611","66795628","66796023","66796024","66796048","66796083","66796108","66796158","66796167","66796171","66796190","66796208","66796209","66796218","66796224","66796236","66796273","66796285","66796306","66796337","66796370","66796385","66796402","66796456","66796460","66796468","66796483","66796506","66796517","66796531","66796540","66796541","66796560","66796568","66796570","66796571","66796574","66796575","66796576","66796578","66796581","66796599","66797006","66797021","66797041","66797075","66797113","66797119","66797129","66797159","66797170","66797177","66797199","66797238","66797239","66797253","66797309","66797329","66797330","66797333","66797346","66797351","66797374","66797379","66797387","66797392","66797411","66797425","66797435","66797441","66797450","66797487","66797497","66797499","66797516","66797528","66797529","66797530","66797534","66797535","66797544","66797547","66797561","66797567","66797607","66798016","66799010","66799014","66800005","66800017","66800028","66801004","66802042","66802059","66802100","66802111","66802117","66802124","66802139","66802152","66802176","66802191","66802199","66802199","66802209","66802211","66802215","66802222","66802226","66802240","66802246","66802257","66803001","66803007","66803018","66803036","66803077","66803087","66803097","66803111","66803112","66803119","66803139","66803165","66803172","66803175","66803189","66803206","66803210"});
    private static void printArray(Object[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + ",");
        }
    }





    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //You can return the answer in any order.

    public static int[] returnAddends(int[] array, int target) {

        for (int iterator = 0; iterator < array.length; iterator++) {
            int newTarget = target - array[iterator];
            System.out.println("number to search in the array:" + newTarget);

            for (int arrayIterator = 0; iterator != arrayIterator && arrayIterator < array.length; arrayIterator++) {
                if (array[arrayIterator] == newTarget) {
                    System.out.println("target achieved:" + array[arrayIterator] + "," + array[iterator]);
                    return new int[]{array[arrayIterator], array[iterator]};
                }
            }

        }
        return null;
    }


    public static int[] returnTargetNumbers(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j != i && j < array.length - 1; j++) {
                int sum = array[i] + array[j];
                if (sum == target) {
                    return new int[]{i, j};
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

        } catch (NumberFormatException ex) {

        }
        return 0;


    }

    public static boolean isNumber(String s) {
        String trimmedString = s.trim();

        if (trimmedString.contains("e")) {
            //Pattern ePattern = Pattern.compile("[^e]*e");
            //Matcher matcher = ePattern.matcher(s);

            int charCount = trimmedString.length() - trimmedString.replaceAll("e", "").length();
            //int decimalCount = trimmedString.length() - trimmedString.replaceAll(".", "").length();
//            int count =0;
//
//            while(matcher.find()) {
//                count++;
//            }
            if (charCount > 1) {
                System.out.println("Inside this check");
                return false;
            }
            try {
                Double.parseDouble(trimmedString);
                System.out.println("Here");
                return true;
            } catch (NumberFormatException ex) {
                System.out.println("Exception");
                return false;
            }

        } else {
            if (trimmedString.startsWith("-") || trimmedString.startsWith("+") || trimmedString.startsWith("/")) {
                trimmedString = trimmedString.substring(1);
            }
            if (trimmedString.startsWith(".") && trimmedString.length() > 1) {
                trimmedString = "0" + trimmedString;
            } else if (trimmedString.endsWith(".") && trimmedString.length() > 1) {
                trimmedString = trimmedString + "0";
            }
            if (!trimmedString.matches("[0-9]+(\\.[0-9]*)?")) {
                System.out.println("Invalid String");
                return false;
            }

            System.out.println("in the else part");
            try {
                Double.parseDouble(trimmedString);
                System.out.println("Here");
                return true;
            } catch (NumberFormatException ex) {
                System.out.println("Exception");
                return false;
            }
        }
    }

    public static boolean checkPossibility(int[] nums) {
        int countofNonDecreasingElements = 0;

        if (nums.length <= 1 || nums.length > Math.pow(10, 4)) {
            System.out.println("Invalid array size:" + nums.length);
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > Math.pow(10, 5) || nums[i] < Math.pow(-10, 5)) {
                System.out.println("Invalid index:" + nums[i]);
                return false;
            }
            if (countofNonDecreasingElements > 1) {
                System.out.println("more than one non decreasing number found:");
                return false;
            }
            System.out.println("nums[i]=" + nums[i]);
            System.out.println("nums[i+1]=" + nums[i + 1]);
            if (nums[i] <= nums[i + 1]) {
                System.out.println("non-decreasing array pattern:" + nums[i] + "," + nums[i + 1]);
//                if((i+2)<nums.length && nums[i]>=nums[i+2]) {
//                    countofNonDecreasingElements++;
//                    //i++;
//                }
            } else {
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i] = nums[i - 1];
                    System.out.println("found a non decreasing number:" + nums[i + 1]);
                    //countofNonDecreasingElements++;
                } else {
                    nums[i + 1] = nums[i];
                }

                countofNonDecreasingElements++;

                // System.out.println("found a non decreasing number:"+nums[i]);
            }
        }
        if (countofNonDecreasingElements <= 1) {
            return true;
        }
        return false;
    }

    private static boolean checkPossibilities(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (i > 0) {
                    if (arr[i - 1] <= arr[i + 1])
                        arr[i] = arr[i - 1];
                    else
                        arr[i + 1] = arr[i];
                }
                count++;
                if (count > 1)
                    return false;
            }
        }
        return true;
    }

    public static int lengthOfLastWord(String s) {
        return s.trim().length() == 0 || s.split(" ").length == 0 ? 0 : s.split(" ")[s.split(" ").length - 1].length();
    }

    public static String thousandSeparator(int n) {
        String number = String.valueOf(n);
        String returnString = "";
        while (number.length() >= 0) {
            if (number.length() <= 3) {
                returnString = number + returnString;
                return returnString;
            }
            returnString = number.substring(number.length() - 3) + returnString;
            number = number.substring(0, number.length() - 3);
            returnString = "." + returnString;
        }


        return returnString;
    }


    public static String decodeAtIndex(String s, int K) {
        if (s.length() >= 2 && s.length() <= 100) {
            char[] characters = s.toCharArray();
            String decodedString = "";
            for (Character character : characters) {
                if (decodedString.length() <= K) {
                    if (Character.isDigit(character)) {

                        int integerCharacterValue = Integer.parseInt(String.valueOf(character));
                        String sequenceToAdd = decodedString;
                        while (integerCharacterValue != 1) {

                            K %= decodedString.length();
                            decodedString = decodedString + sequenceToAdd;
                            integerCharacterValue--;
                            if (decodedString.length() >= K) {
                                break;
                            }
                        }

                    } else {
                        decodedString = decodedString + character;
                    }
                } else {
                    break;
                }
            }


            System.out.println(decodedString);
            K = K - 1;
            //System.out.println("character at:"+K+":"+decodedString.charAt(K));
            return String.valueOf(decodedString.charAt(K));
        } else {
            return null;
        }


    }

    public static int gcdOfIntegers(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    protected static void printArray(int[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + ",");
        }
    }


    protected static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean buddyStrings(String A, String B) {
        //List<Integer> indexes = new ArrayList<>();
        int[] indexes = new int[26];
        int uniqueCharacters = 0;
        boolean isDuplicateCharacterPresent = false;
        if (A.length() != B.length()) {
            return false;
        } else {
            if (A.length() <= 1) {
                return false;
            }
            for (int i = 0; i < A.length(); i++) {
                //count[A.charAt(i) - 'a']++;

                //int x = A.charAt(i) - 'a';

                if (A.charAt(i) != B.charAt(i)) {
                    indexes[A.charAt(i) - 'a']++;
                }
                if (indexes[0] > 1) {
                    return false;
                }
                for (int j = i + 1; j < A.length() - 1; j++) {
                    if (A.charAt(i) == A.charAt(j)) {
                        isDuplicateCharacterPresent = true;
                        break;
                    }
                }
            }

            if (indexes.length == 0) {
                if (isDuplicateCharacterPresent) {
                    return true;
                }
                for (int j = 1; j < A.length(); j++) {
                    if (A.charAt(j - 1) != A.charAt(j) || B.charAt(j - 1) != B.charAt(j)) {
                        return false;
                    }
                }
                return true;
            }
            if (indexes.length == 1) {
                return false;
            }

            if (A.charAt(indexes[0]) == (B.charAt(indexes[1])) && A.charAt(indexes[1]) == (B.charAt(indexes[10]))) {
                return true;
            }

        }
        return false;
    }

    private int getMax(int[] array) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[max] < array[i]) {
                max = i;
            }
        }

        System.out.println("largest in the array:" + array[max]);

        return max;
    }

    public static int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfGreatestInSubArray = i + 1;
            for (int j = i + 1; j < arr.length; j++) { //find the largest in the subarray
                if (arr[indexOfGreatestInSubArray] < arr[j]) {
                    indexOfGreatestInSubArray = j;
                }
            }

            arr[i] = arr[indexOfGreatestInSubArray];
        }
        arr[arr.length - 1] = -1;

        printArray(arr);
        return arr;
    }

    private static int[] replaceElementx(int[] arr) {

        int max = arr[arr.length - 1];
        //int newmax = 0;
        int[] replacedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            replacedArray[i] = max;
            if (max < arr[i]) {
                max = arr[i];
            }

        }
        replacedArray[replacedArray.length - 1] = -1;
        //printArray(arr);
        return replacedArray;
    }

    public int[] ReplaceElementx(int[] arr) {
        int oldmax = -1;
        int newmax = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            newmax = Math.max(arr[i], oldmax);
            arr[i] = oldmax;
            if (newmax > oldmax) oldmax = newmax;
        }
        printArray(arr);
        return arr;
    }

    public static int[] replaceElement(int[] arr) {
        int l = arr.length;
        int nge[] = new int[l];
        int max = -1;
        for (int i = l - 1; i >= 0; i--) {
            nge[i] = max;
            max = (arr[i] > max) ? arr[i] : max;
        }

        //printArray(arr);
        return nge;
    }

    public static int[] sumZero(int n) {
        boolean isEven = false;

        int[] sumZeroArray = new int[n];
        //int remainingCounters = n;
        int totalSum = 0;
        if (n == 1) {
            sumZeroArray[0] = 0;
        } else {
            for (int i = 0; i < n - 1; i++) {
                sumZeroArray[i] = 1 + i;
                totalSum = sumZeroArray[i] + totalSum;
            }
            sumZeroArray[n - 1] = -totalSum;
        }

        printArray(sumZeroArray);
        return sumZeroArray;

    }


    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCodeArray = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Map<Character, String> alphabetMap = new WeakHashMap<Character, String>();
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetMap.put(c, morseCodeArray[i]);
            i++;
        }


        int uniqueCount = 1;
        String morseValue = "";
        //Set<String> morseSet = new HashSet<>();
        for (final String word : words) {
            String wordMorseValue = "";
            //System.out.println("word:"+word);
            for (char alphabet : word.toCharArray()) {
                //System.out.println("alphabet:"+alphabet+"map:");

                wordMorseValue = wordMorseValue + alphabetMap.get(String.valueOf(alphabet));
            }
//            "gin" -> "--...-."
//            "zen" -> "--...-."
//            "gig" -> "--...--."
//            "msg" -> "--...--."
            //morseSet.add(wordMorseValue);
            //System.out.println("uniqueCount:"+uniqueCount+",morseValue:"+morseValue+",wordMorseValue:"+wordMorseValue);
            if (morseValue == "") {
                morseValue = wordMorseValue;
            }
            if (!wordMorseValue.equals(morseValue)) {
                //System.out.println("word:"+word+",morseValue:"+morseValue+",wordMorseValue:"+wordMorseValue);
                uniqueCount++;
                morseValue = wordMorseValue;

                System.out.println("uniqueCount:" + uniqueCount);
            }

            System.out.println("word:" + word + ",morseValue:" + morseValue + ",wordMorseValue:" + wordMorseValue);

        }

        return uniqueCount;
    }

    public static int uniqueMorseRepresentation(String[] words) {
        String[] morseCodeArray = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Map<Character, String> alphabetMap = new HashMap<Character, String>();
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetMap.put(c, morseCodeArray[i]);
            i++;
        }

        //String [] wordsInMorseCode = new String[words.length];
        i = 0;
        for (final String word : words) {
            String wordMorseValue = "";

            for (char alphabet : word.toCharArray()) {
                wordMorseValue = wordMorseValue + alphabetMap.get(alphabet);
            }
            words[i] = wordMorseValue;
        }
        int uniqueCount = 0;
        for (int j = words.length - 1; j >= 0; j--) {

            if (words[j] != words[j - 1]) {
                words[j - 1] = words[j];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    public static int thirdMax(int[] nums) {

        int thirdMax = 0;

        HashSet<Integer> numbers = new HashSet<>();

        for (int number : nums) {
            numbers.add(number);
        }

        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted numbers:" + sortedNumbers);
        if (sortedNumbers.size() <= 2) {
            thirdMax = sortedNumbers.get(0);
        } else if (sortedNumbers.size() > 2) {
            thirdMax = sortedNumbers.get(sortedNumbers.size() - 3);
        }

        return thirdMax;
    }

    public static int getNMax(int[] array) {


        int max = 0;
        int maxIndex = 0;

        //Set<Integer> numbers = new HashSet<>();
        List<Integer> numbers = new ArrayList<>();
        for (int number : array) {
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        if (numbers.size() == 2) {
            return numbers.get(0) < numbers.get(1) ? numbers.get(1) : numbers.get(0);
        } else if (numbers.size() == 1) {
            return numbers.get(0);
        }
        for (maxIndex = 0; maxIndex < 3; maxIndex++) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(max) <= numbers.get(i)) {
                    max = i;
                }
            }

            if (maxIndex == 2) {
                break;
            } else {
                if (numbers.size() >= 2) {
                    numbers.remove(max);
                    max = 0;
                } else {
                    break;
                }
            }
        }
        System.out.println("3rd largest:" + numbers.get(max));
        return numbers.get(max);

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int elem : nums) {
            if (!pq.contains(elem)) {
                if (pq.size() < k)
                    pq.add(elem);
                else {
                    pq.add(elem);
                    pq.poll();
                }
            }
        }
        if (pq.size() < k) {
            while (pq.size() > 1)
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

            for (int j = i + 1; j < number.length() - i - 1; j++) {
                int startIndexOfSum = j + 1;
                if (number.length() == startIndexOfSum) {
                    isAdditive = true;
                    return isAdditive;
                } else {
                    int addendTwo = Integer.parseInt(number.substring(i + 1, startIndexOfSum));
                    int sum = addendOne + addendTwo;
                    int lengthOfSum = Math.max(String.valueOf(addendOne).length(), String.valueOf(addendTwo).length()) + 1;
                    for (int k = 1; k <= lengthOfSum; k++)
                        if ((startIndexOfSum + k) < number.length() && sum == Integer.parseInt(number.substring(startIndexOfSum, startIndexOfSum + k))) {
                            isAdditive = true;
                            addendOne = addendTwo;
                            sum = addendTwo;
                            startIndexOfSum = startIndexOfSum + k;
                        } else {
                            isAdditive = false;
                        }
                }
            }

        }

        if (isAdditive) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean canConvertString(String s, String t, int k) {
        if (s.equals(t)) {
            return true;
        }
        char[] firstCharArray = s.toCharArray();
        char[] secondCharArray = t.toCharArray();

        int[] diffIndexes = new int[firstCharArray.length];
        Set<Integer> setOfPasses = new HashSet<>();

        setOfPasses.add(0);
        //store dissimilar indexes
        if (firstCharArray.length != secondCharArray.length || k < firstCharArray.length) {
            return false;
        }

        //aab bbb
        for (int i = 0; i < firstCharArray.length; i++) {
            diffIndexes[i] = secondCharArray[i] - firstCharArray[i];
            System.out.println("for i=" + i + ", difference between " + secondCharArray[i] + " and " + firstCharArray[i] + " is " + diffIndexes[i]);
            if (diffIndexes[i] < 0) {
                if (26 - diffIndexes[i] <= k) {
                    setOfPasses.add(26 - diffIndexes[i]);
                } else {
                    System.out.println(diffIndexes[i] + " pass is greater than the allowed number of passes:" + k);
                    return false;
                }
            } else if ((diffIndexes[i] != 0) && setOfPasses.contains(diffIndexes[i])) {
                System.out.println(diffIndexes[i] + " pass has already been executed, it can not be executed again");
                return false;
            } else if (diffIndexes[i] > k) {
                System.out.println(diffIndexes[i] + " pass is greater than the allowed number of passes:" + k);
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
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
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
        int diffCount = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                diffCount++;
                if (diffCount > 1) {
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
        Hashtable<Character, Integer> compressionMap = new Hashtable<>();

        for (int i = 0; i < str.length(); i++) {
            if (null == compressionMap.get(str.charAt(i))) {
                compressionMap.put(str.charAt(i), 1);
            } else {
                compressionMap.put(str.charAt(i), compressionMap.get(str.charAt(i)) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : compressionMap.entrySet()) {
            compressedString.append(entry.getKey()).append(entry.getValue());
        }

        System.out.println("map:" + compressionMap);
        System.out.println("compressedString:" + compressedString);

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
        int[] memArray = new int[n + 1];
        Arrays.fill(memArray, -1);
        return cachedCountWays(n, memArray);
    }

    public static int cachedCountWays(int n, int[] memArray) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memArray[n] > -1) {
            return memArray[n];
        }

        memArray[n] = cachedCountWays(n - 1, memArray) + cachedCountWays(n - 2, memArray) + cachedCountWays(n - 3, memArray);
        return memArray[n];
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;

        if (set.size() == index) {
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
        System.out.println("Enter:" + System.currentTimeMillis());
        return multiplyWithoutAsteriskTemp(number, multiplier, 1);
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
        int temp = first;
        first = second;
        second = temp;
    }

    public static void main(String[] args) {
        int[] array = {11, 2, 4, 65, 32, 22, 9, 44, 31}; //{3,2,3,1,2,4,5,5,6};//
        int target = 6;

        String[] words = {"zocd", "gjkl", "hzqk", "hzgq", "gjkl"};//{"gin", "zen", "gig", "msg"}; //"zocd","gjkl","hzqk","hzgq","gjkl"
        ArrayList<Integer> set = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
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




