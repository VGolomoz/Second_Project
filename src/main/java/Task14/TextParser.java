package Task14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TextParser {

    private Set<String> wordsList;
    private Set<String> palindromeList;
    private ArrayList<String> maxPalindromes;

    public void print() {

        parseToWords(readText());
        if (checkPalindrome()) {
            findMaxPalindrome();
            System.out.println("Palindromes: ");
            for (String s : maxPalindromes) {
                System.out.println(s);
            }
        } else System.err.println("There is no palindromes!");
    }

    private void findMaxPalindrome() {
        maxPalindromes = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(palindromeList);
        String max = temp.get(0);

        for (String s : temp) {
            if (s.length() < max.length()) continue;
            else max = s;
        }

        for (String s : temp) {
            if (s.length() < max.length()) continue;
            else maxPalindromes.add(s);
        }
    }

    private boolean checkPalindrome() {
        palindromeList = new HashSet<>();
        boolean flag = false;

        for (String s : wordsList) {
            int L = s.length();
            for (int i = 1; i < L; ++i) {
                for (int j = 0; j < (L - i); ++j) {
                    String subs = s.substring(j, i + j + 1);
                    if (isPalindrome(subs) && subs.length() > 1)
                        palindromeList.add(subs);
                }
            }
        }
        if (!palindromeList.isEmpty()) flag = true;
        return flag;
    }

    private boolean isPalindrome(String s) {

        if (s.length() <= 1) return true;
        if (s.charAt(0) == s.charAt(s.length() - 1)) return isPalindrome(s.substring(1, s.length() - 1));
        return false;
    }

    private void parseToWords(String text) {

        wordsList = new HashSet<>();

        String[] words = text.split(" ");

        for (String word : words) {
            if (word.length() > 1)
                wordsList.add(word);
        }
    }

    private String readText() {
        StringBuilder text = new StringBuilder();
        try {
            FileReader fr = new FileReader("Task1.txt");
            Scanner in = new Scanner(fr);
            while (in.hasNext()) {
                text.append(in.nextLine().replaceAll("[^а-яА-Яa-zA-Z]", " ")
                        .replaceAll("(\\s+)|(\\t)|(\\n)|(\\r)|(\\f)|(\\u0085)|(\\u2028)|(\\u2029)", " "));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        /*System.out.println(text);*/
        return text.toString().trim();
    }
}
