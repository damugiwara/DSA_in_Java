import java.util.Scanner;

class arrays {

    int[] arr;
    int size;
    int capacity;

    arrays(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }

    void traversal() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void insert(int element) {
        if (size == capacity) {
            System.out.println("Array is full.");
            return;
        }
        arr[size++] = element;
    }

    void insertAtPosition(int index, int value) {
        if (size == capacity || index < 0 || index > size) {
            System.out.println("Invalid position.");
            return;
        }
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
        size++;
    }

    void delete() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        size--;
    }

    void deleteAtPosition(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    void search(int target) {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found.");
    }

    void update(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return;
        }
        arr[index] = value;
    }

    void sort() {
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        arrays array = new arrays(sc.nextInt());

        int choice;

        do {
            System.out.println("\n1.Insert 2.InsertAt 3.Delete 4.DeleteAt 5.Search 6.Update 7.Sort 8.Traverse 9.Exit");
            choice = sc.nextInt();

            if (choice == 1) array.insert(sc.nextInt());
            else if (choice == 2) array.insertAtPosition(sc.nextInt(), sc.nextInt());
            else if (choice == 3) array.delete();
            else if (choice == 4) array.deleteAtPosition(sc.nextInt());
            else if (choice == 5) array.search(sc.nextInt());
            else if (choice == 6) array.update(sc.nextInt(), sc.nextInt());
            else if (choice == 7) array.sort();
            else if (choice == 8) array.traversal();

        } while (choice != 9);

        sc.close();
    }
}
