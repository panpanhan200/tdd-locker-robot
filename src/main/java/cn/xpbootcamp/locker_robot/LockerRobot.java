package cn.xpbootcamp.locker_robot;

import java.util.List;
import java.util.Optional;

public abstract class LockerRobot {
    protected List<Locker> lockerList;

    abstract Optional<Locker> findLocker();

    public LockerRobot(List<Locker> lockerList) {
        this.lockerList = lockerList;
    }

    public Ticket deposit(Bag bag) {

        Optional<Locker> notFullLocker = findLocker();
        if (notFullLocker.isPresent()) {
            Locker locker = notFullLocker.get();
            Ticket ticket = locker.deposit(bag);
            ticket.setLockerId(lockerList.indexOf(locker));
            return ticket;
        } else {
            throw new LockerUnavailableException();
        }
    }

    public Bag withdraw(Ticket ticket) {

        if (ticket.lockerId.isPresent()) {
            return lockerList.get(ticket.lockerId.get()).withdraw(ticket);
        } else {
            throw new TicketInvalidException();
        }
    }
}
