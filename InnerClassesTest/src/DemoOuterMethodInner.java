/**
 * Created by Aux-039 on 5/22/2017.
 */
public class DemoOuterMethodInner {
    void display(){
        class Inner{
            public int display1(){
                return 10;
            }
        }
        Inner inner = new Inner();
        System.out.println(inner.display1());

    }

    public static void main(String[] args) {
        DemoOuterMethodInner dmi = new DemoOuterMethodInner();
        dmi.display();
    }
}
