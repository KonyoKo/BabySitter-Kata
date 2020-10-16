import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BabySitterTest {

    private BabySitter testBabySitter;

    @Test
    public void testValidateStartTime() {
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("6:00 PM");
        assertTrue(testBabySitter.getStartTime().equals("18:00"));
        testBabySitter.setStartTime("21:00");
        assertTrue(testBabySitter.getStartTime().equals("21:00"));
        testBabySitter.setStartTime("16:00");
        assertNull(testBabySitter.getStartTime());
    }

    @Test
    public void testValidateEndTime() {
        testBabySitter = new BabySitter();
        testBabySitter.setEndTime("9:00 PM");
        assertTrue(testBabySitter.getEndTime().equals("21:00"));
        testBabySitter.setEndTime("03:00");
        assertTrue(testBabySitter.getEndTime().equals("03:00"));
        testBabySitter.setEndTime("5:00 AM");
        assertNull(testBabySitter.getEndTime());
    }

    @Test
    public void testValidateBedTime() {
        testBabySitter = new BabySitter();
        testBabySitter.setBedTime("9:00 PM");
        assertTrue(testBabySitter.getBedTime().equals("21:00"));
        testBabySitter.setBedTime("23:59");
        assertTrue(testBabySitter.getBedTime().equals("23:59"));
        testBabySitter.setBedTime("1:00 AM");
        assertNull(testBabySitter.getBedTime());
        testBabySitter.setBedTime("20:00");
        assertNull(testBabySitter.getBedTime());
    }

    @Test
    public void testCalculateShiftFrom5PMTo4AM() { //test normal shift
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("5:00 PM");
        testBabySitter.setBedTime("9:00 PM");
        testBabySitter.setEndTime("4:00 AM");
        assertEquals(136, testBabySitter.getNightlyPay());
    }

    @Test
    public void testCalculateShiftFrom5PMTo8PM() {
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("5:00 PM");
        testBabySitter.setBedTime("9:00 PM");
        testBabySitter.setEndTime("8:00 PM");
        assertEquals(36, testBabySitter.getNightlyPay());
    }

    @Test
    public void testCalculateShiftFrom1AMTo3AM() {
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("1:00 AM");
        testBabySitter.setBedTime("9:00 PM");
        testBabySitter.setEndTime("3:00 AM");
        assertEquals(32, testBabySitter.getNightlyPay());
    }

    @Test
    public void testCalculateShiftFrom10PMTo0AM() {
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("10:00 PM");
        testBabySitter.setBedTime("9:00 PM");
        testBabySitter.setEndTime("0:00 AM");
        assertEquals(16, testBabySitter.getNightlyPay());
    }

    @Test
    public void testCalculateEndTimeBeforeBedShift() {
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("6:00 PM");
        testBabySitter.setBedTime("9:00 PM");
        testBabySitter.setEndTime("8:00 PM");
        assertEquals(24, testBabySitter.getNightlyPay());
    }

    @Test
    public void testCalculateEndTimeAfterBedShift() {
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("6:00 PM");
        testBabySitter.setBedTime("9:30 PM");
        testBabySitter.setEndTime("10:30 PM");
        assertEquals(56, testBabySitter.getNightlyPay());
    }

    @Test
    public void testCalculateEndTimeAfterBedBeforeMidShift() {
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("20:00");
        testBabySitter.setBedTime("9:00 PM");
        testBabySitter.setEndTime("11:00 PM");
        assertEquals(28, testBabySitter.getNightlyPay());
    }

    @Test
    public void testCalculateEndTimeAfterMidShift() {
        testBabySitter = new BabySitter();
        testBabySitter.setStartTime("20:00");
        testBabySitter.setBedTime("10:00 PM");
        testBabySitter.setEndTime("2:00 AM");
        assertEquals(72, testBabySitter.getNightlyPay());
    }
}