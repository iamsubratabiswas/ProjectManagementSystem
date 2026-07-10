package ju.subrata_biswas_002511002013.projectmanagement;

import java.time.LocalDate;

public class Assignment {

    private final Employee employee;
    private final Project project;
    private final String responsibility;
    private final LocalDate assignedOn;

    public Assignment(Employee employee,
                      Project project,
                      String responsibility,
                      LocalDate assignedOn) {

        if (employee == null ||
                project == null ||
                responsibility == null ||
                responsibility.isBlank()) {

            throw new IllegalArgumentException(
                    "Invalid assignment"
            );
        }

        this.employee = employee;
        this.project = project;
        this.responsibility = responsibility;

        this.assignedOn = assignedOn == null
                ? LocalDate.now()
                : assignedOn;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public LocalDate getAssignedOn() {
        return assignedOn;
    }

    @Override
    public String toString() {
        return employee.getName()
                + " -> "
                + project.getName()
                + " | "
                + responsibility
                + " | "
                + assignedOn;
    }
}