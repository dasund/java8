package creational;

/**
 * Created by Dasun De Silva on 9/11/2017.
 */
public enum  SingletonEnum {
    INSTANCE;

    public void doStuff(){
        System.out.println("Enum using singleton hashcode = " + hashCode());
    }
}

class CallEnum{
    public static void main(String[] args) {
        SingletonEnum.INSTANCE.doStuff();
        SingletonEnum.INSTANCE.doStuff();
    }
}
