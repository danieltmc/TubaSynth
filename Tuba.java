import javax.sound.sampled.*;

public class Tuba
{
	public Synth synth;
	private Key tuning;

	public enum Key
	{
		CC, BBFLAT, EFLAT, F
	}
	
	public Tuba()
	{
		try
		{
			this.synth = new Synth();
			this.tuning = Key.CC;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public Tuba(int sample_rate, double amplitude, Key key) throws LineUnavailableException
	{
		this.synth = new Synth(sample_rate, amplitude);
		this.tuning = key;
		
		// Loop while waiting for input
		while (true)
		{
			try
			{
				note_poll();
				// Sleep for 40 milliseconds while the note plays
				Thread.sleep(40);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	private void note_poll()
	{
		if (this.tuning == Key.CC)
		{
			CC();
		}
		else if (this.tuning == Key.BBFLAT)
		{
			BBFLAT();
		}
		else if (this.tuning == Key.EFLAT)
		{
			EFLAT();
		}
		else if (this.tuning == Key.F)
		{
			F();
		}
	}
	
	public void CC()
	{
		// Open fingering
		if (true)
		{
		
		}
		// First valve
		else if (true)
		{
		
		}
		// Second valve
		else if (true)
		{
		
		}
		// Third valve
		else if (true)
		{
		
		}
		// Fourth valve
		else if (true)
		{
		
		}
	}
	
	public void BBFLAT()
	{
	
	}
	
	public void EFLAT()
	{
	
	}
	
	public void F()
	{
	
	}
	
	public static void main(String[] args)
	{
		new Tuba();
	}
}
