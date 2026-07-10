package ju.subrata_biswas_002511002013.projectmanagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectManagementSystemTest {

    @Test
    void testAddClient() {
        ProjectManagementSystem system = new ProjectManagementSystem();

        Client client = new Client(
                1,
                "Suman Sil Enterprises",
                "suman.sil@company.com"
        );

        system.addClient(client);

        assertEquals(1, system.getClients().size());
        assertEquals(
                "Suman Sil Enterprises",
                system.getClients().get(0).getName()
        );
    }

    @Test
    void testAddEmployee() {
        ProjectManagementSystem system = new ProjectManagementSystem();

        Employee employee = new Employee(
                101,
                "Subrata Biswas",
                Designation.PROJECT_MANAGER,
                Set.of("Project Planning", "Agile")
        );

        system.addEmployee(employee);

        assertEquals(1, system.getEmployees().size());
        assertEquals(
                "Subrata Biswas",
                system.getEmployees().get(0).getName()
        );
    }

    @Test
    void testEmployeeAssignmentToProject() {
        Client client = new Client(
                1,
                "Suman Sil Enterprises",
                "suman.sil@company.com"
        );

        Employee employee = new Employee(
                102,
                "Sayanjib Sur",
                Designation.SOFTWARE_ENGINEER,
                Set.of("Java", "SQL")
        );

        Project project = new WebDevelopmentProject(
                1001,
                "Retail Management Portal",
                client,
                "Develop retail management portal",
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 10, 30),
                500000
        );

        project.assignEmployee(
                employee,
                "Backend development"
        );

        assertEquals(1, project.getAssignments().size());
        assertEquals(
                "Sayanjib Sur",
                project.getAssignments()
                        .get(0)
                        .getEmployee()
                        .getName()
        );
    }

    @Test
    void testProjectDevelopmentTracker() {
        Client client = new Client(
                2,
                "Susmita Chakrabarti Health Services",
                "susmita@healthservices.com"
        );

        Project project = new MobileAppProject(
                1002,
                "Patient Appointment App",
                client,
                "Doctor search and appointment booking",
                LocalDate.of(2026, 6, 15),
                LocalDate.of(2026, 12, 15),
                750000
        );

        project.updateDevelopment(
                ProjectStage.REQUIREMENT,
                "Completed"
        );

        assertEquals(
                1,
                project.getDevelopmentRecords().size()
        );

        assertEquals(
                ProjectStage.REQUIREMENT,
                project.getDevelopmentRecords()
                        .get(0)
                        .getStage()
        );

        assertEquals(
                "Completed",
                project.getDevelopmentRecords()
                        .get(0)
                        .getStatus()
        );
    }

    @Test
    void testProjectBilling() {
        Billing billing = new Billing(500000);

        billing.makePayment(200000);
        billing.makePayment(100000);

        assertEquals(
                300000,
                billing.getAmountPaid(),
                0.001
        );

        assertEquals(
                200000,
                billing.getDueAmount(),
                0.001
        );
    }

    @Test
    void testClientFeedback() {
        Client client = new Client(
                3,
                "Sumit Rajak Analytics",
                "sumit@analytics.com"
        );

        Project project = new DataAnalyticsProject(
                1003,
                "Business Analytics System",
                client,
                "Analyze business data",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 1, 31),
                600000
        );

        project.addFeedback(
                ProjectStage.REQUIREMENT,
                "Additional analytics reports required",
                4
        );

        assertEquals(1, project.getFeedbacks().size());

        assertEquals(
                4,
                project.getFeedbacks()
                        .get(0)
                        .getRating()
        );

        assertEquals(
                ProjectStage.REQUIREMENT,
                project.getFeedbacks()
                        .get(0)
                        .getStage()
        );
    }

    @Test
    void testDuplicateEmployeeAssignment() {
        Client client = new Client(
                1,
                "Suman Sil Enterprises",
                "suman.sil@company.com"
        );

        Employee employee = new Employee(
                101,
                "Subrata Biswas",
                Designation.PROJECT_MANAGER,
                Set.of("Project Planning")
        );

        Project project = new WebDevelopmentProject(
                1001,
                "Retail Management Portal",
                client,
                "Develop retail management portal",
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 10, 30),
                500000
        );

        project.assignEmployee(
                employee,
                "Project management"
        );

        assertThrows(
                IllegalStateException.class,
                () -> project.assignEmployee(
                        employee,
                        "Second assignment"
                )
        );
    }

    @Test
    void testInvalidFeedbackRating() {
        Client client = new Client(
                1,
                "Suman Sil Enterprises",
                "suman.sil@company.com"
        );

        Project project = new WebDevelopmentProject(
                1001,
                "Retail Management Portal",
                client,
                "Develop retail management portal",
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 10, 30),
                500000
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> project.addFeedback(
                        ProjectStage.TESTING,
                        "Invalid rating test",
                        6
                )
        );
    }
}