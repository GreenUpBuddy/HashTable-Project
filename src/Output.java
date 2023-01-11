import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
/*
TCSS 342 - Professor Sakpal
JD Sawyer
Assignment 3
 */
public class Output {
    /**
     * output method for outputfile
     *
     * @param filename the file wished to be input
     * @param table    the table to be added to
     * @param java     the java table to track java collisions
     * @throws FileNotFoundException if the input file does not exist.
     */
    public static void output(File filename, File anagramsFile, HashTable table, HashTable java,PrintStream stream) throws FileNotFoundException {
        long myTime1;
        long myTime2;
        long totTime;
        double seconds;
        Scanner in;

        /*
        This is used to calculate the java collision count without slowing my table down.
         */

        try {
            in = new Scanner(filename);
            while (in.hasNextLine()) {
                Anagram word = new Anagram();
                word.setWord(in.nextLine());
                java.javaAdd(word);
            }
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException("The file words.txt does not exist");
        }

        Scanner javaIn;
        try {
            javaIn = new Scanner(filename);
            HashSet javaTable = new HashSet();
            myTime1 = System.nanoTime();
            while (javaIn.hasNextLine()) {
                Anagram word = new Anagram();
                word.setWord(javaIn.nextLine());
                javaTable.add(word);
            }
            myTime2 = System.nanoTime();
            totTime = myTime2 - myTime1;
            seconds = (double) totTime / 1_000_000_000;
            stream.append("Java time: " + seconds + " seconds" + "\n");
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException("The file words.txt does not exist");
        }

        /*
            This portion of my code inserts the contents of the words.txt file into my hashtable
            and another hashTable used to keep track of Java's collisions
            Then reports the time taken in seconds.
         */


        try {
            in = new Scanner(filename);
            myTime1 = System.nanoTime();
            while (in.hasNextLine()) {
                Anagram word = new Anagram();
                word.setWord(in.nextLine());
                table.add(word);
            }
            myTime2 = System.nanoTime();
            totTime = myTime2 - myTime1;
            seconds = (double) totTime / 1_000_000_000;
            stream.append("My time: " + seconds + " seconds" + "\n");
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException("The file words.txt does not exist");
        }

        /*
            This portion of my code reports the collisions from my hashfunction and java's
            String hashcode function.

            Then it checks my HashTable for the queried anagram inputs based on input.txt.
         */
        stream.append("Java Collision Count: ").append(java.getJavaCol() + "" + "\n");
        stream.append("My Collision Count: ").append(table.getColCount() + "" + "\n");


        Scanner input = new Scanner(anagramsFile);
        while (input.hasNextLine()) {
            Anagram word = new Anagram();
            stream.append("\n");
            word.setWord(input.nextLine().strip().toLowerCase());
            if (table.get(table.search(word)) != null) {
                stream.append("input: ").append(word.getWord() + " ").append(table.get(table.search(word)).getValues().size() + " ").append(table.get(table.search(word)).getValues().toString());
                stream.append("\n");
            } else {
                stream.append("input: ").append(word.getWord() + " ").append("0");
                stream.append("\n");
            }
        }
    }
}
