package linear;

/* https://leetcode.com/problems/add-two-numbers/ */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int firstNumber = createNumberFromList(l1);
        int secondNumber = createNumberFromList(l2);
        //ListNode node = new ListNode();

        int sum = sum(firstNumber,secondNumber);

        //int sum = firstNumber + secondNumber;
        System.out.println("sum:"+sum);

        //return null;

        return convertToList(sum);

        //return createList( String.valueOf((int)Double.sum(firstNumber,secondNumber)),1,node);
    }

    private static int sum(int firstNumber, int secondNumber) {
        int firstNumberLength = (int) (Math.log10(firstNumber) + 1);
        int secondnumberLength = (int) (Math.log10(secondNumber) + 1);
        int lengthDiff = firstNumberLength-secondnumberLength;
        if(lengthDiff < 0) {
            firstNumber = (int) (firstNumber * Math.pow(10,Math.abs(lengthDiff)));
        } else {
            secondNumber = (int) (secondNumber * Math.pow(10,lengthDiff));
        }

        System.out.println("first number:"+firstNumber+"; second number:"+secondNumber);

        return firstNumber + secondNumber;
    }


    public static ListNode convertToList(int sum) {
        ListNode sumList = null;
        int length = (int) (Math.log10(sum) + 1);
        int lengthComparator = 0;
        System.out.println("number of digits in sum:"+length);
        while(sum%10 >= 0) {
            sumList = new ListNode( sum%10,sumList);
            sum = sum/10;
            ++lengthComparator;

            if(lengthComparator>= length) {

                return reverse(sumList);
            }
        }
        System.out.println("sumList:"+sumList);
        return reverse(sumList);
    }

    private static ListNode reverse(ListNode sumList) {
        ListNode curr = sumList, prev=null, next;

        while (curr != null) {
            next = curr.next;
            //System.out.println(next);
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Return the head of reversed linked list
        System.out.println("sumList:"+prev);
        return prev;
    }


    private static int createNumberFromList(ListNode l) {
        int number = 0;
        while(l.next!=null) {
            number = number * 10 +l.val;
            l=l.next;
        }
        number = number*10 + l.val;
        System.out.println(number);
        return number;
    }



//    private static double createNumber(ListNode l1) {
//        double num1 = 0;
//        int i = 0;
//        while(l1.next != null) {
//            num1 = num1 + l1.val * Math.pow(10,i);
//            l1 = l1.next;
//            i++;
//        }
//        return num1 + l1.val * Math.pow(10,i);
//    }

//    private static ListNode createList(String sum, int i,ListNode node) {
//
//        System.out.println(sum);
//        if(sum.length()==0) {
//            System.out.println("final:"+node);
//            return node;
//        } else {
//            char digit = sum.charAt(sum.length()-1);
//            sum = sum.substring(0,sum.length()-1);
//            if(i==1) {
//                node.val = Integer.parseInt(String.valueOf(digit));
//                System.out.println("first:"+node);
//                i++;
//                return createList(sum,i,node);
//            } else {
//                ListNode newNode = new ListNode(Integer.parseInt(String.valueOf(digit)));
//                node.next = newNode;
//                //node = newNode;
//                System.out.println("next:" + node);
//                return createList(sum,i,newNode);
//            }
//
//        }
//    }





    public static void main(String [] args) {
//9,9,9,9,9,9,9
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9,l1);
        ListNode l3 = new ListNode(9,l2);
        ListNode l8 = new ListNode(9,l3);
        ListNode l9 = new ListNode(9,l8);
        ListNode l10 = new ListNode(9,l9);
        ListNode l11= new ListNode(9,l10);

        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9,l4);
        ListNode l6 = new ListNode(9,l5);
        ListNode l12 = new ListNode(9,l6);
        addTwoNumbers(l11,l12);

    }
}
