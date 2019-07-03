package Task1;

public interface TextElement {

    void addElement(TextElement element);

    void removeElement(TextElement element);

    TextElement getElement(int index);

    String toString();

    void toPrint();
}
