package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void should_return_ticket_when_requesting_deposition_given_locker_initialized_and_available() {
        Locker locker = new Locker(15);

        Ticket ticket = locker.deposit();
        assertDoesNotThrow(locker::deposit);
        assertTrue(ticket.boxId.isPresent());
    }

    @Test
    void should_return_ticket_when_requesting_deposition_given_locker_initialized_but_not_available() {
        Locker locker = new Locker(1);
        locker.deposit();

        Exception exception = assertThrows(RuntimeException.class, locker::deposit);
        assertEquals("Locker is full", exception.getMessage());
    }

    @Test
    void should_return_withdraw_successfully_when_withdraw_with_ticket_given_ticket_valid() {
        Locker locker = new Locker(15);
        Ticket ticket = locker.deposit();
        assertTrue(ticket.boxId.isPresent());

        assertDoesNotThrow(() -> locker.withdraw(ticket));
    }

    @Test
    void should_return_ticket_invalid_message_when_withdraw_with_ticket_given_ticket_has_been_used() {
        Locker locker = new Locker(15);

        Ticket ticket = locker.deposit();
        locker.withdraw(ticket);

        Exception exception = assertThrows(RuntimeException.class, () ->
                locker.withdraw(ticket));
        assertEquals("Ticket is invalid", exception.getMessage());
    }
}
