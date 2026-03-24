import java.util.*;

class EventService {

    private Map<Resource, TreeMap<TimeSlot, Event>> schedule = new HashMap<>();

    public void allocateEvent(Resource resource, Event event)
            throws Exception {

        schedule.putIfAbsent(resource, new TreeMap<>());
        TreeMap<TimeSlot, Event> bookings = schedule.get(resource);

        // Conflict check
        for (TimeSlot slot : bookings.keySet()) {
            if (event.getSlot().overlaps(slot)) {
                throw new ScheduleConflictException("Conflict with existing event");
            }
        }

        bookings.put(event.getSlot(), event);
        System.out.println("Event allocated successfully!");
    }
}