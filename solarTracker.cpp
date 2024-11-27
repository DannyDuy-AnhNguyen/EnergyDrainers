#include <Servo.h>

// make ints for analog inputs
int TopLeft = A0;
int TopRight = A1;
int BottomLeft = A2;
int BottomRight = A3;

// make ints for storing analog inputs for servo
int valTL;
int valTR;
int valBL;
int valBR;

// create ints for outputs
int AzimuthLeft;
int AzimuthRight;
int tiltUp;
int tiltDown;

// create servo objects
Servo servoAttitude;
Servo servoAzimuth;

void setup()
{
  servoAzimuth.attach(9); //couple servo that turns to output 9
  servoAttitude.attach(10); // couple servo that tilts to output 10

}

void loop()
{
  valTL = analogRead(TopLeft); // log analog inputs into integers
  valTR = analogRead(TopRight);
  valBL = analogRead(BottomLeft);
  valBR = analogRead(BottomRight);


  tiltUp = TopRight + TopLeft;
  tiltDown = BottomRight + BottomLeft;
  AzimuthLeft = TopLeft + BottomLeft;
  AzimuthRight = TopRight + BottomRight;

  tiltUp = map(tiltUp, 0, 1023, 0, 90);
  tiltDown = map(tiltDown, 0, 1023, 0, 90);
  AzimuthLeft = map(AzimuthLeft, 0, 1023, 0, 180);
  AzimuthRight = map(AzimuthRight, 0, 1023, 0, 180);
  
  
  
  if(tiltUp > tiltDown) {
    servoAttitude.write(tiltUp);
  }
}
