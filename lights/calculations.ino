#include "lib.h"
#include "calculations.h"
#include "patterns.h"

CRGB calculateLED(int frame, int led) {
  int sel = (digitalRead(CTRL0) == HIGH ? 8 : 0) |
            (digitalRead(CTRL1) == HIGH ? 4 : 0) |
            (digitalRead(CTRL2) == HIGH ? 2 : 0) |
            (digitalRead(CTRL3) == HIGH ? 1 : 0);
  switch ( sel ) {
    case 0:
      return pattern0(frame, led);
    case 1:
      return pattern1(frame, led);
    case 2:
      return pattern2(frame, led);
    case 3:
      return pattern3(frame, led);
    case 4:
      return pattern4(frame, led);
    case 5:
      return pattern5(frame, led);
    case 6:
      return pattern6(frame, led);
    case 7:
      return pattern7(frame, led);
    default:
      return CRGB(0, 0, 0);
  }
}

