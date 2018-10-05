import java.util.Scanner;

class QueueArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        if(!option.equals("end")) {
            int size = Integer.parseInt(option);
            Queue queue = new Queue(size);

            do {
                option = scanner.nextLine();

                if (option.contains("add")) {
                    Integer element = Integer.parseInt(option.split(" ")[1]);
                    queue.add(element);
                } else if (option.contains("print")) {
                    System.out.println(queue.toString());
                } else if (option.contains("element")) {
                    if(queue.getHead() != null){
                        System.out.println(queue.getHead());
                    }
                } else if (option.contains("remove")) {
                    queue.remove();
                }

            } while (!option.equals("end"));
        } else {
            System.exit(0);
        }


    }
}

class Queue {

    private Integer[] array;
    private int head;

    Queue(int size) {
        this.array = new Integer[size];
        this.head = -1;
    }

    void add(Integer element) {
        if (this.isFull()) {
            System.out.println("full");
        } else {
            this.array[++this.head] = element;
        }
    }

    void remove() {
        if (this.isEmpty()) {
            System.out.println("empty");
        } else {
            this.shiftLeft();
            this.head--;
        }
    }

    Integer getHead() {
        Integer element = null;

        if (!this.isEmpty()) {
            element = this.array[0];
        }

        return element;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();

        if (this.isEmpty()) {
            toString = new StringBuilder("empty");
        } else if (this.isFull()) {
            toString = new StringBuilder("full");
        } else {
            for (int i = 0; i <= this.head; i++) {
                toString.append(" ").append(this.array[i]);
            }
        }

        return toString.toString().trim();
    }

    private boolean isEmpty() {
        return this.head == -1;
    }

    private boolean isFull() {
        return this.head == this.array.length - 1;
    }

    private void shiftLeft() {
        for (int i = 0; i < this.head; i++) {
            this.array[i] = this.array[i + 1];
        }
    }
}