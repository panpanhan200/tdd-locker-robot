package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmartLockerRobotTest {
    @Test
    void should_deposit_bag_to_B_and_return_ticket_when_robot_receives_one_bag_given_locker_A_with_1_empty_box_and_locker_B_with_2_empty_boxes() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(2);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        SmartLockerRobot robot = new SmartLockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        assertNotNull(ticket);
        assertTrue(lockerB.hasBag(bag));
    }

    @Test
    void should_return_ticket_when_robot_receives_one_bag_given_locker_A_with_1_empty_box_and_locker_B_with_1_empty_box() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        SmartLockerRobot robot = new SmartLockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        assertNotNull(ticket);
    }

    @Test
    void should_deposit_failed_when_robot_receives_one_bag_given_locker_A_with_0_empty_box_and_locker_B_with_0_empty_box() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        List<Locker> lockers = new ArrayList<>();
        lockers.add(lockerA);
        lockers.add(lockerB);

        SmartLockerRobot robot = new SmartLockerRobot(lockers);

        Bag bagA = new Bag();
        Bag bagB = new Bag();
        robot.deposit(bagA);
        robot.deposit(bagB);

        Bag bag = new Bag();
        assertThrows(LockerUnavailableException.class, () -> robot.deposit(bag));
    }
}
