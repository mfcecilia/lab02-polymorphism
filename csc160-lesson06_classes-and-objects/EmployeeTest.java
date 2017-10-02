
package edu.frontrange.csc160.a6;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Math.abs;
import static java.lang.System.out;

/**
 * Class to test class Employee.
 * 
 * @author	Dr. Bruce K. Haddon, Instructor
 * @author      Robert Gilanyi, Instructor
 * @version	August 2017, CSC-160
 */
public class EmployeeTest
{
/**
 * The initial monthly salary for the first employee.
 */
private static final double EMPLOYEE1_MONTHLY_SALARY = 2985.00;

/**
 * The initial monthly salary for the second employee.
 */
private static final double EMPLOYEE2_MONTHLY_SALARY = 3361.75;

/**
 * Check that the given employee has the given attributes. Used to check that
 * displayValues does not have unexpected side effects.
 * <p>
 * @param given			  the given Employee object (which is not null)
 * @param firstName	the expected value to be returned by getFirst
 * @param lastName		the expected value to be returned by getLast
 * @param salary		  the expected value to be returned by getMonthlySalary
 */
private void checkEmployee(Employee given, String firstName, String lastName,
		double salary)
{
	boolean OK = true;

	/* Accumulate the start of the toString value expected. */
	String str1 = given.getClass().getName();

	/* Identify what can be identified of the employee. */
	out.print("**Checking the nominal employee ");
	out.print(firstName == null ? "<null>" :
			firstName.isEmpty() ? "<empty>" : firstName);
	out.print(" ");
	out.print(lastName == null ? "<null>" :
			lastName.isEmpty() ? "<empty>" : lastName);
	out.println();

	/* If both the actual and the expected first name are null, then OK,
	   otherwise if the expected value is null (and thus the actual found value
	   was not) report this, otherwise check to see if they are equal, and if
	   not, report that. */
	String firstFromObject = null;
	try
	{
		firstFromObject = this.<String>getField(given, "firstNameField");
	} catch( NoSuchFieldException | IllegalArgumentException |
			IllegalAccessException | SecurityException ex ) {}

	if( firstFromObject != null || firstName != null )
		if( firstName == null )
		{
			OK = false;
			out.printf("**?? Error: First name expected to be null," +
					" found to be \"%s\"%n", firstFromObject);
		} else if( !firstName.equals(firstFromObject) )
		{
			OK = false;
			out.printf("**?? Error: First name expected to be \"%s\"," +
					" found to be \"%s\"%n", firstName, firstFromObject);
		}

	String lastFromObject = null;
	try
	{
		lastFromObject = this.<String>getField(given, "lastNameField");
	} catch( NoSuchFieldException | IllegalArgumentException |
			IllegalAccessException | SecurityException ex )
	{
	}

	/* If both the actual and the expected last name are null, then OK,
	   otherwise if the expected value is null (and thus the actual found value
	   was not) report this, otherwise check to see if they are equal, and if
	   not, report that. */
	if( lastFromObject != null || lastName != null )
		if( lastName == null )
		{
			OK = false;
			out.printf("**?? Error: Last name expected to be null," +
					" found to be \"%s\"%n", lastFromObject);
		} else if( !lastName.equals(lastFromObject) )
		{
			OK = false;
			out.printf("**?? Error: Last name expected to be \"%s\"," +
					" found to be \"%s\"%n", lastName, lastFromObject);
		}
	String str2 = null;
	try
	{
		/* Accumulate more of the toString value expected. */
		Method method = given.getClass().getMethod("hashCode");
		if( method.getDeclaringClass() == Object.class )
			str2 = method.invoke(given).toString();
	} catch( NoSuchMethodException | IllegalArgumentException |
			InvocationTargetException | IllegalAccessException |
			SecurityException | ClassCastException ex ) {}

	/* Check to see if the salary value is close enough to what is expected If
	   not, report it. */
	double salaryFromObject = 0.0;
	try
	{
		salaryFromObject = this.<Double>getField(given, "salaryField");
	} catch( NoSuchFieldException | IllegalArgumentException |
			IllegalAccessException | SecurityException ex ) {}

	if( abs(salaryFromObject - salary) > 0.0001 )
	{
		OK = false;
		out.printf("**?? Error: Monthly salary expected to be \"%.2f\"," +
				" found to be \"%.2f\"%n", salary, salaryFromObject);
	}

	if( !(str1 == null || str2 == null) )
		str1 += "\u0040" + Integer.toHexString(Integer.parseInt(str2));

	if( OK )
	{
		out.print("**");
		out.print(firstName == null ? "<null>" :
				firstName.isEmpty() ? "<empty>" : firstName);
		out.print(" ");
		out.print(lastName == null ? "<null>" :
				lastName.isEmpty() ? "<empty>" : lastName);
		out.println(" is OK");
	}

	/* Check that displayValue gives an acceptable result. */
	out.println("**The result of \"displayValues\" for that employee");
	given.displayValues();

	/* Print message only if the toString values to not match. */
	if( str2 != null &&
			!(str1 + "\u0020" + firstName +
			" " + lastName).equals(given.toString()) )
		out.
				println("**?? toString value \"" + given.toString() +
						"\" incorrect");
}

/**
 * Get the value of a field of the object without using the defined getter. Use
 * reflection to reach straight into the object.
 *
 * @param <T>		the type of the field
 * @param object	the object containing the field
 * @param name		the name of the field
 * @return			the value found
 * @throws NoSuchFieldException     if there is no such field
 * @throws IllegalArgumentException	should not happen
 * @throws IllegalAccessException   should not happen
 * @throws SecurityException        should not happen
 */
@SuppressWarnings("unchecked")
private <T> T getField(Object object, String name) throws NoSuchFieldException,
		IllegalArgumentException, IllegalAccessException
{
	/* Get the class object for the instance, and create the variable to hold
	   the result of accessing the field. */
	Class<?> clazz = object.getClass();
	T value = null;
	try
	{
		/* Get the field object for the declared field, make sure it is
		   accessible, and then grab the value of the field. */
		Field field = clazz.getDeclaredField(name);
		field.setAccessible(true);
		value = (T) field.get(object);
	} catch( IllegalArgumentException | IllegalAccessException |
			NoSuchFieldException | SecurityException ex )
	{
		/* The only exception expected to happen is that the field does not have
		   the correct name. */
		out.println(
				"**?? Cannot find field: " + ex.getMessage());
		throw ex;
	}

	/* Return the value found. */
	return value;
}

/**
 * Do the work for the EmployeeTest.
 */
private void run()
{
	/* Create some empty strings which are not the constant "". */
	String emptyString1 = new String();
	String emptyString2 = new String();
	String emptyString3 = new String();

	/* Check the compiler has not done too much optimization. */
	assert !((Object) emptyString1 == (Object) emptyString2 ||
			(Object) emptyString1 == (Object) "" ||
			(Object) emptyString2 == (Object) emptyString3 ||
			(Object) emptyString2 == (Object) "" ||
			(Object) emptyString3 == (Object) emptyString1 ||
			(Object) emptyString3 == (Object) "") :
			"**?? Empty test strings not unique!";

	/* This try block is intended to catch any exceptions that may occur. Of
	   course, there should not be any. */
	try
	{
		/* This is required to ensure that the output directed to the err file
		   appears in the correct sequence with the output directed to the out
		   file. Otherwise the two files are independent, and the output does
		   not necessarily appear in the correct time order. */
		System.setErr(out);

		out.println("**CSC-240 Assignment 2");
		out.println();
		out.println("** --- TESTING CREATING VALID Employee OBJECTS ---");
		out.println();

		/* Instantiate two valid Employee objects.  */
		out.println("**Creating two valid employees");
		Employee employee1 =
				new Employee("Bob", "Jones", EMPLOYEE1_MONTHLY_SALARY);
		checkEmployee(employee1, "Bob", "Jones", EMPLOYEE1_MONTHLY_SALARY);

		Employee employee2 =
				new Employee("Susan", "Bakker", EMPLOYEE2_MONTHLY_SALARY);
		checkEmployee(employee2, "Susan", "Bakker", EMPLOYEE2_MONTHLY_SALARY);

		out.println("**Changing first name of Bob Jones to Robert");
		try
		{
			employee1.setFirst("Robert");
		} catch( NullPointerException npe )
		{
			out.println("**?? Erroneous \"setFirst\": " +
					"resulted in NullPointerException");
		}
		if( employee1.getFirst() == null ||
				!employee1.getFirst().equals("Robert") )
			out.println("**?? Erroneous \"getFirst\": " +
					"did not result in returning expected value");
		checkEmployee(employee1, "Robert", "Jones", EMPLOYEE1_MONTHLY_SALARY);

		out.println("**Changing last name of Susan Bakker to Baker");
		try
		{
			employee2.setLast("Baker");
		} catch( NullPointerException npe )
		{
			out.println("**?? Erroneous \"setLast\": " +
					"resulted in NullPointerException");
		}
		if( employee2.getLast() == null ||
				!employee2.getLast().equals("Baker") )
			out.println("**?? Erroneous \"getLast\": " +
					"did not result in returning expected value");
		checkEmployee(employee2, "Susan", "Baker", EMPLOYEE2_MONTHLY_SALARY);

		/* Increase employee salaries by 10%. */
		out.println();
		out.println("** --- INCREASING Employee SALARIES BY 10% ---");
		out.println();

		/* Increase the salary of employee1 by 10%. */
		employee1.setMonthlySalary(employee1.getMonthlySalary() * 1.10);
		/* Check that the salary increase was correctly recorded. */
		checkEmployee(employee1, "Robert", "Jones",
				EMPLOYEE1_MONTHLY_SALARY * 1.10);

		/* Increase the salary of employee2 by 10%. */
		employee2.setMonthlySalary(employee2.getMonthlySalary() * 1.10);
		/* Check that the salary increase was correctly recorded. */
		checkEmployee(employee2, "Susan", "Baker",
				EMPLOYEE2_MONTHLY_SALARY * 1.10);

		/* Test that bad Employee values cannot be set. */
		out.println();
		out.println("** --- TESTING INVALID CALLS TO Employee METHODS ---");
		out.println();

		/* Try to set some non-acceptable values. */
		out.println("**Setting last name of Robert Jones to \"\"");
		employee1.setLast(emptyString1);
		checkEmployee(employee1, "Robert", null, EMPLOYEE1_MONTHLY_SALARY * 1.10);
		if( employee1.getLast() != null )
			out.println("**?? Error: \"getLast\" " +
					"did not return a null value");

		out.println("**Setting first name of Robert Jones to null");
		try
		{
			employee1.setFirst(null);
		} catch( NullPointerException npe )
		{
			out.println("**?? Error: \"setFirst\" " +
					"resulted in NullPointerException");
		}
		checkEmployee(employee1, null, null, EMPLOYEE1_MONTHLY_SALARY * 1.10);
		if( employee1.getFirst() != null )
			out.println("**?? Error: \"getFirst\" " +
					"did not return a null value");

		out.println("**Setting first name of Susan Baker to \"\"");
		employee2.setFirst(emptyString2);
		checkEmployee(employee2, null, "Baker", EMPLOYEE2_MONTHLY_SALARY * 1.10);
		if( employee2.getFirst() != null )
			out.println("**?? Error: \"getFirst\" " +
					"did not return a null value");

		out.println("**Setting last name of Susan Baker to null");
		try
		{
			employee2.setLast(null);
		} catch( NullPointerException npe )
		{
			out.println("**?? Error: \"setLast\" " +
					"resulted in NullPointerException");
		}
		checkEmployee(employee2, null, null, EMPLOYEE2_MONTHLY_SALARY * 1.10);
		if( employee2.getLast() != null )
			out.println("**?? Error: \"getLast\" " +
					"did not return a null value");

		out.println("**Setting salary of Susan Baker to -1000.0");
		employee2.setMonthlySalary(-1000.0);
		checkEmployee(employee2, null, null, 0.0);
		if( employee2.getMonthlySalary() != 0.0 )
			System.out.println(
					"**?? Error: \"getMonthlySalary\"  " +
					"did not return a zero value");

		/* Try to create Employee objects with non-acceptable initial values. */
		out.println("**Creating \"\" Smith, with salary of -500.0");
		Employee employee3 = new Employee(emptyString3, "Smith", -500.0);
		checkEmployee(employee3, null, "Smith", 0.0);
		if( employee3.getFirst() != null )
			out.println("**?? After construction: \"getFirst\" " +
					"did not return a null value");
		if( employee3.getMonthlySalary() != 0.0 )
			out.println(
					"**?? After construction: \"getMonthlySalary\" " +
					"did not result in zero value");

		out.println("**Creating <null> Baker");
		Employee employee4 = null;
		try
		{
			employee4 = new Employee(null, "Baker", 500.0);
		} catch( NullPointerException ex )
		{
			out.println("**?? Error in constructor: null " +
					"\"first name\" resulted in NullPointerException");
		}
		if( employee4 != null )
		{
			checkEmployee(employee4, null, "Baker", 500.0);
			if( employee4.getFirst() != null )
				out.println("**?? After construction: \"getFirst\" " +
						"did not return a null value");
			if( employee4.getMonthlySalary() != 500.0 )
				out.println(
						"**?? After construction: \"getMonthlySalary\"  " +
						"did not result in the value set");
		}
	} catch( Throwable th )
	{
		/* The application under test should not throw any Exceptions or Errors.
		   The use of Exceptions will not be studied until a later lesson, but
		   they are nevertheless an inescapable part of the Java programming
		   system. */
		out.println("**?? An exception or error has been thrown");
		out.println("**?? The exception is: " + th.toString());
		out.println("**?? The source of the error can be found " +
				"in this stacktrace:");
		th.printStackTrace(out);
	}
}

/**
 * Main entry point.
 * <p>
 * Execute:</p>
 * <pre>java edu.frontrange.csc240.a2.EmployeeTest</pre>
 *
 * @param args	unused
 */
public static void main(String[] args)
{
	new EmployeeTest().run();		// Run the test
}
}
