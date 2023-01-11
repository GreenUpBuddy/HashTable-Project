import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
TCSS 342 - Professor Sakpal
JD Sawyer
Assignment 3
 */
public class Anagram {
    //List of words that are anagrams with this object.
    private final ArrayList<String> values = new ArrayList<>();
    //the word value attached to this object;
    private String word;

    //word getter
    public String getWord() {
        return word;
    }

    //word setter also adds the word to the list of anagrams for this word.
    public void setWord(String word) {
        this.word = word;
        this.values.add(this.word);
    }

    //gets the key for this object (the word sorted)
    public String getKey() {
        String temp = word;
        char[] tempArray = temp.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    //a method to add a new word to the list of anagrams
    public void addValue(String elem) {
        this.values.add(elem);
    }

    //List getter for the list of anagrams.
    public List<String> getValues() {
        return this.values;
    }

    //checks for equality by comparing two anagram objects keys.
    public boolean equals(Anagram o1) {
        return this.getKey().equals(o1.getKey());
    }
}
