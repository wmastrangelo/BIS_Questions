
package yourChoice;

import java.util.Collections;
import java.util.Scanner;
import java.net.URL;
import java.util.ArrayList;

public class WordCount {

    public static void main(String[] args) {

        try {
            ArrayList<Word> new1 = readFile();
            // Prints all values in ArrayList
            for (int i = 0; i < new1.size(); i++) {
                System.out.println(new1.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Word> readFile() throws Exception {
        // Initialize container for words
        ArrayList<Word> words = new ArrayList<Word>();

        try {
            // Open Stream to data source
            URL url = new URL("https://www.gutenberg.org/files/1/1-0.txt");
            Scanner scan = new Scanner(url.openStream());
            // Loop until end of file
            while (scan.hasNext()) {
                // Taking in by an entire line and then splitting on a regular expression
                String line = scan.nextLine();
                String[] lineArray = line.split(("[\\p{Punct}\\s]+"));
                // String workingStr = cleanString(scan.next());
                for (int i = 0; i < lineArray.length; i++) {
                    String workingStr = cleanString(lineArray[i]);
                    // String splitting can sometimes return an empty string, check against this
                    if (!workingStr.equals("")) {
                        int index = indexOfString(words, workingStr);
                        // Finds a word in ArrayList already
                        if (index != -1) {
                            // Iterate the count of that word
                            words.get(index).setCount(words.get(index).getCount() + 1);
                        }
                        // Does not find a word in list already
                        else {
                            words.add(new Word(workingStr, 1));
                        }
                    }
                }
            }
            // Sorts ArrayList
            Collections.sort(words);
            scan.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    // Forces all letters to lowercase
    public static String cleanString(String str) {
        // String cleaned = str.replaceAll("\\p{Punct}", "").trim().toLowerCase();
        String cleaned = str.toLowerCase();
        return cleaned;
    }

    // Find if the word is already stored in the ArrayList
    // Returns index of word if found, returns -1 if that word does not exist in
    // ArrayList
    public static int indexOfString(ArrayList<Word> words, String s) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getString().equals(s)) {
                return i;
            }
        }
        return -1;
    }

}

// Object that holds words and their frequency
// Comparable allows for use of Collections.sort()
class Word implements Comparable<Word> {
    private String string;
    private int count;

    public Word() {

    }

    public Word(String string, int count) {
        this.string = string;
        this.count = count;
    }

    public String toString() {
        String str = string + " " + count + "";
        return str;
    }

    public String getString() {
        return this.string;
    }

    public void setWord(String w) {
        this.string = w;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int c) {
        this.count = c;
    }

    // Tells Collections.sort() what field to sort on
    // Sorts in descending order
    @Override
    public int compareTo(Word compares) {
        int compareCount = compares.getCount();

        return compareCount - this.count;

    }

}