
/**
 * A basic phone class that contains many of the functions that a typical 
 * real-world phone would have. Includes a battery function, fake
 * streaming capabilities, as well as sending/reading texts.
 *
 * @author Elijah Anderson
 * @version 23 May 2017 -- updated 6 June 2017
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MyPhone {

    private int numTextsSent;
    private double dataConsumed;
    private double batteryLife = 1.0;
    private String customerName;
    private String phoneNumber;
    private boolean wifi = false;
    private JFrame frame = new JFrame();

    private final double VIDEO_DATA_PER_MIN = 250.0 / 60.0;
    private final double AUDIO_DATA_PER_MIN = 65.0 / 60.0;
    private final double VIDEO_BATT_PER_MIN = 1.0 / 360.0;
    private final double AUDIO_BATT_PER_MIN = 1.0 / 720.0;

    private final double DATA_COST_BASIC_2GB = 50.0;
    private final double DATA_COST_PER_EXTRA_GB = 15.0;
    private final double ADMINISTRATIVE_FEE = 0.61;

    public MyPhone (String name, String num) {
        customerName = name;
        setPhoneNumber(num);
    }

    // getters
    public int getNumTexts () { /* returns the total number of texts sent or received this month. */
        return numTextsSent;
    }

    public double getBatteryLife () { /* returns the remaining amount of battery life, should be in the range 0.0 – 1.0. */
        return batteryLife;
    }

    public double getDataUsage () { /* returns the amount of data used so far this month in megabytes (MB). */
        return dataConsumed;
    }

    public String getCustomerName () { /* returns name that is assigned to the phone */
        return customerName;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    // setters
    public void setName (String name){ /* – sets the customer name. */
        customerName = name;
    }

    public void setPhoneNumber (String num){ /* – sets the phone number. The String should contain a ten-digit sequence of digits */
        if (num.length() != 10) {
            System.out.println("Given phone number is not 10 digits");
            phoneNumber = "9999999999";
        }
        else {
            phoneNumber = num;
        }
    }

    public void setWifi (boolean wifi) {
        this.wifi = wifi;
    }

    public void showBatteryLife () {
        JOptionPane.showMessageDialog(frame, (int) (getBatteryLife() * 100) + "%", "Battery", JOptionPane.INFORMATION_MESSAGE);
    }

    public void chargeBattery (int mins){ /* – updates the battery life to reflect a charge for mins additional minutes. */
        double chargePerMin = 0.008333;
        if (mins < 0) {
            System.out.println("Given minutes is negative");
            return;
        }
        batteryLife += chargePerMin * mins;
        if (getBatteryLife() > 1.0) {
            batteryLife = 1.0;
        }
        showBatteryLife();
    }

    public void streamAudio (int mins){ /* – calculates the amount of data consumed and battery power used to stream the specified minutes of audio. */
        if (mins < 0) {
            System.out.println("Given minutes is negative");
            return;
        }
        if (batteryLife - (AUDIO_BATT_PER_MIN * mins) < 0.0) {   /* if battery will die mid stream */
            double minsUntilDead = batteryLife / AUDIO_BATT_PER_MIN; /* gets how many minutes will be used until phone is dead */
            batteryLife -= AUDIO_BATT_PER_MIN * minsUntilDead; /* reduces battery to (what should be) dead */
            dataConsumed += minsUntilDead * (((wifi) ? 0 : 1) * AUDIO_DATA_PER_MIN); /* uses data for only minutes until out of battery, but no data if wifi is on */

            JOptionPane.showMessageDialog(frame, "Warning: Out of battery", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            batteryLife -= AUDIO_BATT_PER_MIN * mins; /* otherwise just decreases battery and increases data accordingly */
            dataConsumed += mins * (((wifi) ? 0 : 1) * AUDIO_DATA_PER_MIN);
        }
    }

    public void streamVideo(int mins){ /* – calculates the amount of data consumed and battery power used to stream the specified minutes of video. */
        if (mins < 0) {
            System.out.println("Given minutes is negative");
            return;
        }
        if (batteryLife - (VIDEO_BATT_PER_MIN * mins) < 0.0) {   /* if battery will die mid stream */
            double minsUntilDead = batteryLife / VIDEO_BATT_PER_MIN; /* gets how many minutes will be used until phone is dead */
            batteryLife -= VIDEO_BATT_PER_MIN * minsUntilDead; /* reduces battery to (what should be) dead */
            dataConsumed += minsUntilDead * VIDEO_DATA_PER_MIN; /* uses data for only minutes until out of battery */

            JOptionPane.showMessageDialog(frame, "Warning: Out of battery", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            batteryLife -= VIDEO_BATT_PER_MIN * mins; /* otherwise just decreases battery and increases data accordingly */
            dataConsumed += mins * VIDEO_DATA_PER_MIN;
        }
    }

    public void sendText (String text){ /* – increments the  text counter.  Uses JOptionPane to display the text. */
        numTextsSent ++;

        JOptionPane.showMessageDialog(frame, text, "Sent Text", JOptionPane.INFORMATION_MESSAGE);
    }

    public void readText(){ /* – uses JOptionPane to display a short text message of your choice. */
        String[] textOptions = new String[] {
            "What are you up to?",
            "I am on my way.",
            "How are you, today?",
            "Let's get together",
            "Python > Java"
        };
        JOptionPane.showMessageDialog(frame, textOptions[(int) (Math.random( ) * 5)], "Received Text", JOptionPane.INFORMATION_MESSAGE);
    }

    public void printStatement(){ /* – prints a monthly statement using System.out.print statements. */
        /*
        MyPhone Monthly Statement
         
        Customer:   Amanda Jaffe
        Number: (123)456-7890
        Texts   1
        Data usage: 2.1 (GB)
         
        2GB Plan    $50.00
        Additional data fee:    $15.00
        Universal Usage (3%):   $1.95
        Administrative Fee  $0.61
        Total Charges:  $67.56
        */

        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        DecimalFormat fmt2 = new DecimalFormat("#.##");

        System.out.println("MyPhone Monthly Statement \n");
        System.out.println("Customer:  " + getCustomerName());
        System.out.println("Number:  " + fmtPhoneNumber());
        System.out.println("Texts:  " + getNumTexts());
        System.out.println("Data usage:  " + fmt2.format(calcDataUsageGB()) + " (GB) \n");
        System.out.println("2GB Plan:  " + fmt.format(DATA_COST_BASIC_2GB));
        System.out.println("Additional data fee:  " + fmt.format(calcAdditionalDataFee()));
        System.out.println("Universal usage fee (3%):  " + fmt.format(calcUsageCharge()));
        System.out.println("Administrative fee:  " + fmt.format(ADMINISTRATIVE_FEE));
        System.out.println("Total charges:  " + fmt.format(calcTotalFee()));
        System.out.println("");
    }

    private double calcDataUsageGB () {
        return (getDataUsage() / 1024.0);
    }

    private void startNewMonth () { /* – resets the appropriate instance members to zero. */
        dataConsumed = 0.0;
        numTextsSent = 0;
    }

    private double calcAdditionalDataFee () { /* – returns the additional data fee which is $15 for each GB above the basic 2GB, where data usage is rounded up. */
        if (calcDataUsageGB() > 2.0) {
            return DATA_COST_PER_EXTRA_GB * (Math.ceil(calcDataUsageGB()) - 2.0);
        }
        return 0.0;
    }

    private double calcUsageCharge () { /* – returns 3% of the phone service cost, where the phone service cost is $50 plus additional data fees. */
        return 0.03 * (DATA_COST_BASIC_2GB + calcAdditionalDataFee());
    }

    private double calcTotalFee () { /* – returns the total monthly fee, which is the sum of the phone service cost, the usage charge, and the administrative fee ($0.61). */
        return DATA_COST_BASIC_2GB + ADMINISTRATIVE_FEE + calcUsageCharge() + calcAdditionalDataFee();
    }

    private String fmtPhoneNumber () { /* – converts the ten digit String to a standard phone format */
        return "(" + getPhoneNumber().substring(0,3) + ")" + getPhoneNumber().substring(3,6) + "-" + getPhoneNumber().substring(6,getPhoneNumber().length());
    }

}






