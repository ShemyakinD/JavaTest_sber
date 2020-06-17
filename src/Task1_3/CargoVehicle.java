package Task1_3;

import java.util.ArrayList;
import java.util.List;

public class CargoVehicle extends Vehicle {

    public static double consumption = 12.0;
    public static String vehicleType = "Грузовой авто";

    public CargoVehicle(int number, int path, int param) {
        super(200, number, path, param);
    }

    public double getConsumption() {
        return consumption;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public static CargoVehicle[] parse(String[] cars) {
        List<CargoVehicle> vehicleList = new ArrayList<>(); //Сначала сделаем список под ТС
        for (String car : cars) { //Проходим по всему массиву строк
            int carType = parseVehicleCode(car);//Парсим из строки тип ТС
            if (carType == 200) {
                int carNumber = parseVehicleNumber(car);//Парсим из строки номер ТС
                int carPath = parseVehiclePath(car);//Парсим пробег
                int carParam = parseVehicleParam(car);//Парсим параметр
                CargoVehicle newVehicle = new CargoVehicle(carNumber, carPath, carParam);
                //Создаём экземпляр ТС и проверяем его наличие в листе
                int oldVehicleIndex = checkVehicle(newVehicle, vehicleList);
                if (oldVehicleIndex != -1) {//Если есть такое ТС уже, то по ИД обновляем ему пробег
                    Vehicle oldVehicle = vehicleList.get(oldVehicleIndex);
                    newVehicle.setPath(oldVehicle.getPath() + newVehicle.getPath());
                    vehicleList.set(oldVehicleIndex, newVehicle);
                } else {//Если ТС новое - вставляем его в лист
                    vehicleList.add(newVehicle);
                }
            } else continue;
        }

        CargoVehicle[] cargoVehicles = new CargoVehicle[vehicleList.size()]; //обращаем лист в массив и возвращаем его

        return vehicleList.toArray(cargoVehicles);
    }

    public static int checkVehicle(CargoVehicle vehicle, List<CargoVehicle> vehicleList) {
        for (CargoVehicle element : vehicleList) {
            if ((vehicle.getType() == element.getType()) && (vehicle.getNumber() == element.getNumber()))
                return vehicleList.indexOf(element);
        }
        return -1;
    }
}
