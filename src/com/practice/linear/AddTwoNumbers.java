package linear;

import hierarchical.Node;

/* https://leetcode.com/problems/add-two-numbers/ */
public class AddTwoNumbers {

    public static void main(String [] args) {
//9,9,9,9,9,9,9
//        ListNode l1 = new ListNode(9);
//        ListNode l2 = new ListNode(8,l1);
//        ListNode l3 = new ListNode(7,l2);
       ListNode l8 = new ListNode(4);
        ListNode l9 = new ListNode(6,l8);
        ListNode l10 = new ListNode(5,l9);
        //ListNode l11= new ListNode(3,l10);

        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4,l4);
        ListNode l6 = new ListNode(2,l5);
       // ListNode l12 = new ListNode(9,l6);
        addNumbers(l10,l6);

    }

    private static void addNumbers(ListNode first, ListNode second) {
        int firstNumber = (int) createNumber(first);

        int secondNumber = (int) createNumber(second);

        System.out.println("firstNumber="+firstNumber+";secondNumber="+secondNumber);
        addTwoNumbers(firstNumber+secondNumber);

    }


    private static ListNode addTwoNumbers(int number) {    //342 + 465 = 807. ans: [7,0,8]
        ListNode answer = null;

        String _number = String.valueOf(number);
        char [] _numbers = _number.toCharArray();       //[8,0,7]

        for(Character numberCharacter:_numbers) {
            ListNode temp = new ListNode(Integer.valueOf(numberCharacter.toString()),answer);
           answer = temp;
        }

        return answer;
    }

    private static double createNumber(ListNode number) {      // 369 = 9*10^0 + 6 * 10^1, 3*10^2
        int power = 0;
        double digit = 0;
        while(number.next!=null) {
            digit = digit+number.val * Math.pow(10,power);
            number=number.next;
            power++;
        }
        System.out.println("digit="+digit);
        return  digit+number.val * Math.pow(10,power);
    }

}
