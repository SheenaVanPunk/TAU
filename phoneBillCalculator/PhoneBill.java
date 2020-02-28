package phoneBillCalculator;

import java.util.Random;
import java.util.Scanner;

public class PhoneBill {

    private int id;
    private double baseCost;
    private int allottedMinutes;
    private int minutesUsed;

    public PhoneBill() {
        id = 0;
        baseCost = 79.99;
        allottedMinutes = 800;
        minutesUsed = 800;
    }

    public PhoneBill(int id) {
        this.id = id;
        baseCost = 79.99;
        allottedMinutes = 800;
        minutesUsed = 800;
    }

    public PhoneBill(int id, double baseCost, int allottedMinutes, int minutesUsed) {
        setId(id);
        setBaseCost(baseCost);
        setAllottedMinutes(allottedMinutes);
        setMinutesUsed(minutesUsed);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public int getAllottedMinutes() {
        return allottedMinutes;
    }

    public void setAllottedMinutes(int minutes) {
        allottedMinutes = minutes;
    }

    public int getMinutesUsed() {
        return minutesUsed;
    }

    public void setMinutesUsed(int minutes) {
        minutesUsed = minutes;
    }

    public double calculateOverage() {
        if (minutesUsed <= allottedMinutes) {
            return 0;
        }
        double overageRate = 0.25;
        return (minutesUsed - allottedMinutes)* overageRate;
    }

    public double calculateTax() {
        double taxPercentage = 0.15;
        return taxPercentage * (baseCost + calculateOverage());
    }

    public double calculateTotal() {
        return baseCost + calculateOverage() + calculateTax();
    }

    public void printBill() {
        System.out.println("------------------------------------");
        System.out.println("Your phone bill summary for Plan # " + getId());
        System.out.println("------------------------------------");
        System.out.println("Base plan cost: $" + getBaseCost());
        System.out.println("Overage minutes cost: $" + String.format("%.2f", calculateOverage()));
        System.out.println("Tax: $" + String.format("%.2f", calculateTax()));
        System.out.println("------------------------------------");
        System.out.println("Total: $" + String.format("%.2f", calculateTotal()));
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
    }


    public static PhoneBill getPhoneBillDetails() {
        Random random = new Random();
        int id = random.nextInt(100);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter base plan cost: ");
        double baseCost = scanner.nextDouble();

        System.out.println("Enter the number of allotted minutes you have: ");
        int allottedMinutes = scanner.nextInt();

        System.out.println("Enter the number of minutes you used: ");
        int minutesUsed = scanner.nextInt();

        scanner.close();
        return new PhoneBill(id, baseCost, allottedMinutes, minutesUsed);
    }

}
