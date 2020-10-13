public class PayrateCalculator {

    private static int startTime;
    private static int bedTime;
    private static int midnight;
    private static int endTime;

    private static final String MIDNIGHT = "00:00";

    private static final double START_TO_BED_RATE = 12;
    private static final double BED_TO_MIDNIGHT_RATE = 8;
    private static final double MIDNIGHT_TO_END_RATE = 16;

    public static double calculate (String startTime, String bedTime, String endTime) {
        PayrateCalculator.startTime = HourCalculator.convertHoursToInteger(startTime);
        PayrateCalculator.bedTime = HourCalculator.convertHoursToInteger(bedTime);
        PayrateCalculator.midnight = HourCalculator.convertHoursToInteger(MIDNIGHT);
        PayrateCalculator.endTime = HourCalculator.convertHoursToInteger(endTime);
        return calculateStartToBed() * START_TO_BED_RATE + calculateBedToMidnight() * BED_TO_MIDNIGHT_RATE + calculateMidnightToEnd() * MIDNIGHT_TO_END_RATE;
    }

    private static Integer calculateStartToBed() {

        return 0;
    }

    private static Integer calculateBedToMidnight() {

        return 0;
    }

    private static Integer calculateMidnightToEnd() {

        return 0;
    }
}
