package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrimaryLockerRobotTest {

    @Test
    void should_deposit_bag_into_locker_a_and_return_ticket_when_robot_receives_one_bag_given_robot_has_two_lockers_named_a_and_b_with_order_a_b_with_capacity_one_and_not_full() {
        List<Locker> lockerList = new ArrayList<>();
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);

        lockerList.add(lockerA);
        lockerList.add(lockerB);

        Robot robot = new Robot(lockerList);

        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        assertNotNull(ticket);
        assertTrue(lockerA.hasBag(bag));
    }

    @Test
    void should_deposit_bag_into_locker_a_and_return_ticket_when_robot_receives_one_bag_given_robot_has_two_lockers_named_a_and_b_with_order_a_b_with_capacity_one_and_a_full_b_not_full() {
        List<Locker> lockerList = new ArrayList<>();
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);

        lockerList.add(lockerA);
        lockerList.add(lockerB);
        Bag bagIgnored = new Bag();
        lockerA.deposit(bagIgnored);

        Robot robot = new Robot(lockerList);

        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        assertNotNull(ticket);
        assertFalse(lockerA.hasBag(bag));
        assertTrue(lockerB.hasBag(bag));
    }

    @Test
    void should_deposit_bag_into_locker_a_and_return_ticket_when_robot_receives_one_bag_given_robot_has_two_lockers_named_a_and_b_with_order_a_b_with_capacity_one_and_a_b_all_full() {
        List<Locker> lockerList = new ArrayList<>();
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);

        lockerList.add(lockerA);
        lockerList.add(lockerB);
        Bag bagA = new Bag();
        lockerA.deposit(bagA);
        Bag bagB = new Bag();
        lockerB.deposit(bagB);

        Robot robot = new Robot(lockerList);

        Bag bag = new Bag();
        assertThrows(LockerUnavailableException.class, () -> robot.deposit(bag));
    }

    @Test
    void should_return_bag_when_withdraw_with_ticket_given_a_locker_with_deposited_bag_and_ticket_valid() {
        List<Locker> lockerList = new ArrayList<>();
        Locker lockerA = new Locker(1);
        lockerList.add(lockerA);
        Robot robot = new Robot(lockerList);

        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        Bag returnedBag = robot.withdraw(ticket);
        assertEquals(bag, returnedBag);
    }

    @Test
    void should_return_bag_when_withdraw_with_ticket_given_ticket_used() {
        List<Locker> lockerList = new ArrayList<>();
        Locker lockerA = new Locker(1);
        lockerList.add(lockerA);
        Robot robot = new Robot(lockerList);

        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);
        robot.withdraw(ticket);

        Exception exception = assertThrows(RuntimeException.class, () ->
                robot.withdraw(ticket));
        assertEquals("Ticket is invalid", exception.getMessage());
    }

}
