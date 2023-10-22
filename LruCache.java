import java.util.*;

class ListNode {
    int data;
    ListNode next;
    ListNode prev;

    ListNode(int x) {
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}

public class LruCache {
    static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(10);
        ListNode temp = head;
        System.out.println("Enter list nodes:");
        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();
            ListNode x = new ListNode(num);
            x.prev = temp;
            temp.next = x;
            temp = temp.next;
        }
        temp.next = null;
        temp = head;
        while (temp.next != null) {
            LruDesign(temp.data);
            temp = temp.next;
        }
		LruDesign(temp.data);
    }

    static void LruDesign(int x) {
        HashMap<Integer, ListNode> hm = new HashMap<>();
        ListNode HeadDummy = new ListNode(-1);
        ListNode TailDummy = new ListNode(-1);
        HeadDummy.next = TailDummy;
        TailDummy.prev = HeadDummy;
        int capacity = 5;
        // Search x in HM
        if (hm.containsKey(x)) {
            ListNode node = hm.get(x);
            if (node != null) {
                // Remove node with val x
                node.prev.next = node.next;
                node.next.prev = node.prev;

                // Add node with val x to tail
                node.next = TailDummy;
                node.prev = TailDummy.prev;
                TailDummy.prev = node;
                node.prev.next = node;
            } else {
                // Handle the case where the node is null
            }
        } else {
            if (size == capacity) {
                // Remove head.next
				hm.remove(x);
				if(HeadDummy.next!=null){
				HeadDummy.next = HeadDummy.next.next;
				}
				if(HeadDummy.next!=null){
					HeadDummy.next.prev = HeadDummy;
				}
                size--;
                
            }
            ListNode addNode = new ListNode(x);
            hm.put(x, addNode);
            size++;
            // Add node to tail
            addNode.next = TailDummy;
            addNode.prev = TailDummy.prev;
            TailDummy.prev = addNode;
            addNode.prev.next = addNode;
        }
    }
}
