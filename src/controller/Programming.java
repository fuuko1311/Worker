package controller;

import model.Worker;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Programming extends Menu {
    static String[] mchoice = {
            "Add a Worker",
            "Up salary",
            "Down salary",
            "Display Information salary",
            "Exit"};

    ArrayList<Worker> workerList;
    public Programming() {
        super("Worker Management", mchoice);
        workerList = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        if (n == mchoice.length) System.exit(0);

        switch (n) {
            case 1: //Add a Worker
                    addWorker();
                break;

            case 2: //Increase salary for worker
                increaseSalary();
                break;

            case 3: //Decrease for worker
                decreaseSalary();
                break;

            case 4: //Show adjusted salary worker information
                displayInformationSalary();
                break;
            case 5:
                System.out.println("Bye~~~~");
                System.exit(0);
        }
    }

    Scanner scanner = new Scanner(System.in);
    public void addWorker() {
        System.out.println("\nEnter information for a Worker~~~~");

        System.out.print("Enter Code: ");
        String id = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        int ageYear, age;
        do {
            System.out.print("Enter Year of birth: ");
            ageYear = scanner.nextInt();
            age = 2024-ageYear;
            System.out.printf("Worker's age is: %d", age);
            System.out.println();
            if ((2024 - ageYear)<18 || (2024 - ageYear)>50) {
                System.out.println("Age invalid. TRY AGAIN!!!!\n");
            }
        } while ((2024 - ageYear)<18 || (2024 - ageYear)>50);
        scanner.nextLine();

        System.out.print("Enter Salary: ");
        int salary = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter work location: ");
        String workLocation = scanner.nextLine();

        Worker worker = new Worker(id, name, age, salary, workLocation);
        workerList.add(worker);

        System.out.println("Worker information added successfully.");
    }

    private Worker findWorkerById(String id) {
        for (Worker worker : workerList) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }

   /* private boolean isWorkerIdExists(String id) {
        for (Worker worker : workerList) {
            if (worker.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }*/

    public void increaseSalary() {
        System.out.println("\nEnter worker code and amount to increase salary:");

        System.out.print("Enter Code: ");
        String id = scanner.nextLine();

        Worker worker = findWorkerById(id);
        if (worker == null) {
            System.out.println("Worker with this ID does not exist.");
            return;
        }

        System.out.print("Enter amount to increase salary: ");
        int amount = scanner.nextInt();
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }

        worker.setSalary(worker.getSalary() + amount);
        System.out.println("Salary increased successfully.");
    }

    public void decreaseSalary() {
        System.out.println("\nEnter worker code and amount to decrease salary:");

        System.out.print("Enter Code: ");
        String id = scanner.nextLine();

        Worker worker = findWorkerById(id);
        if (worker == null) {
            System.out.println("Worker with this ID does not exist.");
            return;
        }

        System.out.print("Enter amount to decrease salary: ");
        int amount = scanner.nextInt();
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }

        if (amount > worker.getSalary()) {
            System.out.println("Amount to decrease is greater than current salary.");
            return;
        }

        worker.setSalary(worker.getSalary() - amount);
        System.out.println("Salary decreased successfully.");
    }

    public void displayInformationSalary() {
        System.out.println("\nWorker information with adjusted salary:");
        System.out.println("ID\tName\tAge\tSalary\tLocation");
        for (Worker worker : workerList) {
            System.out.println(worker.getId() + "\t" + worker.getName() + "\t" +
                    worker.getAgeYear() + "\t" + worker.getSalary() + "\t" + worker.getWorkLocation());
        }
    }
///////
}
