import java.util.Arrays;
import java.util.Scanner;

/**
 * HashSet
 * HashSets implementam a noção matemática de conjunto em Java, isto é, não permitem elementos repetidos. HashSets são estruturas bem semelhantes à Tabelas Hash no que diz respeito à implementação, pois também podem ser baseadas em arrays e utilizam funções de hash para determinar onde armazenar o valor passado. Contudo, uma grande diferença é que eles não armazenam , mas apenas os valores.
 * Devido à natureza das funções de hash que utilizamos na construção de HashSets, colisões são inevitáveis. Isto é, para algum par de valores, existe a possibilidade de seus hashes serem iguais e, por consequência, esses objetos serão mapeados para a mesma posição.
 * Uma das maneiras de se resolver colisões é, caso o hash seja mapeado para uma posição já ocupada, o algoritmo de inserção procura por uma outra posição livre para inserir o valor. A essa estratégia, dá-se o nome de resolução de colisões por endereçamento aberto. Em particular, quando a tentativa é sempre verificar a próxima posição livre do array, diz-se que a estratégia utiliza um probing linear.
 * Implemente um programa que leia da entrada padrão operações em um HashSet imprima o seu estado sempre que as operações put e remove forem efetuadas.
 * O HashSet deve armazenar valores inteiros e deve resolver colisões por endereçamento aberto e probing linear.
 *
 * Seu HashSet deve ter as seguintes funções:
 * - put <valor>
 * - remove <valor>
 * - contains <valor>
 *
 * Importante! Para facilitar os testes, seu HashSet sempre terá a seguinte função base de hash:
 * hash(key, i) = (hash(key) + i) % M, onde M é o tamanho da tabela, i é o probe.
 *
 * Importante! Caso o conjunto já esteja completamente cheio durante uma inserção, basta não adicionar o novo valor. Contudo, mesmo que a operação não seja realizada, imprima o conteúdo do conjunto.
 *
 * Entrada
 * Seu programa deve ler da entrada o tamanho da tabela e uma série de operações (put, remove e contains).
 * - put: adiciona um valor no conjunto
 * - remove: remove o valor do conjunto
 * - contains: verifica se o conjunto contém um valor passado como parâmetro.
 * A leitura de operações deve ser encerrada com a palavra "end".
 *
 * Saída
 * Seu programa deve imprimir o conteúdo do HashSet sempre que as operações put e remove forem efetuadas. Quando a operação contains for lida, seu programa deve imprimir true ou false.
 *
 * Restrições
 * - Seu HashSet deve ser baseado em arrays.
 * - A função de hash deve ser sempre a mesma (exceto pelo probing): key % M,
 * onde M é o tamanho do conjunto.
 * - Crie a classe HashSet para organizar o seu código.
 */
class HashSetProbing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        HashSet hashSet = new HashSet(size);
        String option;

        do {
            option = scanner.nextLine();

            if (option.contains("put")) {
                int element = Integer.parseInt(option.split(" ")[1]);
                hashSet.put(element);
                System.out.println(hashSet);
            } else if (option.contains("remove")) {
                int element = Integer.parseInt(option.split(" ")[1]);
                hashSet.remove(element);
                System.out.println(hashSet);
            } else if (option.contains("contains")) {
                int element = Integer.parseInt(option.split(" ")[1]);
                System.out.println(hashSet.contains(element));
            }
        } while (!option.equalsIgnoreCase("end"));
    }
}

class HashSet {
    private Integer[] table;
    private int size;
    private int elements;

    HashSet(int size) {
        this.table = new Integer[size];
        this.size = size;
        this.elements = 0;
    }

    boolean isEmpty() {
        return this.elements == 0;
    }

    boolean isFull() {
        return this.size == elements;
    }

    int hash(int key) {
        return key % this.size;
    }

    int hash(int key, int probe) {
        return (this.hash(key) + probe) % this.size;
    }

    void put(int element) {
        if (!isFull()) {
            int probe = 0;
            int sizeBefore = this.elements;

            while (probe != this.size && sizeBefore == this.elements) {
                int hash = this.hash(element, probe);

                if (this.table[hash] == null && !this.contains(element)) {
                    this.table[hash] = element;
                    this.elements++;
                } else {
                    probe++;
                }
            }
        }
    }

    void remove(int element) {
        if (!isEmpty()) {
            int index = this.indexOf(element);

            if(index != -1) {
                this.table[index] = null;
                this.elements--;
            }
        }
    }

    boolean contains(int element) {
        boolean contain = false;

        if(!isEmpty()) {
            int index = this.indexOf(element);

            if (index != -1) {
                contain = true;
            }

        }

        return contain;
    }

    int indexOf(int element) {
        int indexOf = -1;

        if(!isEmpty()) {
            int probe = 0;
            int hash = this.hash(element, probe);

            while (probe != this.size && indexOf == -1) {
                if (this.table[hash] != null && this.table[hash] == element) {
                    indexOf = hash;
                } else {
                    probe++;
                    hash = this.hash(element, probe);
                }
            }
        }

        return indexOf;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.table);
    }
}
