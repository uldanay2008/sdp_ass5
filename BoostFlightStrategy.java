public class BoostFlightStrategy implements FlightStrategy {
    private static final double FUEL_PER_KM = 2.0;
    private static final double BOOST_ACTIVATION_FUEL = 100.0;

    @Override
    public double calculateFuel(double distance) {
        return distance * FUEL_PER_KM + BOOST_ACTIVATION_FUEL;
    }
}