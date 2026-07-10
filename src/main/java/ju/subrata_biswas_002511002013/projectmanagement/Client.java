package ju.subrata_biswas_002511002013.projectmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

    private final int clientId;
    private final String name;
    private final String email;
    private final List<Project> projects = new ArrayList<>();

    public Client(int clientId, String name, String email) {

        if (clientId <= 0 || name == null ||
                name.isBlank() || email == null || email.isBlank()) {
            throw new IllegalArgumentException("Invalid client data");
        }

        this.clientId = clientId;
        this.name = name;
        this.email = email;
    }

    public int getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    void addProject(Project project) {
        if (project != null && !projects.contains(project)) {
            projects.add(project);
        }
    }

    @Override
    public String toString() {
        return clientId + " - " + name + " (" + email + ")";
    }
}