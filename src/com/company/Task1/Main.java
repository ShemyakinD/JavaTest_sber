package com.company.Task1;

public class Main {

    public static void main(String[] args) {
        String[] cars = new String[]{"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        System.out.println("\n------------------Вывод итоговой стоимости");
        Task1.getAllCost(cars);
        System.out.println("\n------------------Вывод максимальной стоимости");
        Task1.getMaxCost(cars);
        System.out.println("\n------------------Вывод минимальной стоимости");
        Task1.getMinCost(cars);

        System.out.println("\n------------------Сортировка по пробегу");
        Task1.sortVehicles(cars,400,0);
        System.out.println("\n------------------Сортировка по параметру");
        Task1.sortVehicles(cars,200,1);
    }
}
