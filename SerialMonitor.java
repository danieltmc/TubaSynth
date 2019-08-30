import com.fazecast.jSerialComm.*;

public class SerialMonitor
{	
	public void monitor_buffer()
	{
		port.openPort();
		try
		{
			while (port.bytesAvailable() == 0)
			{
				Thread.sleep(10);
			}
			byte[] buffer = new byte[port.bytesAvailable()];
			port.readBytes(buffer, buffer.length);
			// TODO: Decode bytes and play tone
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		port.closePort();
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
