package com.company.Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс вывода и расчёта информации по транспортным средствам. Задание 1.
 * Публичные только методы вывода. Расчёт частная информация.
 */
public class Task1 {

    //Метод для вывода затрат на обслуживание всех автомобилей
    public static void getAllCost (String[] cars){
        double resultCost = 0.0;//Переменная для хранения итогового количества затрат на ГСМ
        Vehicle[] vehicles = parseCars(cars);//Распарсим строковый массив машин в массив объектов транспорт
        Map<String,Double> vehiclesGroupCost = getVehicleGroupCostMap(vehicles);//Создаём словарь <Тип ТС, Стоимость обслуживания>
        for (Vehicle vehicle : vehicles) {//Пробегаемся по массиву ТС получаем для каждого стоимость обслуживания и выводим
            double cost = getVehicleCost(vehicle);
            resultCost += cost;//не забываем рассчитать итоговую стоимость обслуживания
            System.out.printf("\n%s гос. номер %s затратил на обслуживание %.2f", vehicle.getVehicleType(), vehicle.getNumber(), cost);
        }
        System.out.println("\n------------------------------------");

        for (String vehicleType : vehiclesGroupCost.keySet()) {//Проходим по ключам словаря типов ТС и стоимостьи и выводим их.
            System.out.printf("\n%s затраты на обслуживание %.2f", vehicleType, vehiclesGroupCost.get(vehicleType));
        }

        //Выводим итоговую стоимость ГСМ
        System.out.printf("\n\nИтоговая стоимость обслуживания %.2f",resultCost);
    }

    //Метод вывода максимальной стоимости обслуживания по типам ТС
    public static void getMaxCost(String[] cars){
        Vehicle[] vehicles = parseCars(cars);//Парсим строковый массив машин в массив объектов транспорт
        Map<String,Double> vehiclesGroupCost = getVehicleGroupCostMap(vehicles);//Создаём словарь <Тип ТС, Стоимость обслуживания>
        Double maxCost = -99999990.0;
        String typeName = "";
        //Пробегаемся по словарю типов ТС и стоимости обслуживания и ищем максимальное значение
        //записываем его в maxCost и выводим
        for (String vehicleType: vehiclesGroupCost.keySet()) {
            if (maxCost < vehiclesGroupCost.get(vehicleType)) {
                maxCost = vehiclesGroupCost.get(vehicleType);
                typeName = vehicleType;
            }
        }
        System.out.printf("\nАвто с максимальным расходом: %s %.2f",typeName,maxCost);
    }
    //Метод вывода минимальной стоимости обслуживания по типам ТС
    //Аналогичен getMaxCost, только ищем минимум по убыванию
    public static void getMinCost(String[] cars){
        Vehicle[] vehicles = parseCars(cars);//Парсим строковый массив машин в массив объектов транспорт
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

    //Сортировка массива машин по типу и флагу
    //sortBy = 0 - сортировка по Пробегу авто, иначе сортировка по Параметру
    public static void sortVehicles(String[] cars, int vehicleType, int sortBy){
        Vehicle[] vehicles = parseCars(cars);//Парсим строковый массив машин в массив объектов транспорт
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

    //Метод парсит массив автомобилей в массив объектов Транспортное Средство (ТС)
    private static Vehicle[] parseCars(String[] cars){
        List<Vehicle> vehicleList = new ArrayList<>(); //Сначала сделаем список под ТС
        for (String car: cars) { //Проходим по всему массиву строк
            int carType = parseVehicleCode(car);//Парсим из строки тип ТС
            int carNumber = parseVehicleNumber(car);//Парсим из строки номер ТС
            int carPath = parseVehiclePath(car);//Парсим пробег
            int carParam = parseVehicleParam(car);//Парсим параметр
            Vehicle newVehicle = new Vehicle(carType,carNumber,carPath,carParam);
            //Создаём экземпляр ТС и проверяем его наличие в листе
            int oldVehicleIndex = checkVehicle(newVehicle,vehicleList);
            if (oldVehicleIndex != -1){//Если есть такое ТС уже, то по ИД обновляем ему пробег
                Vehicle oldVehicle = vehicleList.get(oldVehicleIndex);
                newVehicle.setPath(oldVehicle.getPath() + newVehicle.getPath());
                vehicleList.set(oldVehicleIndex,newVehicle);
            }
            else {//Если ТС новое - вставляем его в лист
                vehicleList.add(newVehicle);
            }
        }

        Vehicle[] vehicles = new Vehicle[vehicleList.size()]; //обращаем лист в массив и возвращаем его

        return vehicleList.toArray(vehicles);
    }

    //Проверка листа с ТС на наличие записи по номеру ТС и типу
    //Если ТС найдено - возвращаем индекс записи в листе, иначе -1
    private static int checkVehicle(Vehicle vehicle, List<Vehicle> vehicleList){
        for (Vehicle element: vehicleList){
            if ((vehicle.getType() == element.getType())&&(vehicle.getNumber() == element.getNumber()))
                return vehicleList.indexOf(element);
        }
        return -1;
    }

    //Метод получения словаря с типом ТС и его затратами на обслуживание на основе массива ТС
    private static Map<String,Double> getVehicleGroupCostMap(Vehicle[] vehicles){
        Map<String,Double> vehicleGroup = new HashMap<>();
        for (Vehicle vehicle: vehicles) {
            //Пробегаемся по массиву ТС извлекаем у каждого тип и добавляем в словарь, при этом высчитывая стоимость обслуживания
            String vehicleType = vehicle.getVehicleType();
            if (!vehicleGroup.containsKey(vehicleType)) vehicleGroup.put(vehicleType,getVehicleCost(vehicle));
            else vehicleGroup.put(vehicleType,vehicleGroup.get(vehicleType) + getVehicleCost(vehicle));
        }
        return vehicleGroup;
    }

    //Парсим пробег ТС из строки
    private static Integer parseVehiclePath(String car){
        return Integer.parseInt(car.split("-")[1]);
    }

    //Парсим параметр ТС из строки
    private static int parseVehicleParam(String car){
        return (car.split("-").length > 2) ? Integer.parseInt(car.split("-")[2]) : 0;
    }

    //Парсим номер ТС из строки
    private static int parseVehicleNumber(String car){
        return Integer.parseInt(car.substring(car.indexOf("_")+1,car.indexOf("-")));
    }

    //Парсим тип ТС из строки
    private static int parseVehicleCode(String car){
        return Integer.parseInt(car.substring(1,car.indexOf("_")));
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

    //Функция расчёта стоимости обслуживания ТС
    private static Double getVehicleCost(Vehicle vehicle){
        return (double)vehicle.getPath() / 100 * vehicle.getConsumption() * getFuleCost(vehicle.getType());
    }
}
