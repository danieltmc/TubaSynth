import com.fazecast.jSerialComm.*;

public class SerialMonitor
{
	public void connect(String port)
	{
		
	}
	
	public static SerialPort[] get_ports()
	{
		return(SerialPort.getCommPorts());
	}
	
	public static void main(String[] args)
	{
		SerialPort[] ports = get_ports();
		for (int i = 0; i < ports.length; i++)
		{
			System.out.println(ports[i]);
		}
	}
}
