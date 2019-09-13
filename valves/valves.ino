#include <MIDI.h>

enum tuning
{
  BBb, CC, Eb, F
};

const int valve1 = 16;
const int valve2 = 5;
const int valve3 = 4;
const int valve4 = 0;
const int wind = A0;
const int interrupt = 2;

int valve1_status = 0; // 0-1
int valve2_status = 0; // 0-1
int valve3_status = 0; // 0-1
int valve4_status = 0; // 0-1
int wind_status = 0; // 0-1023
int interrupt_status = 0; // 0-1
int freq = 0; // 0-1000

int valve_combo = 0;
int encoded = 0;

int last_note = 0;
int last_vel = 0;
int new_note = 0;
int new_vel = 0;
const int channel = 1;
bool playing = true;

tuning key = CC;

MIDI_CREATE_DEFAULT_INSTANCE();

void BBb_loop()
{
  // No sound
  if (!wind_status)
  {
    MIDI.sendNoteOff(last_note, last_vel, channel);
    playing = false;
    return;
  }
  // 0000 - Open valves
  else if (!valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1000 - First valve
  else if (valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0100 - Second valve
  else if (!valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0010 - Third valve
  else if (!valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0001 - Fourth valve
  else if (!valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1100 - First and Second
  else if (valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1010 - First and Third
  else if (valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1001 - First and Fourth
  else if (valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0110 - Second and Third
  else if (!valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0101 - Second and Fourth
  else if (!valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0011 - Third and Fourth
  else if (!valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1110 - First, Second, and Third
  else if (valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1101 - First, Second, and Fourth
  else if (valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1011 - First, Third, and Fourth
  else if (valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 0111 - Second, Third, and Fourth
  else if (!valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1111 - All valves
  else if (valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }

  new_vel = wind_status / 8;
  if (playing)
  {
    MIDI.sendNoteOff(last_note, last_vel, channel);
  }
  MIDI.sendNoteOn(new_note, new_vel, channel);
  last_note = new_note;
  last_vel = new_vel;
  playing = true;
}

void CC_loop()
{
  // No sound
  if (!wind_status)
  {
    MIDI.sendNoteOff(last_note, last_vel, channel);
    playing = false;
    return;
  }
  // Follow the harmonic series
  // Cutoff frequencies are approximately halfway between the harmonics for a given fingering
  // 0000 - Open valves
  else if (!valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    /*
    if (freq < 12)
    {
      new_note = 0; // C-1 or 8.18Hz AKA Triple Pedal C
    }
    else if (freq < 24)
    {
      new_note = 12; // C0 or 16.35Hz AKA Double Pedal C
    }
    else if (freq < 40)*/
    if (freq < 40)
    {
      new_note = 24; // C1 or 32.70Hz AKA Pedal C
    }
    else if (freq < 57)
    {
      new_note = 31; // G1 or 49.00Hz AKA Low G
    }
    else if (freq < 75)
    {
      new_note = 36; // C2 or 65.41Hz AKA Low C
    }
    else if (freq < 90)
    {
      new_note = 40; // E2 or 82.41Hz AKA Middle E
    }
    else if (freq < 114)
    {
      new_note = 43; // G2 or 98.00Hz AKA Middle G
    }
    else if (freq < 146)
    {
      new_note = 48; // C3 or 130.81Hz AKA (Tuba) Middle C
    }
    else if (freq < 180)
    {
      new_note = 52; // E3 or 164.81Hz AKA High E
    }
    else if (freq < 229)
    {
      new_note = 55; // G3 or 196.00Hz AKA High G
    }
    else if (freq < 287)
    {
      new_note = 60; // C4 or 261.63Hz AKA High C (Middle on Piano)
    }
    else if (freq < 311)
    {
      new_note = 62; // D4 or 293.66 AKA D Above Staff
    }
    else if (freq < 361)
    {
      new_note = 64; //E4 or 329.63Hz AKA Treble E
    }
    else if (freq < 458)
    {
      new_note = 67; // G4 or 392.00Hz AKA Treble G
    }
    else if (freq < 555)
    {
      new_note = 72; // C5 or 523.25Hz AKA Treble C
    }
    else if (freq < 623)
    {
      new_note = 74; // D5 or 587.32Hz AKA Treble D
    }
    else if (freq < 721)
    {
      new_note = 76; // E5 or 659.26Hz AKA Not Playable
    }
    else if (freq < 915)
    {
      new_note = 79; // G5 or 783.99Hz AKA Not Playable
    }
    else
    {
      new_note = 84; // C6 or 1046.50Hz AKA Not Playable
    }
  }
  // 1000 - First valve
  else if (valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    if (freq < 1000)
    {
      new_note = 22; // Bb0 or 30.87Hz AKA Pedal Bb
    }
    else if (freq < 1000)
    {
      new_note = 34; // Bb1 or 58.27Hz AKA Low Bb
    }
    else if (freq < 1000)
    {
      new_note = 41; // F2 or 87.31Hz AKA Middle F
    }
    else if (freq < 1000)
    {
      new_note = 46; // Bb2 or 116.54Hz AKA Middle Bb
    }
    else if (freq < 1000)
    {
      new_note = 50; // D3 or 146.83Hz AKA High D
    }
    else if (freq < 1000)
    {
      new_note = 53; // F3 or 174.61 AKA High F
    }
    else if (freq < 1000)
    {
      new_note = 58; // Bb3 or 233.88Hz AKA High Bb
    }
    else if (freq < 1000)
    {
      new_note = 62; // D4 or 293.66Hz AKA D Above Staff
    }
    else if (freq < 1000)
    {
      new_note = 65; // F4 or 349.23Hz AKA Treble F
    }
    else if (freq < 1000)
    {
      new_note = 68; // Ab4 or 415.30Hz AKA Treble Ab
    }
    else if (freq < 1000)
    {
      new_note = 70; // Bb4 or 466.16Hz AKA Treble Bb
    }
    else if (freq < 1000)
    {
      new_note = 74; // D5 or 587.32Hz AKA Treble D
    }
    else if (freq < 1000)
    {
      new_note = 77; // F5 or 698.46Hz AKA Not Playable
    }
    else if (freq < 1000)
    {
      new_note = 80; // Ab5 or 830.61Hz AKA Not Playable
    }
    else if (freq < 1000)
    {
      new_note = 82; // Bb5 or 932.33Hz AKA Not Playable
    }
  }
  // 0100 - Second valve
  else if (!valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0010 - Third valve
  else if (!valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0001 - Fourth valve
  else if (!valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1100 - First and Second
  else if (valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1010 - First and Third
  else if (valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1001 - First and Fourth
  else if (valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0110 - Second and Third
  else if (!valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0101 - Second and Fourth
  else if (!valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0011 - Third and Fourth
  else if (!valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1110 - First, Second, and Third
  else if (valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1101 - First, Second, and Fourth
  else if (valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1011 - First, Third, and Fourth
  else if (valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 0111 - Second, Third, and Fourth
  else if (!valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1111 - All valves
  else if (valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }

  new_vel = wind_status / 8;
  if (playing)
  {
    MIDI.sendNoteOff(last_note, last_vel, channel);
  }
  MIDI.sendNoteOn(new_note, new_vel, channel);
  last_note = new_note;
  last_vel = new_vel;
  playing = true;
}

void Eb_loop()
{
  // No sound
  if (!wind_status)
  {
    MIDI.sendNoteOff(last_note, last_vel, channel);
    playing = false;
    return;
  }
  // 0000 - Open valves
  else if (!valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1000 - First valve
  else if (valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0100 - Second valve
  else if (!valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0010 - Third valve
  else if (!valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0001 - Fourth valve
  else if (!valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1100 - First and Second
  else if (valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1010 - First and Third
  else if (valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1001 - First and Fourth
  else if (valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0110 - Second and Third
  else if (!valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0101 - Second and Fourth
  else if (!valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0011 - Third and Fourth
  else if (!valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1110 - First, Second, and Third
  else if (valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1101 - First, Second, and Fourth
  else if (valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1011 - First, Third, and Fourth
  else if (valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 0111 - Second, Third, and Fourth
  else if (!valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1111 - All valves
  else if (valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }

  new_vel = wind_status / 8;
  if (playing)
  {
    MIDI.sendNoteOff(last_note, last_vel, channel);
  }
  MIDI.sendNoteOn(new_note, new_vel, channel);
  last_note = new_note;
  last_vel = new_vel;
  playing = true;
}

void F_loop()
{
  // No sound
  if (!wind_status)
  {
    MIDI.sendNoteOff(last_note, last_vel, channel);
    playing = false;
    return;
  }
  // 0000 - Open valves
  else if (!valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1000 - First valve
  else if (valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0100 - Second valve
  else if (!valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0010 - Third valve
  else if (!valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0001 - Fourth valve
  else if (!valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1100 - First and Second
  else if (valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1010 - First and Third
  else if (valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1001 - First and Fourth
  else if (valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0110 - Second and Third
  else if (!valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0101 - Second and Fourth
  else if (!valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0011 - Third and Fourth
  else if (!valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1110 - First, Second, and Third
  else if (valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1101 - First, Second, and Fourth
  else if (valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1011 - First, Third, and Fourth
  else if (valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 0111 - Second, Third, and Fourth
  else if (!valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1111 - All valves
  else if (valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }

  new_vel = wind_status / 8;
  if (playing)
  {
    MIDI.sendNoteOff(last_note, last_vel, channel);
  }
  MIDI.sendNoteOn(new_note, new_vel, channel);
  last_note = new_note;
  last_vel = new_vel;
  playing = true;
}

void setup()
{
  Serial.begin(9600);
  pinMode(valve1, INPUT);
  pinMode(valve2, INPUT);
  pinMode(valve3, INPUT);
  pinMode(valve4, INPUT);
  pinMode(wind, INPUT);
  pinMode(interrupt, INPUT);

  MIDI.begin(MIDI_CHANNEL_OMNI);
}

void loop()
{
  valve1_status = digitalRead(valve1);
  valve2_status = digitalRead(valve2);
  valve3_status = digitalRead(valve3);
  valve4_status = digitalRead(valve4);
  wind_status = analogRead(wind);
  interrupt_status = digitalRead(interrupt);
  
  // Stop program
  if (interrupt_status)
  {
    Serial.print("Program exited. Restart device to restart program.");
    while (1)
    {
      // Do nothing
    }
  }

  if (key == BBb)
  {
    BBb_loop();
  }
  else if (key == CC)
  {
    CC_loop();
  }
  else if (key == Eb)
  {
    Eb_loop();
  }
  else if (key == F)
  {
    F_loop();
  }
}
