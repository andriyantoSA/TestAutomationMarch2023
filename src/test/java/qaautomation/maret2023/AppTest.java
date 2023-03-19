package qaautomation.maret2023;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	@BeforeMethod
	public void setUp() {
		System.out.println("This is prequisite");
	}
	
	@AfterMethod
	public void close() {
		System.out.println("This is a after method");
	}
	
    @Test
    public void shouldAnswerWithTrue()
    {
        assertEquals( 1,1 );
    }
    
    @Test
    public void shouldAnswerWithTrue2()
    {
        assertEquals( 2,2 );
    }
}
