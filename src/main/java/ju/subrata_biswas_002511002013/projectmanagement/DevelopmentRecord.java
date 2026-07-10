package ju.subrata_biswas_002511002013.projectmanagement;

import java.time.LocalDate;

public class DevelopmentRecord {

    private final ProjectStage stage;
    private final String status;
    private final LocalDate updatedOn;

    public DevelopmentRecord(ProjectStage stage,
                             String status,
                             LocalDate updatedOn) {

        if (stage == null ||
                status == null ||
                status.isBlank()) {

            throw new IllegalArgumentException(
                    "Invalid development record"
            );
        }

        this.stage = stage;
        this.status = status;

        this.updatedOn = updatedOn == null
                ? LocalDate.now()
                : updatedOn;
    }

    public ProjectStage getStage() {
        return stage;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public String toString() {
        return stage
                + " : "
                + status
                + " ("
                + updatedOn
                + ")";
    }
}