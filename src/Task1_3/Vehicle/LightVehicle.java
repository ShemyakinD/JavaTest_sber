package Task1_3.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class LightVehicle extends Vehicle implements CalculateCost {

    public static double consumption = 12.5;
    public static String vehicleType = "Легковой авто";

    public LightVehicle(int number, int path, int param) {
        super(100, number, path, param);
    }

    public double getConsumption() {
        return consumption;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public static LightVehicle[] parse(String[] cars) {
        List<LightVehicle> vehicleList = new ArrayList<>(); //Сначала сделаем список под ТС
        for (String car : cars) { //Проходим по всему массиву строк
            int carType = parseVehicleCode(car);//Парсим из строки тип ТС
            if (carType == 100) {
                int carNumber = parseVehicleNumber(car);//Парсим из строки номер ТС
                int carPath = parseVehiclePath(car);//Парсим пробег
                int carParam = parseVehicleParam(car);//Парсим параметр
                LightVehicle newVehicle = new LightVehicle(carNumber, carPath, carParam);
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

        LightVehicle[] lightVehicles = new LightVehicle[vehicleList.size()]; //обращаем лист в массив и возвращаем его

        return vehicleList.toArray(lightVehicles);
    }

    public static int checkVehicle(LightVehicle vehicle, List<LightVehicle> vehicleList) {
        for (LightVehicle element : vehicleList) {
            if ((vehicle.getType() == element.getType()) && (vehicle.getNumber() == element.getNumber()))
                return vehicleList.indexOf(element);
        }
        return -1;
    }
}
