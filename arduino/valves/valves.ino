const int valve1 = 16;
const int valve2 = 5;
const int valve3 = 4;
const int valve4 = 0;
int valve1_status = 0;
int valve2_status = 0;
int valve3_status = 0;
int valve4_status = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(valve1, INPUT);
  pinMode(valve2, INPUT);
  pinMode(valve3, INPUT);
  pinMode(valve4, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  valve1_status = digitalRead(valve1);
  valve2_status = digitalRead(valve2);
  valve3_status = digitalRead(valve3);
  valve4_status = digitalRead(valve4);

  Serial.println(valve1_status);
  Serial.println(valve2_status);
  Serial.println(valve3_status);
  Serial.println(valve4_status);
}
