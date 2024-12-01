/*
* https://leetcode.com/problems/merge-two-sorted-lists/
*
*  Example 1
   Input: list1 = [1,2,4], list2 = [1,3,4]
   Output: [1,1,2,3,4,4]

* Example 2:
    Input: list1 = [], list2 = []
    Output: []

* Example 3:
    Input: list1 = [], list2 = [0]
    Output: [0]
*
* */

package linear;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLists {

//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        List<Integer> _l1 = createList(list1);
//        List<Integer> _l2 = createList(list2);
//        _l1.addAll(_l2);
//        Collections.sort(_l1);
//
//        return  createNode(_l1);
//
//    }

    private static ListNode createNode(List<Integer> l1) {
        ListNode answer = new ListNode();
        for(Integer number : l1) {
            if(answer.next == null) {
                answer.val = number;
                answer.next = new ListNode();
            } else {
                ListNode current = answer.next;
                current.val = number;
                current.next = new ListNode();

            }

        }
        

        return answer;
    }

    private static List<Integer> createList(ListNode node) {
        List<Integer> numbers = new ArrayList<>();
        boolean exit = false;
        while(!exit) {
            numbers.add(node.val);

            if(node.next==null) {
                exit = true;
            } else {
                node = node.next;
            }
        }
        return numbers;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(8,l1);
        ListNode l3 = new ListNode(7,l2);

//      ListNode l8 = new ListNode(4);
//      ListNode l9 = new ListNode(6,l8);
//      ListNode l10 = new ListNode(5,l9);
//      ListNode l11= new ListNode(3,l10);
//      ListNode l12 = new ListNode(9,l6);

        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4,l4);
        ListNode l6 = new ListNode(2,l5);

        mergeTwoLists(l3,l6);

    }
}
