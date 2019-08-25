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
				// TODO: Remove sleep. Not necessary if notes are played in 1ms increments
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
			// Play C or G
		}
		// First valve
		else if (true)
		{
			// Play F or Bb
		}
		// Second valve
		else if (true)
		{
			// Play Gb or B
		}
		// Third valve
		else if (true)
		{
			// Play E or A
		}
		// Fourth valve
		else if (true)
		{
			// Play D or low G
		}
		// 1 & 2
		else if (true)
		{
			// Play E or A
		}
		// 1 & 3
		else if (true)
		{
			// Play D or low G
		}
		// 1 & 4
		else if (true)
		{
			// No known note
		}
		// 2 & 3
		else if (true)
		{
			// Play Eb or Ab
		}
		// 2 & 4
		else if (true)
		{
			// Play Db or low Gb
		}
		// 3 & 4
		else if (true)
		{
			// Low Eb - bad tuning
			// Low Cb
		}
		// 1 & 2 & 3
		else if (true)
		{
			// Play Db or low F
		}
		// 1 & 2 & 4
		else if (true)
		{
			// Play low F
		}
		// 1 & 3 & 4
		else if (true)
		{
			// Play low Db
		}
		// 2 & 3 & 4
		else if (true)
		{
			// Play low E
		}
		// 1 & 2 & 3 & 4
		else if (true)
		{
			// Play low C
		}
	}
	
	public void BBFLAT()
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
		// 1 & 2
		else if (true)
		{
		
		}
		// 1 & 3
		else if (true)
		{
		
		}
		// 1 & 4
		else if (true)
		{
		
		}
		// 2 & 3
		else if (true)
		{
		
		}
		// 2 & 4
		else if (true)
		{
		
		}
		// 3 & 4
		else if (true)
		{
		
		}
		// 1 & 2 & 3
		else if (true)
		{
		
		}
		// 1 & 2 & 4
		else if (true)
		{
		
		}
		// 1 & 3 & 4
		else if (true)
		{
		
		}
		// 2 & 3 & 4
		else if (true)
		{
		
		}
		// 1 & 2 & 3 & 4
		else if (true)
		{
		
		}
	}

	public void EFLAT()
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
		// 1 & 2
		else if (true)
		{
		
		}
		// 1 & 3
		else if (true)
		{
		
		}
		// 1 & 4
		else if (true)
		{
		
		}
		// 2 & 3
		else if (true)
		{
		
		}
		// 2 & 4
		else if (true)
		{
		
		}
		// 3 & 4
		else if (true)
		{
		
		}
		// 1 & 2 & 3
		else if (true)
		{
		
		}
		// 1 & 2 & 4
		else if (true)
		{
		
		}
		// 1 & 3 & 4
		else if (true)
		{
		
		}
		// 2 & 3 & 4
		else if (true)
		{
		
		}
		// 1 & 2 & 3 & 4
		else if (true)
		{
		
		}
	}
	
	public void F()
	{
	
	}
	
	public static void main(String[] args)
	{
		new Tuba();
	}
}
