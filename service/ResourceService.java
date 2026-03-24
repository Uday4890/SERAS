import java.util.*;

class ResourceService {

    private List<Resource> resources = new ArrayList<>();

    public void addResource(Resource r) {
        resources.add(r);
    }

    public Resource findAvailableResource(String type) {
        for (Resource r : resources) {
            if (r.getType().equalsIgnoreCase(type) && r.isAvailable()) {
                return r;
            }
        }
        return null;
    }
}