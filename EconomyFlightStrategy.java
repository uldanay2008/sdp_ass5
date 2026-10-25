public class EconomyFlightStrategy implements FlightStrategy {
    private static final double FUEL_PER_KM = 0.5;

    @Override
    public double calculateFuel(double distance) {
        return distance * FUEL_PER_KM;
    }
}