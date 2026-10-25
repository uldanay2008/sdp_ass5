public class StandardFlightStrategy implements FlightStrategy {
    private static final double FUEL_PER_KM = 1.0;

    @Override
    public double calculateFuel(double distance) {
        return distance * FUEL_PER_KM;
    }
}