package Task1_3.Vehicle;

public interface CalculateCost {

    static Double getVehicleCostByFuel(Vehicle vehicle, double fuelCost){
        return (double)vehicle.getPath() / 100 * vehicle.getConsumption() * fuelCost;
    }

    static void printVehicleCost(Vehicle vehicle, double cost){
        System.out.printf("\n%s гос. номер %s затратил на обслуживание %.2f", vehicle.getVehicleType(), vehicle.getNumber(), cost);
    }

    static void printVehicleGroupCost(Vehicle vehicle, double cost){
        System.out.printf("\n%s затраты на обслуживание %.2f", vehicle.getVehicleType(), cost);
    }

}
