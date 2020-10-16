import java.util.Scanner;

public class Project {

    public static void main(String[] args) {
        BabySitter babySitter = new BabySitter();
        Scanner input = new Scanner(System.in);


        System.out.println("Please Enter The Start Time In HH:MM Format : ");
        babySitter.setStartTime(input.next());
        if (babySitter.getStartTime() != null){
            System.out.println("Please Enter The Bed Time In HH:MM Format : ");
            babySitter.setBedTime(input.next());
            if(babySitter.getBedTime() != null) {
                System.out.println("Please Enter The End Time In HH:MM Format : ");
                babySitter.setEndTime(input.next());
                if(babySitter.getEndTime() != null){
                    System.out.println("The Nightly Pay out will be : $" + babySitter.getNightlyPay());
                }
                else{
                    babySitter.failCase();
                }
            }
            else{
                babySitter.failCase();
            }
        }
        else{
         babySitter.failCase();
        }









    }
}
