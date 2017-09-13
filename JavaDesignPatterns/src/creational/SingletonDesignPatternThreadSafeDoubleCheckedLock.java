package creational;

/**
 * Created by Dasun De Silva on 8/29/2017.
 */
class SingletonDesignPatternThreadSafeDoubleCheckedLock {

    private static SingletonDesignPatternThreadSafeDoubleCheckedLock singletonDesignPatternThreadSafe;

    private SingletonDesignPatternThreadSafeDoubleCheckedLock(){

    }

    public static SingletonDesignPatternThreadSafeDoubleCheckedLock getSingletonDesignPatternThreadSafe(){
        if(singletonDesignPatternThreadSafe == null){
            synchronized (SingletonDesignPatternThreadSafeDoubleCheckedLock.class) {
                singletonDesignPatternThreadSafe = new SingletonDesignPatternThreadSafeDoubleCheckedLock();
            }
        }
        return singletonDesignPatternThreadSafe;
    }
}

class TestDoubleCheck{
    public static void main(String[] args) {
        SingletonDesignPatternThreadSafeDoubleCheckedLock singletonDesignPatternThreadSafeDoubleCheckedLock = SingletonDesignPatternThreadSafeDoubleCheckedLock .getSingletonDesignPatternThreadSafe();
        SingletonDesignPatternThreadSafeDoubleCheckedLock singletonDesignPatternThreadSafeDoubleCheckedLock2 = SingletonDesignPatternThreadSafeDoubleCheckedLock .getSingletonDesignPatternThreadSafe();

        System.out.println(singletonDesignPatternThreadSafeDoubleCheckedLock.hashCode());
        System.out.println(singletonDesignPatternThreadSafeDoubleCheckedLock2.hashCode());
    }
}
