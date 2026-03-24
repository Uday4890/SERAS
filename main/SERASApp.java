import java.time.*;

public class SERASApp {

    public static void main(String[] args) {

        try {
            Resource hall = new Resource("R1", "Hall");

            EventService service = new EventService();

            TimeSlot slot1 = new TimeSlot(
                    LocalDateTime.of(2026, 3, 25, 10, 0),
                    LocalDateTime.of(2026, 3, 25, 12, 0)
            );

            Event e1 = new Event("E1", "Tech Talk", slot1, 1);

            service.allocateEvent(hall, e1);

            System.out.println("System running successfully!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}