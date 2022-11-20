package ru.croc.task11;

import java.time.LocalDateTime;


public class Lot {
    private volatile double currentRate;
    private volatile String userName;
    private final LocalDateTime auctionEnd;

    public Lot(double currentRate, LocalDateTime auctionEnd) {
        this.currentRate = currentRate;
        this.auctionEnd = auctionEnd;
    }

    public synchronized boolean updateRate(String name, double rate) {
        if (LocalDateTime.now().compareTo(auctionEnd) < 0 && rate > currentRate) {
            currentRate = rate;
            userName = name;
            return true;
        }
        return false;
    }

    public String getWinner() {
        if (LocalDateTime.now().compareTo(auctionEnd) > 0) {
            return userName;
        }
        return null;
    }

    public LocalDateTime getAuctionEnd() {
        return auctionEnd;
    }
}
