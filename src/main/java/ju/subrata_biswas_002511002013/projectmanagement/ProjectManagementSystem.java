package ju.subrata_biswas_002511002013.projectmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectManagementSystem {

    private final List<Client> clients = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();

    public void addClient(Client client) {

        if (client == null ||
                clients.stream()
                        .anyMatch(c ->
                                c.getClientId() == client.getClientId())) {

            throw new IllegalArgumentException(
                    "Duplicate or null client"
            );
        }

        clients.add(client);
    }

    public void addEmployee(Employee employee) {

        if (employee == null ||
                employees.stream()
                        .anyMatch(e ->
                                e.getEmployeeId() == employee.getEmployeeId())) {

            throw new IllegalArgumentException(
                    "Duplicate or null employee"
            );
        }

        employees.add(employee);
    }

    public void addProject(Project project) {

        if (project == null ||
                projects.stream()
                        .anyMatch(p ->
                                p.getProjectId() == project.getProjectId())) {

            throw new IllegalArgumentException(
                    "Duplicate or null project"
            );
        }

        projects.add(project);
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public void printProjectReport(Project project) {

        System.out.println(
                "\n================ PROJECT REPORT ================"
        );

        System.out.println(
                "Project     : " + project
        );

        System.out.println(
                "Requirement : " + project.getRequirement()
        );

        System.out.println(
                "Duration    : "
                        + project.getStartDate()
                        + " to "
                        + project.getDeadline()
        );

        System.out.println("\nEMPLOYEE ASSIGNMENTS");

        project.getAssignments()
                .forEach(assignment ->
                        System.out.println("  " + assignment));

        System.out.println("\nDEVELOPMENT TRACKER");

        project.getDevelopmentRecords()
                .forEach(record ->
                        System.out.println("  " + record));

        System.out.println("\nBILLING");

        System.out.println(
                "  " + project.getBilling()
        );

        System.out.println("\nCLIENT FEEDBACK");

        project.getFeedbacks()
                .forEach(feedback ->
                        System.out.println("  " + feedback));

        System.out.println(
                "================================================"
        );
    }
}