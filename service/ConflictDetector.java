import java.util.*;

class ConflictDetector {

    public static void checkConflict(TimeSlot newSlot, List<TimeSlot> existingSlots)
            throws ScheduleConflictException {

        for (TimeSlot slot : existingSlots) {
            if (newSlot.overlaps(slot)) {
                throw new ScheduleConflictException("Time slot conflict detected!");
            }
        }
    }
}