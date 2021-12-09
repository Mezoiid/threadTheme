package com.company;

public class Parking extends Thread{
    private int [] car;
    private int count;

    public Parking(){
        this.car = new int[20];
        for (int i = 0;i<car.length;i++){
            car[i]=-1;
            count=20;
        }
    }
    synchronized boolean takePlace(int num){
        for (int i = 0;i<car.length;i++) {
            if (car[i] == -1) {
                car[i]=num;
                count--;
                return true;
            }
        }
     return false;
    }

    synchronized void freePlace(int num){
        for (int i = 0;i<car.length;i++){
            if (car[i]==num){
                car[i]=-1;
                count++;
                return;
            }
        }
    }
    public void run(){
        while (!isInterrupted()) {
            try {
                Thread.sleep(5000);
                System.out.println("Свободных мест " + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

