package com.company.Task1;

public class Vehicle {
    private int type;
    private int number;
    private int path;
    private int param;

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

    public String getVehicleType(){
        switch (this.type) {
            case 100: return "Легковой авто";
            case 200: return "Грузовой авто";
            case 300: return "Пассажирский транспорт";
            case 400: return "Тяжёлая техника";
            default: return "Wrong code";
        }
    }

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
