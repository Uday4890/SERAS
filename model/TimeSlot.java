import java.time.*;

class TimeSlot implements Comparable<TimeSlot> {
    private LocalDateTime start;
    private LocalDateTime end;

    public TimeSlot(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(TimeSlot other) {
        return !(end.isBefore(other.start) || start.isAfter(other.end));
    }

    @Override
    public int compareTo(TimeSlot o) {
        return this.start.compareTo(o.start);
    }
}