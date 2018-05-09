package singleton;

public class LazySingleton2 {
    private LazySingleton2() {
    }

    static class SingletonHolder {
        private static final LazySingleton2 instance = new LazySingleton2();
    }

    public static LazySingleton2 getInstance() {
        return SingletonHolder.instance;
    }
}