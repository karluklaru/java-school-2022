package ru.croc.task11;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Lot lot = new Lot(0, "", LocalDateTime.now().plusSeconds(15));
        Thread user1 = new Thread(new User("Rayan", lot));
        Thread user2 = new Thread(new User("David", lot));
        Thread user3 = new Thread(new User("Mira", lot));
        user1.start();
        user2.start();
        user3.start();
    }
}
