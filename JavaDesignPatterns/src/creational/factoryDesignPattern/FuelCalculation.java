package creational.factoryDesignPattern;

/**
 * Created by Dasun De Silva on 8/16/2017.
 */
public interface FuelCalculation {
    public String getVehicleType(int category);
    public double getFuelConsumption(int rpm, String type);

}

class PetrolCarConsumption implements FuelCalculation{

    @Override
    public String getVehicleType(int category) {
        String carType;
        switch (category) {
            case 1:
                carType = "LIGHT_VEHICLE";
                break;
            case 2:
                carType = "HEAVY_VEHICLE";
                break;
            default:
                carType = "MIDDLE_LEVEL_VEHICLE";
        }
        return carType;
    }

    @Override
    public double getFuelConsumption(int rpm, String type) {
        double consumption = 0;
        switch (type) {
            case "LIGHT_VEHICLE":
                consumption = .10 * rpm;
                break;
            case "HEAVY_VEHICLE":
                consumption = .06 * rpm;
                break;
            case "MIDDLE_LEVEL_VEHICLE":
                consumption = .08 * rpm;
                break;
            default:
                consumption = .09 * rpm;
                break;
        }
        return consumption;
    }

}

class DieselCarConsumption implements FuelCalculation{

    @Override
    public String getVehicleType(int category) {
        String carType;
        switch (category) {
            case 1:
                carType = "LIGHT_VEHICLE";
                break;
            case 2:
                carType = "HEAVY_VEHICLE";
                break;
            default:
                carType = "MIDDLE_LEVEL_VEHICLE";
        }
        return carType;
    }

    @Override
    public double getFuelConsumption(int rpm, String type) {
        double consumption = 0;
        switch (type) {
            case "LIGHT_VEHICLE":
                consumption = .12 * rpm;
                break;
            case "HEAVY_VEHICLE":
                consumption = .08 * rpm;
                break;
            case "MIDDLE_LEVEL_VEHICLE":
                consumption = .10 * rpm;
                break;
            default:
                consumption = .11 * rpm;
                break;
        }
        return consumption;
    }
}

//USAGE WITHOUT FACTORY - START
class ConsumptionWithoutFactory{
    public static void main(String[] args) {
        PetrolCarConsumption petrolCarConsumption = new PetrolCarConsumption();
        String vehicleType = petrolCarConsumption.getVehicleType(1);
        System.out.println("PETROL CONSUMPTION FOR LIGHT VEHICLE= "  + petrolCarConsumption.getFuelConsumption(1000, vehicleType));

        vehicleType = petrolCarConsumption.getVehicleType(2);
        System.out.println("PETROL CONSUMPTION  FOR HEAVY VEHICLE= "  + petrolCarConsumption.getFuelConsumption(2000, vehicleType));

    }
}
//USAGE WITHOUT FACTORY - END


//IMPLEMENT THE FACTORY CLASS & USE FACTORY-  START
class FuelFactory{
    public static FuelCalculation getVehicleCategory(int category){

        if(category == 1)
            return new PetrolCarConsumption();
        else if(category == 2)
            return new DieselCarConsumption();

        return null;
    }
}

class ConsumptionWithFactory{
    public static void main(String[] args) {
//        FuelFactory fuelFactory = new FuelFactory();
        FuelCalculation fuelCalculation = FuelFactory.getVehicleCategory(1);
        if(fuelCalculation != null) {
            String vehicleType = fuelCalculation.getVehicleType(1);
            System.out.println("PETROL CONSUMPTION USING FACTORY FOR LIGHT VEHICLE = "  + fuelCalculation.getFuelConsumption(1000,vehicleType) );

            vehicleType = fuelCalculation.getVehicleType(2);
            System.out.println("PETROL CONSUMPTION USING FACTORY FOR HEAVY VEHICLE = "  + fuelCalculation.getFuelConsumption(2000,vehicleType) );
        } else {
            System.out.println("YOU HAVE NOT PASSED CORRECT VEHICLE CATEGORY. CATEGORY = 1 FOR PETROL, CATEGORY = 2 FOR DIESEL");
        }

    }
}
//IMPLEMENT THE FACTORY CLASS & USE FACTORY - END

