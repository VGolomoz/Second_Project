package Task1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";


    public TextElement parse() {
        TextElement sentencesList = parseToSentence(readText());
        return sentencesList;
    }

    private String readText() {
        StringBuilder text = new StringBuilder();
        try {
            FileReader fr = new FileReader("Task1.txt");
            Scanner in = new Scanner(fr);
            while (in.hasNext()) {
                text.append(in.nextLine().trim().replaceAll("\\uFEFF", "")
                        .replaceAll("(\\s+)|(\\t)|(\\n)|(\\r)|(\\f)", " "));
            }
        } catch (Exception e) {
            System.err.println("File not found");
        }
        return text.toString();
    }

    private TextElement parseToSentence(String text) {
        TextElement sentencesList = new Sentences();
        Pattern pattertSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher m2 = pattertSentence.matcher(text);
        String sentence = "";
        while (m2.find()) {
            sentence = m2.group();
            parseToSymbol(sentencesList, sentence);
            //System.out.println("Sentence: " + sentence); //comment 1
        }
        return sentencesList;
    }

    private void parseToSymbol(TextElement sentencesList, String sentence) {

        ArrayList<Character> array = new ArrayList<Character>();
        for (char c : sentence.toCharArray()) {
            array.add(c);
        }

        String someWord = "";

        for (int i = 0; i < array.size(); i++) {

            String symbol = Character.toString(array.get(i));

            if (symbol.matches("[a-zа-яА-ЯA-Z]")) someWord += symbol;

            else if (symbol.matches("[0-9]")) {
                if (!someWord.isEmpty()) sentencesList.addElement(new Word(someWord));
                someWord = "";
                sentencesList.addElement(new Numbers(symbol));
            } else {
                if (!someWord.isEmpty()) sentencesList.addElement(new Word(someWord));
                someWord = "";
                sentencesList.addElement(new Marks(symbol));
            }
            /*System.out.println("symbol: " + symbol); //comment 2*/
        }
    }
}
