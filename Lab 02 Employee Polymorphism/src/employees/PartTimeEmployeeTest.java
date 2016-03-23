package employees;

public class PartTimeEmployeeTest extends student.TestCase {
    
    private PartTimeEmployee girl;

    public void setUp()
    {
      girl = new PartTimeEmployee("Mykayla", 10, 2);
    }
    
    public void testGetHoursWorked()
    {
        assertEquals(2, girl.getHoursWorked(), 0.01);
    }
    
    public void testWeeklyPay()
    {
        assertEquals(20, girl.weeklyPay(), 0.01);
    }
    

}
