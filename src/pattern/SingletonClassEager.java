package pattern;

/**
 * Project hackerrank.
 * <p>
 * Created by Rhony  on 16/10/20.
 */
public class SingletonClassEager {
    private static volatile SingletonClassEager sSoleInstance = new SingletonClassEager();

    //private constructor.
    private SingletonClassEager(){}

    public static SingletonClassEager getInstance() {
        return sSoleInstance;
    }
}
