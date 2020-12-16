@file:Suppress("FunctionName")

package pattern

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException

/**
 * Project hackerrank.
 *
 * @see <a href="https://medium.com/@kevalpatel2106/digesting-singleton-design-pattern-in-java-5d434f4f322">source medium</a>
 * Created by Rhony  on 16/10/20.
 */
class SingletonClassTest {

    @Test
    fun `Eager init - check hashCode equals from the same thread`() {
        val s1 = SingletonClassEager.getInstance().hashCode()
        val s2 = SingletonClassEager.getInstance().hashCode()

        assertEquals("Singleton hashcode is different:", s1, s2)

        println(
            "This approach has one drawback. Here instance is created even though client application might " +
                    "\n not be using it. This might be a considerable issue if your singleton class in \n" +
                    "creating a database connection or creating a socket. This may cause the memory leak \n " +
                    "problem. The solution is to create the new instance of the class, when needed. \n" +
                    "This can be achieved by Lazy Initialization method."
        )

        println("\nLet's try to test with lazy init")
    }

    @Test
    fun `Lazy init - check hashCode equals from the same thread`() {
        val s1 = SingletonClassLazy.getInstance().hashCode()
        val s2 = SingletonClassLazy.getInstance().hashCode()

        assertEquals("Singleton hashcode is different:", s1, s2)

        println(
            "We can see that both the instances are having the same hash code. So, that means above " +
                    "\ncode will make the perfect singleton. Right???? No."
        )

        println("\nWhat about Java Reflection API?")
    }

    @Test
    fun `Lazy init - check hashCode equals using java reflection API`() {

        println("Create the 1st instance")
        val s1: SingletonClassLazy = SingletonClassLazy.getInstance()

        println("Create 2nd instance using Java Reflection API.")
        var s2: SingletonClassLazy? = null
        try {
            val clazz: Class<SingletonClassLazy> = SingletonClassLazy::class.java
            val cons: Constructor<SingletonClassLazy> = clazz.getDeclaredConstructor()
            cons.isAccessible = true
            s2 = cons.newInstance()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        }

        assertEquals(
            "\n See that equal assertion is not green, that mean singleton has multiple instances" +
                    "\n To prevent singleton failure while due to reflection we have to throw a run-time " +
                    "\nexception in constructor, if the constructor is already initialized and some class to " +
                    "initialize it again." +
                    "\nBut throwing exception still not a proper way !" +
                    "\nSingleton hashcode is different:", s1.hashCode(), s2.hashCode()
        )
    }

    @Test
    fun `Lazy init - test for thread safe`() {
        var s1HashCode = 0
        var s2HashCode = 1
        val thread1 = Thread {
            s1HashCode = SingletonClassLazy.getInstance().hashCode()
        }
        val thread2 = Thread {
            s2HashCode = SingletonClassLazy.getInstance().hashCode()
        }

        thread1.start()
        thread2.start()

        println("\nJust run multiple times in case the singleton remains the same hashcode")

        Thread.sleep(500)
        assertEquals("\nSingleton hashcode is different:", s1HashCode, s2HashCode)
    }

    /**
     * @see <a href="https://www.javamex.com/tutorials/synchronization_volatile.html">What is volatile ?</a>
     *
     * Skipping out to use synchronized and volatile
     */
    @Test
    fun `Lazy init - Solution test with synchronized and volatile`() {
        var s1HashCode = 0
        var s2HashCode = 0
        val thread1 = Thread {
            s1HashCode = SingletonClassSynchronized.getInstance().hashCode()
        }
        val thread2 = Thread {
            s2HashCode = SingletonClassSynchronized.getInstance().hashCode()
        }

        thread1.start()
        thread2.start()

        println("\nJust run multiple times to prove that hash code still the same")

        Thread.sleep(500)
        assertEquals(s1HashCode, s2HashCode)
    }

}
