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
            ticket.setBoxId(this.boxes.indexOf(box));
        });

        if (!targetBox.isPresent()) {
            throw new LockerFullException();
        }
        return ticket;
    }

    public Bag withdraw(Ticket ticket) {
        if (isValidTicket(ticket)) {
            throw new TicketInvalidException();
        }

        final Box box = boxes.get(ticket.boxId.get());
        Bag bag = box.bag.get();
        box.bag = Optional.empty();
        return bag;
    }

    private boolean isValidTicket(Ticket ticket) {
        return !ticket.boxId.isPresent() || ticket.boxId.get() >= boxes.size() ||
                ticket.boxId.get() < 0 || !boxes.get(ticket.boxId.get()).isOccupied();
    }

    public void setCapacity(int capacity) {
        boolean isLockerInUse = boxes.stream().anyMatch(Box::isOccupied);
        if (isLockerInUse) {
            throw new LockerInUseException();
        }
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasBag(Bag bag) {
        return boxes.stream().anyMatch(box -> box.bag.map(value -> value.equals(bag)).orElse(false));
    }

    public boolean isFull() {
        return boxes.stream().allMatch(box -> box.isOccupied());
    }

    public long getEmptyBoxCount() {
        return boxes.stream().filter(box -> !box.isOccupied()).count();
    }

    public long getVacancyRate() {
        return boxes.stream().filter(box -> !box.isOccupied()).count() / boxes.size();
    }
}
