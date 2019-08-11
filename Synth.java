import javax.sound.sampled.*;

public class Synth
{
	public static final int BUFFER_SIZE = 1;
	public static final int SAMPLE_SIZE = 8; // 16 requires an increased buffer size of 2
	private int SAMPLE_RATE;
	private double amplitude;
	
	public Synth()
	{
		this.SAMPLE_RATE = 44100;
		this.amplitude = 1.0;
	}
	
	public Synth(int sample_rate, double amplitude)
	{
		this.SAMPLE_RATE = sample_rate;
		this.amplitude = amplitude;
	}
	
	public void tone(double hz, int length, double volume) throws LineUnavailableException
	{
		byte[] buffer = new byte[BUFFER_SIZE];
		AudioFormat format = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, 1, true, false);
		SourceDataLine sdl = AudioSystem.getSourceDataLine(format);
		
		sdl.open(format);
		sdl.start();
		for (int i = 0; i < length * ((SAMPLE_RATE / 1000) + 1); i++)
		{
			double angle = i / ((double) SAMPLE_RATE / hz) * 2.0 * Math.PI;
			buffer[0] = (byte) (Math.sin(angle) * 127.0 * volume * amplitude);
			sdl.write(buffer, 0, 1);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}
	
	public void set_amplitude(double value)
	{
		this.amplitude = ((value >= 0.0) & (value <= 1.0)) ? value : 1.0;
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
