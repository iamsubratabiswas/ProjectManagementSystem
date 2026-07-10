package ju.subrata_biswas_002511002013.projectmanagement;

public class Billing {

    private final double projectCost;
    private double amountPaid;

    public Billing(double projectCost) {
        if (projectCost < 0) {
            throw new IllegalArgumentException(
                    "Project cost cannot be negative"
            );
        }

        this.projectCost = projectCost;
    }

    public double getProjectCost() {
        return projectCost;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getDueAmount() {
        return projectCost - amountPaid;
    }

    public void makePayment(double amount) {
        if (amount <= 0 || amount > getDueAmount()) {
            throw new IllegalArgumentException(
                    "Invalid payment amount"
            );
        }

        amountPaid += amount;
    }

    @Override
    public String toString() {
        return String.format(
                "Cost=%.2f, Paid=%.2f, Due=%.2f",
                projectCost,
                amountPaid,
                getDueAmount()
        );
    }
}