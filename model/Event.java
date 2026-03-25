class Event {
    private String eventId;
    private String name;
    private TimeSlot slot;
    private int priority;

    public Event(String id, String name, TimeSlot slot, int priority) {
        this.eventId = id;
        this.name = name;
        this.slot = slot;
        this.priority = priority;
    }

    public String getEventId() { return eventId; }
    public String getName() { return name; }
    public TimeSlot getSlot() { return slot; }
    public int getPriority() { return priority; }
}