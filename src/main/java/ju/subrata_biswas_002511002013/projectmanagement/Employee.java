package ju.subrata_biswas_002511002013.projectmanagement;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Employee {

    private final int employeeId;
    private final String name;
    private final Designation designation;
    private final Set<String> skills = new LinkedHashSet<>();

    public Employee(int employeeId, String name,
                    Designation designation, Set<String> skills) {

        if (employeeId <= 0 || name == null ||
                name.isBlank() || designation == null) {
            throw new IllegalArgumentException("Invalid employee data");
        }

        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;

        if (skills != null) {
            this.skills.addAll(skills);
        }
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public Designation getDesignation() {
        return designation;
    }

    public Set<String> getSkills() {
        return Collections.unmodifiableSet(skills);
    }

    @Override
    public String toString() {
        return employeeId + " - " + name
                + " [" + designation + "] Skills=" + skills;
    }
}