package singleton_design_pattern;

// Eager Singleton - The instance is created when the class is loaded.
class SingletonEager {
    private static SingletonEager instance = new SingletonEager(); // Eagerly create an instance.

    private SingletonEager() {
        // Private constructor to prevent external instantiation.
    }

    public static SingletonEager getInstance() {
        return instance;
    }
}

// Lazy Singleton - The instance is created when it is first requested.
class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent external instantiation.
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// Lazy Singleton with synchronized method - Thread-safe but with a performance overhead.
class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod() {
        // Private constructor to prevent external instantiation.
    }

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

// Lazy Singleton with double-checked locking - Thread-safe and efficient.
class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
        // Private constructor to prevent external instantiation.
    }

    public static SingletonSynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        System.out.println(instance);
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println(instance1);
    }
}
