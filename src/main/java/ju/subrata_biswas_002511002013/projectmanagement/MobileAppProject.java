package ju.subrata_biswas_002511002013.projectmanagement;

import java.time.LocalDate;

public class MobileAppProject extends Project {

    public MobileAppProject(
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
        return "MOBILE APPLICATION";
    }
}