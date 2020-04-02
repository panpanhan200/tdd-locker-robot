package cn.xpbootcamp.locker_robot;

import java.util.Optional;

public class Box {
    public Optional<Bag> bag = Optional.empty();

    public boolean isOccupied() {
        return bag.isPresent();
    }

}
