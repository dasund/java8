package creational;

/**
 * Created by Dasun De Silva on 8/24/2017.
 */
public class SingletonDesignPatternLazyImplementation {

    //THIS STATIC OBJECT KEEP THE INSTANCE THAT ONLY ONE THIS CLASS IS GOING TO BE CREATED
    private static SingletonDesignPatternLazyImplementation singletonDesignPatternLazyImplementation;

    //THIS PRIVATE CONSTRUCTOR PREVENT ANY OTHER CLASS INSTANTIATING.
    private SingletonDesignPatternLazyImplementation(){

    }

    //THIS PROVIDE ACCESSIBILITY IN GLOBAL
    public static SingletonDesignPatternLazyImplementation getSingletonDesignPatternObject(){
        if(singletonDesignPatternLazyImplementation == null){
            singletonDesignPatternLazyImplementation = new SingletonDesignPatternLazyImplementation();
        }
        return singletonDesignPatternLazyImplementation;
    }

    public void print(int arg){
        System.out.println("Hello here I am " + arg);
    }
}


class TestSingleton{
    public static void main(String[] args) {
        SingletonDesignPatternLazyImplementation.getSingletonDesignPatternObject().print(0);
    }
}

class TestSingletonMultipleThreads implements Runnable{
    int counter = 0;
    public void run(int arg) {
        SingletonDesignPatternLazyImplementation.getSingletonDesignPatternObject().print(arg);

    }

    @Override
    public void run() {
        run( ++counter );
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        TestSingletonMultipleThreads testSingletonMultipleThreads = new TestSingletonMultipleThreads();
        Thread t = new Thread(testSingletonMultipleThreads);
        t.start();
        Thread.sleep(2000);
//        TestSingletonMultipleThreads testSingletonMultipleThreads2 = new TestSingletonMultipleThreads();
        Thread t2 = new Thread(testSingletonMultipleThreads);
        t2.start();

    }
}