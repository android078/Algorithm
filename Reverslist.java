public class Reverslist {
    public static void main(String[] args) {
        int [] keys = {10, 11, 12, 13, 14, 15};
        Node head = null;
        for(int i = keys.length-1;i >= 0;i--){
            head = new Node(keys [i], head);
        }
        head = reverse (head);
        printList(head);
    }

    class Node
    {
        int data;
        Node next;

        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    class Main
    {
        public static void printList(Node head){
            Node previos = head;
            while(previos != null)
            {
                System.out.println(previos.data + "-->");
                previos = previos.next;
            }
            System.out.println("null");
        }
    }

    
}
