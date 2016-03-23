package employees;
//if i have the import "student.TestCase" i don't need the "extends student.TestCase"
import student.TestCase; 
import java.util.*;

public class EmployeeTest extends student.TestCase{
    
    private Employee girl;

    public void setUp()
    {
      girl = new Employee("Mykayla", 10);
    }

    public void testConstructor()
    {
      assertEquals("Mykayla", girl.getName());
      assertEquals(10, 0.01, girl.getHourlyRate());
    }
    
    public void testGetName()
    {
        assertEquals("Mykayla", girl.getName());
    }
    
    public void testGetHourlyRate()
    {
        assertEquals(10, 0.01, girl.getHourlyRate());
    }
    
    public void testWeeklyPay()
    {
        assertEquals(400, 0.01, girl.weeklyPay());
    }
    
}
