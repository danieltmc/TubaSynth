import javax.comm.*;

public class SerialMonitor
{
	public void connect(String port)
	{
		
	}
	
	public void list_ports()
	{
		java.util.Enumeration<CommPortIdentifier> port_enum = CommPortIdentifier.getPortIdentifiers();
		while (port_enum.hasMoreElements())
		{
			CommPortIdentifier identifier = port_enum.nextElement();
			System.out.println(identifier.getName() + " - " );//+ );
		}
	}
	
	public String port_type(int type)
	{
		return(null);
	}
}
