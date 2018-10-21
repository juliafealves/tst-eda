import java.util.*;

/**
 * Tabelas Hash (resolução de conflitos com chaining)
 * Devido à natureza das funções de hash que utilizamos na construção de Tabelas Hash, colisões são inevitáveis. Isto é, para algum par de objetos com chaves diferentes, existe a possibilidade de seus hashes serem iguais e, por consequência, esses objetos serão mapeados para a mesma posição da tabela.
 * Uma das maneiras de se resolver colisões é, ao invés de armazenar o par em uma posição da tabela, armazenar uma fila contendo todos os pares que forem mapeados para aquela posição.
 * Implemente um programa que leia da entrada padrão operações em uma tabela hash e imprima o seu estado sempre que as operações put e remove forem efetuadas.
 * A tabela hash deve armazenar chaves inteiras e valores do tipo String e deve resolver colisões por chaining.
 * Sua tabela deve ter as seguintes funções:
 * - put <chave> <valor>
 * - remove <chave>
 * - keys
 * - values
 *
 * Importante! Para facilitar os testes, sua tabela sempre terá a seguinte função de hash:
 * hash(key) = key % M, onde M é o tamanho da tabela
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
 * Quando a operação keys ou values for lida, deve imprimir as chaves ou valores em ordem crescente.
 * Sempre que seu programa ler as operações put e remove, ele deve imprimir o estado da tabela após a execução dessas operações.
 *
 * Restrições
 * - Sua tabela deve ser baseada em arrays. Contudo, as listas dentro da tabela devem ser do tipo ArrayList.
 * - A função de hash deve ser sempre a mesma: key % M, onde M é o tamanho da tabela.
 * - Crie a classe TabelaHash para organizar o seu código.
 * - Crie uma classe Pair como abstração para chave e valor.
 */
class TabelaHashChaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        HashTable hashTable = new HashTable(size);
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

class HashTable {
    private Object[] table;
    private int totalElements;
    private int size;

    HashTable(int size) {
        this.table = new Object[size];
        this.size = size;
        this.totalElements = 0;

        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new ArrayList<Pair>();
        }
    }

    int[] listKeys() {
        int[] keys = new int[this.totalElements];

        if (!this.isEmpty()) {
            int index = 0;
            for (Object elementList : this.table) {
                ArrayList<Pair> list = (ArrayList<Pair>) elementList;

                for (Pair pair : list) {
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
            for (Object elementList : this.table) {
                ArrayList<Pair> list = (ArrayList<Pair>) elementList;

                for (Pair pair : list) {
                    values[index] = pair.getValue();
                    index++;
                }
            }

            Arrays.sort(values);
        }

        return values;
    }

    void put(int key, String value) {
        int index = this.hash(key);
        ArrayList<Pair> list = (ArrayList<Pair>) this.table[index];

        if (list != null) {
            boolean existElement = this.updatePair(list, key, value);

            if (!existElement) {
                list.add(new Pair(key, value));
                table[index] = list;
                this.totalElements++;
            }
        }
    }

    void remove(int key) {
        if (!this.isEmpty()) {
            int index = this.hash(key);

            if (this.table[index] != null) {
                ArrayList<Pair> list = (ArrayList<Pair>) this.table[index];
                Pair pair = this.search(list, key);

                if (pair != null) {
                    list.remove(pair);
                    this.totalElements--;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.table);
    }

    int hash(int key) {
        return key % this.size;
    }

    boolean isEmpty() {
        return this.totalElements == 0;
    }

    boolean updatePair(ArrayList<Pair> list, int key, String value) {
        boolean updated = false;
        Pair pair = this.search(list, key);

        if (pair != null) {
            pair.setValue(value);
            updated = true;
        }

        return updated;
    }

    Pair search(ArrayList<Pair> list, int key) {
        Pair pairFound = null;

        if (!this.isEmpty()) {
            boolean notFound = true;
            int index = 0;

            while (notFound && index != list.size()) {
                Pair pair = list.get(index);

                if (pair.getKey() == key) {
                    pairFound = pair;
                    notFound = false;
                }

                index++;
            }
        }

        return pairFound;
    }
}

class Pair {
    private int key;
    private String value;

    Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    int getKey() {
        return this.key;
    }

    String getValue() {
        return this.value;
    }

    void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "<" + this.key + ", " + this.value + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair par = (Pair) o;
        return key == par.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
