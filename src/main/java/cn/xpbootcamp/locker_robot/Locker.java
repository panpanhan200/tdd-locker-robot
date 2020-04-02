package cn.xpbootcamp.locker_robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Locker {
    private int capacity;
    List<Box> boxes = new ArrayList<>();

    public Locker(int capacity) {
        this.capacity = capacity;
        for (int i = 0; i < capacity; i++) {
            Box box = new Box();
            boxes.add(box);
        }
    }

    public Ticket deposit(Bag bag) {
        Optional<Box> targetBox = boxes.stream().filter(box -> !box.isOccupied()).findFirst();
        Ticket ticket = new Ticket();
        targetBox.ifPresent(box -> {
            box.bag = Optional.of(bag);
            ticket.assignId(this.boxes.indexOf(box));
        });

        if (!targetBox.isPresent()) {
            throw new RuntimeException("Locker is full");
        }
        return ticket;
    }

    public Bag withdraw(Ticket ticket) {
        if (isValidTicket(ticket)) {
            throw new RuntimeException("Ticket is invalid");
        }

        Bag bag = boxes.get(ticket.boxId.get()).bag.get();
        boxes.get(ticket.boxId.get()).bag = Optional.empty();
        return bag;
    }

    private boolean isValidTicket(Ticket ticket) {
        return !ticket.boxId.isPresent() || ticket.boxId.get() >= boxes.size() ||
                ticket.boxId.get() < 0 || !boxes.get(ticket.boxId.get()).isOccupied();
    }

    public void setCapacity(int capacity) {
        boolean isLockerInUse = boxes.stream().anyMatch(box -> box.isOccupied());
        if (isLockerInUse) {
            throw new RuntimeException("Set locker capacity failed");
        }
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
