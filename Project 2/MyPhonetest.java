
/**
 * Testing for MyPhone class
 *
 * @author Elijah Anderson
 * @version 6 June 2017
 */
public class MyPhonetest
{
    /*
    public static void main (String[] a) {
        MyPhone mine = new MyPhone("Amanda Jaffe", "1234567890");
    
        mine.setPhoneNumber("12345678");

        mine.printStatement();
        mine.streamVideo(100);
        mine.streamAudio(100);
        mine.chargeBattery(120);
        mine.sendText("Text message");
        mine.readText();
        mine.showBatteryLife();

        mine.streamVideo(-100);
        mine.streamAudio(-100);
        mine.streamVideo(0);
        mine.chargeBattery(-120);
        mine.chargeBattery(0);

        mine.streamVideo(720);
        mine.chargeBattery(120);
        mine.streamVideo(720);
        System.out.println(mine.getBatteryLife()); // should be 0

        mine.printStatement();
    }
    */

    
    public static void main (String[] a) {

        MyPhone mine = new MyPhone("Project 2 Demo", "1234567890");
        mine.chargeBattery(500);   
        mine.setWifi(false);
        mine.streamAudio(120);
        mine.streamVideo(120);
        mine.sendText("Project 2 Demo");
        mine.readText();
        mine.printStatement();
        System.out.println( mine.getBatteryLife() );
    }
    
}
