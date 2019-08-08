import javax.sound.midi.*;
import javax.sound.sampled.*;
import java.util.List;
import java.util.Arrays;
import java.io.*;

public class Synthesizer
{
	static int sample_rate = 44100;

	public static double[] tone(double hz, double duration)
	{
		int num_samples = (int) (sample_rate * duration);
		double[] out = new double[num_samples + 1];
		for (int i = 0; i < num_samples + 1; i++)
		{
			out[i] = Math.sin(2 * Math.PI * i * hz / sample_rate);
		}
		return out;
	}
	
	public static void play(double[] array)
	{
		try
		{
			byte[] out = new byte[array.length];
			for (int i = 0; i < array.length; i++)
			{
				out[i] = (byte) (array[i] * 255);
			}
			AudioFormat format = new AudioFormat(sample_rate, 16, 1, true, false);
			Clip clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, format));
			clip.open(new AudioInputStream(new ByteArrayInputStream(out), format, (long) out.length));
			clip.start();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args)
	{
		double hz = 440.0;
		double duration = 5.0;
		double[] out = tone(hz, duration);
		//System.out.println(Arrays.toString(out));
		play(out);
	}
}
