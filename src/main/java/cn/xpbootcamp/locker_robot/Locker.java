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

    public void deposit() {
        Optional<Box> targetBox = boxes.stream().filter(box -> !box.isOccupied).findFirst();
        targetBox.ifPresent(box -> box.isOccupied = true);
    }

    public void setCapacity(int capacity) {
        boolean isLockerInUse = boxes.stream().anyMatch(box -> box.isOccupied);
        if (isLockerInUse) {
            throw new RuntimeException("Set locker capacity failed");
        }
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
