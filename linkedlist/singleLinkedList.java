import java.util.Scanner;

class singleLinkedList{

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void insertAtPosition(int position, int data) {

        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteFromBeginning() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        head = head.next;
    }

    void deleteFromEnd() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Value not found");
    }

    void deleteByPosition(int position) {

        if (head == null || position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        int count = 1;

        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    int size() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    int search(int value) {
        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == value) {
                return position;
            }
            temp = temp.next;
            position++;
        }

        return -1;
    }

    void sort() {

        if (head == null || head.next == null) {
            return;
        }

        Node i, j;
        int temp;

        for (i = head; i != null; i = i.next) {
            for (j = head; j.next != null; j = j.next) {
                if (j.data > j.next.data) {
                    temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
    }

    void reverse() {

        if(head == null){
            System.out.print("Linked list is empty.");
            return;
        }

        Node prev = null;
        Node temp = head;
        Node nextNode;

        while (temp != null) {
            nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        head = prev;
    }

    void display() {

        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
    public static void main(String[] args){
        singleLinkedList list = new singleLinkedList();
        Scanner sc = new Scanner(System.in);

        int choice, data, position;

        do {
            System.out.println("\n---- Singly Linked List Menu ----");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete by Value");
            System.out.println("7. Delete by Position");
            System.out.println("8. Search");
            System.out.println("9. Sort");
            System.out.println("10. Reverse");
            System.out.println("11. Size");
            System.out.println("12. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtPosition(position, data);
                    break;

                case 4:
                    list.deleteFromBeginning();
                    break;

                case 5:
                    list.deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter value: ");
                    data = sc.nextInt();
                    list.deleteByValue(data);
                    break;

                case 7:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    list.deleteByPosition(position);
                    break;

                case 8:
                    System.out.print("Enter value: ");
                    data = sc.nextInt();
                    int pos = list.search(data);
                    if (pos == -1)
                        System.out.println("Element not found");
                    else
                        System.out.println("Found at position " + pos);
                    break;

                case 9:
                    list.sort();
                    System.out.println("List sorted");
                    break;

                case 10:
                    list.reverse();
                    System.out.println("List reversed");
                    break;

                case 11:
                    System.out.println("Size = " + list.size());
                    break;

                case 12:
                    list.display();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}

