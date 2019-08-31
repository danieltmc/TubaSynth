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

int valve_combo = 0;
int encoded = 0;

void setup()
{
  Serial.begin(9600);
  pinMode(valve1, INPUT);
  pinMode(valve2, INPUT);
  pinMode(valve3, INPUT);
  pinMode(valve4, INPUT);
  pinMode(wind, INPUT);
  pinMode(interrupt, INPUT);
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
    Serial.write(-1);
    return;
  }
  // No sound
  else if (!wind_status)
  {
    Serial.write(0);
    return;
  }
  // 0000 - Open valves
  else if (!valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    valve_combo = 0;
  }
  // 1000 - First valve
  else if (valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    valve_combo = 1;
  }
  // 0100 - Second valve
  else if (!valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    valve_combo = 2;
  }
  // 0010 - Third valve
  else if (!valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    valve_combo = 3;
  }
  // 0001 - Fourth valve
  else if (!valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    valve_combo = 4;
  }
  // 1100 - First and Second
  else if (valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    valve_combo = 12;
  }
  // 1010 - First and Third
  else if (valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    valve_combo = 13;
  }
  // 1001 - First and Fourth
  else if (valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    valve_combo = 14;
  }
  // 0110 - Second and Third
  else if (!valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    valve_combo = 23;
  }
  // 0101 - Second and Fourth
  else if (!valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    valve_combo = 24;
  }
  // 0011 - Third and Fourth
  else if (!valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    valve_combo = 34;
  }
  // 1110 - First, Second, and Third
  else if (valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    valve_combo = 123;
  }
  // 1101 - First, Second, and Fourth
  else if (valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    valve_combo = 124;
  }
  // 1011 - First, Third, and Fourth
  else if (valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    valve_combo = 134;
  }
  // 0111 - Second, Third, and Fourth
  else if (!valve1_status & valve2_status & valve3_status & valve4_status)
  {
    valve_combo = 234;
  }
  // 1111 - All valves
  else if (valve1_status & valve2_status & valve3_status & valve4_status)
  {
    valve_combo = 1234;
  }
  
  encoded = (valve_combo << 10) + wind_status;
  Serial.write(encoded);
  
  //Serial.println(valve_combo);
}
