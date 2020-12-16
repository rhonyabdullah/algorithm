package pattern;

/**
 * Project hackerrank.
 * <p>
 * Created by Rhony  on 16/10/20.
 */
public class SingletonClassLazy {
    private static SingletonClassLazy sSoleInstance;

    private SingletonClassLazy() {}  //private constructor.

    public static SingletonClassLazy getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            sSoleInstance = new SingletonClassLazy();
        }

        return sSoleInstance;
    }
}
