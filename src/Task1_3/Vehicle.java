package Task1_3;

/**
 * Класс транспортного средства. Задание 1.
 * Содержит геттеры и сеттеры для ТС, а так же функции для возвращения информации по экземпляру
 */
abstract class Vehicle {
    private int type;//тип ТС
    private int number;//номер авто
    private int path;//пробег
    private int param;//параметр

    //Конструктор для ТС
    public Vehicle(int type, int number, int path, int param) {
        this.type = type;
        this.number = number;
        this.path = path;
        this.param = param;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    public abstract String getVehicleType();

    public abstract double getConsumption();

    //Парсим пробег ТС из строки
    public static Integer parseVehiclePath(String car) {
        return Integer.parseInt(car.split("-")[1]);
    }

    //Парсим параметр ТС из строки
    public static int parseVehicleParam(String car) {
        return (car.split("-").length > 2) ? Integer.parseInt(car.split("-")[2]) : 0;
    }

    //Парсим номер ТС из строки
    public static int parseVehicleNumber(String car) {
        return Integer.parseInt(car.substring(car.indexOf("_") + 1, car.indexOf("-")));
    }

    //Парсим тип ТС из строки
    public static int parseVehicleCode(String car) {
        return Integer.parseInt(car.substring(1, car.indexOf("_")));
    }
}
