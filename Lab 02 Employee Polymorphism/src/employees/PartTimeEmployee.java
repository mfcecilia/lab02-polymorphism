package employees;
import java.util.*;


/**
 * This class is a way to filter out specific
 * people from the larger Employee class
 * @author Mykayla
 *
 */
public class PartTimeEmployee extends Employee {
    
    //~ Fields ................................................................
    
   
    private int hoursWorked;
    
    //~ Constructor ...........................................................
    /**
    * New PartTimeEmployee object.
    *
    * @param name Name of PartTimeEmployee
    * @param hourlyRate Pay rate of PartTimeEmployee (per hour).
    */
    
    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked)
    {
       super(name, hourlyRate);
       this.hoursWorked = hoursWorked;
    }
    
    public int getHoursWorked()
    {
        return hoursWorked;
    }
    
    @Override
    public double weeklyPay()
    {
        return this.getHourlyRate() * hoursWorked;
    }

}
