import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Valor mais próximo de N em uma árvore binária de pesquisa
 * Escreva um programa que leia os números a serem adicionados em uma BST e um número N sobre o qual se deseja encontrar o valor mais próximo a ele presente na árvore.
 *
 * Restrições
 * - Não é permitido procurar por sucessor ou predecessor. Ainda que fosse, N
 * não precisa ser um valor presente na árvore.
 * - A implementação deve ser O(h). Isto é, você não pode percorrer
 * toda a árvore para encontrar o elemento.
 *
 * Entrada
 * Seu programa deve ler duas linhas da entrada. A primeira linha irá conter (em ordem) os elementos que devem ser adicionados à árvore. A segunda irá conter um valor N (não necessariamente presente na árvore).
 * Seu programa deve encontrar na árvore o valor mais próximo de N.
 * Você pode assumir que não haverá elementos repetidos na árvore. Você pode assumir que não haverá empate dois valores.
 *
 * Saída
 * Inicialmente, seu programa deve imprimir o encaminhamento em pré-ordem da árvore lida. Depois, deve imprimir o valor mais próximo a N presente na árvore. Veja os exemplos de execução abaixo.
 */
class CloserBST {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        for (String number : numbers) {
            tree.insert(Integer.parseInt(number));
        }

        Integer number = scanner.nextInt();
        System.out.println(Arrays.toString(tree.preOrder().toArray()));
        System.out.println(tree.getCloser(number));
    }
}

class BST<T extends Comparable<T>> {
    private Node<T> root;

    BST() {
        this.root = new Node<>();
    }

    void insert(T element) {
        this.insert(this.root, element);
    }

    private void insert(Node<T> node, T element) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new Node<>());
            node.getLeft().setParent(node);
            node.setRight(new Node<>());
            node.getRight().setParent(node);
        } else if (node.getData().compareTo(element) > 0) {
            this.insert(node.getLeft(), element);
        } else if (node.getData().compareTo(element) < 0) {
            this.insert(node.getRight(), element);
        }
    }

    T getCloser(T element) {
        return this.getCloser(this.root, element);
    }

    private T getCloser(Node<T> node, T element) {
        T closer = null;

        if (node.isEmpty()) {
            int min = Math.abs(node.getParent().getData().compareTo(element));
            Node<T> parent = node.getParent();
            closer = parent.getData();

            if (!parent.getLeft().isEmpty()) {
                int diffLeft = Math.abs(parent.getLeft().getData().compareTo(element));

                if (min > diffLeft) {
                    min = diffLeft;
                    closer = parent.getLeft().getData();
                }
            }

            if (!parent.getRight().isEmpty()) {
                int diffRight = Math.abs(parent.getRight().getData().compareTo(element));

                if (min > diffRight) {
                    closer = parent.getRight().getData();
                }
            }

        } else if (node.getData().equals(element)) {
            closer = node.getData();
        } else if (node.getData().compareTo(element) > 0) {
            closer = this.getCloser(node.getLeft(), element);
        } else if (node.getData().compareTo(element) < 0) {
            closer = this.getCloser(node.getRight(), element);
        }

        return closer;
    }

    ArrayList<T> preOrder() {
        return preOrder(this.root, new ArrayList<>());
    }

    private ArrayList<T> preOrder(Node<T> node, ArrayList<T> arrayList) {
        if (!node.isEmpty()) {
            arrayList.add(node.getData());
            preOrder(node.getLeft(), arrayList);
            preOrder(node.getRight(), arrayList);
        }

        return arrayList;
    }
}

class Node<T> {
    private T data;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    boolean isEmpty() {
        return this.data == null;
    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    Node<T> getParent() {
        return parent;
    }

    void setParent(Node<T> parent) {
        this.parent = parent;
    }

    Node<T> getLeft() {
        return left;
    }

    void setLeft(Node<T> left) {
        this.left = left;
    }

    Node<T> getRight() {
        return right;
    }

    void setRight(Node<T> right) {
        this.right = right;
    }
}
