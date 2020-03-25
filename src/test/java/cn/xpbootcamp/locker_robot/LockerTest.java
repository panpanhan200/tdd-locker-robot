package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LockerTest {
    @Test
    void should_set_locker_capacity_successfully_when_init_locker_given_locker_is_not_initialized() {
        int capacity = 50;
        Locker locker = new Locker(capacity);
        assertEquals(locker.getCapacity(), capacity);
    }

    @Test
    void should_update_locker_capacity_successfully_when_update_locker_give_locker_is_initialized_and_not_in_use() {
        int newCapacity = 50;
        int oldCapacity = 15;
        Locker locker = new Locker(oldCapacity);
        locker.setCapacity(newCapacity);
        assertEquals(locker.getCapacity(), newCapacity);
    }

    @Test
    void should_return_set_locker_capacity_failed_message_when_update_locker_capacity_given_locker_is_in_use() {
        int newCapacity = 50;
        int oldCapacity = 15;
        Locker locker = new Locker(oldCapacity);
        locker.deposit();
        Exception exception = assertThrows(RuntimeException.class, () ->
                locker.setCapacity(newCapacity));
        assertEquals("Set locker capacity failed", exception.getMessage());
    }
}
