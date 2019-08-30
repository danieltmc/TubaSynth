import com.fazecast.jSerialComm.*;

public class SerialMonitor
{	
	public void monitor_buffer(SerialPort port)
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
	
	public void monitor_stream(SerialPort port)
	{
		port.openPort();
		port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		InputStream in = port.getInputStream();
		try
		{
			while (true) // TODO: Change to poll for interrupt
			{
				// TODO: Decode bytes and play tune
			}
			in.close();
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
