package employees;
import java.util.*;
//-------------------------------------------------------------------------
/**
*  Represents an average employee working 40 hours per week.
*
*  @author  Mykayla Fernandes mkaykay1
*  @version 2016.03.16
*/
public class Employee
{
	//~ Fields ................................................................

	private String name;
	private double hourlyRate;

	//~ Constructor ...........................................................
	/**
	* New Employee object.
	*
	* @param name Name of Employee
	* @param hourlyRate Pay rate of Employee (per hour).
	*/
	public Employee(String name, double hourlyRate)
	{
	   this.name = name;
	   this.hourlyRate = hourlyRate;
	}


	//~ Methods ...............................................................

	// ----------------------------------------------------------
	/**
	* Gets the employee's name.
	* @return the employee's name
	*/
	public String getName()
	{
	   return name;
	}


	// ----------------------------------------------------------
	/**
	* Gets the pay rate (per hour).
	* @return the pay rate
	*/
	public double getHourlyRate()
	{
	   return hourlyRate;
	}

	// ----------------------------------------------------------
	/**
	* Amount paid to the employee for an average 40 hour work week.
	* @return weekly Weekly pay for employee
	*/
	public double weeklyPay()
	{
	   return hourlyRate * 40;
	}

	@Override
    public boolean equals(Object obj)
    {
	    if(obj == null) //base case
	    {
	        return false;
	    }
	    if (obj == this) //base case
	    {
	        return true;
	    }
	    if (obj.getClass() == this.getClass()) //base case
	    {
	        Employee person = (Employee)obj; //this is casting from an obj to an employee
	        if (name.equals(person.getName()))
	        {
	            return true;
	        }
	        else
	        {
	            return false; //adding an else to ensure method returns a boolean
	        }
	    }
	    else
	    {
	        return false; //adding an else statement to ensure method returns a boolean
	    }


    }
}
