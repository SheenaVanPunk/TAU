package phoneBillCalculator;


public class PhoneBillCalculator {

    public static void main(String args[]) {

        /**
         * DEFAULT Constructor
         **/
        PhoneBill bill1 = new PhoneBill();
        bill1.setId(1);
        bill1.printBill();

        /**
         * Constructor 2: id as a parameter
         **/

        PhoneBill bill2 = new PhoneBill(2); //Constructor with only ID as a parameter
        bill2.setMinutesUsed(1000);
        bill2.printBill();

        /**
         * Constructor 3: 4 parameters
         **/

        PhoneBill bill3 = new PhoneBill(3, 44.99, 100, 109); // Constructor containing all fields
        bill3.printBill();

        /**
         * User entering data: basePlan, allottedMinutes and minutesUsed. Constructor 3 is used again.
         **/

        PhoneBill bill4 = PhoneBill.getPhoneBillDetails();
        bill4.printBill();
    }


}
