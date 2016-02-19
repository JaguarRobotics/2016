#include "lib.h"
#include "calculations.h"
#include "constants.h"

CRGB leds[NUM_LEDS];
int frame = 0;

void setup() {
  FastLED.addLeds<WS2811, DATA_PIN, RGB>(leds, NUM_LEDS);
  pinMode(CTRL0, OUTPUT);
  pinMode(CTRL1, OUTPUT);
  pinMode(CTRL2, OUTPUT);
  pinMode(CTRL3, OUTPUT);
}

void loop() {
  ++frame;
  register int i;
  for ( i = 0; i < NUM_LEDS; ++i ) {
    leds[i] = calculateLED(frame, i);
  }
  FastLED.show();
  delay(1);
}

