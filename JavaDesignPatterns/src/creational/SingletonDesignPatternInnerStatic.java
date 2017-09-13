package creational;

import java.lang.reflect.Constructor;

/**
 * Created by Dasun De Silva on 8/29/2017.
 */
public class SingletonDesignPatternInnerStatic {

    private SingletonDesignPatternInnerStatic(){}

    private static class Helper{
        private static final SingletonDesignPatternInnerStatic SINGLETON_DESIGN_PATTERN_INNER_STATIC = new SingletonDesignPatternInnerStatic();
    }

    public static SingletonDesignPatternInnerStatic getSingletonDesignPatternInnerStatic(){
        return Helper.SINGLETON_DESIGN_PATTERN_INNER_STATIC;
    }

}


class Test{
    public static void main(String[] args) {
        SingletonDesignPatternInnerStatic singletonDesignPatternInnerStatic = SingletonDesignPatternInnerStatic.getSingletonDesignPatternInnerStatic();
        SingletonDesignPatternInnerStatic singletonDesignPatternInnerStatic2 = SingletonDesignPatternInnerStatic.getSingletonDesignPatternInnerStatic();

        try {
            Constructor[] constructors = SingletonDesignPatternInnerStatic.class.getConstructors();
            for(Constructor x : constructors){
                x.setAccessible(true);
                singletonDesignPatternInnerStatic2 = (SingletonDesignPatternInnerStatic) x.newInstance();
                break;
            }
        } catch (Exception xx){
            xx.printStackTrace();
        }

        System.out.println(singletonDesignPatternInnerStatic.hashCode());
        System.out.println(singletonDesignPatternInnerStatic2.hashCode());
    }
}