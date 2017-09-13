package creational;

/**
 * Created by Dasun De Silva on 8/29/2017.
 */
public class SingletonDesignPatternThreadSafe {

    private static SingletonDesignPatternThreadSafe singletonDesignPatternThreadSafe;

    private SingletonDesignPatternThreadSafe(){

    }

    public static synchronized SingletonDesignPatternThreadSafe getSingletonDesignPatternThreadSafe(){
        if(singletonDesignPatternThreadSafe == null){
            singletonDesignPatternThreadSafe = new SingletonDesignPatternThreadSafe();
        }
        return singletonDesignPatternThreadSafe;
    }
}

class ThreadSafe{

    public static void main(String[] args) {
        SingletonDesignPatternThreadSafe singletonDesignPatternThreadSafe = SingletonDesignPatternThreadSafe.getSingletonDesignPatternThreadSafe();
        SingletonDesignPatternThreadSafe singletonDesignPatternThreadSafe2 = SingletonDesignPatternThreadSafe.getSingletonDesignPatternThreadSafe();
        System.out.println(singletonDesignPatternThreadSafe.hashCode());
        System.out.println(singletonDesignPatternThreadSafe2.hashCode());
    }
}
