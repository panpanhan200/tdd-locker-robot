package cn.xpbootcamp.locker_robot;

import java.util.Optional;

public class Ticket {
public Optional<Integer> boxId;
public Optional<Integer> lockerId;

    public Ticket() {
        this.boxId = Optional.empty();
    }

    public Ticket(int id) {
        this.boxId = Optional.of(id);
    }

    public void setBoxId(int id) {
        this.boxId = Optional.of(id);
    }

    public void setLockerId(int id) {
        this.lockerId = Optional.of(id);
    }
}
