package cn.xpbootcamp.locker_robot;

import java.util.List;
import java.util.Optional;

public class PrimaryRobot extends Robot {
    public PrimaryRobot(List<Locker> lockerList) {
        super(lockerList);
    }

    @Override
    Optional<Locker> findLocker() {
        return lockerList.stream().filter(locker -> !locker.isFull()).findFirst();
    }
}
