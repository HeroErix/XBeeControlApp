import com.digi.xbee.api.WiFiDevice;
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.models.XBeeProtocol;

public class DataSender {
	XBeeDevice myDevice;
    
    public DataSender(String port, int baud) {
    	myDevice = new XBeeDevice(port, baud);
    }

    public void send(String command) {
        byte[] dataToSend = command.getBytes();

        try {
            myDevice.open();
            System.out.format("Sending broadcast data: '%s'", new String(dataToSend));
            myDevice.sendBroadcastData(dataToSend);
            System.out.println(" >> Success");
        } catch (XBeeException e) {
            System.out.println(" >> Error");
            e.printStackTrace();
            System.exit(1);
        } finally {
            myDevice.close();
        }
    }
}