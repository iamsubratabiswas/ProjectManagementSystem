package ju.subrata_biswas_002511002013.projectmanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Project {

    private final int projectId;
    private final String name;
    private final Client client;
    private final String requirement;
    private final LocalDate startDate;
    private final LocalDate deadline;
    private final Billing billing;

    private final List<Assignment> assignments = new ArrayList<>();
    private final List<DevelopmentRecord> developmentRecords = new ArrayList<>();
    private final List<ClientFeedback> feedbacks = new ArrayList<>();

    protected Project(int projectId,
                      String name,
                      Client client,
                      String requirement,
                      LocalDate startDate,
                      LocalDate deadline,
                      double projectCost) {

        if (projectId <= 0 ||
                name == null ||
                name.isBlank() ||
                client == null ||
                requirement == null ||
                requirement.isBlank() ||
                startDate == null ||
                deadline == null ||
                deadline.isBefore(startDate)) {

            throw new IllegalArgumentException("Invalid project data");
        }

        this.projectId = projectId;
        this.name = name;
        this.client = client;
        this.requirement = requirement;
        this.startDate = startDate;
        this.deadline = deadline;
        this.billing = new Billing(projectCost);

        client.addProject(this);
    }

    public abstract String getProjectType();

    public int getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public Client getClient() {
        return client;
    }

    public String getRequirement() {
        return requirement;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Billing getBilling() {
        return billing;
    }

    public List<Assignment> getAssignments() {
        return Collections.unmodifiableList(assignments);
    }

    public List<DevelopmentRecord> getDevelopmentRecords() {
        return Collections.unmodifiableList(developmentRecords);
    }

    public List<ClientFeedback> getFeedbacks() {
        return Collections.unmodifiableList(feedbacks);
    }

    public void assignEmployee(Employee employee, String responsibility) {

        boolean alreadyAssigned = assignments.stream()
                .anyMatch(assignment ->
                        assignment.getEmployee().getEmployeeId()
                                == employee.getEmployeeId());

        if (alreadyAssigned) {
            throw new IllegalStateException(
                    "Employee already assigned to this project"
            );
        }

        assignments.add(
                new Assignment(
                        employee,
                        this,
                        responsibility,
                        LocalDate.now()
                )
        );
    }

    public void updateDevelopment(ProjectStage stage, String status) {

        developmentRecords.add(
                new DevelopmentRecord(
                        stage,
                        status,
                        LocalDate.now()
                )
        );
    }

    public void addFeedback(ProjectStage stage,
                            String comment,
                            int rating) {

        feedbacks.add(
                new ClientFeedback(
                        stage,
                        comment,
                        rating,
                        LocalDate.now()
                )
        );
    }

    @Override
    public String toString() {

        return projectId + " - " + name
                + " [" + getProjectType() + "] Client="
                + client.getName();
    }
}