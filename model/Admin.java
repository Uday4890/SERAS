class Admin extends User {

    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayRole() {
        System.out.println("Admin");
    }
}