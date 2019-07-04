package Task14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private Set<String> palindromeList;
    private List<String> maxPalindromes;

    public void printMaxPalindrome() {

        parseToSentences(readText());
        if (!palindromeList.isEmpty()) {
            findMaxPalindrome();
            System.out.println("Max length palindromes: ");
            for (String s : maxPalindromes) {
                System.out.println(s);
            }
        } else System.err.println("There is no palindromes!");
    }

    public void printAllPalindromes() {
        if (!palindromeList.isEmpty()) {
            System.out.println("========================");
            System.out.println("All finded palindromes: ");
            for (String s : palindromeList) {
                System.out.println(s);
            }
        }
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

    private void checkPalindrome(String sentence) {
        palindromeList = new HashSet<>();
        int l = sentence.length();
        for (int i = 0; i < l; ++i) {
            for (int j = 0; j < (l - i); ++j) {
                String subs = sentence.substring(j, i + j + 1);
                if (isPalindrome(subs) && subs.length() > 1)
                    palindromeList.add(subs);
            }
        }
    }

    private boolean isPalindrome(String s) {

        if (s.length() <= 1) return true;
        if (s.charAt(0) == s.charAt(s.length() - 1)) return isPalindrome(s.substring(1, s.length() - 1));
        return false;
    }

    private void parseToSentences(String text) {

        Pattern pattertSentence = Pattern.compile("([^(\\.|!|\\?)]+)(\\.|!|\\?)");
        Matcher matcher = pattertSentence.matcher(text);
        StringBuilder sentence = new StringBuilder();
        while (matcher.find()) {
            sentence.append(matcher.group());
        }
        checkPalindrome(sentence.toString().trim().replaceAll("[.-]", "").replaceAll("\\s+", " ").toLowerCase());
    }

    private String readText() {
        StringBuilder text = new StringBuilder();
        try {
            FileReader fr = new FileReader("Task1.txt");
            Scanner in = new Scanner(fr);
            while (in.hasNext()) {
                text.append(in.nextLine().replaceAll("[^а-яА-Яa-zA-Z.!?'-]", " ")
                        .replaceAll("(\\t)&(\\n)&(\\r)&(\\f)&(\\u0085)&(\\u2028)&(\\u2029)", " "));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        /*System.out.println(text);*/
        return text.toString();
    }
}
