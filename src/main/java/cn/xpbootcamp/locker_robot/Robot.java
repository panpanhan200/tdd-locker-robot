package cn.xpbootcamp.locker_robot;

import java.util.List;
import java.util.Optional;

public class Robot {
    private List<Locker> lockerList;

    public Robot(List<Locker> lockerList) {
        this.lockerList = lockerList;
    }

    public Ticket deposit(Bag bag) {

        Optional<Locker> notFullLocker = lockerList.stream().filter(locker -> !locker.isFull()).findFirst();
        if (notFullLocker.isPresent()) {
            Ticket ticket = notFullLocker.get().deposit(bag);
            ticket.setLockerId(lockerList.indexOf(notFullLocker.get()));
            return ticket;
        } else {
            throw new RuntimeException("No available locker");
        }
    }

    public Bag withdraw(Ticket ticket) {

        if (ticket.lockerId.isPresent()) {
            return lockerList.get(ticket.lockerId.get()).withdraw(ticket);
        } else {
            throw new RuntimeException("Ticket is invalid");
        }
    }
}
