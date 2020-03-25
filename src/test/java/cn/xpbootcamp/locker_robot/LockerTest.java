package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LockerTest {
    @Test
    void should_set_locker_capacity_successfully_when_init_locker_given_locker_is_not_initialized() {
        int capacity = 50;
        Locker locker = new Locker(capacity);
        assertEquals(locker.capacity, capacity);
    }
}
