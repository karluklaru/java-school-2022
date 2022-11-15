package ru.croc.task11;

import java.time.LocalDateTime;

public class User extends Thread {
    private final String userName;
    private final Lot lot;

    public User(String userName, Lot lot) {
        this.userName = userName;
        this.lot = lot;
    }

    @Override
    public void run() {
        boolean check;
        int randomRate = 0;
        while (lot.getAuctionEnd().compareTo(LocalDateTime.now()) > 0) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            randomRate += (int) (Math.random()*10);
            check = lot.updateRate(userName, randomRate);
            if (check) {
                System.out.println("New rate! " + userName + " updating rate to " + randomRate);
            }
        }
    }
}
