package Task1;

public class Marks implements TextElement {

    private String str;

    public Marks(String str){
        this.str = str;
    }

    public void addElement(TextElement element) {
        throw new UnsupportedOperationException();
    }

    public void removeElement(TextElement element) {
        throw new UnsupportedOperationException();
    }

    public TextElement getElement(int index) {
        return this;
    }

    public String toString() {
        return str;
    }

    public void toPrint(){
        throw new UnsupportedOperationException();
    }
}
