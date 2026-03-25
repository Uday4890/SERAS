import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SERASApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventService eventService = new EventService();
        ResourceService resourceService = new ResourceService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Welcome to SERAS (Smart Event Resource Allocation System)");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Resource");
            System.out.println("2. Add & Allocate Event");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter Resource ID: ");
                        String resId = scanner.nextLine();
                        System.out.print("Enter Resource Type (e.g., Hall, Lab, Equipment): ");
                        String resType = scanner.nextLine();
                        Resource resource = new Resource(resId, resType);
                        resourceService.addResource(resource);
                        System.out.println("Resource added successfully.");
                        break;
                    case "2":
                        System.out.print("Enter Event ID: ");
                        String eventId = scanner.nextLine();
                        System.out.print("Enter Event Name: ");
                        String eventName = scanner.nextLine();
                        
                        System.out.print("Enter Target Resource Type (e.g., Hall, Lab): ");
                        String targetType = scanner.nextLine();
                        Resource targetResource = resourceService.findAvailableResource(targetType);
                        
                        // If no available resource found in the service, prompt to create one
                        if (targetResource == null) {
                            System.out.println("No available resource found for type: " + targetType);
                            System.out.print("Do you want to create a new resource for this allocation? (y/n): ");
                            if (scanner.nextLine().equalsIgnoreCase("y")) {
                                System.out.print("Enter New Resource ID: ");
                                String newResId = scanner.nextLine();
                                targetResource = new Resource(newResId, targetType);
                                resourceService.addResource(targetResource);
                            } else {
                                System.out.println("Event allocation cancelled.");
                                break;
                            }
                        }

                        System.out.print("Enter Start Time (yyyy-MM-dd HH:mm): ");
                        String startStr = scanner.nextLine();
                        LocalDateTime start = LocalDateTime.parse(startStr, formatter);
                        
                        System.out.print("Enter End Time (yyyy-MM-dd HH:mm): ");
                        String endStr = scanner.nextLine();
                        LocalDateTime end = LocalDateTime.parse(endStr, formatter);
                        
                        System.out.print("Enter Priority (1-10): ");
                        int priority = Integer.parseInt(scanner.nextLine());

                        TimeSlot slot = new TimeSlot(start, end);
                        Event event = new Event(eventId, eventName, slot, priority);

                        eventService.allocateEvent(targetResource, event);
                        break;
                    case "3":
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}