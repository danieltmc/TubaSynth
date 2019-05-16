import javax.sound.midi.*;
import javax.sound.sampled.*;
import java.util.List;

public class Synth
{
	public Transmitter transmitter;
	private MidiReceiver receiver;
	
	public Synth()
	{
		MidiDevice device;
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		try
		{
			// Initialize Tuba Synth
		}
		catch (Exception e) { System.out.println(e.toString()); }
		
		for (int i = 0; i < infos.length; i++)
		{
			try
			{
				device = MidiSystem.getMidiDevice(infos[i]);
				List<Transmitter> transmitters = device.getTransmitters();
				for (int j = 0; j < transmitters.size(); j++)
				{
					transmitters.get(j).setReceiver(new MidiInputReceiver(device.getDeviceInfo().toString()));
				}
				temp = new MidiInputReceiver(device.getDeviceInfo().toString());
				temp.setClipArray(clips);
				transmitter = device.getTransmitter();
				transmitter.setReceiver(temp);
				device.open();
				System.out.println("MIDI Device Initialized: " + device.getDeviceInfo() + " was opened");
			}
			catch (MidiUnavailableException e) { /* Do nothing because we are iterating through all options until we find one input and one output that work */ }
		}
	}
	
	public static void main(String[] args)
	{
		Synth synth = new Synth();
	}
}
