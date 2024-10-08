Personal Budget Planning Application

Overview
This Java application helps users manage their personal budgets by allowing them to input their income, expenses, and make decisions about renting, 
buying property, and purchasing vehicles. The application calculates total expenses, checks for financial feasibility, and provides insights on spending based on income.

Features
•       Calculate and display total expenses based on user inputs.
•       Allow users to choose between renting or buying a property, with a detailed calculation of monthly payments.
•       Calculate vehicle monthly payments if the user decides to purchase a vehicle.
•       Provide estimates on whether home loan or vehicle payments exceed one-third of the user’s gross income.
•       Display expenses in descending order.
•       Warn users if their total expenses exceed 75% of their income.

Prerequisites
•       Java JDK 8 or higher: You must have Java Development Kit (JDK) installed.
•       NetBeans IDE (optional): The project can be compiled and run through NetBeans, but it can also be compiled and run through the command line.

Installation and Setup
1.      Clone or download the repository:
git clone https://github.com/24078674/Com1321AssignmentGroupU.git
2.      Navigate to the project directory:
cd personal-budget-planner



Instructions for Compiling and Running
1))Compile and Run via Command Line
---1.Open a terminal in the project directory.
---2.Compile the code:
Run the following command to compile the Java files:
javac COM1321AssignmentGroupU/.java
---3.Run the application:
After compiling, execute the following command to run the program:
java Com1321AssignmentGroupU

2))Compile and Run via NetBeans
---1.Open NetBeans.
---2.Create a new project:
 •Go to File -> New Project -> Java -> Java Application.
 •Set the project name as PersonalBudgetPlanner.
 • Set the project location to the directory where the COM1321AssignmentGroupU.java file is located.
---3.Add the source file:
 • Right-click on the Source Packages in the project panel.
 •Select New -> Java Class.
 •  Name the class COM1321AssignmentGroupU, and copy the contents of COM1321AssignmentGroupU.java into this file.
---4.Run the program:
 •Press F6 or click Run -> Run Project to compile and run the program.

How to Use the Application
1.Input your financial information:
        •       Enter your full income before deductions.
        •       Input the percentage of your income taken as tax.
        •       Provide amounts for your monthly groceries, cell phone and telephone, travel costs, and other expenses
2.Choose between renting or buying a property:
        •       Input the relevant data, such as rent amount or property purchase price, interest rate, and repayment duration.
3.Decide whether to purchase a vehicle:
        •       If selected, input the vehicle price, interest rate, and the number of months to repay.
4.View summary:
        •       The program will calculate and display your total expenses, remaining income, and expenses sorted in descending order.

Example Output

Enter your full income before deductions: 20000
Enter your full monthly tax in percentage: 10
Enter your full Groceries Amount: 3000
Enter your Cell phone and Telephone amount: 500
Enter your full Travel costs Amount: 1000
Enter your other expenses: 1500
Total Expenses: 7550.0
Choose between renting or buying a property
Enter 1 to Choose Renting or Enter 2 to choose buying a property: 1
Enter Monthly Rent: 4000
After all deductions you'll be left with: 9450.0
Your Total amount of Expenses is: 10550.0
Do you want to purchase a vehicle? (1 for yes, 2 for no): 2
Your Expenses in Descending order : [4000.0, 3000.0, 1500.0, 1000.0, 500.0, 200.0]
Thank you for using this application Good bye
