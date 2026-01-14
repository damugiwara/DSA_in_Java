import java.util.Scanner;

class queueUsingLinkedList{
    
    class Node{

        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node rear;
    Node front;
    int size;

    queueUsingLinkedList(){
        this.rear = null;
        this.front = null;
        this.size =  0;
    }

    void enqueue(int data){

        Node newNode = new Node(data);

        if(rear == null){
            rear = front = newNode;
            size++;
            return;
        }

        rear.next = newNode;
        rear = newNode;
        size++;

        System.out.print(data + " enqueued.");

    }

    int dequeue(){
        
        if(front == null){
            System.out.print("Queue is empty.");
            return -1;
        }

        int removed = front.data;
        front = front.next;

        if(front == null){
            rear = null;
        }

        size--;
        return removed;
    }

    void isEmpty(){

        if(front == null){
            System.out.print("Queue is empty.");
            return;
        }

        System.out.print("Queue is not empty.");
    }

    void peek(){

        if(front == null){
            System.out.print("Queue is empty.");
            return;
        }

        System.out.print("Front element: " + front.data);
    }

    void display(){

        if(front == null){
            System.out.print("Queue is empty.");
            return;
        }

        Node temp = front;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.print("null");
    }

        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        queueUsingLinkedList q = new queueUsingLinkedList();

        int choice;

        do {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. isEmpty");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.isEmpty();
                    break;

                case 5:
                    q.display();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
