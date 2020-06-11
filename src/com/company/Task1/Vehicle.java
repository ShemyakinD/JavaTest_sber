package com.company.Task1;

/**
 * Класс транспортного средства. Задание 1.
 * Содержит геттеры и сеттеры для ТС, а так же функции для возвращения информации по экземпляру
 */
public class Vehicle {
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

    //Получение типа ТС
    public String getVehicleType(){
        switch (this.type) {
            case 100: return "Легковой авто";
            case 200: return "Грузовой авто";
            case 300: return "Пассажирский транспорт";
            case 400: return "Тяжёлая техника";
            default: return "Wrong code";
        }
    }

    //Получение потребления топлива ТС
    public double getConsumption(){
        switch (this.type) {
            case 100: return 12.5;
            case 200: return 12.0;
            case 300: return 11.5;
            case 400: return 20.0;
            default: return 0.0;
        }
    }

}
