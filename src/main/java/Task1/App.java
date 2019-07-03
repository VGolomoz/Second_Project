package Task1;

public class App {

    public static void main(String[] args) {

        TextElement text = new TextParser().parse();

        System.out.println(text.toString());
        //text.toPrint();
    }
}
