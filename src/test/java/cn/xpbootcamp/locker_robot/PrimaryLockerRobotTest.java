package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrimaryLockerRobotTest {

    @Test
    void should_deposit_bag_into_locker_a_and_return_ticket_when_robot_receives_one_bag_given_robot_has_two_lockers_named_a_and_b_with_order_a_b_with_capacity_one_and_not_full() {
        List<Locker> lockerList = new ArrayList<Locker>();
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


}
