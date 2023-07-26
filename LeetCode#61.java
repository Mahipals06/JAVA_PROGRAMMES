/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)
        return head;
        ListNode temp=head;
        int length=1;  // starting from 1 because we wiil not count last one 
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        temp.next=head; //when null is reached we make list cyclic eg. 5-->1
        // temp.val=5 here 
        k=k%length;  // k==2
        k=length-k; // k==3
        while(k>0){
            temp=temp.next; //value =1-->2-->3  
            k--;//at three stops k=3-2=2,2-1=1,1-1=0 
        } 
        head=temp.next;  //head=3.next i.e 4
        temp.next=null; //temp was 3 3.next set to null
        return head;  //returning from 4->5->1->2->3->null

    }
}
