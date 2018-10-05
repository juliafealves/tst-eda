import java.util.Scanner;

/**
 * Fila com Array:
 * Implemente uma fila com capacidade limitada utilizando array.
 *
 * Entrada:
 * Seu programa deve ler da entrada o tamanho da fila e uma série de operações (add, remove, element e print). A leitura de operações deve ser encerrada com a palavra "end".
 *
 * Saída:
 * Seu programa deve imprimir o conteúdo da fila sempre que uma operação print for lida. Se a fila estiver vazia, imprima "empty". Se estiver cheia, imprima "full".
 * Seu programa deve imprimir o elemento inicial da fila quando ler a operação element.
 * Se a fila estiver vazia e for lida a operação remove, imprima "empty".
 * Se a fila estiver cheia e for lida a operação add, imprima "full".
 */
class QueueArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Queue queue = new Queue(size);
        String option;

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