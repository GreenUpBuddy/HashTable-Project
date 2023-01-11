/*
TCSS 342 - Professor Sakpal
JD Sawyer
Assignment 3
 */
public class HashTable {
    private final int tableSize = 199999;
    private final Anagram[] table = new Anagram[tableSize];
    private int colCount = 0;
    private int javaCol = 0;

    /**
     * this hashes the string to an index
     *
     * @param key the key to be hashed
     * @return the index at which to be inserted.
     */
    public int hashCode(String key) {
        // P and M
        int p = 31;
        int m = (int) (1e9 + 9);
        long power_of_p = 1;
        long hash_val = 0;

        // Loop to calculate the hash value
        // by iterating over the elements of String
        for (int i = 0; i < key.length(); i++) {
            hash_val = (hash_val + (key.charAt(i) - 'a' + 1) * power_of_p) % m;
            power_of_p = (power_of_p * p) % m;
        }
        if (hash_val < 0) {
            hash_val = hash_val * -1;
        }
        return ((int) hash_val) % tableSize;
    }

    /**
     * java's hashcode function
     *
     * @param key string to be hashed
     * @return the index position to be inserted.
     */
    public int javaHash(String key) {
        int code = key.hashCode();
        if (code < 0) {
            code = code * -1;
        }
        return code % tableSize;
    }

    /**
     * This adds the word to the list using the hashcode function to generate an index.
     * if collision occurs linear probing is used.
     *
     * @param word the anagram object to be added
     */
    public void add(Anagram word) {
        int possible = hashCode(word.getKey());

        if (table[possible] == null) {
            table[possible] = word;
        } else {
            colCount++;
            if (table[possible].equals(word)) {

            } else {
                int i = 0;
                while (table[possible + i] != null) {
                    i++;
                }
                table[possible + i] = word;
            }
        }
    }

    /**
     * This adds using Java's hashcode function. If collision occurs it handles with linear probing.
     *
     * @param word the anagram object to be added.
     */
    public void javaAdd(Anagram word) {
        int possible = javaHash(word.getKey());
        if (table[possible] == null) {
            table[possible] = (word);
        } else {
            javaCol++;
            if (word.equals(table[possible])) {
                table[possible].addValue(word.getWord());
            } else {
                int i = 0;
                while (table[possible + i] != null) {
                    i++;
                }
                table[possible + i] = word;
            }
        }
    }

    /**
     * this searches the list by checking first the given index using the hashfuntion then linearly checking next.
     *
     * @param word the anagram object to search for.
     * @return the index of the object
     */
    public int search(Anagram word) {
        int possible = hashCode(word.getKey());
        if (table[possible] != null && word.equals(table[possible])) {
            return possible;
        } else{
                int i = 0;
                while (table[possible + i] != null) {
                    i++;
                    if (table[possible + i] != null && table[possible + i].equals(word)){
                        return possible + i;
                    }
                }
                return possible + i;
            }
        }

    /**
     * gets the object at a given index
     *
     * @param index the index requested
     * @return the object at index
     */
    public Anagram get(int index) {
        return table[index];
    }

    public int getColCount() {
        return this.colCount;
    }

    public int getJavaCol() {
        return this.javaCol;
    }
}