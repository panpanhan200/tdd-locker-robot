package cn.xpbootcamp.locker_robot;

import java.util.List;
import java.util.Optional;

public class PrimaryLockerRobot extends LockerRobot {
    public PrimaryLockerRobot(List<Locker> lockerList) {
        super(lockerList);
    }

    @Override
    Optional<Locker> findTargetLocker() {
        return lockerList.stream().filter(locker -> !locker.isFull()).findFirst();
    }
}
