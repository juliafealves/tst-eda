import java.util.ArrayList;
import java.util.Scanner;

/**
 * Mínimo em uma árvore binária de pesquisa
 * Implemente um programa que identifique o valor mínimo em uma BST.
 *
 * Entrada
 * Seu programa deve ler apenas uma linha da entrada. Essa linha irá conter (em ordem) os elementos que devem ser adicionados à árvore.
 * Você pode assumir que não haverá elementos repetidos na árvore e que a árvore possui ao menos um elemento.
 *
 * Saída
 * Seu programa deve imprimir o caminho percorrido até o elemento mínimo da árvore.
 */
class MinBSTMain {
    public static void main(String[] args) {
        MinBST<Integer> tree = new MinBST<>();
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        for (String number : numbers) {
            tree.insert(Integer.parseInt(number));
        }

        String output = "";
        for (Integer element : tree.minimum()) {
            output += " " + element;
        }

        System.out.println(output.trim());
    }
}

class MinBST<T extends Comparable<T>> extends BST<T> {
    MinBST() {
        super();
    }

    ArrayList<T> minimum() {
        return minimum(this.getRoot(), new ArrayList<>());
    }

    private ArrayList<T> minimum(Node<T> node, ArrayList<T> arrayList) {
        arrayList.add(node.getData());

        if (!node.getLeft().isEmpty()) {
            this.minimum(node.getLeft(), arrayList);
        }

        return arrayList;
    }
}