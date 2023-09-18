import java.util.logging.Filter;


public abstract class ShortWordFilter implements Filter, ShortWordFilter1 {

    @Override

    public boolean accept(Object x) {

        String word = (String) x;

        return word.length() < 5;

    }

}