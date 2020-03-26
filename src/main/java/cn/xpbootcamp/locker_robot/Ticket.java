package cn.xpbootcamp.locker_robot;

import java.util.Optional;

public class Ticket {
public Optional<Integer> boxId;

    public Ticket() {
        this.boxId = Optional.empty();
    }

    public Ticket(int id) {
        this.boxId = Optional.of(id);
    }

    public void assignId(int id) {
        this.boxId = Optional.of(id);
    }
}
