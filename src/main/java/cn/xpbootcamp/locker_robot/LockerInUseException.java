package cn.xpbootcamp.locker_robot;

public class LockerInUseException extends RuntimeException {
    public LockerInUseException() {
        super("Set locker capacity failed");
    }
}
