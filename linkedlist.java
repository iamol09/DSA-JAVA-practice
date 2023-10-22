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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempL1 = list1;
        ListNode tempL2 = list2;
        ListNode headMerged=null;
        
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        if (list1.val <= list2.val) {
            headMerged = list1;
            tempL1 = tempL1.next;
        } else {
            headMerged = list2;
            tempL2 = tempL2.next;
        }
        
        ListNode temp = headMerged;
        
        while (tempL1 != null && tempL2 != null) {
            if (tempL1.val <= tempL2.val) {
                temp.next = tempL1;
                tempL1 = tempL1.next;
            } else {
                temp.next = tempL2;
                tempL2 = tempL2.next;
            }
            temp = temp.next;
        }
        
        if (tempL1 != null) {
            temp.next = tempL1;
        }
        
        if (tempL2 != null) {
            temp.next = tempL2;
        }
        
        return headMerged;
    }
}

//Merge K sorted list

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
 import java.util.*;
 public class ListNodeComparator implements Comparator<ListNode>{
     public int compare(ListNode a,ListNode b){
         return Integer.compare(a.val,b.val);
     }
 }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        List<ListNode> list=new ArrayList<ListNode>();
        for(int i=0;i<lists.length;i++){
            ListNode temp=lists[i];
            while(temp!=null){
                list.add(temp);
                temp=temp.next;
            }
        }
        Collections.sort(list, new ListNodeComparator());
        ListNode head=null;
        ListNode temp=head;
        for(ListNode x:list){
            if(head==null){
                head=x;
                temp=x;
            }
            else{
                temp.next=x;
                temp=temp.next;
            }

        }
        return head;
        
    }
}


// partition list

