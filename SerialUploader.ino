#include <ArduinoJson.h>

int TopLeft;
int TopRight;
int BottomLeft;
int BottomRight;

void setup() {
  // Initialize Serial port
  Serial.begin(9600);
  while (!Serial) {
    continue;
 }
}

void loop() {
  TopLeft = analogRead(A0);
  TopRight = analogRead(A1);
  BottomLeft = analogRead(A2);
  BottomRight = analogRead(A3);

   // Allocate the JSON document
 JsonDocument doc;

  // Add values in the document
  doc["TopLeft"] = 1;
  doc["TopRight"] = 2;
  doc["BottomLeft"] = 3;
  doc["BottomRight"] = 4;

  //buttonState = digitalRead(buttonPin);

    serializeJson(doc, Serial);

    // Start a new line
    Serial.println();
    Serial.flush();
    delay(500);
  

}