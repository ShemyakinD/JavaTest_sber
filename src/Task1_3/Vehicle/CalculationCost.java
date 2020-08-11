package Task1_3.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс вывода и расчёта информации по транспортным средствам. Задание 1.
 * Публичные только методы вывода. Расчёт частная информация.
 */
public class CalculationCost {

    public static void getCost(String[] cars, String filename){
        getAllCost(cars,filename);
        getMaxCost(cars, filename);
        getMinCost(cars, filename);
    }

    //Метод для вывода затрат на обслуживание всех автомобилей
    public static void getAllCost (String[] cars, String filename){
        double resultCost = 0.0;//Переменная для хранения итогового количества затрат на ГСМ
        //Распарсим строковый массив машин в массив объектов транспорт
        CargoVehicle[] cargoVehicles = CargoVehicle.parse(cars);
        HeavyVehicle[] heavyVehicles = HeavyVehicle.parse(cars);
        PassengerVehicle[] passengerVehicles = PassengerVehicle.parse(cars);
        LightVehicle[] lightVehicles = LightVehicle.parse(cars);

        resultCost += calcVehicleGroup(cargoVehicles,true, filename);
        resultCost += calcVehicleGroup(heavyVehicles,true, filename);
        resultCost += calcVehicleGroup(passengerVehicles,true, filename);
        resultCost += calcVehicleGroup(lightVehicles,true, filename);

        //Выводим итоговую стоимость ГСМ
        ConsoleInterface.printToFile(filename,String.format("\n\nИтоговая стоимость обслуживания %.2f\n",resultCost));
    }

    private static double calcVehicleGroup (Vehicle[] vehicles, boolean print, String filename){
        double resultGroupCost = 0.0;
        for (int i = 0; i < vehicles.length; i++){
            double cost = CalculateCost.getVehicleCostByFuel(vehicles[i],getFuleCost(vehicles[i].getType()));
            resultGroupCost += cost;
            if (print && i == vehicles.length - 1)
                    CalculateCost.printVehicleGroupCost(vehicles[i],resultGroupCost, filename);
        }
        return resultGroupCost;
    }

    //Метод вывода максимальной стоимости обслуживания по типам ТС
   public static void getMaxCost(String[] cars, String filename){
        Double maxCost = -99999990.0;
        double calculatedCost = 0.0;
        int type = 0;

        calculatedCost =  calcVehicleGroup(CargoVehicle.parse(cars),false, null);
        if (maxCost < calculatedCost){
            maxCost = calculatedCost;
            type = 0;
        }

       calculatedCost =  calcVehicleGroup(HeavyVehicle.parse(cars),false, null);
       if (maxCost < calculatedCost){
           maxCost = calculatedCost;
           type = 1;
       }

       calculatedCost =  calcVehicleGroup(PassengerVehicle.parse(cars),false, null);
       if (maxCost < calculatedCost){
           maxCost = calculatedCost;
           type = 2;
       }

       calculatedCost =  calcVehicleGroup(LightVehicle.parse(cars),false, null);
       if (maxCost < calculatedCost){
           maxCost = calculatedCost;
           type = 3;
       }

       switch (type){
           case 0: {
               ConsoleInterface.printToFile(filename,String.format("\n\nАвто с максимальным расходом: %s %.2f",CargoVehicle.vehicleType,maxCost));
               break;
           }
           case 1: {
               ConsoleInterface.printToFile(filename,String.format("\nАвто с максимальным расходом: %s %.2f",HeavyVehicle.vehicleType,maxCost));
               break;
           }
           case 2: {
               ConsoleInterface.printToFile(filename,String.format("\nАвто с максимальным расходом: %s %.2f",PassengerVehicle.vehicleType,maxCost));
               break;
           }
           case 3: {
               ConsoleInterface.printToFile(filename,String.format("\nАвто с максимальным расходом: %s %.2f",LightVehicle.vehicleType,maxCost));
               break;
           }
       }
    }

