/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }else{
            ListNode copy = head;
            while(copy != null && copy.next != null){
                if(copy.val != copy.next.val){
                    copy = copy.next;
                }else{
                    copy.next = copy.next.next;
                }
            }
            return head;
        }
    }
}