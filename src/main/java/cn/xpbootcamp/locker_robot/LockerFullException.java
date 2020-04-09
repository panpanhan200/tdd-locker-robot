package cn.xpbootcamp.locker_robot;

public class LockerFullException extends RuntimeException {
    public LockerFullException() {
        super("Locker is full");
    }
}
