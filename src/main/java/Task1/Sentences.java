package Task1;

import java.util.ArrayList;
import java.util.List;

public class Sentences implements TextElement {

    private List<TextElement> sentences;

    public Sentences() {
        sentences = new ArrayList<TextElement>();
    }

    public void addElement(TextElement element) {
        sentences.add(element);
    }

    public void removeElement(TextElement element) {
        sentences.remove(element);
    }

    public TextElement getElement(int index) {
        return sentences.get(index);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (TextElement s : sentences) {
            result.append(s);
        }
        return result.toString();
    }

    public void toPrint() {
        for (TextElement te : sentences) {
            System.out.println(te.getClass());
            System.out.println(te.toString());
        }
    }
}
