import java.util.ArrayList;
import java.util.Scanner;

/**
 * Máximo em uma árvore binária de pesquisa
 * Implemente um programa que identifique o valor máximo em uma BST.
 *
 * Entrada
 * Seu programa deve ler apenas uma linha da entrada. Essa linha irá conter (em ordem) os elementos que devem ser adicionados à árvore.
 * Você pode assumir que não haverá elementos repetidos na árvore e que a árvore possui ao menos um elemento.
 *
 * Saída
 * Seu programa deve imprimir o caminho percorrido até o elemento máximo da árvore.
 */
class MaxBSTMain {
    public static void main(String[] args) {
        MaxBST<Integer> tree = new MaxBST<>();
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        for (String number : numbers) {
            tree.insert(Integer.parseInt(number));
        }

        String output = "";
        for (Integer element : tree.maximum()) {
            output += " " + element;
        }

        System.out.println(output.trim());
    }
}

class MaxBST<T extends Comparable<T>> extends BST<T> {
    MaxBST() {
        super();
    }

    ArrayList<T> maximum() {
        return this.maximum(this.getRoot(), new ArrayList<>());
    }

    private ArrayList<T> maximum(Node<T> node, ArrayList<T> arrayList) {
        arrayList.add(node.getData());

        if(!node.getRight().isEmpty()) {
            this.maximum(node.getRight(), arrayList);
        }

        return arrayList;
    }
}
