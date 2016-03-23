package employees;

public class ExternalContractor extends Employee {
    
  //~ Constructor ...........................................................
    /**
    * New Contractor object.
    *
    * @param name Name of Contractor
    * @param hourlyRate Pay rate of Contractor (per hour).
    */
    public ExternalContractor(String name, double hourlyRate)
    {
       super(name, hourlyRate);
    }
    
    /**
     * Gets the pay rate (per hour).
     * @precondition rank must be positive integer
     * @return the pay rate
     */
     public double getHourlyRate(int rank)
     {
         if (rank == 1)
         {
             return 38.50;
         }
         if (rank == 2)
         {
            return 41.75;
         }
         if (rank >= 3)
         {
            return 45.50;
         }
         else
         {
             return 0;
         }
      
     }
     
     
     /**
      * Amount paid to the contractor for an average work week.
      * @precondition rank must be positive integer
      * @param hours is hours worked
      * @param rank is number 1 - 3
      * @return weekly Weekly pay for contractor
      */
      public double weeklyPay(int hours, int rank)
      {
         return getHourlyRate(rank)* hours;
      }

}

