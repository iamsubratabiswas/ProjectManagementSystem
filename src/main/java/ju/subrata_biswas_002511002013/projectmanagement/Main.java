package ju.subrata_biswas_002511002013.projectmanagement;

import java.time.LocalDate;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        ProjectManagementSystem system =
                new ProjectManagementSystem();

        Client client1 = new Client(
                1,
                "Suman Sil Enterprises",
                "suman.sil@company.com"
        );

        Client client2 = new Client(
                2,
                "Susmita Chakrabarti Health Services",
                "susmita@healthservices.com"
        );

        Client client3 = new Client(
                3,
                "Sumit Rajak Analytics",
                "sumit@analytics.com"
        );

        system.addClient(client1);
        system.addClient(client2);
        system.addClient(client3);


        Employee e1 = new Employee(
                101,
                "Subrata Biswas",
                Designation.PROJECT_MANAGER,
                Set.of("Project Planning", "Agile")
        );

        Employee e2 = new Employee(
                102,
                "Sayanjib Sur",
                Designation.SOFTWARE_ENGINEER,
                Set.of("Java", "Spring Boot", "SQL")
        );

        Employee e3 = new Employee(
                103,
                "Peuli Karmakar",
                Designation.TEST_ENGINEER,
                Set.of("JUnit", "Selenium")
        );

        Employee e4 = new Employee(
                104,
                "Anup Biswas",
                Designation.DEVOPS_ENGINEER,
                Set.of("Docker", "CI/CD", "AWS")
        );

        Employee e5 = new Employee(
                105,
                "Muazzem Hossain",
                Designation.BUSINESS_ANALYST,
                Set.of("Requirement Analysis", "Documentation")
        );

        Employee e6 = new Employee(
                106,
                "Khijir Alam",
                Designation.SOFTWARE_ENGINEER,
                Set.of("Android", "Java", "REST API")
        );

        Employee e7 = new Employee(
                107,
                "Sayan Bacchar",
                Designation.TEST_ENGINEER,
                Set.of("Mobile Testing", "JUnit")
        );

        Employee e8 = new Employee(
                108,
                "Chayan Ghosh",
                Designation.MAINTENANCE_ENGINEER,
                Set.of("System Monitoring", "Bug Fixing")
        );

        Employee e9 = new Employee(
                109,
                "Jalesh Banerjee",
                Designation.SOFTWARE_ENGINEER,
                Set.of("Python", "Data Analysis", "SQL")
        );


        system.addEmployee(e1);
        system.addEmployee(e2);
        system.addEmployee(e3);
        system.addEmployee(e4);
        system.addEmployee(e5);
        system.addEmployee(e6);
        system.addEmployee(e7);
        system.addEmployee(e8);
        system.addEmployee(e9);


        Project project1 = new WebDevelopmentProject(
                1001,
                "Retail Management Portal",
                client1,
                "Develop a secure web portal for product, order and customer management.",
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 10, 30),
                500000
        );

        Project project2 = new MobileAppProject(
                1002,
                "Patient Appointment App",
                client2,
                "Build a mobile application for doctor search and appointment booking.",
                LocalDate.of(2026, 6, 15),
                LocalDate.of(2026, 12, 15),
                750000
        );

        Project project3 = new DataAnalyticsProject(
                1003,
                "Business Analytics System",
                client3,
                "Analyze business data and generate management reports.",
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2027, 1, 31),
                600000
        );


        system.addProject(project1);
        system.addProject(project2);
        system.addProject(project3);


        project1.assignEmployee(
                e1,
                "Project planning and client coordination"
        );

        project1.assignEmployee(
                e2,
                "Backend and database development"
        );

        project1.assignEmployee(
                e3,
                "Functional and regression testing"
        );

        project1.assignEmployee(
                e4,
                "Deployment pipeline and cloud hosting"
        );

        project1.assignEmployee(
                e5,
                "Requirement analysis"
        );


        project2.assignEmployee(
                e1,
                "Project supervision"
        );

        project2.assignEmployee(
                e6,
                "Mobile application development"
        );

        project2.assignEmployee(
                e7,
                "Mobile application testing"
        );

        project2.assignEmployee(
                e8,
                "Application maintenance"
        );


        project3.assignEmployee(
                e5,
                "Business requirement analysis"
        );

        project3.assignEmployee(
                e9,
                "Data processing and analytics"
        );


        // PROJECT 1 DEVELOPMENT LIFECYCLE

        project1.updateDevelopment(
                ProjectStage.REQUIREMENT,
                "Completed"
        );

        project1.addFeedback(
                ProjectStage.REQUIREMENT,
                "Requirements captured correctly",
                5
        );


        project1.updateDevelopment(
                ProjectStage.FEASIBILITY,
                "Completed"
        );

        project1.addFeedback(
                ProjectStage.FEASIBILITY,
                "Proposed solution is acceptable",
                4
        );


        project1.updateDevelopment(
                ProjectStage.TESTING,
                "Completed"
        );

        project1.addFeedback(
                ProjectStage.TESTING,
                "Application passed required testing",
                4
        );


        project1.updateDevelopment(
                ProjectStage.DEPLOYMENT,
                "Completed"
        );

        project1.addFeedback(
                ProjectStage.DEPLOYMENT,
                "Deployment completed successfully",
                5
        );


        project1.updateDevelopment(
                ProjectStage.MAINTENANCE,
                "In Progress"
        );

        project1.addFeedback(
                ProjectStage.MAINTENANCE,
                "Maintenance support is satisfactory",
                4
        );


        // PROJECT 2 DEVELOPMENT LIFECYCLE

        project2.updateDevelopment(
                ProjectStage.REQUIREMENT,
                "Completed"
        );

        project2.addFeedback(
                ProjectStage.REQUIREMENT,
                "Application requirements approved",
                5
        );

        project2.updateDevelopment(
                ProjectStage.FEASIBILITY,
                "Completed"
        );

        project2.addFeedback(
                ProjectStage.FEASIBILITY,
                "Mobile application plan is feasible",
                4
        );


        // PROJECT 3 DEVELOPMENT LIFECYCLE

        project3.updateDevelopment(
                ProjectStage.REQUIREMENT,
                "In Progress"
        );

        project3.addFeedback(
                ProjectStage.REQUIREMENT,
                "Additional analytics reports required",
                4
        );


        // PROJECT BILLING

        project1.getBilling().makePayment(200000);
        project1.getBilling().makePayment(100000);

        project2.getBilling().makePayment(300000);

        project3.getBilling().makePayment(150000);


        // DISPLAY PROJECT REPORTS

        system.printProjectReport(project1);

        system.printProjectReport(project2);

        system.printProjectReport(project3);


        // DISPLAY ALL PROJECTS

        System.out.println("\nALL PROJECTS");

        system.getProjects()
                .forEach(System.out::println);
    }
}