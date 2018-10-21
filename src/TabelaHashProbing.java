import java.util.Arrays;
import java.util.Scanner;

/**
 * Tabelas Hash (resolução de conflitos com endereçamento aberto)
 * Devido à natureza das funções de hash que utilizamos na construção de Tabelas Hash, colisões são inevitáveis. Isto é, para algum par de objetos com chaves diferentes, existe a possibilidade de seus hashes serem iguais e, por consequência, esses objetos serão mapeados para a mesma posição da tabela.
 * Uma das maneiras de se resolver colisões é, caso o hash da chave seja mapeado para uma posição já ocupada, o algoritmo de inserção procura por uma outra posição livre para inserir o par . A essa estratégia, dá-se o nome de resolução de colisões por endereçamento aberto. Em particular, quando a tentativa é sempre verificar a próxima posição da tabela, diz-se que a estratégia utiliza um probing linear.
 * Implemente um programa que leia da entrada padrão operações em uma tabela hash e imprima o seu estado sempre que as operações put e remove forem efetuadas.
 * A tabela hash deve armazenar chaves inteiras e valores do tipo String e deve resolver colisões por endereçamento aberto e probing linear.
 * Sua tabela deve ter as seguintes funções:
 * - put <chave> <valor>
 * - remove <chave>
 * - keys
 * - values
 *
 * Importante! Para facilitar os testes, sua tabela sempre terá a seguinte função base de hash:
 *
 * hash(key, i) = (hash(key) + i) % M, onde M é o tamanho da tabela, i é o probe.
 * Importante! Caso a tabela já esteja completamente cheia durante uma inserção, basta não adicionar o novo par. Contudo, mesmo que a operação não seja realizada, imprima o conteúdo da tabela.
 *
 * Entrada
 * Seu programa deve ler da entrada o tamanho da tabela e uma série de operações (put, remove, keys, e values).
 * - put: adiciona o par chave,valor na tabela
 * - remove: remove o par cuja chave é igual a chave passada como parâmetro
 * - keys: imprime em ordem as chaves da tabela. Você pode usar Arrays.sort para isso.
 * - values: imprime em ordem os valores da tabela. Você pode usar Arrays.sort para isso.
 * A leitura de operações deve ser encerrada com a palavra "end".
 *
 * Saída
 * Seu programa deve imprimir o conteúdo da tabela sempre após as operações put e remove forem efetuadas. Quando a operação keys ou values for lida, deve imprimir as chaves ou valores em ordem crescente.
 *
 * Restrições
 * - Sua tabela deve ser baseada em arrays.
 * - A função de hash deve ser sempre a mesma (exceto pelo probing): key % M,
 * onde M é o tamanho da tabela.
 * - Crie a classe TabelaHash para organizar o seu código.
 * - Crie uma classe Pair como abstração para chave e valor.
 */
class TabelaHashProbing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        HashTableLinear hashTable = new HashTableLinear(size);
        String option;

        do {
            option = scanner.nextLine();

            if (option.contains("keys")) {
                System.out.println(Arrays.toString(hashTable.listKeys()));
            } else if (option.contains("values")) {
                System.out.println(Arrays.toString(hashTable.listValues()));
            } else if (option.contains("put")) {
                int key = Integer.parseInt(option.split(" ")[1]);
                String value = option.split(" ")[2];
                hashTable.put(key, value);
                System.out.println(hashTable);
            } else if (option.contains("remove")) {
                int key = Integer.parseInt(option.split(" ")[1]);
                hashTable.remove(key);
                System.out.println(hashTable);
            }

        } while (!option.equalsIgnoreCase("end"));
    }
}

class HashTableLinear {
    private Pair[] table;
    private int totalElements;
    private int size;

    HashTableLinear(int size) {
        this.table = new Pair[size];
        this.size = size;
        this.totalElements = 0;
    }

    int hash(int key) {
        return key % this.size;
    }

    int hash(int key, int probe) {
        return (this.hash(key) + probe) % this.size;
    }

    int indexOf(int key) {
        int indexOf = -1;

        if (!isEmpty()) {
            int probe = 0;
            int index = this.hash(key, probe);

            while (probe != this.size && indexOf == -1) {
                if (this.table[index] != null && this.table[index].getKey() == key) {
                    indexOf = index;
                } else {
                    probe++;
                    index = this.hash(key, probe);
                }
            }
        }

        return indexOf;
    }

    boolean isEmpty() {
        return this.totalElements == 0;
    }

    boolean isFull() {
        return this.size == this.totalElements;
    }

    int[] listKeys() {
        int[] keys = new int[this.totalElements];

        if (!this.isEmpty()) {
            int index = 0;

            for (Pair pair : this.table) {
                if (pair != null) {
                    keys[index] = pair.getKey();
                    index++;
                }
            }

            Arrays.sort(keys);
        }

        return keys;
    }

    String[] listValues() {
        String[] values = new String[this.totalElements];

        if (!this.isEmpty()) {
            int index = 0;

            for (Pair pair : this.table) {
                if (pair != null) {
                    values[index] = pair.getValue();
                    index++;
                }
            }

            Arrays.sort(values);
        }

        return values;
    }

    void put(int key, String value) {
        if (!isFull()) {
            int probe = 0;
            boolean notInserted = true;

            while (probe != this.size && notInserted) {
                int index = this.hash(key, probe);

                if (this.table[index] == null) {
                    this.table[index] = new Pair(key, value);
                    this.totalElements++;
                    notInserted = false;
                } else if (this.table[index].getKey() == key) {
                    this.table[index].setValue(value);
                    notInserted = false;
                } else {
                    probe++;
                }
            }
        }
    }

    void remove(int key) {
        if (!this.isEmpty()) {
            int index = this.indexOf(key);

            if (index != -1) {
                this.table[index] = null;
                this.totalElements--;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.table);
    }
}
