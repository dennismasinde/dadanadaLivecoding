public class Main {

    /*
    You are given two non-empty linked lists representing two
    non-negative integers. The digits are stored in reverse order,
    and each of their nodes contains a single digit. Add the two
    numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero,
    except the number 0 itself.
     */

    public static void main(String[] args) {

        System.out.println("Should return true: " + new ArrayJump().jumpTest(new int[]{2,3,1,1,4}));
        System.out.println("Should return false: " + new ArrayJump().jumpTest(new int[]{3,2,1,0,4}));

        ListNode current = new Main().addTwoNumbers(
                new ListNode(4, new ListNode(4, new ListNode(6))),
                new ListNode(5, new ListNode(1, new ListNode(2)))
        );

        while(current != null) {
            System.out.print(current.val + " --> ");
            current = current.next;
        }
        System.out.println("null");

        ListNode current1 = new Main().sumNodeValues(
                new ListNode(4, new ListNode(4, new ListNode(6))),
                new ListNode(5, new ListNode(1, new ListNode(2)))
        );

        while(current1 != null) {
            System.out.print(current1.val + " --> ");
            current1 = current1.next;
        }
        System.out.println("null");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode tail = temp;

        int carry = 0;
        while(l1 != null || l2 != null) {

            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            tail.next = new ListNode( sum % 10);
            tail = tail.next;

            if (l1 != null) { l1 = l1.next;}
            if (l2 != null) { l2 = l2.next;}

        }
        return temp.next;
    }

    public ListNode sumNodeValues(ListNode node1, ListNode node2) {
        ListNode node3 = new ListNode();
        ListNode temp = node3;

        while( node1 != null || node2 != null) {
            int x = 0;
            if (node1 != null) {
                x = node1.val;
                node1 = node1.next;
            }

            int y = 0;
            if (node2 != null) {
                y = node2.val;
                node2 = node2.next;
            }

            temp.next = new ListNode(x + y );
            temp = temp.next;
        }
        return node3.next;
    }
}
