package com.company;

public class Car extends Thread{
    private boolean isRiding;
    private Parking parking;
    private int num;
    public Car(int num,Parking parking){
        this.isRiding = true;
        this.num = num;
        this.parking = parking;
    }

    public void run() {
        while (!isInterrupted()) {
            if (isRiding) {
                try {
                    Thread.sleep((int) (5000 + (Math.random() * 5) * 1000));
                    synchronized (parking) {
                        if (parking.takePlace(num)) {
                            isRiding = false;
                            System.out.println("enter " + this.num);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    Thread.sleep((int) (7000 + (Math.random() * 8) * 1000));
                    parking.freePlace(num);
                    isRiding = true;
                            System.out.println("exit "+this.num);
                    } catch(InterruptedException e){
                         e.printStackTrace();
                    }
            }
        }
    }
}
