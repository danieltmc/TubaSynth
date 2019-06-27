import javax.sound.midi.*;
import javax.sound.sampled.*;
import java.util.List;

public class DigitalTuba
{
	//public Transmitter transmitter;
	//private MidiReceiver receiver;
	public static final int SAMPLING_RATE = 44100;
	private AudioFormat format = new AudioFormat(SAMPLING_RATE, 16, 1, true, false);
	// Setup
	// Go
	// Drain
	public double value = (double) 0.0; // Needs to range between 0.0 and 1.0

	public DigitalTuba()
	{
		MidiDevice device;
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
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
				this.receiver = new MidiReceiver(device.getDeviceInfo().toString());
				this.transmitter = device.getTransmitter();
				this.transmitter.setReceiver(receiver);
				device.open();
				System.out.println("MIDI Device Initialized: " + device.getDeviceInfo() + " was opened");
			}
			catch (MidiUnavailableException e) { /* Do nothing - iterating through all options until 1 input and 1 output are found */ }
		}
		
	}

	public static void main(String[] args)
	{
		DigitalTuba tuba = new DigitalTuba();
	}
}
