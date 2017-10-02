
package edu.frontrange.csc160.a6;

import static java.lang.System.out;

/**
 * Employee class, to meet the requirements stated in the Assignment
 * Instructions for Assignment 2.
 * <p>
 * The following UML is given for this class: </p>
 * <p>
 * <strong><u>Employee</u> <br>
 * - firstNameField: String <br>
 * - lastNameField: String <br>
 * - salaryField: double <br>
 * <br>
 * +&lt;constructor&gt; Employee(firstName: String, lastName: String,
 * initialSalary: double) <br>
 * + setFirst(firstName: String) <br>
 * + setLast(lastName: String) <br>
 * + setMonthlySalary(salary: double) <br>
 * + getFirst(): String <br>
 * + getLast(): String <br>
 * + getMonthlySalary(): double <br>
 * + displayValues() <br>
 * + toString() : String </strong></p>
 *
 * @author	Dr. Bruce K. Haddon, Instructor
 * @author      Robert Gilanyi, Instructor
 * @version	August 2017, CSC-160
 */
public class Employee
{
/**
 * The employee's first name (assuming Western World naming).
 */
private String firstNameField;

/**
 * The employee's last name (assuming Western World naming).
 */
private String lastNameField;

/**
 * Employee's salary (assuming USA dollars).
 */
private double salaryField;

/**
 * Constructor.
 *
 * @param firstName     employee's first name (assuming Western World naming)
 * @param lastName      employee's last name (assuming Western World naming)
 * @param initialSalary	employee's initial salary (assuming USA dollars)
 */
public Employee(String firstName, String lastName, double initialSalary)
{
	out.println("Constructor not yet implemented");
}

/**
 * Print on the standard output the details of this employee.
 */
public void displayValues()
{
	out.println("displayValues not yet implemented");
}

/**
 * Getter for the employee's first name (assuming Western World naming).
 *
 * @return	employee's first name.
 */
public String getFirst()
{
	return "getFirst not yet implemented";
}

/**
 * Setter for the employee's first name (assuming Western World naming).
 *
 * @param firstName	employee's first name (assuming Western World naming).
 */
public void setFirst(String firstName)
{
	out.println("setFirst not yet implemented");
}

/**
 * Getter for the employee's last name (assuming Western World naming).
 *
 * @return	employee's last name.
 */
public String getLast()
{
	return "getLast not yet implemented";
}

/**
 * Setter for the employee's last name (assuming Western World naming).
 *
 * @param lastName	employee's last name (assuming Western World naming).
 */
public void setLast(String lastName)
{
	out.println("setLast not yet implemented");
}

/**
 * Getter for the monthly salary.
 *
 * @return	the value of the monthly salary
 */
public double getMonthlySalary()
{
	out.println("getMonthlySalary not yet implemented");
	return Double.MIN_VALUE;
}

/**
 * Setter for the monthly salary.
 * <p>
 * @param salary	the monthly salary
 */
public void setMonthlySalary(double salary)
{
	out.println("setMonthlySalary not yet implemented");
}

/**
 * String identifying and describing this employee.
 *
 * @return the string
 */
@Override
public String toString()
{
	return "toString not yet implemented";
}
}
