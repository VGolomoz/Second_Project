package Task6;

import java.util.Comparator;

public class WordsComparator implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {

        int result = 0;

        if (o1.length()<1 || o2.length()<1) result = o1.toLowerCase().compareTo(o2.toLowerCase());
        else result = o1.toLowerCase().substring(0,1).compareTo(o2.toLowerCase().substring(0,1));

        return result;
    }
}
