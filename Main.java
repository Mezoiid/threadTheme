package com.company;

public class Main {

    public static void main(String[] args) {
    Parking parking = new Parking();

    Car [] mas = new Car[50];
    for (int i = 0; i<50;i++){
        mas[i]=new Car(i,parking);
    }
    for (int i = 0;i<mas.length;i++)
        mas[i].start();
    parking.start();
    }
}
