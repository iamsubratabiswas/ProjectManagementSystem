package ju.subrata_biswas_002511002013.projectmanagement;

import java.time.LocalDate;

public class MaintenanceProject extends Project {

    public MaintenanceProject(
            int projectId,
            String name,
            Client client,
            String requirement,
            LocalDate startDate,
            LocalDate deadline,
            double projectCost) {

        super(projectId, name, client, requirement,
                startDate, deadline, projectCost);
    }

    @Override
    public String getProjectType() {
        return "MAINTENANCE";
    }
}