package cn.xpbootcamp.locker_robot;

public class TicketInvalidException extends RuntimeException {
    public TicketInvalidException() {
        super("Ticket is invalid");
    }
}
