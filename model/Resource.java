class Resource {
    private String resourceId;
    private String type; // Hall, Lab, Equipment
    private boolean available;

    public Resource(String resourceId, String type) {
        this.resourceId = resourceId;
        this.type = type;
        this.available = true;
    }

    public String getId() { return resourceId; }
    public String getType() { return type; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean status) { this.available = status; }
}