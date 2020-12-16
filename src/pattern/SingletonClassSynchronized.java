package pattern;

/**
 * Project hackerrank.
 * <p>
 * Created by Rhony  on 16/10/20.
 */
public class SingletonClassSynchronized {
    private static volatile SingletonClassSynchronized sSoleInstance;

    //private constructor.
    private SingletonClassSynchronized(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClassSynchronized getInstance() {
        //Double check locking pattern
        if (sSoleInstance == null) { //Check for the first time

            synchronized (SingletonClassSynchronized.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (sSoleInstance == null) sSoleInstance = new SingletonClassSynchronized();
            }
        }

        return sSoleInstance;
    }
}
