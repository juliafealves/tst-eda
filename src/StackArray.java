import java.util.Scanner;

/**
 * Pilha com Array:
 * Implemente uma pilha com capacidade limitada utilizando array.
 *
 * Entrada:
 * Seu programa deve ler da entrada o tamanho da pilha e uma série de operações (pop, push, peek e print). A leitura de operações deve ser encerrada com a palavra "end".
 *
 * Saída:
 * Seu programa deve imprimir o conteúdo da pilha sempre que uma operação print for lida. Se a pilha estiver vazia, imprima "empty".
 * Seu programa deve imprimir o elemento no topo da pilha quando ler a operação peek.
 * Se a pilha estiver vazia e for lida a operação pop, imprima "empty".
 * Se a pilha estiver cheia e for lida a operação push, imprima "full".
 */
class StackArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Stack stack = new Stack(size);
        String option;

        do {
            option = scanner.nextLine();

            if (option.contains("push")) {
                Integer element = Integer.parseInt(option.split(" ")[1]);
                stack.push(element);
            } else if (option.contains("pop")) {
                stack.pop();
            } else if (option.contains("peek")) {
                Integer element = stack.getTail();

                if (element != null) {
                    System.out.println(element);
                }
            } else if (option.contains("print")) {
                System.out.println(stack);
            }
        } while (!option.equals("end"));
    }
}

class Stack {

    private Integer[] array;
    private int tail;

    Stack(int size) {
        this.array = new Integer[size];
        this.tail = -1;
    }

    void push(Integer element) {
        if (this.isFull()) {
            System.out.println("full");
        } else {
            this.array[++this.tail] = element;
        }
    }

    void pop() {
        if (this.isEmpty()) {
            System.out.println("empty");
        } else {
            this.tail--;
        }
    }

    Integer getTail() {
        Integer element = null;

        if (!this.isEmpty()) {
            element = this.array[this.tail];
        }

        return element;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();

        if (this.isEmpty()) {
            toString = toString.append("empty");
        } else {
            for (int i = 0; i <= this.tail; i++) {
                toString.append(" ").append(this.array[i]);
            }
        }

        return toString.toString().trim();
    }

    private boolean isEmpty() {
        return this.tail == -1;
    }

    private boolean isFull() {
        return this.tail == this.array.length - 1;
    }
}