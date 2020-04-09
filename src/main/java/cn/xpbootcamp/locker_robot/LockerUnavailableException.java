package cn.xpbootcamp.locker_robot;

public class LockerUnavailableException extends RuntimeException {

    public LockerUnavailableException() {
        super("No available locker");
    }
}
