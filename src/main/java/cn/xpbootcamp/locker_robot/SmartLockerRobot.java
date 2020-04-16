package cn.xpbootcamp.locker_robot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartLockerRobot extends LockerRobot {
    public SmartLockerRobot(List<Locker> lockerList) {
        super(lockerList);
    }

    Comparator<Locker> comparator = Comparator.comparing(Locker::getEmptyBoxCount);

    @Override
    Optional<Locker> findTargetLocker() {
        Optional<Locker> targetLocker = lockerList.stream().max(comparator);
        return targetLocker.get().getEmptyBoxCount() == 0 ? Optional.empty() : targetLocker;
    }
}
