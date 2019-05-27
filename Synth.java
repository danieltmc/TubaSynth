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
			Tuba tuba = new Tuba();
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
					transmitters.get(j).setReceiver(new MidiReceiver(device.getDeviceInfo().toString()));
				}
				receiver = new MidiReceiver(device.getDeviceInfo().toString());
				transmitter = device.getTransmitter();
				transmitter.setReceiver(receiver);
				device.open();
				System.out.println("MIDI Device Initialized: " + device.getDeviceInfo() + " was opened");
			}
			catch (MidiUnavailableException e) { /* Do nothing - iterating through all options until 1 input and 1 output are found */ }
		}
	}
	
	public static void main(String[] args)
	{
		Synth synth = new Synth();
		while (true)
		{
			if (synth.receiver.on)
			{
				synth.tuba.update(synth.receiver.note);
			}
			else
			{
				// Silence if the note is off
				synth.tuba.update();
			}
		}
		synth.tuba.stop();
	}
}
