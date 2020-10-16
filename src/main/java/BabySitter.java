import java.util.Scanner;

public class BabySitter{
    private String startTime;
    private String bedTime;
    private String endTime;
    private static final String MIN_START_TIME = "17:00";
    private static final String MAX_END_TIME = "04:00";
    private static final String MIN_BED_TIME = "21:00";
    private static final String MAX_BED_TIME = "23:59";

    //Empty Constructor
    public BabySitter() {

    }

    public double getNightlyPay() {
        return PayrateCalculator.calculate(startTime, bedTime, endTime);
    }

    private String validateInput(String start, String end, String input) {
        if(input.contains("AM") || input.contains("am") || input.contains("PM") || input.contains("pm")) {
            input = HourCalculator.convertToMilitaryFormat(input);
        }

        if(!HourCalculator.inBetween(start, end, input)) {
            System.out.println("Input is out of range");
            return null;
        }
        return input;
    }





    //Getters
    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getBedTime() {
        return this.bedTime;
    }


    //Setters
    public void setStartTime(String startTime) {
        this.startTime = validateInput(MIN_START_TIME, MAX_END_TIME, startTime);
    }

    public void setEndTime(String endTime) {
        this.endTime = validateInput(MIN_START_TIME, MAX_END_TIME, endTime);
    }

    public void setBedTime(String bedTime) {
        this.bedTime = validateInput(MIN_BED_TIME, MAX_BED_TIME, bedTime);
    }

    //Helper Method
    public void failCase() {
        System.out.println("Please try again.");
        return;
    }

}
