import javax.sound.sampled.*;

public class Synth
{
	public static final int BUFFER_SIZE = 16;
	public static final int SAMPLE_RATE = 44100;
	
	public Mixer.Info mixer;
	public AudioFormat format = new AudioFormat(SAMPLE_RATE, 16, 1, true, false);
	public SourceDataLine sdl;
	public byte[] buffer = new byte[BUFFER_SIZE];
	
	public Synth()
	{
		
	}
	
	public static void main(String[] args)
	{
		
	}
}
