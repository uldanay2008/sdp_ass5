public class Main {
    public static void main(String[] args) {
        double distance = 1000;

        FlightPlanner planner =
                new FlightPlanner(new EconomyFlightStrategy());

        System.out.println("Distance: " + distance + " km");

        System.out.println(
                "Economy mode: " + planner.calculateFuel(distance) + " L"
        );

        planner.setStrategy(new StandardFlightStrategy());

        System.out.println(
                "Standard mode: " + planner.calculateFuel(distance) + " L"
        );

        planner.setStrategy(new BoostFlightStrategy());

        System.out.println(
                "Boost mode: " + planner.calculateFuel(distance) + " L"
        );
    }
}