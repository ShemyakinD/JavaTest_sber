package com.company.Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {

    public static void getAllCost (String[] cars){
        double resultCost = 0.0;
        Vehicle[] vehicles = parseCars(cars);
        Map<String,Double> vehiclesGroupCost = getVehicleGroupCostMap(vehicles);
        for (Vehicle vehicle : vehicles) {
            double cost = getVehicleCost(vehicle);
            resultCost += cost;
            System.out.printf("\n%s гос. номер %s затратил на обслуживание %.2f", vehicle.getVehicleType(), vehicle.getNumber(), cost);
        }
        System.out.println("\n------------------------------------");

        for (String vehicleType : vehiclesGroupCost.keySet()) {
            System.out.printf("\n%s затраты на обслуживание %.2f", vehicleType, vehiclesGroupCost.get(vehicleType));
        }

        System.out.printf("\n\nИтоговая стоимость обслуживания %.2f",resultCost);
    }

    public static void getMaxCost(String[] cars){
        Vehicle[] vehicles = parseCars(cars);
        Map<String,Double> vehiclesGroupCost = getVehicleGroupCostMap(vehicles);
        Double maxCost = -99999990.0;
        String typeName = "";
        for (String vehicleType: vehiclesGroupCost.keySet()) {
            if (maxCost < vehiclesGroupCost.get(vehicleType)) {
                maxCost = vehiclesGroupCost.get(vehicleType);
                typeName = vehicleType;
            }
        }
        System.out.printf("\nАвто с максимальным расходом: %s %.2f",typeName,maxCost);
    }

    public static void getMinCost(String[] cars){
        Vehicle[] vehicles = parseCars(cars);
        Map<String,Double> vehiclesGroupCost = getVehicleGroupCostMap(vehicles);
        Double minCost = 99999990.0;
        String typeName = "";
        for (String vehicleType: vehiclesGroupCost.keySet()) {
            if (minCost > vehiclesGroupCost.get(vehicleType)) {
                minCost = vehiclesGroupCost.get(vehicleType);
                typeName = vehicleType;
            }
        }
        System.out.printf("\nАвто с минимальным расходом: %s %.2f",typeName,minCost);
    }

    public static void sortVehicles(String[] cars, int vehicleType, int sortBy){
        Vehicle[] vehicles = parseCars(cars);
        if (sortBy == 0) {
            vehicles = sortVehiclePath(vehicles);
            System.out.println("\nОтсортированные по пробегу автомобили");
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getType() == vehicleType)
                    System.out.printf("Тип: %s, номер: %s, пробег: %s, параметр: %s\n",vehicle.getVehicleType(),vehicle.getNumber(),vehicle.getPath(),vehicle.getParam());
            }
        }
        else {
            vehicles = sortVehicleParam(vehicles);
            System.out.println("\nОтсортированные по параметру автомобили");
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getType() == vehicleType)
                System.out.printf("Тип: %s, номер: %s, пробег: %s, параметр: %s\n",vehicle.getVehicleType(),vehicle.getNumber(),vehicle.getPath(),vehicle.getParam());
            }
        }

    }

    private static Vehicle[] sortVehiclePath(Vehicle[]  vehicleArr) {
        for(int i = vehicleArr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if( vehicleArr[j].getPath() > vehicleArr[j+1].getPath() ){
                Vehicle tmp = vehicleArr[j];
                vehicleArr[j] = vehicleArr[j+1];
                vehicleArr[j+1] = tmp;
                }
            }
        }
        return vehicleArr;
    }

    private static Vehicle[] sortVehicleParam(Vehicle[]  vehicleArr) {
        for(int i = vehicleArr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( vehicleArr[j].getParam() > vehicleArr[j+1].getParam() ){
                    Vehicle tmp = vehicleArr[j];
                    vehicleArr[j] = vehicleArr[j+1];
                    vehicleArr[j+1] = tmp;
                }
            }
        }
        return vehicleArr;
    }

    private static Vehicle[] parseCars(String[] cars){
        List<Vehicle> vehicleList = new ArrayList<>();
        for (String car: cars) {
            int carType = parseVehicleCode(car);
            int carNumber = parseVehicleNumber(car);
            int carPath = parseVehiclePath(car);
            int carParam = parseVehicleParam(car);
            Vehicle newVehicle = new Vehicle(carType,carNumber,carPath,carParam);
            int oldVehicleIndex = checkVehicle(newVehicle,vehicleList);
            if (oldVehicleIndex != -1){
                Vehicle oldVehicle = vehicleList.get(oldVehicleIndex);
                newVehicle.setPath(oldVehicle.getPath() + newVehicle.getPath());
                vehicleList.set(oldVehicleIndex,newVehicle);
            }
            else {
                vehicleList.add(newVehicle);
            }
        }

        Vehicle[] vehicles = new Vehicle[vehicleList.size()];

        return vehicleList.toArray(vehicles);
    }

    private static Map<String,Double> getVehicleGroupCostMap(Vehicle[] vehicles){
        Map<String,Double> vehicleGroup = new HashMap<>();
        for (Vehicle vehicle: vehicles) {
            String vehicleType = vehicle.getVehicleType();
            if (!vehicleGroup.containsKey(vehicleType)) vehicleGroup.put(vehicleType,getVehicleCost(vehicle));
            else vehicleGroup.put(vehicleType,vehicleGroup.get(vehicleType) + getVehicleCost(vehicle));
        }
        return vehicleGroup;
    }

    private static int checkVehicle(Vehicle vehicle, List<Vehicle> vehicleList){
        for (Vehicle element: vehicleList){
            if ((vehicle.getType() == element.getType())&&(vehicle.getNumber() == element.getNumber()))
                return vehicleList.indexOf(element);
        }
        return -1;
    }
    
    private static Integer parseVehiclePath(String car){
        return Integer.parseInt(car.split("-")[1]);
    }

    private static int parseVehicleParam(String car){
        return (car.split("-").length > 2) ? Integer.parseInt(car.split("-")[2]) : 0;
    }

    private static int parseVehicleNumber(String car){
        return Integer.parseInt(car.substring(car.indexOf("_")+1,car.indexOf("-")));
    }

    private static int parseVehicleCode(String car){
        return Integer.parseInt(car.substring(1,car.indexOf("_")));
    }

    private static double getFuleCost(int vehicleType){
        switch (vehicleType) {
            case 100: return 46.1;
            case 200: return 48.9;
            case 300: return 47.5;
            case 400: return 48.9;
            default: return 0.0;
        }
    }

    private static Double getVehicleCost(Vehicle vehicle){
        return (double)vehicle.getPath() / 100 * vehicle.getConsumption() * getFuleCost(vehicle.getType());
    }
}
