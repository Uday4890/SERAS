class Organizer extends User {

    public Organizer(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayRole() {
        System.out.println("Organizer");
    }
}