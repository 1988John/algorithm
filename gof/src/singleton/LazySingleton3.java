package singleton;

public class LazySingleton3 {

    private static boolean initialized = false;

    private LazySingleton3() {
        synchronized (LazySingleton3.class) {
            if (!initialized) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("单例已被破坏");
            }
        }
    }

    static class SingletonHolder {
        private static final LazySingleton3 instance = new LazySingleton3();
    }

    public static LazySingleton3 getInstance() {
        return SingletonHolder.instance;
    }

}