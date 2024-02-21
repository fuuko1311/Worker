package controller;

import model.Worker;
import view.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Programming extends Menu {
    static String[] mchoice = {
            "Add a Worker",
            "Increase salary for worker",
            "Decrease for worker",
            "Show adjusted salary worker information",
            "Exit"};

    ArrayList<Worker> workerList;
    public Programming() {
        super("Worker Management", mchoice);
    }

    @Override
    public void execute(int n) {
        if (n == mchoice.length) System.exit(0);

        switch (n) {
            case 1: //Add a Worker
                try {
                    addWorker();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;

            case 2: //Increase salary for worker

                break;

            case 3: //Decrease for worker

                break;

            case 4: //Show adjusted salary worker information

                break;
            case 5:
                System.out.println("Bye~~~~");
                System.exit(0);
        }
    }

    Scanner scanner = new Scanner(System.in);
    public void addWorker() throws Exception {
        System.out.println("\nEnter information for a Worker~~~~");

        System.out.print("Enter Code: ");
        String id = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Year of birth: ");
        int ageYear;
        //int ageYear = scanner.nextInt();
        do {
            ageYear = scanner.nextInt();
            System.out.printf("Worker's age is: %d", (2024 - ageYear));
            System.out.println();
            if ((2024 - ageYear)<18 && (2024 - ageYear)>50) {
                throw new Exception("Age invalid.");
            }
            //System.out.println("Age invalid.");

        } while ((2024 - ageYear)<18 && (2024 - ageYear)>50);

        scanner.nextLine();
        System.out.print("Enter Salary: ");
        int salary = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter work location: ");
        String workLocation = scanner.nextLine();

        Worker worker = new Worker(id, name, ageYear, salary, workLocation);
        workerList.add(worker);

        System.out.println("Worker information added successfully.");
    }

    /*public void displayRecentlyEnteredInformation() throws Exception {
        if (countriesList.isEmpty()) {
            throw new Exception("No country information available.");
        }
        //EastAsiaCountries recentlyEntered = countriesList.get(countriesList.size() - 1);
        System.out.println("\nRecently Entered Country Information~~~~");
        System.out.println("ID\t\tName\t\t\tTotal Area\t\tTerrain");
        *//*recentlyEntered.display();*//*
        for (EastAsiaCountries country : countriesList) {
            country.display();
            System.out.println();
        }
    }

    public void searchInformationByName() throws Exception {
        System.out.print("Enter Country Name to search: ");
        String searchName = scanner.nextLine();

        ArrayList<EastAsiaCountries> result = new ArrayList<>();
        for (EastAsiaCountries country : countriesList) {
            if (country.getCountryName().equalsIgnoreCase(searchName)) {
                result.add(country);
            }
        }

        if (result.isEmpty()) {
            throw new Exception("Country not found.");
        }

        System.out.println("Search Result:");
        for (EastAsiaCountries country : result) {
            country.display();
        }
    }

    public void displayInformationByAscendingOrder() throws Exception {
        if (countriesList.isEmpty()) {
            throw new Exception("No country information available.");
        }

        ArrayList<EastAsiaCountries> sortedList = new ArrayList<>(countriesList);
        Collections.sort(sortedList, Comparator.comparing(EastAsiaCountries::getCountryName));

        System.out.println("Country Information Sorted by Name (Ascending Order):");
        for (EastAsiaCountries country : sortedList) {
            country.display();
        }
    }*/
}
