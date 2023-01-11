import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/*
TCSS 342 - Professor Sakpal
JD Sawyer
Assignment 3
 */
public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream stream = new PrintStream(new FileOutputStream("output.txt", false));
        HashTable table = new HashTable();
        HashTable java = new HashTable();
        Output.output(new File("src/words.txt"), new File("src/input.txt"),table, java, stream);
    }
}
