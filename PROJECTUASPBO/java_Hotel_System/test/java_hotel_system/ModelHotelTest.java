

package java_hotel_system;
 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author hokyt
 */
public class ModelHotelTest {
    //relasi
    ModelHotel mH;
    
    public ModelHotelTest() {
        mH = new ModelHotel("Regular Room", "1", 700000);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testShowMessage(){
        String expectedResult = "For the information, Regular Room, booked for 1 day"
                + "\nThe price is  : 700000";
        //Assert.assertEquals(expectedResult, mH.messageFormat());
    }
}
