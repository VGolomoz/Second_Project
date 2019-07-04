package Task6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TextParser {

    private List<String> list;

    public void print() {

        parseToWords(readText());

        String letter = list.get(0);
        boolean redline = true;

        for (String word : list) {
            if (word.toLowerCase().charAt(0) != letter.toLowerCase().charAt(0)) {
                redline = true;
                letter = word;
            }
            if (redline) {
                System.out.print("\n" + "\r");
                System.out.print(word + " ");
            }
            else {
                System.out.print(word + " ");
            }
            redline = false;
        }
    }


    private void parseToWords(String text) {

        list = new ArrayList<>();

        String[] words = text.split(" ");

        for (String word : words) {
            list.add(word);
        }
        Collections.sort(list, new WordsComparator());
    }


    private String readText() {
        StringBuilder text = new StringBuilder();
        try {
            FileReader fr = new FileReader("Task1.txt");
            Scanner in = new Scanner(fr);
            while (in.hasNext()) {
                text.append(in.nextLine().replaceAll("\\s-\\s", " ").replaceAll("[^а-яА-Яa-zA-Z-']", " ")
                        .replaceAll("(\\s+)|(\\t)|(\\n)|(\\r)|(\\f)|(\\u0085)|(\\u2028)|(\\u2029)", " "));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        /*System.out.println(text);*/
        return text.toString().trim();
    }
}
