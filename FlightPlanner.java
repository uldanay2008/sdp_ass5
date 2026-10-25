import java.util.Objects;

public class FlightPlanner {
    private FlightStrategy strategy;

    public FlightPlanner(FlightStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(FlightStrategy strategy) {
        this.strategy = Objects.requireNonNull(
                strategy, "Strategy must not be null"
        );
    }

    public double calculateFuel(double distance) {
        if (!Double.isFinite(distance) || distance <= 0) {
            throw new IllegalArgumentException(
                    "Distance must be a positive finite number"
            );
        }

        return strategy.calculateFuel(distance);
    }
}