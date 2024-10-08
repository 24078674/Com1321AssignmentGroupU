/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.com1321assignmentgroupu;

/**
 *
 * @author User
 */
//import utilitis from java library
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.reverseOrder;
import java.util.Scanner;

public class COM1321AssignmentGroupU {
    public static void main(String[] args) {
        //Create objects for accessing methods from the abstract class and the child class and also for taking user input
        Expense pt = new Terif();
        Terif pt2 = new Terif();
        Scanner input = new Scanner(System.in);
        
        //Declaring variables that will be used
        //Allow user to enter their full income before  any deduction
        System.out.print("Enter your full income before deductions: ");
        double fullIncome = input.nextDouble();
        
        //Allow user to enter their full monthly tax in percentage
        System.out.print("Enter your full monthly tax in percentage: ");
        double tax = input.nextDouble();
        
         //Allow user to enter their full Groceries Amount
        System.out.print("Enter your full Groceries Amount: ");
        double groceries = input.nextDouble();
        
        //Allow user to enter their Cell phone and Telephone amount
        System.out.print("Enter your Cell phone and Telephone ammount: ");
        double cellAndTelephone = input.nextDouble();
        
        //Allow user to enter their full  Travel costs Amount
        System.out.print("Enter your full Travel costs Amount: ");
        double travelCosts = input.nextDouble();
        
        //Allow user to enter their other expenses amount
        System.out.print("Enter your other expenses: ");
        double others = input.nextDouble();
        
         double taxAmount = pt.calculateTax(tax, fullIncome);//Store calculated tax in a variable called taxAmount
         
         double[] expenses = {0,taxAmount, groceries, travelCosts, cellAndTelephone, others}; //Storing all expenses in an Array
         
         double totalExpenses = pt2.calculateTotalExpenses(expenses);//Storing the total calculated Expenses in a variable called totalExpenses

        System.out.println("Total Expenses: " + totalExpenses);// Display to the user the Total Expenses
        
        //Alow the user to choose bettwen buying a property or renting
        System.out.print("Choose between renting or buying a property "
                + "\n" +
                "Enter 1 to Choose Renting or Enter 2 to choose buying a property: ");
        
        int choice = input.nextInt();
        
        pt2.estimate(fullIncome, tax, groceries, travelCosts, cellAndTelephone, others, choice, expenses);// Call the method estimate 
        
        ArrayList<Double>Expenses = new ArrayList<Double>();//Create an Array List to store all expenses
        
            Expenses = pt.addArrays(expenses, Expenses); // add expenses from part 1 to the array list
            
             System.out.print("Do you want to purchase a vehicle? (Enter 1 for yes, 2 for no): ");//Allow the user to choose if they want to buy a car or not
             choice = input.nextInt();
             
        switch(choice){
        case 1: //if the user chooses to buy a car
            
            System.out.print("Enter vehicle purchase price: ");//Allow the user to enter the vehicle's full price
            double vehiclePrice = input.nextDouble();

            System.out.print("Enter interest rate in percentage: ");// Allow the user to enter the interest rate in percentage
            double vehicleInterestRate = input.nextDouble();

            System.out.print("Enter number of months to repay (between 12 and 60): ");// Allow the user to enter the months needed for him to payout the car installments
            int vehicleMonthsToRepay = input.nextInt();
            
            //Call the method to calclate vehicle monthly payments and store it in a variable
            double vehicleMonthlyPayment = pt.calculateVehicleMonthlyPayment(vehiclePrice, vehicleInterestRate, vehicleMonthsToRepay);
            
            System.out.println("Your monthly vehicle payment is: " + vehicleMonthlyPayment);//Dispaly how much the user will be paying
            
            Expenses.add(vehicleMonthlyPayment);// Add the monthly installments in the array list of expenses
            pt2.Delegate(fullIncome, Expenses);
            double remainingMoney = fullIncome- pt.sumExpenses(Expenses);//Call the method to calclate the sum of expenses and subtract in from the income and store it in a variable
            System.out.println("After all deductions and vehicle payment, you'll be left with: " + remainingMoney);//Display the remaining ammount
            
            pt.vehicleEstimate(fullIncome, vehiclePrice, vehicleInterestRate, vehicleMonthsToRepay, Expenses);// Call a method called vehice estimate
            //print out the the expenses in a descending order
            
            System.out.println("Thank you for using this application Good bye");//Exit the program
            break;
        default:
            System.out.println("Thank you for using this application");//Exit the program
        }
    }
}

abstract class Expense {//Create a class called Expense and make it abstract

    Scanner input = new Scanner(System.in);//Make an object to take input outside the to avoid creating many objects
    
    //Create a method to calculate Tax
    double calculateTax(double tax, double income) {
        return (tax / 100) * income;
    }
    
    //Create a method to calculate total Expenses
    double calculateTotalExpenses(double[] expenses) {
        double sum = 0;
        for (double expense : expenses) {
            sum = sum + expense;
        }
        return sum;
    }
    
    //create a method to calculate available money
    double availableMoney(double income, double tax, double groceries, double travelCosts, double cellAndTelephone, double others, double rentOrProperty) {
        return income - (groceries + ((tax / 100) * income) + travelCosts + cellAndTelephone + others + rentOrProperty);
    }
    
