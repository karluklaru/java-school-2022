package ru.croc.task11;

import java.time.LocalDateTime;

public class User extends Thread {
    private String userName;
    private Lot lot;

    public User(String userName, Lot lot) {
        this.userName = userName;
        this.lot = lot;
    }

    @Override
    public void run() {
        boolean check;
        int rn = 0;
        while (lot.getAuctionEnd().compareTo(LocalDateTime.now()) > 0) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            rn += (int) (Math.random()*10);
            check = lot.updateRate(userName, rn);
            if (check) {
                System.out.println("New rate! " + userName + " updating rate to " + rn);
            }
        }
    }
}
