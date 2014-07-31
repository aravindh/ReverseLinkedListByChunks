import java.util.LinkedList;

public class ReverseLinkedList {
    public static Node reverse(Node head, int num){
        Node current = head;
        if(current == null) {
            return null;
        }
        Node prev = null;
        Node next;
        Node prev_head = current;
        Node new_head = null;
        int count = 0;
            while(current != null && count < num){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }
            new_head = prev;
            prev_head.next = reverse(current, num);
        return new_head;
    }

    public static void displayList(Node head){
        Node current = head;
        System.out.println("\nLinked List:");
        while(current != null){
            System.out.print(" "+current.data);
            current = current.next;
        }
    }

    public static void main(String args[]) {
        int size = Integer.parseInt(args[0]);
        LinkedList ll = new LinkedList();
        Node head = new Node(null, null);
        Node current = head;
        for(String num :args[1].split(",")){
            current.next = new Node(Integer.parseInt(num), null);
            current = current.next;
        }
        displayList(head.next);
        Node new_Head = reverse(head.next, size);
        displayList(new_Head);
    }

}
