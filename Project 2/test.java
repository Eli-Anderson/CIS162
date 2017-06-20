

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class test
{
    @Test
    public void testChargeBattery () {
        MyPhone phone = new MyPhone("asdf", "1234567890");
        //phone.streamVideo(60);
        assertEquals(1.0, phone.getBatteryLife(), 0.001);
        phone.chargeBattery(-25);
        assertEquals(1.0, phone.getBatteryLife(), 0.001);
    }
}
