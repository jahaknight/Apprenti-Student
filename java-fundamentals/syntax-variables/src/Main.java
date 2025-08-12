//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    //Need static Variable to be accessed in main method
    static int hippoCount = 0;


    public static void main(String[] args) {
        //Loop through 1 to 10 and count hippos
        for (int i = 0; i <=10; i++) {

            hippoCount++;
            System.out.print(hippoCount + " Hippotamus\n");

        }

        //Common Data Types Variables as Variables
        int height;
        height = 170;
        double weight = 175.5;
        float pi = 3.1415926f;
        System.out.println(pi);
        char oneLetter = 'X';
        String eyeColor = "Blue";
        System.out.println(eyeColor.substring(1,3));

        Integer age = 51;

        boolean canDrive = (age >= 21);

        System.out.println(canDrive);

        //x centimeters * 0.3937 = inches
        int heightInches = (int) Math.round(height * 0.3937);

        System.out.println(heightInches);

       byte smallNumber = 127;

       short smallerInt = 32767;

       long pages = 28435616368543L;

       double ageWeightRatio = age / Weight


    }


}