    //Метод вывода минимальной стоимости обслуживания по типам ТС
    //Аналогичен getMaxCost, только ищем минимум по убыванию
    public static void getMinCost(String[] cars, String filename){

        Double minCost = 99999990.0;
        double calculatedCost = 0.0;
        int type = 0;

        calculatedCost =  calcVehicleGroup(CargoVehicle.parse(cars),false, null);
        if (minCost > calculatedCost){
            minCost = calculatedCost;
            type = 0;
        }

        calculatedCost =  calcVehicleGroup(HeavyVehicle.parse(cars),false, null);
        if (minCost > calculatedCost){
            minCost = calculatedCost;
            type = 1;
        }

        calculatedCost =  calcVehicleGroup(PassengerVehicle.parse(cars),false, null);
        if (minCost > calculatedCost){
            minCost = calculatedCost;
            type = 2;
        }

        calculatedCost =  calcVehicleGroup(LightVehicle.parse(cars),false, null);
        if (minCost > calculatedCost){
            minCost = calculatedCost;
            type = 3;
        }

        switch (type){
            case 0: {
                ConsoleInterface.printToFile(filename,String.format("\nАвто с минимальным расходом: %s %.2f",CargoVehicle.vehicleType,minCost));
                break;
            }
            case 1: {
                ConsoleInterface.printToFile(filename,String.format("\nАвто с минимальным расходом: %s %.2f",HeavyVehicle.vehicleType,minCost));
                break;
            }
            case 2: {
                ConsoleInterface.printToFile(filename,String.format("\nАвто с минимальным расходом: %s %.2f",PassengerVehicle.vehicleType,minCost));
                break;
            }
            case 3: {
                ConsoleInterface.printToFile(filename,String.format("\nАвто с минимальным расходом: %s %.2f",LightVehicle.vehicleType,minCost));
                break;
            }
        }
    }

    //Сортировка массива машин по типу и флагу
    //sortBy = 0 - сортировка по Пробегу авто, иначе сортировка по Параметру
    public static void sortVehicles(String[] cars, int vehicleType, int sortBy){
        //Парсим строковый массив машин в массив объектов транспорт
        LightVehicle[] lightVehicles = LightVehicle.parse(cars);
        PassengerVehicle[] passengerVehicles = PassengerVehicle.parse(cars);
        HeavyVehicle[] heavyVehicles = HeavyVehicle.parse(cars);
        CargoVehicle[] cargoVehicles = CargoVehicle.parse(cars);
        Vehicle[] vehicles = concatVehicleTypes(cargoVehicles,lightVehicles,heavyVehicles,passengerVehicles);
        if (sortBy == 0) {
            vehicles = sortVehiclePath(vehicles);//Сортируем массив по Пробегу и перезаписываем его
            System.out.println("\nОтсортированные по пробегу автомобили");
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getType() == vehicleType)
                    System.out.printf("Тип: %s, номер: %s, пробег: %s, параметр: %s\n",vehicle.getVehicleType(),vehicle.getNumber(),vehicle.getPath(),vehicle.getParam());
            }
        }
        else {
            vehicles = sortVehicleParam(vehicles);//Сортируем массив по Параметру и перезаписываем его
            System.out.println("\nОтсортированные по параметру автомобили");
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getType() == vehicleType)
                System.out.printf("Тип: %s, номер: %s, пробег: %s, параметр: %s\n",vehicle.getVehicleType(),vehicle.getNumber(),vehicle.getPath(),vehicle.getParam());
            }
        }
    }

    private static Vehicle[] concatVehicleTypes(CargoVehicle[] cargoVehicles, LightVehicle[] lightVehicles, HeavyVehicle[] heavyVehicles, PassengerVehicle[] passengerVehicles){
        Vehicle[] vehicles = new Vehicle[cargoVehicles.length+lightVehicles.length+heavyVehicles.length+passengerVehicles.length];
       List<Vehicle> vehicleList = new ArrayList<>();
       for (Vehicle vehicle : cargoVehicles){
           vehicleList.add(vehicle);
       }
        for (Vehicle vehicle : lightVehicles){
            vehicleList.add(vehicle);
        }
        for (Vehicle vehicle : heavyVehicles){
            vehicleList.add(vehicle);
        }
        for (Vehicle vehicle : passengerVehicles){
            vehicleList.add(vehicle);
        }
       return vehicleList.toArray(vehicles);
    }

    //Сортировка пузырьком массива ТС по Пробегу
    private static Vehicle[] sortVehiclePath(Vehicle[]  vehicleArr) {
        for(int i = vehicleArr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){//Идём с начала до максимального элемента массива и проталкиваем к нему наибольшие значения
            if( vehicleArr[j].getPath() > vehicleArr[j+1].getPath() ){
                Vehicle tmp = vehicleArr[j];
                vehicleArr[j] = vehicleArr[j+1];
                vehicleArr[j+1] = tmp;
                }
            }
        }
        return vehicleArr;
    }
    //Сортировка пузырьком массива ТС по Параметру
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

    //Вывод стоимости топлива для ТС. Не принадлежит классу Vehicle, т.к. стоимость динамическая и не зависит от ТС
    private static double getFuleCost(int vehicleType){
        switch (vehicleType) {
            case 100: return 46.1;
            case 200: return 48.9;
            case 300: return 47.5;
            case 400: return 48.9;
            default: return 0.0;
        }
    }
}
