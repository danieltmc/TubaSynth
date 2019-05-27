import javax.sound.midi.*;
import javax.sound.sampled.*;

public class Tuba
{
	double[] note_frequencies = {16.35, 17.32, 18.35, 19.45, 20.60, 21.83, 23.12, 24.5, 25.96, 27.5, 25.96, 27.5, 29.14, 30.87, 32.7, 34.65, 36.71, 38.89, 41.2, 43.65, 46.25, 49.0, 51.91, 55.0, 58.27, 61.74, 65.41, 69.3, 73.42, 77.78, 82.41, 87.31, 92.5, 98.0, 103.83, 110.0, 116.54, 123.47, 130.81, 138.59, 146.83, 155.56, 164.81, 174.61, 185.0, 196.0, 207.65, 220.0, 233.08, 246.94, 261.63, 277.18, 293.66, 311.13, 329.63, 349.23, 369.99, 392.0, 415.3, 440.0, 466.16, 493.88, 523.25, 554.37, 587.33, 622.25, 659.25, 698.46, 739.99, 783.99, 830.61, 880.0, 932.33, 987.77, 1046.5, 1108.73, 1174.66, 1244.51, 1318.51, 1396.91, 1479.98, 1567.98, 1661.22, 1760.0, 1864.66, 1975.53, 2093.0, 2217.46, 2349.32, 2489.02, 2637.02, 2793.83, 2959.96, 3135.96, 3322.44, 3520.0, 3729.31, 3951.07, 4186.01, 4434.92, 4698.63, 4978.03, 5274.04, 5587.65, 5919.91, 6271.93, 6644.88, 7040.0, 7458.62, 7902.13};
	double sample;
	byte[] buffer;
	long tick;
	SourceDataLine sdl;
	
	public Tuba()
	{
		tick = (long) 0;
		buffer = new byte[1];
		AudioFormat af = new AudioFormat((float) 44100, 8, 1, true, false);
		sdl = AudioSystem.getSourceDataLine(af);
		sdl.open();
		sdl.start();
	}
	
	public void update(int note)
	{
		sample = (double) tick / ((double) 44100 / note_frequencies[note]) * (double) 2 * (double) Math.PI;
		buffer[0] = (byte) (Math.sin(sample) * 100);
		sdl.write(buffer, 0, 1);
		tick++;
	}
	
	public void update()
	{
		buffer[0] = (byte) 0;
		sdl.write(buffer, 0, 1);
		tick++;
	}
	
	public void stop()
	{
		sdl.drain();
		sdl.stop();
	}
}
