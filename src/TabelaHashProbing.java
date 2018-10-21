import java.util.Arrays;
import java.util.Scanner;

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

    int hashProbe(int key, int probe) {
        return (this.hash(key) + probe) % this.size;
    }

    int indexOf(int key) {
        int indexOf = -1;

        if (!isEmpty()) {
            int probe = 0;
            int index = this.hashProbe(key, probe);

            while (this.table[index] != null && probe != this.size && indexOf == -1) {
                if (this.table[index].getKey() == key) {
                    indexOf = index;
                } else {
                    probe++;
                    index = this.hashProbe(key, probe);
                }
            }
        }

        return indexOf;
    }

    boolean isEmpty() {
        return this.totalElements == 0;
    }

    boolean isFull() {
        return (this.size - 1) == this.totalElements;
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
                int index = this.hashProbe(key, probe);

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
