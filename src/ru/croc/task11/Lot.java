package ru.croc.task11;

import java.time.LocalDateTime;


public class Lot {
    private double currentRate;
    private String userName;
    private final LocalDateTime auctionEnd;
    private final Object lock = new Object();

    public Lot(double currentRate, String userName, LocalDateTime auctionEnd) {
        this.currentRate = currentRate;
        this.userName = userName;
        this.auctionEnd = auctionEnd;
    }

    public boolean updateRate(String name, double rate) {
        synchronized(lock) {
        if (LocalDateTime.now().compareTo(auctionEnd) < 0 && rate > currentRate) {
            currentRate = rate;
            userName = name;
            return true;
        }
        return false;
        }
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getAuctionEnd() {
        return auctionEnd;
    }
}
