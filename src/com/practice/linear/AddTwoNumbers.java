package linear;

/* https://leetcode.com/problems/add-two-numbers/ */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        double firstNumber = createNumber(l1);
        double secondNumber = createNumber(l2);
        ListNode node = new ListNode();
        //System.out.println(firstNumber+"+"+secondNumber+"="+sum);

        return createList( String.valueOf((int)Double.sum(firstNumber,secondNumber)),1,node);
    }

    private static double createNumber(ListNode l1) {
        double num1 = 0;
        int i = 0;
        while(l1.next != null) {
            num1 = num1 + l1.val * Math.pow(10,i);
            l1 = l1.next;
            i++;
        }
        return num1 + l1.val * Math.pow(10,i);
    }

    private static ListNode createList(String sum, int i,ListNode node) {

        System.out.println(sum);
        if(sum.length()==0) {
            System.out.println("final:"+node);
            return node;
        } else {
            char digit = sum.charAt(sum.length()-1);
            sum = sum.substring(0,sum.length()-1);
            if(i==1) {
                node.val = Integer.parseInt(String.valueOf(digit));
                System.out.println("first:"+node);
                i++;
                return createList(sum,i,node);
            } else {
                ListNode newNode = new ListNode(Integer.parseInt(String.valueOf(digit)));
                node.next = newNode;
                //node = newNode;
                System.out.println("next:" + node);
                return createList(sum,i,newNode);
            }




        }
    }





    public static void main(String [] args) {

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4,l1);
        ListNode l3 = new ListNode(2,l2);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6,l4);
        ListNode l6 = new ListNode(5,l5);
        addTwoNumbers(l3,l6);

    }
}
