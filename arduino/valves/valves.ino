const int valve1 = 16;
const int valve2 = 5;
const int valve3 = 4;
const int valve4 = 0;
int valve1_status = 0;
int valve2_status = 0;
int valve3_status = 0;
int valve4_status = 0;

void setup()
{
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(valve1, INPUT);
  pinMode(valve2, INPUT);
  pinMode(valve3, INPUT);
  pinMode(valve4, INPUT);
}

void loop()
{
  // put your main code here, to run repeatedly:
  valve1_status = digitalRead(valve1);
  valve2_status = digitalRead(valve2);
  valve3_status = digitalRead(valve3);
  valve4_status = digitalRead(valve4);

  // 0000
  if (!valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1000
  else if (valve1_status & !valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0100
  else if (!valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 0010
  else if (!valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0001
  else if (!valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1100
  else if (valve1_status & valve2_status & !valve3_status & !valve4_status)
  {
    
  }
  // 1010
  else if (valve1_status & !valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1001
  else if (valve1_status & !valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0110
  else if (!valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 0101
  else if (!valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 0011
  else if (!valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1110
  else if (valve1_status & valve2_status & valve3_status & !valve4_status)
  {
    
  }
  // 1101
  else if (valve1_status & valve2_status & !valve3_status & valve4_status)
  {
    
  }
  // 1011
  else if (valve1_status & !valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 0111
  else if (!valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }
  // 1111
  else if (valve1_status & valve2_status & valve3_status & valve4_status)
  {
    
  }
  //Serial.print(valve1_status);
  //Serial.print(valve2_status);
  //Serial.print(valve3_status);
  //Serial.println(valve4_status);
}
