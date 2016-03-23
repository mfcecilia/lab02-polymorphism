package employees;
import student.TestCase;

public class ExternalContractorTest extends student.TestCase {
    
    private ExternalContractor girl;

    public void setUp()
    {
      girl = new ExternalContractor("Mykayla", 1);

    }
    
    public void testGetHourlyRate()
    {
        assertEquals( 38.50, girl.getHourlyRate(1), 0.01);
        assertEquals(41.75, girl.getHourlyRate(2), 0.01);
        assertEquals(45.50, girl.getHourlyRate(3), 0.01);
        
    }
    
    public void testWeeklyPay()
    {
        assertEquals(91, girl.weeklyPay(2, 3), 0.01);
    }

}