    //Create a method for when a user selects to buy a proprty or rent 
    void estimate(double fullIncome, double tax, double groceries, double travelCosts, double cellAndTelephone, double others, int choice, double[] expenses) {
        double moneyLeft;
        double totalExpenses;

        if (choice == 1) {//if user selects to rent 
            
            System.out.print("Enter Monthly Rent: ");//Allow the user to enter monthly rent
            double rent = input.nextDouble();
            
            moneyLeft = availableMoney(fullIncome, tax, groceries, travelCosts, cellAndTelephone, others, rent); //Calculate the money left
            
            expenses[0] = rent;//add rent in the expenses array
            
            totalExpenses = calculateTotalExpenses(expenses);//Calculate Total Expeneses
            
            System.out.println("After all deductions you'll be left with: " + moneyLeft);//Display The ammount of money left
            
            System.out.println("Your Total amount of Expenses is: " + totalExpenses);//Display the total amount of expenses
            
        } else if (choice == 2) {//If user selects to buy a property
            //Declare variables
            double property, interestRate, deposits;
            int monthsToRepay;

            System.out.print("Enter Purchase price of Property: ");//Allow the user to enter the purchase price of the property
            property = input.nextDouble();

            System.out.print("Enter Interest rate in percentage: ");//allow the user to enter interest rate in percentage
            interestRate = input.nextDouble();

            System.out.print("Enter Number of months to repay (between 240 and 360): ");//Allow the user to enter the number of months to repay
            monthsToRepay = input.nextInt();
            
         
            
            deposits = calculateHomeLoan(property, interestRate, monthsToRepay);//Store Calculated homeloan in a variable
            
            propertyEstimate(fullIncome, property, interestRate, deposits, monthsToRepay);//call method property estimation to verify if the user entered wrong number of months
            
            moneyLeft = availableMoney(fullIncome, tax, groceries, travelCosts, cellAndTelephone, others, deposits);//calculate available money
            
            expenses[0] = deposits;//store deposits in the arry
            
            totalExpenses = calculateTotalExpenses(expenses);
            
            System.out.println("After all deductions you'll be left with: " + moneyLeft);//Display money left 
         
            
            System.out.println("Your Total amount of Expenses is: " + totalExpenses);// Display total Expenses
            
        } else {
            //If user enters incorrect value
            System.out.println("Please enter either 1 to pick Rent or 2 to pick Buy Property");
        }
    }
    
    //Method to calculate HomeLoan
    double calculateHomeLoan(double property, double interestRate, int monthsToRepay) {
        
        double interest = interestRate / 100;
        double n = monthsToRepay / 12;
        double homeLoan = property * (1 + (interest * n));
        return homeLoan / monthsToRepay;
    }
    
    //Method to display if home loan is more than the 3rd  and months to repay is to repay
    void propertyEstimate(double income, double property, double interestRate, double deposits, int monthsToRepay) {
        if (isValidMonthsToRepay(monthsToRepay)) {
            System.out.println("Your monthly payments are: " + deposits);
            if (isHomeLoanMoreThanThirdOfIncome(income, deposits)) {
                System.out.println("You are likely to not get the home loan since home loan is more than a third of the user's gross monthly");
            }
        } else {
            System.out.println("Number of months must be between 240 and 360");
        }
    }
    
    //Method to validate months to repay
    boolean isValidMonthsToRepay(int monthsToRepay) {
        return monthsToRepay >= 240 && monthsToRepay <= 360;
    }
    
    //Method to check homeloan is more than the third of income
    boolean isHomeLoanMoreThanThirdOfIncome(double income, double homeLoanRepayments) {
        return homeLoanRepayments > 0.3333 * income;
    }
    
    //Method to calculate Vehicle Monthly Payment
    double calculateVehicleMonthlyPayment(double vehiclePrice, double interestRate, int monthsToRepay) {
        double interest = interestRate / 100;
      return vehiclePrice * (interest / (1 - Math.pow(1 + interest, -monthsToRepay)));
        
    }
    
    //Method for vehicle Estimate
     void vehicleEstimate(double income, double vehiclePrice, double interestRate, int monthsToRepay,ArrayList<Double> expenses) {
        double vehicleMonthlyPayment = calculateVehicleMonthlyPayment(vehiclePrice, interestRate, monthsToRepay);
        System.out.println("Your monthly vehicle payment is: " + vehicleMonthlyPayment);

        if (isVehiclePaymentMoreThanThirdOfIncome(income, vehicleMonthlyPayment)) {
            System.out.println("You are likely to struggle with vehicle payments since it's more than a third of your gross monthly income");
        }
    }
     
     //Method to to see if the vehicle payment is more than the 3rd of income
    boolean isVehiclePaymentMoreThanThirdOfIncome(double income, double vehicleMonthlyPayment) {
        return vehicleMonthlyPayment > 0.3333 * income;
    }
    
    //Method to add values of array in part 1
    ArrayList<Double> addArrays(double[] arr,ArrayList<Double> expenses){
        for(double value:arr){
            expenses.add(value);
            
        }
        return expenses;
    }
    
    // Method to sum all values of an arrayList
     double sumExpenses(ArrayList<Double> expenses){
         double sum = 0;
        for(double value:expenses){
            sum = sum+value;
            
        }
        return sum;
    }
     // Method to see if the expense is more than 75% 
     boolean isMoreThan75(double income,ArrayList<Double>Expenses){
         double Total =sumExpenses(Expenses);
         return (Total/income)*100>75;
     }

}

class Terif extends Expense {//Child class of expenses
    
    //Method to get Total Expenses
    void getTotalExpense(double[] expenses) {
        Expense methods = new Terif();
        System.out.println("Total Expenses are: " + methods.calculateTotalExpenses(expenses));
    }
    //Method to DISPLAY if the user has used more than 75% of their income
     void Delegate(double income,ArrayList<Double>Expenses){
         Expense methods = new Terif();
         if(methods.isMoreThan75(income, Expenses)){
             System.out.println("You have used more than 75% of ur income");
         }
     }

}