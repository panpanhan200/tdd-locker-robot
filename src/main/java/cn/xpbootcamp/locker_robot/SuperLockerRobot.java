package cn.xpbootcamp.locker_robot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperLockerRobot extends LockerRobot {
    public SuperLockerRobot(List<Locker> lockerList) {
        super(lockerList);
    }

    Comparator<Locker> comparator = Comparator.comparing(Locker::getVacancyRate);

    @Override
    Optional<Locker> findTargetLocker() {
        Optional<Locker> targetLocker = lockerList.stream().max(comparator);
        return targetLocker.get().getVacancyRate() == 0 ? Optional.empty() : targetLocker;
    }
}
