package ju.subrata_biswas_002511002013.projectmanagement;

import java.time.LocalDate;

public class ClientFeedback {

    private final ProjectStage stage;
    private final String comment;
    private final int rating;
    private final LocalDate feedbackDate;

    public ClientFeedback(ProjectStage stage,
                          String comment,
                          int rating,
                          LocalDate feedbackDate) {

        if (stage == null ||
                comment == null ||
                comment.isBlank() ||
                rating < 1 ||
                rating > 5) {

            throw new IllegalArgumentException(
                    "Invalid feedback"
            );
        }

        this.stage = stage;
        this.comment = comment;
        this.rating = rating;

        this.feedbackDate = feedbackDate == null
                ? LocalDate.now()
                : feedbackDate;
    }

    public ProjectStage getStage() {
        return stage;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    @Override
    public String toString() {
        return stage
                + " | Rating="
                + rating
                + "/5 | "
                + comment
                + " | "
                + feedbackDate;
    }
}