package creational.abstractFactoryDesignPattern;

/**
 * Created by Dasun De Silva on 8/21/2017.
 */

/**
 * CREATED THE ABSTRACT COST INTERFACE HERE.
 */
public interface TravellingCost {
    double setCostPerKM();
}

/**
 * CREATING FIRST CONCRETE COST CLASSES FOR BUS TRAVELLERS.
 */

class BusTravellingCost implements TravellingCost{

    @Override
    public double setCostPerKM() {
        return 100;
    }
}

/**
 * CREATING SECOND CONCRETE COST CLASSES FOR UBER TAXI TRAVELLERS.
 */
class UberTravellingCost implements TravellingCost{

    @Override
    public double setCostPerKM() {
        return 150;
    }
}

/**
 * CREATING ABSTRACT FACTORY
 */

interface AbstractCostFactory{
    TravellingCost generateCost();
}

/**
 * CREATING CONCRETE FACTORY FOR BUS TRAVELLERS
 */

class BusCostFactory implements AbstractCostFactory{
    public TravellingCost generateCost(){
        BusTravellingCost busTravellingCost  = new BusTravellingCost();
        return busTravellingCost;
    }
}

/**
 * CREATING CONCRETE FACTORY FOR UBER TRAVELLERS
 */

class UberCostFactory  implements AbstractCostFactory{
    public TravellingCost generateCost(){
        UberTravellingCost uberTravellingCost = new UberTravellingCost();
        return uberTravellingCost;
    }
}

/**
 * NOW CREATING TRAVELLER CLASS WHICH METHOD SEND TRAVELLINGCOST OBJECT ACRODING TO PASSING COST FACTORY TYPE.
 */
class Traveller{
    public double getCheapestRide(AbstractCostFactory abstractCostFactory){
        TravellingCost travellingCost = abstractCostFactory.generateCost();
        return travellingCost.setCostPerKM();
    }
}


/**
 * THIS CLASS CALLED TRAVELLED CLASS TO GET THE COST BUT WE HAVE TO PASS RELEVANT FACTORY AS A PARAMETER.
 */
class Main{
    public static void main(String[] args) {
        Traveller traveller = new Traveller();
        //GET BUS COST
        AbstractCostFactory abstractBusCostFactory = new BusCostFactory();
        System.out.println( "BUS COST = " + traveller.getCheapestRide(abstractBusCostFactory)  );

        //GET UBER COST
        AbstractCostFactory abstractUberCostFactory = new UberCostFactory();
        System.out.println( "UBER COST = " + traveller.getCheapestRide(abstractUberCostFactory)  );
    }
}






