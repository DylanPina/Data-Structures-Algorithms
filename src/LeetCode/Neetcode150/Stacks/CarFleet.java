package LeetCode.Neetcode150.Stacks;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/**
 * PROBLEM: https://leetcode.com/problems/car-fleet/
 * SOLUTION: https://www.youtube.com/watch?v=Pr6T-3yB9RM
 * BIG O: O(nlogn)
 */
public class CarFleet {

    private class Car {
        int position;
        double timeToFinish;

        public Car(int position, double timeToFinish) {
            this.position = position;
            this.timeToFinish = timeToFinish;
        }
    }
    private int target;

    public int carFleet(int target, int[] position, int[] speed) {
        this.target = target;
        Car[] cars = getCars(position, speed);
        Arrays.sort(cars, (a, b) -> Integer.compare(b.position, a.position));

        Deque<Double> fleets = new LinkedList<>();
        for (Car car : cars) {
            double timeToFinish = car.timeToFinish;
            if (fleets.isEmpty() || timeToFinish > fleets.getLast()) {
                fleets.add(timeToFinish);
            }
        }
        return fleets.size();
    }

    private Car[] getCars(int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(position[i], (target - position[i]) / (double) speed[i]);
        }
        return cars;
    }

    public static void main(String[] args) {
        CarFleet cf = new CarFleet();

        int[] position1 = { 10, 8, 0, 5, 3 };
        int[] speed1 = { 2, 4, 1, 1, 3 };
        System.out.println(cf.carFleet(12, position1, speed1));

        int[] position2 = { 3 };
        int[] speed2 = { 1 };
        System.out.println(cf.carFleet(10, position2, speed2));

        int[] position3 = { 0, 2, 4 };
        int[] speed3 = { 4, 2, 1 };
        System.out.println(cf.carFleet(100, position3, speed3));
    }
}
