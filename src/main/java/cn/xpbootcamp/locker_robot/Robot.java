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
            return notFullLocker.get().deposit(bag);
        } else {
            throw new RuntimeException("No available locker");
        }
    }
}
