import javax.sound.sampled.*;

public class Synth
{
	// Number of bytes to store in the buffer
	public static final int BUFFER_SIZE = 1;
	// Size of each sample in bits
	public static final int SAMPLE_SIZE = 8; // 16 requires an increased buffer size of 2
	// Number of samples to generate per second
	private int SAMPLE_RATE;
	// Volume of the synthesizer (that is not affected by tremolo, etc)
	private double amplitude;
	// Array that will hold the samples to be emitted by the SourceDataLine
	private byte[] buffer;
	// Format of the audio output
	private AudioFormat format;
	// Connection to system resources that allows audio emission
	private SourceDataLine sdl;
	
	/*
	 * The default Synth constructor.
	 * The volume is set to 100% and the sample rate is set to 44,100Hz (highest pitch possible is 22,050Hz - theoretically outside the range of human hearing).
	 */
	public Synth() throws LineUnavailableException
	{
		this.SAMPLE_RATE = 44100;
		this.amplitude = 1.0;
		this.buffer = new byte[BUFFER_SIZE];
		this.format = new AUdioFormat(SAMPLE_RATE, SAMPLE_SIZE, 1, true, false);
		this.sdl = AudioSystem.getSourceDataLine(this.format);
	}
	
	/*
	 * The customizable Synth constructor.
	 * The sample rate and synthesizer volume can be defined by the user.
	 * @param	int		number of samples to generate per second
	 * @param	double	starting volume of the synthesizer
	 */
	public Synth(int sample_rate, double amplitude) throws LineUnavailableException
	{
		this.SAMPLE_RATE = sample_rate;
		this.amplitude = amplitude;
		this.buffer = new byte[BUFFER_SIZE];
		this.format = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, 1, true, false);
		this.sdl = AudioSystem.getSourceDataLine(this.format);
	}
	
	/*
	 * Tone generator that emits a pitch of the desired frequency, length, and relative volume.
	 * @param	double	frequency of the pitch to be emitted
	 * @param	int		time to emit the pitch (in milliseconds)
	 * @param	double	relative volume of the pitch (useful for effects like tremolo)
	 * @throws	LineUnavailableException	if the line cannot be opened due to resource restrictions
	 */
	public void tone(double hz, int length, double volume) throws LineUnavailableException
	{
		this.sdl.open(this.format);
		this.sdl.start();
		for (int i = 0; i < length * ((SAMPLE_RATE / 1000) + 1); i++)
		{
			double angle = i / ((double) SAMPLE_RATE / hz) * 2.0 * Math.PI;
			this.buffer[0] = (byte) (Math.sin(angle) * 127.0 * volume * amplitude);
			this.sdl.write(buffer, 0, 1);
		}
		this.sdl.drain();
		this.sdl.stop();
		this.sdl.close();
	}
	
	/*
	 * Method to update the current volume of the Synth.
	 * @param	double	decimal value of the desired volume
	 */
	public void set_amplitude(double value)
	{
		this.amplitude = ((value >= 0.0) & (value <= 1.0)) ? value : 1.0;
	}
	
	/*
	 * Method to fetch the current amplitude of the Synth.
	 * @return			current volume of the synthesizer
	 */
	public double get_amplitude()
	{
		return(this.amplitude);
	}
	
	public static void main(String[] args)
	{
		try
		{
			Synth synth = new Synth(50000, 1.0);
			synth.tone(440.0, 1000, 1.0);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
