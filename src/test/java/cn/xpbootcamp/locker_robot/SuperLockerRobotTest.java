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
}
