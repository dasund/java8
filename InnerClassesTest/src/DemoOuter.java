/**
 * Created by Aux-039 on 5/22/2017.
 */
public class DemoOuter {
    private int x = 10 ;
    private class DemoInner{
        public void display(){
            System.out.println("Inner Class" + x);
        }
    }
     void printInner(){
        DemoInner di = new DemoInner();
        di.display();
    }
}
