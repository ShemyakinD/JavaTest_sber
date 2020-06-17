package Task1_3;

import java.util.ArrayList;
import java.util.List;

public class HeavyVehicle extends Vehicle {

    public static double consumption = 20.0;
    public static String vehicleType = "Тяжёлая техника";

    public HeavyVehicle(int number, int path, int param) {
        super(400, number, path, param);
    }

    public double getConsumption() {
        return consumption;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public static HeavyVehicle[] parse(String[] cars) {
        List<HeavyVehicle> vehicleList = new ArrayList<>(); //Сначала сделаем список под ТС
        for (String car : cars) { //Проходим по всему массиву строк
            int carType = parseVehicleCode(car);//Парсим из строки тип ТС
            if (carType == 400) {
                int carNumber = parseVehicleNumber(car);//Парсим из строки номер ТС
                int carPath = parseVehiclePath(car);//Парсим пробег
                int carParam = parseVehicleParam(car);//Парсим параметр
                HeavyVehicle newVehicle = new HeavyVehicle(carNumber, carPath, carParam);
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

        HeavyVehicle[] heavyVehicles = new HeavyVehicle[vehicleList.size()]; //обращаем лист в массив и возвращаем его

        return vehicleList.toArray(heavyVehicles);
    }

    public static int checkVehicle(HeavyVehicle vehicle, List<HeavyVehicle> vehicleList) {
        for (HeavyVehicle element : vehicleList) {
            if ((vehicle.getType() == element.getType()) && (vehicle.getNumber() == element.getNumber()))
                return vehicleList.indexOf(element);
        }
        return -1;
    }
}
