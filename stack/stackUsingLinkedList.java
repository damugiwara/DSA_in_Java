import java.util.Scanner;

class stackUsingLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top;
    int size;

    stackUsingLinkedList() {
        top = null;
        size = 0;
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(data + " pushed into stack.");
    }

    void pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println(top.data + " popped from stack.");
        top = top.next;
        size--;
    }

    void peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top element: " + top.data);
    }

    void isEmpty() {
        if (top == null) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack is not empty.");
        }
    }

    int size() {
        return size;
    }

    void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        Node temp = top;
        System.out.print("Stack (top → bottom): ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stackUsingLinkedList s = new stackUsingLinkedList();

        int choice;
        do {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. isEmpty");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    s.push(sc.nextInt());
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.peek();
                    break;

                case 4:
                    s.display();
                    break;

                case 5:
                    System.out.println("Stack size: " + s.size());
                    break;

                case 6:
                    s.isEmpty();  
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
