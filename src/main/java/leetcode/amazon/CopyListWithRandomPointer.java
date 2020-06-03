package leetcode.amazon;

public class CopyListWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node currNode = head;
        while(currNode != null){
            Node newCurrNode = new Node(currNode.val);
            Node nextCurrNode = currNode.next;
            currNode.next = newCurrNode;
            newCurrNode.next = nextCurrNode;
            currNode = nextCurrNode;
        }
        currNode = head;
        while(currNode != null){
            Node newCurrNode = currNode.next;
            Node randOfCurrNode = currNode.random;
            if(randOfCurrNode != null){
                newCurrNode.random = randOfCurrNode.next;
            }
            currNode = currNode.next.next;
        }
        currNode = head;
        Node newHead = currNode.next;
        Node newCurrNode = newHead;
        while(currNode!=null){
            Node currNextNode = currNode.next.next;
            if(currNextNode != null){
                newCurrNode.next = currNextNode.next;
            }
            currNode.next = currNextNode;
            currNode = currNextNode;
            newCurrNode = newCurrNode.next;
        }
        return newHead;
    }

    private void printLL(Node head){
        Node currNode = head;
        while(currNode!=null){
            System.out.print("{" + currNode.val + " ");
            if(currNode.random!=null) System.out.print(currNode.random.val);
            System.out.print("}");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer cc = new CopyListWithRandomPointer();

        Node head = new Node(7);
        Node curr2 = new Node(13);
        Node curr3 = new Node(11);
        Node curr4 = new Node(10);
        Node curr5 = new Node(1);
        head.next = curr2;
        curr2.next = curr3;
        curr3.next = curr4;
        curr4.next = curr5;
        curr2.random=head;
        curr3.random = curr5;
        curr4.random = curr3;
        curr5.random = head;

        cc.printLL(head);

        Node newHead = cc.copyRandomList(head);
        cc.printLL(newHead);
    }

}
