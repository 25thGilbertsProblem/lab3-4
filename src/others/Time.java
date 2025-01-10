package others;

public record Time(int hours, int minutes) {
    public boolean isAfter(int thresholdHours) {
        return hours >= thresholdHours;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

}