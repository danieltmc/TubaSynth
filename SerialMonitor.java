//import javax.comm.*;
import com.fazecast.jSerialComm.*;

public class SerialMonitor
{
	public void connect(String port)
	{
		
	}
	
	public static void list_ports()
	{
		java.util.Enumeration<CommPortIdentifier> port_enum = CommPortIdentifier.getPortIdentifiers();
		while (port_enum.hasMoreElements())
		{
			CommPortIdentifier identifier = port_enum.nextElement();
			System.out.println(identifier.getName() + " - " + port_type(identifier.getPortType()));
		}
	}
	
	public static String port_type(int type)
	{
		if (type == CommPortIdentifier.PORT_SERIAL)
		{
			return("Serial");
		}
		else
		{
			return("Other type not used by this program");
		}
	}
	
	public static void main(String[] args)
	{
		list_ports();
	}
}
