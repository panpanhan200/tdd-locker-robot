package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperLockerRobotTest {
    @Test
    void should_deposit_bag_to_B_and_return_ticket_when_robot_deposits_one_bag_given_locker_A_with_vacancy_rate_50_percent_and_locker_B_with_vacancy_rate_100_percent() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);

        Bag bagA = new Bag();
        lockerA.deposit(bagA);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        SuperLockerRobot robot = new SuperLockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        assertNotNull(ticket);
        assertTrue(lockerB.hasBag(bag));
    }

    @Test
    void should_deposit_bag_to_A_and_return_ticket_when_robot_deposits_one_bag_given_locker_A_with_vacancy_rate_100_percent_and_locker_B_with_vacancy_rate_50_percent() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);

        Bag bagB = new Bag();
        lockerB.deposit(bagB);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        SuperLockerRobot robot = new SuperLockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        assertNotNull(ticket);
        assertTrue(lockerA.hasBag(bag));
    }

    @Test
    void should_return_ticket_when_robot_deposits_one_bag_given_locker_A_and_B_both_with_vacancy_rate_50_percent() {
        Locker lockerA = new Locker(2);
        Locker lockerB = new Locker(2);

        Bag bagA = new Bag();
        lockerA.deposit(bagA);
        Bag bagB = new Bag();
        lockerB.deposit(bagB);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        SuperLockerRobot robot = new SuperLockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        assertNotNull(ticket);
        assertTrue(lockerA.hasBag(bag));
    }

    @Test
    void should_deposit_failed_when_robot_deposits_one_bag_given_locker_A_and_B_both_with_vacancy_rate_0_percent() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);

        Bag bagA = new Bag();
        lockerA.deposit(bagA);
        Bag bagB = new Bag();
        lockerB.deposit(bagB);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        SuperLockerRobot robot = new SuperLockerRobot(lockers);

        Bag bag = new Bag();
        assertThrows(LockerUnavailableException.class, () -> robot.deposit(bag));
    }

    @Test
    void should_return_bag1_when_withdraw_with_ticket_given_bag2_is_deposited_in_lockerB_and_ticket_is_returned_after_bag1_is_deposited_in_lockerA() {
        List<Locker> lockerList = new ArrayList<>();
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        lockerList.add(lockerA);
        lockerList.add(lockerB);
        SmartLockerRobot robot = new SmartLockerRobot(lockerList);

        Bag bag1 = new Bag();
        Ticket ticket = robot.deposit(bag1);
        Bag bag2 = new Bag();
        robot.deposit(bag2);

        assertTrue(lockerA.hasBag(bag1));
        assertTrue(lockerB.hasBag(bag2));

        Bag returnedBag = robot.withdraw(ticket);
        assertEquals(bag1, returnedBag);
    }

    @Test
    void should_withdraw_failed_when_withdraw_with_ticket_given_ticket_used() {
        List<Locker> lockerList = new ArrayList<>();
        Locker lockerA = new Locker(1);
        lockerList.add(lockerA);
        SmartLockerRobot robot = new SmartLockerRobot(lockerList);

        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);
        robot.withdraw(ticket);

        assertThrows(TicketInvalidException.class, () -> robot.withdraw(ticket));
    }
}
