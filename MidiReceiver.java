import javax.sound.midi.*;
import javax.sound.sampled.*;
import java.io.*;

public class MidiReceiver implements Receiver
{
	// Name of MIDI device
	public String name;
	// Midi Status values
	private Integer note_off = new Integer(0x8);
	private Integer note_on = new Integer(0x9);
	private Integer poly_press = new Integer(0xA);
	private Integer control_change = new Integer(0xB);
	private Integer program_change = new Integer(0xC);
	private Integer channel_press = new Integer(0xD);
	private Integer pitch_bend = new Integer(0xE);
	private Integer sysex = new Integer(0xF);
	// Status of note
	public boolean on = false;
	public Integer note;
	
	public MidiReceiver(String name)
	{
		this.name = name;
	}
	
	public void send(MidiMessage msg, long timestamp)
	{	
		// Status messages are 32 bits, the 24 MSB and the 4 LSB don't matter, so the 4 necessary bits are isolated
		Integer status = new Integer(((msg.getMessage()[0] >> 4) & (0xf)));
		Integer input_channel = new Integer(msg.getMessage()[1]);
		Integer input_val = new Integer(msg.getMessage()[2]);
		System.out.println("\nStatus: " + Integer.toHexString(status));
		
		if (status.equals(note_on))
		{
			// TODO: Implement
			System.out.println("Note on");
			this.on = true;
			this.note = input_channel.intValue();
		}
		else if (status.equals(note_off))
		{
			// TODO: Implement
			System.out.println("Note off");
			this.note = false;
		}
		else if (status.equals(poly_press))
		{
			// TODO: Add Aftertouch (changing sound by pressing harder on the key while it is already pressed)
			System.out.println("Polyphonic Pressure");
		}
		else if (status.equals(control_change))
		{
			// TODO: Add Control Change (see https://www.midi.org/specifications-old/item/table-3-control-change-messages-data-bytes-2 for info)
			System.out.println("Control Change");
		}
		else if (status.equals(program_change))
		{
			// TODO: Add Program Change (patch change - allow user to change samples)
			System.out.println("Program Change");
		}
		else if (status.equals(channel_press))
		{
			// TODO: Add Channel Pressure (Like aftertouch, but averaged across all of the keys of the controller)
			System.out.println("Channel Pressure");
		}
		else if (status.equals(pitch_bend))
		{
			// TODO: Add Pitch Bend (push the pitch higher or lower)
			System.out.println("Pitch Bend");
		}
		else if (status.equals(sysex))
		{
			// TODO: Determine Intended Functionality
			System.out.println("System Exclusive Message");
		}
	}
	
	public void close()
	{
		
	}
}
