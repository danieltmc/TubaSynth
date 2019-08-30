const int valve1 = 16;
const int valve2 = 5;
const int valve3 = 4;
const int valve4 = 0;
const int interrupt = 2;

int valve1_status = 0;
int valve2_status = 0;
int valve3_status = 0;
int valve4_status = 0;
int interrupt_status = 0;

void setup()
{
  Serial.begin(9600);
  pinMode(valve1, INPUT);
  pinMode(valve2, INPUT);
  pinMode(valve3, INPUT);
  pinMode(valve4, INPUT);
  pinMode(interrupt, INPUT);
}

void loop()
{
  valve1_status = digitalRead(valve1);
  valve2_status = digitalRead(valve2);
  valve3_status = digitalRead(valve3);
  valve4_status = digitalRead(valve4);
  interrupt_status = digitalRead(interrupt);

  if (interrupt_status)
  {
    Serial.write(-1);
    return;
  }
  // 0000
  if (!valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    Serial.write(0);
  }
  // 1000
  else if (valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    Serial.write(1);
  }
  // 0100
  else if (!valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    Serial.write(2);
  }
  // 0010
  else if (!valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    Serial.write(3);
  }
  // 0001
  else if (!valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    Serial.write(4);
  }
  // 1100
  else if (valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    Serial.write(12);
  }
  // 1010
  else if (valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    Serial.write(13);
  }
  // 1001
  else if (valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    Serial.write(14);
  }
  // 0110
  else if (!valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    Serial.write(23);
  }
  // 0101
  else if (!valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    Serial.write(24);
  }
  // 0011
  else if (!valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    Serial.write(34);
  }
  // 1110
  else if (valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    Serial.write(123);
  }
  // 1101
  else if (valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    Serial.write(124);
  }
  // 1011
  else if (valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    Serial.write(134);
  }
  // 0111
  else if (!valve1_status & valve2_status & valve3_status & valve4_status)
  {
    Serial.write(234);
  }
  // 1111
  else if (valve1_status & valve2_status & valve3_status & valve4_status)
  {
    Serial.write(1234);
  }
  //Serial.print(valve1_status);
  //Serial.print(valve2_status);
  //Serial.print(valve3_status);
  //Serial.print(valve4_status);
  //Serial.print("\n");
}
